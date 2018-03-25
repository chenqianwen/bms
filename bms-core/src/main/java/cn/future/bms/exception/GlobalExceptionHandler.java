package cn.future.bms.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author： ygl
 * @date： 2018/3/25
 * @Description：
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public void globalException(HttpServletRequest req, HttpServletResponse res, Exception e) throws IOException {
        res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
    }

}
