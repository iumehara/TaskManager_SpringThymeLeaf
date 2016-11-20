package io.umeharaTest.repos;

import io.umehara.dataMappers.TaskDataMapper;
import io.umehara.models.Task;
import io.umehara.repos.TaskRepo;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TaskRepoTest {
    private TaskRepo repo;

    @Before
    public void setUp() throws Exception {
        TaskDataMapper dataMapper = mock(TaskDataMapper.class);
        List<Task> expectedTasks = Collections.singletonList(new Task("hello there!"));
        when(dataMapper.getAll()).thenReturn(expectedTasks);
        repo = new TaskRepo(dataMapper);
    }

    @Test
    public void test_getAll_returnsAllTasks() throws Exception {
        List<Task> repos = repo.getAll();

        assertThat(repos.get(0).getName(), equalTo("hello there!"));
    }
}
