package io.umehara.repos;

import io.umehara.models.Task;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class TaskRepo {

    public TaskRepo() {
    }

    public List<Task> getAll() {
        Task task= new Task("hello there!");
        return Collections.singletonList(task);
    }
}
