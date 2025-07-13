package com.devping.repository;

import com.devping.model.Task;
import com.devping.model.Project;
import com.devping.model.User;
import com.devping.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject(Project project);
    List<Task> findByAssignee(User assignee);
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByProjectAndStatus(Project project, TaskStatus status);
    List<Task> findByAssigneeAndStatus(User assignee, TaskStatus status);
}
