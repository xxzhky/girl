package com.dt.handle;

import com.dt.domain.Girl;
import com.dt.domain.Result;
import com.dt.exception.GirlException;
import com.dt.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by RID on 2017/4/12.
 */
@ControllerAdvice
public class ExceptionsHandler {
    private Logger logger= LoggerFactory.getLogger(ExceptionsHandler.class);

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Result handleShow(Exception e){
        if (e instanceof GirlException){
            GirlException ge=(GirlException)e;
            return ResultUtil.err(ge.getCode(),ge.getMessage());
        }else {
            logger.error("Sys Exception: {}", e);
            return ResultUtil.err(-1, "unknow error.");
        }
    }

}

