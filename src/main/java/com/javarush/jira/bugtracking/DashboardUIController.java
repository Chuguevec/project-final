package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.to.SprintTo;
import com.javarush.jira.bugtracking.to.TaskTo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/")
public class DashboardUIController {

    private TaskService taskService;

    @GetMapping// index page
    public String getAll(Model model) {
        List<TaskTo> tasks = taskService.getAll();
        Map<SprintTo, List<TaskTo>> taskMap = tasks.stream()
                .collect(Collectors.groupingBy(TaskTo::getSprint));
        model.addAttribute("taskMap", taskMap);
        return "index";
    }

    @PutMapping
    public String addTagForTask(@RequestParam("taskId") int taskId,
                                @RequestParam ("newTag") String newTag, Model model){
        taskService.addTag(taskId, newTag);
        return getAll(model);
    }

    @DeleteMapping
    public String deleteTagForTask(@RequestParam("taskId") int taskId,
                                @RequestParam ("tag") String newTag, Model model){
        taskService.deleteTag(taskId, newTag);
        return getAll(model);
    }
}
