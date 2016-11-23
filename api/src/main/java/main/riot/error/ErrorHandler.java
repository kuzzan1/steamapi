package main.riot.error;

import main.riot.exception.UnsupportedLocaleException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jonas on 2016-11-21.
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = UnsupportedLocaleException.class)
    @ResponseBody
    public Error defaulLocaleErrorHandler( HttpServletRequest req, Exception e) throws Exception  {
        return new Error(e.getMessage());
    }
}
