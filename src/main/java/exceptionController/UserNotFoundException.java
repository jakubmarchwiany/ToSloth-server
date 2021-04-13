package exceptionController;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String id) {
        super("Could not find employee " + id);
    }
}
