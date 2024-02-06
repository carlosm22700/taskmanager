// Function to fetch tasks from the backend
function fetchTasks() {
    $.ajax({
        url: '/api/tasks', // Ensure this matches your servlet URL pattern
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            // Process the response and display tasks
            displayTasks(response.tasks); // Assuming the backend sends an object with a "tasks" array
        },
        error: function (error) {
            console.error('Error fetching tasks:', error);
        }
    });
}

// Function to display tasks on the frontend
function displayTasks(tasks) {
    $('#taskList').empty(); // Clear existing tasks

    tasks.forEach(function (task) {
        var taskItem = $('<li>').text(task.name + ": " + task.description); // Use task.name and task.description
        var deleteButton = $('<button>').text('Delete').click(function () {
            deleteTask(task.id); // Pass the correct task ID for deletion
        });
        taskItem.append(deleteButton);
        $('#taskList').append(taskItem);
    });
}

// Function to create a new task
function createTask(name, description) {
    $.ajax({
        url: '/api/tasks', // Ensure this matches your servlet URL pattern
        method: 'POST',
        contentType: 'application/json', // Set the content type to application/json
        data: JSON.stringify({ name: name, description: description }), // Send both name and description
        success: function (response) {
            // Fetch tasks again to update the list
            fetchTasks();
        },
        error: function (error) {
            console.error('Error creating task:', error);
        }
    });
}

// Function to delete a task
function deleteTask(taskId) {
    $.ajax({
        url: '/api/tasks', // Ensure this matches your servlet URL pattern
        method: 'DELETE',
        data: { id: taskId }, // Send the task ID as a query parameter
        success: function (response) {
            // Fetch tasks again to update the list
            fetchTasks();
        },
        error: function (error) {
            console.error('Error deleting task:', error);
        }
    });
}

// Fetch tasks on page load
$(document).ready(function () {
    fetchTasks();
});
