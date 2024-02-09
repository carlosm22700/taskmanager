package edu.taskmanager.model;

import java.util.Map;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;


public class TaskRepository {
    private static final Map<Integer, Task> tasks = new ConcurrentHashMap<>();
    private static int currentId = 0;

    public static Task addTask(Task task) {
        int id = ++currentId;
        task.setId(id);
        tasks.put(id, task);
        System.out.println("Task added: " + task.getId() + " - " + task.getName());
        return task;
    }

    public static Task getTask(int id) {
        Task task = tasks.get(id);
        System.out.println("Task retrieved: " + (task != null ? task.getId() : "Not found"));
        return task;
    }

    public static Collection<Task> getAllTasks() {
        System.out.println("Fetching all tasks. Total: " + tasks.size());
        return tasks.values();
    }

    public static Task updateTask(int id, Task task) {
        task.setId(id);
        System.out.println("Updating Task: " + id);
        return tasks.put(id, task);
    }

    public static Task removeTask(int id) {
        System.out.println("Attempting to remove Task: " + id);
        Task removed = tasks.remove(id);
        if (removed != null) {
            System.out.println("Task removed successfully: " + id);
        } else {
            System.out.println("Task removal failed, ID not found: " + id);
        }
        return removed;
    }

}
