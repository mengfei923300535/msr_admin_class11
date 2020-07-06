package com.msr.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.constants.ResultCodeEnum;
import com.msr.common.exception.MSRException;
import com.msr.common.vo.R;
import com.msr.edu.entity.Teacher;
import com.msr.edu.query.TeacherQuery;
import com.msr.edu.service.TeacherService;
import com.msr.edu.service.impl.TeacherServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-06-12
 */
@Api(description="讲师管理")

@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("/list")
    public R list(){
        List<Teacher> teacherList = teacherService.list(null);
        return R.ok().data("list",teacherList);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("/delete")
    public R removeById(
            @ApiParam(name = "ids" , value = "讲师ID", required = true)
        @RequestBody Long[] ids){
        boolean flag = teacherService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    TeacherQuery teacherQuery){

        if(page <= 0 || limit <= 0){
            //throw new MSRException(21003, "参数不正确1");
            throw new MSRException(ResultCodeEnum.PARAM_ERROR);
        }

        Page<Teacher> pageParam = new Page<>(page, limit);

        teacherService.pageQuery(pageParam, teacherQuery);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("/save")
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){

        teacherService.save(teacher);
        return R.ok();
    }

    //后端但会的数据如果是集合，则键名用list，如果返回的时对象则用item

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("/info/{id}")//路径传参
    public R getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){

        Teacher teacher = teacherService.getById(id);
        return R.ok().data("item", teacher);
    }

    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("/update")//路径传参
    public R updateById(


            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){

        //teacher.setId(id);
        //teacherService.update(teacher,null);
        teacherService.updateById(teacher);
        return R.ok();
    }


}

