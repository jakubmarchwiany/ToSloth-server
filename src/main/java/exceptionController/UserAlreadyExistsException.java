package exceptionController;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String nickname) {
        super("User with this nickname = (" + nickname + ") already exists");
    }
}
