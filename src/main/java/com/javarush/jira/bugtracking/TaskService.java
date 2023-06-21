package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.internal.mapper.TaskMapper;
import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.internal.repository.TaskRepository;
import com.javarush.jira.bugtracking.to.TaskTo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService extends BugtrackingService<Task, TaskTo, TaskRepository> {
    public TaskService(TaskRepository repository, TaskMapper mapper) {
        super(repository, mapper);
    }

    @Transactional(readOnly = true)
    public List<TaskTo> getAll() {
        return mapper.toToList(repository.getAll());
    }

    @Transactional
    public void addTag(long id, String newTag){
        repository.getExisted(id).getTags().add(newTag);
    }

    @Transactional
    public void deleteTag(int taskId, String newTag) {
        repository.getExisted(taskId).getTags().remove(newTag);
    }
}
