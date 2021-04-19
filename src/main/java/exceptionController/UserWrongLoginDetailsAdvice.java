package exceptionController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserWrongLoginDetailsAdvice {
    @ResponseBody
    @ExceptionHandler(UserWrongLoginDetailsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userWrongLoginDetailsHandler(UserWrongLoginDetailsException ex) {
        return ex.getMessage();
    }
}



