package io.umehara.web;

import io.umehara.models.Task;
import io.umehara.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class TasksController {
    private TaskRepo repo;

    @Autowired
    public TasksController(TaskRepo repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/tasks", method = GET)
    public String index(Model model) {
        List<Task> tasks = repo.getAll();
        model.addAttribute("tasks", tasks);
        return "tasks/index";
    }
}
