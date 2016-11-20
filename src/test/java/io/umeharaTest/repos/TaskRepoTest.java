package io.umeharaTest.repos;

import io.umehara.models.Task;
import io.umehara.repos.TaskRepo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TaskRepoTest {
    private TaskRepo repo;

    @Before
    public void setUp() throws Exception {
        repo = new TaskRepo();
    }

    @Test
    public void test_getAll_returnsAllTasks() throws Exception {
        List<Task> repos = repo.getAll();

        assertThat(repos.get(0).getName(), equalTo("hello there!"));
    }
}
