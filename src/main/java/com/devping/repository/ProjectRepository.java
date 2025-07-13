package com.devping.repository;

import com.devping.model.Project;
import com.devping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByOwner(User owner);
    List<Project> findByContributorsContaining(User contributor);
    
    @Query("SELECT p FROM Project p WHERE p.owner = :user OR :user MEMBER OF p.contributors")
    List<Project> findProjectsByUserInvolvement(@Param("user") User user);
    
    @Query("SELECT p FROM Project p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
    List<Project> searchProjects(@Param("keyword") String keyword);
}
