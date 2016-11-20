package io.umehara.repos;

import io.umehara.dataMappers.TaskDataMapper;
import io.umehara.models.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepo {
    private final TaskDataMapper dataMapper;

    public TaskRepo(TaskDataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    public List<Task> getAll() {
        return dataMapper.getAll();
    }
}
