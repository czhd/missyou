package pro.kelu.missyou.exception.http;

public class HttpException extends RuntimeException {
    public Integer code;
    public Integer httpStatusCode = 500;
}
