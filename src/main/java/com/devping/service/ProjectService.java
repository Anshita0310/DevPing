package com.devping.service;

import com.devping.model.Project;
import com.devping.model.User;
import com.devping.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> findById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public List<Project> findProjectsByOwner(User owner) {
        return projectRepository.findByOwner(owner);
    }

    public List<Project> findProjectsByContributor(User contributor) {
        return projectRepository.findByContributorsContaining(contributor);
    }

    public void deleteProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        projectRepository.delete(project);
    }
}
