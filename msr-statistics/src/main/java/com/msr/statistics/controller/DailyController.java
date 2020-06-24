package com.msr.statistics.controller;


import com.msr.common.vo.R;
import com.msr.statistics.entity.Daily;
import com.msr.statistics.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-06-15
 */
@CrossOrigin
@RestController
@RequestMapping("/statistics/daily")
public class DailyController {
    @Autowired
    private DailyService dailyService;

    @GetMapping("/list")
    public R list() {
        List<Daily> list = dailyService.list(null);
        return R.ok().data("list", list);
    }

    //调用方法，调用业务层统计注册人数的功能
    @GetMapping("{day}")
    public R createStatisticsByDate(@PathVariable String day) {
        Integer countRegister = dailyService.createStatisticsByDay(day);
        return R.ok().data("countRegister", countRegister);

    }
}

