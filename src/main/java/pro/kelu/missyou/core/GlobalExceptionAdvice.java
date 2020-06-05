package pro.kelu.missyou.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.kelu.missyou.core.configuration.ExceptionCodeConfiguration;
import pro.kelu.missyou.exception.http.HttpException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;


@ControllerAdvice
public class GlobalExceptionAdvice{

    @Autowired
    private ExceptionCodeConfiguration exceptionCodeConfiguration;


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req, Exception e) {
        System.out.println(e);
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        return new UnifyResponse(9999, "服务器异常", method + " " + requestUrl);
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest req, HttpException e) {
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();

        UnifyResponse message = new UnifyResponse(e.getCode(), exceptionCodeConfiguration.getMessage(e.getCode()), method + " " + requestUrl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
        return new ResponseEntity<UnifyResponse>(message, httpHeaders, httpStatus);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleBeanValidationException(HttpServletRequest req, MethodArgumentNotValidException e) {
        String method = req.getMethod();
        String requestUrl = req.getRequestURI();

        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = this.formatAllErrorsMessage(errors);
        return new UnifyResponse(10001, message, method + " " + requestUrl);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleConstraintViolationException(HttpServletRequest req, ConstraintViolationException e) {
        String method = req.getMethod();
        String requestUrl = req.getRequestURI();
        String message = e.getMessage();
//        for (ConstraintViolation error: e.getConstraintViolations()) {
//        }
        return new UnifyResponse(10001, message, method + " " + requestUrl);
    }


    private String formatAllErrorsMessage(List<ObjectError> errors) {
        StringBuffer errMsg = new StringBuffer();
        errors.forEach(error ->
                errMsg.append(error.getDefaultMessage()).append("；")
        );
        return errMsg.toString();
    }
}
