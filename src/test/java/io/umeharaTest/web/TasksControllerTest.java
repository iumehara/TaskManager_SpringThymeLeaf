package io.umeharaTest.web;

import io.umehara.models.Task;
import io.umehara.repos.TaskRepo;
import io.umehara.web.TasksController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class TasksControllerTest {
    private MockMvc mockController;
    private TaskRepo repo;

    @Before
    public void setUp() throws Exception {
        repo = mock(TaskRepo.class);
        TasksController controller = new TasksController(repo);
        mockController = standaloneSetup(controller).build();
    }

    @Test
    public void test_index_returnsStatusOK() throws Exception {
        mockController.perform(get("/tasks/"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_index_rendersTemplate() throws Exception {
        mockController.perform(get("/tasks/"))
                .andExpect(view().name("tasks/index"));
    }

    @Test
    public void test_index_returnsData() throws Exception {
        when(repo.getAll()).thenReturn(Collections.singletonList(new Task("this is a test")));

        mockController.perform(get("/tasks/"))
                .andExpect(model().attribute("tasks", hasItem(
                        is(
                                hasProperty("name", is("this is a test"))
                        )
                )));
    }
}
