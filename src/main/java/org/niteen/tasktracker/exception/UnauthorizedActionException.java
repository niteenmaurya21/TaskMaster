package org.niteen.tasktracker.exception;

public class UnauthorizedActionException extends RuntimeException {
    public UnauthorizedActionException(String message)
    {
        super(message);
    }
}
