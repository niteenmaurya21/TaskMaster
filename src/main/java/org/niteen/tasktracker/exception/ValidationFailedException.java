package org.niteen.tasktracker.exception;

public class ValidationFailedException extends RuntimeException{
    public ValidationFailedException(String message)
    {
        super(message);
    }
}
