package com.guimaraes.medicine.repository;

import com.guimaraes.medicine.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findUserByUsername(String username);

    @Query(value = "SELECT * FROM TB_USER WHERE USERNAME = ?1", nativeQuery = true)
    User findByUsername(String username);






}
