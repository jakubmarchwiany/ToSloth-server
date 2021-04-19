package exceptionController;


public class UserWrongLoginDetailsException extends RuntimeException{
    public UserWrongLoginDetailsException(String nickname,String password) {
        super("User with this nickname = (" + nickname + ") and this password = (" + password + ") not exists");
    }
}