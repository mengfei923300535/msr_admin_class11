package com.msr.statistics.feign;

import com.msr.common.vo.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Fei
 * @Package com.msr.statistics.feign
 * @date 2020/6/17 14:14
 *
 * 对外接口
 */
@FeignClient("msr-ucenter")
public interface UcenterFeignService {
    //定义方法：参考对外服务的controller中的方法
    @ApiOperation(value = "今日注册数")
    @GetMapping(value = "/ucenter/member/count-register/{day}")
    public R registerCount(
            @ApiParam(name = "day", value = "统计日期")
            @PathVariable String day);

}
