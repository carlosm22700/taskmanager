package edu.taskmanager.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collection;

public class TaskRepository {
    private static final Map<Integer, Task> tasks = new ConcurrentHashMap<>();
    private static int currentId = 0;

    public static Task addTask(Task task) {
        int id = ++currentId;
        task.setId(id);
        tasks.put(id, task);
        return task;
    }

    public static Task getTask(int id) {
        return tasks.get(id);
    }

    public static Collection<Task> getAllTasks() {
        return tasks.values();
    }

    public static Task updateTask(int id, Task task) {
        task.setId(id);
        return tasks.put(id, task);
    }

    public static Task removeTask(int id) {
        return tasks.remove(id);
    }
}
