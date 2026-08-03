package org.niteen.tasktracker.exception;

public class TeamNotFoundException extends  RuntimeException
{
    public TeamNotFoundException(String message)
    {
        super(message);
    }
}
