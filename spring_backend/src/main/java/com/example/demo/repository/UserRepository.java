package com.example.demo.repository;
import com.example.demo.dto.LoginDto;
import com.example.demo.model.Users;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    // Custom query to fetch only the fields needed for login
   @Query("SELECT new com.example.demo.dto.LoginDto(u.cin, u.password, r.roleName,u.fullName) " +
       "FROM Users u JOIN u.role r " +"WHERE u.cin = :cin")
    Optional<LoginDto> findUserForLogin(@Param("cin") String cin);
}
