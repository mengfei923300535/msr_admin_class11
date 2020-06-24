package com.msr.statistics.service.impl;

import com.msr.statistics.entity.Daily;
import com.msr.statistics.feign.UcenterFeignService;
import com.msr.statistics.mapper.DailyMapper;
import com.msr.statistics.service.DailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author tom
 * @since 2020-06-15
 *
 * 调用feign接口
 */
@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements DailyService {
    @Autowired
    private UcenterFeignService ucenterFeignService;

    @Override
    public Integer createStatisticsByDay(String day) {
        //根据时间获得注册人数（远程调用）
        Integer registerNum = (Integer) ucenterFeignService.registerCount(day).getData().get("countRegister");

        //随机生成数据
        Integer loginNum = RandomUtils.nextInt(100, 200);//TODO
        Integer videoViewNum = RandomUtils.nextInt(100, 200);//TODO
        Integer courseNum = RandomUtils.nextInt(100, 200);//TODO


        //创建统计对象
        Daily daily = new Daily();
        daily.setRegisterNum(registerNum);
        daily.setLoginNum(loginNum);
        daily.setVideoViewNum(videoViewNum);
        daily.setCourseNum(courseNum);
        daily.setDateCalculated(day);

        baseMapper.insert(daily);
        return registerNum;
    }
}
