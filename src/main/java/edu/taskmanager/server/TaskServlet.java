package edu.taskmanager.server;

import edu.taskmanager.model.Task;
import edu.taskmanager.model.TaskRepository;
import java.io.IOException;
import java.util.Collection;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/api/tasks") // Updated to match web.xml mapping
public class TaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private void setAccessControlHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        setAccessControlHeaders(response); // Set CORS headers
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        
        if (name == null || name.trim().isEmpty() || description == null || description.trim().isEmpty()) {
            sendJsonResponse(response, "{\"status\":\"error\", \"message\":\"Both name and description are required.\"}");
            return;
        }
        
        Task task = new Task(0, name, description); // ID is 0 here, will be set in TaskRepository
        TaskRepository.addTask(task);
        
        sendJsonResponse(response, "{\"status\":\"success\", \"message\":\"Task added successfully.\"}");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        setAccessControlHeaders(response); // Set CORS headers
        Collection<Task> tasks = TaskRepository.getAllTasks();
        
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\"tasks\":[");
        int i = 0;
        for (Task task : tasks) {
            jsonBuilder.append(String.format("{\"id\":%d,\"name\":\"%s\",\"description\":\"%s\"}", task.getId(), task.getName(), task.getDescription()));
            if (i < tasks.size() - 1) {
                jsonBuilder.append(",");
            }
            i++;
        }
        jsonBuilder.append("]}");
        
        sendJsonResponse(response, jsonBuilder.toString());
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        setAccessControlHeaders(response); // Set CORS headers
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.trim().isEmpty()) {
            sendJsonResponse(response, "{\"status\":\"error\", \"message\":\"Task ID is required for deletion.\"}");
            return;
        }
        
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            sendJsonResponse(response, "{\"status\":\"error\", \"message\":\"Invalid Task ID.\"}");
            return;
        }
        
        Task removedTask = TaskRepository.removeTask(id);
        if (removedTask == null) {
            sendJsonResponse(response, "{\"status\":\"error\", \"message\":\"Task not found.\"}");
        } else {
            sendJsonResponse(response, "{\"status\":\"success\", \"message\":\"Task deleted successfully.\"}");
        }
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        setAccessControlHeaders(response); // Necessary for CORS pre-flight requests
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private void sendJsonResponse(HttpServletResponse response, String json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
