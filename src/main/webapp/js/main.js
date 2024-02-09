// Function to fetch tasks from the backend
function fetchTasks() {
    $.ajax({
        url: '/TaskManagerWebApp/api/tasks', // Ensure this matches your servlet URL pattern
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            // Process the response and display tasks
            console.log('Tasks fetched successfully:', response.tasks.length, 'tasks');
            displayTasks(response.tasks); // Assuming the backend sends an object with a "tasks" array
        },
        error: function (error) {
            console.error('Error fetching tasks:', error);
        }
    });
}

// Function to display tasks on the frontend
function displayTasks(tasks) {
    var $taskList = $('#taskList');
    $taskList.empty(); // Clear existing tasks

    tasks.forEach(function (task) {
        var taskItem = $('<li>').text(task.name + ": " + task.description);
        var deleteButton = $('<button>').text('Delete').attr('data-task-id', task.id);
        taskItem.append(deleteButton);
        $taskList.append(taskItem);
    });

    // Bind the click event to the task list for handling delete button clicks
    // This replaces any direct .click() bindings on the delete buttons
    $taskList.off('click', 'button').on('click', 'button', function() {
        var taskId = $(this).attr('data-task-id');
        deleteTask(taskId);
    });
}


// Function to create a new task
function createTask(name, description) {
    $.ajax({
        url: '/TaskManagerWebApp/api/tasks',
        method: 'POST',
        data: { name: name, description: description }, // Sending as form parameters
        success: function (response) {
            // Fetch tasks again to update the list
            console.log('Task created successfully:', response);
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
        url: '/TaskManagerWebApp/api/tasks?id=' + taskId, // Append taskId as a query parameter
        method: 'DELETE',
        success: function (response) {
            console.log('Task deleted successfully:', taskId);
            // On successful deletion, remove the task element from the DOM
            $('button[data-task-id="' + taskId + '"]').closest('li').remove();
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
