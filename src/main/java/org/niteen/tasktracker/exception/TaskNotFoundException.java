package org.niteen.tasktracker.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String message)
    {
        super(message);
    }
}
