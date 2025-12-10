package ttspringboot.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TTSpringBootException extends RuntimeException{
    protected String title;
    protected HttpStatus status;

    public TTSpringBootException(String title, String message, HttpStatus status){
        super(message);
        this.title = title;
        this.status = status;
    }
}
