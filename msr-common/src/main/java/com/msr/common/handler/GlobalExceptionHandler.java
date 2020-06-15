package com.msr.common.handler;

import com.fasterxml.jackson.core.JsonParseException;
import com.msr.common.constants.ResultCodeEnum;
import com.msr.common.exception.MSRException;
import com.msr.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Fei
 * @Package com.msr.common.handler
 * @date 2020/6/15 9:33
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error();
    }
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e){
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(JsonParseException e){
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    @ExceptionHandler(MSRException .class)
    @ResponseBody
    public R error(MSRException e){
        //e.printStackTrace();堆栈输出
        //e.printStackTrace();
        log.error(e.getMessage());
        return R.error().message(e.getMessage()).code(e.getCode());
    }


}

