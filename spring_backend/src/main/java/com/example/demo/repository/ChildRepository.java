package com.example.demo.repository;
import com.example.demo.dto.ChildDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Child;



@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    // Custom query to fetch only the fields needed for login
   @Query("SELECT new com.example.demo.dto.ChildDto(c.childId,c.fullName,c.gender,c.birthDate) "+
       "FROM Child c "+" WHERE c.cin = :cin")
    List<ChildDto> findChildrenOfUser(@Param("cin") String cin);
}

