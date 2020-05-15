package pro.kelu.missyou.core;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.kelu.missyou.exception.http.HttpException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public UnifyResponse handleException(HttpServletRequest req, Exception e) {
        System.out.println("统一捕获异常");
        UnifyResponse message = new UnifyResponse(999, "服务器错误", "url");
        return message;
    }

    @ExceptionHandler(HttpException.class)
    public UnifyResponse httpHandelException(HttpServletRequest req, HttpException e) {
        System.out.println("Http异常处理");
        UnifyResponse message = new UnifyResponse(999, "服务器错误", "url");
        return message;
    }
}
