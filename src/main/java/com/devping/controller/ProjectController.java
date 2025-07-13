package com.devping.controller;

import com.devping.model.Project;
import com.devping.model.User;
import com.devping.security.UserPrincipal;
import com.devping.service.ProjectService;
import com.devping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.findAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projectService.findById(id);
        if (project.isPresent()) {
            return ResponseEntity.ok(project.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Project> createProject(@RequestBody Project project, Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Optional<User> user = userService.findById(userPrincipal.getId());
        
        if (user.isPresent()) {
            project.setOwner(user.get());
            Project savedProject = projectService.createProject(project);
            return ResponseEntity.ok(savedProject);
        }
        
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails,
                                               Authentication authentication) {
        Optional<Project> projectOpt = projectService.findById(id);
        if (!projectOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Project project = projectOpt.get();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        
        // Only project owner or admin can update
        if (!project.getOwner().getId().equals(userPrincipal.getId()) && 
            !userPrincipal.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            return ResponseEntity.status(403).build();
        }

        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        project.setTechnologies(projectDetails.getTechnologies());
        project.setRepositoryUrl(projectDetails.getRepositoryUrl());
        project.setStatus(projectDetails.getStatus());

        Project updatedProject = projectService.createProject(project);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteProject(@PathVariable Long id, Authentication authentication) {
        Optional<Project> projectOpt = projectService.findById(id);
        if (!projectOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Project project = projectOpt.get();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        
        // Only project owner or admin can delete
        if (!project.getOwner().getId().equals(userPrincipal.getId()) && 
            !userPrincipal.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            return ResponseEntity.status(403).build();
        }

        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/join")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> joinProject(@PathVariable Long id, Authentication authentication) {
        Optional<Project> projectOpt = projectService.findById(id);
        Optional<User> userOpt = userService.findById(((UserPrincipal) authentication.getPrincipal()).getId());
        
        if (projectOpt.isPresent() && userOpt.isPresent()) {
            Project project = projectOpt.get();
            User user = userOpt.get();
            
            if (!project.getContributors().contains(user)) {
                project.getContributors().add(user);
                projectService.createProject(project);
            }
            
            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.notFound().build();
    }
}
