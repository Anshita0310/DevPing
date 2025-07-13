package com.devping.service;

import com.devping.model.Task;
import com.devping.model.Project;
import com.devping.model.TaskStatus;
import com.devping.model.User;
import com.devping.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> findById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
    
    public List<Task> findTasksByProject(Project project) {
        return taskRepository.findByProject(project);
    }

    public List<Task> findTasksByAssignee(User assignee) {
        return taskRepository.findByAssignee(assignee);
    }

    public List<Task> findTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }
}
