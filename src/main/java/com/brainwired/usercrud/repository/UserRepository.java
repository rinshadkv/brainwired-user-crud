package com.brainwired.usercrud.repository;

import com.brainwired.usercrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByIsDeletedIsFalse();

    Optional<User> findByIdAndIsDeletedIsFalse(Long id);

    @Modifying
    @Query(value = "update user set is_deleted=true where id=:id",nativeQuery = true)
    void deleteById(Long id);
}