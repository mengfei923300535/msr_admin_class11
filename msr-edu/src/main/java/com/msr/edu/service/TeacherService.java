package com.msr.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.edu.query.TeacherQuery;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author tom
 * @since 2020-06-12
 */
@Service
public interface TeacherService extends IService<Teacher> {
    void pageQuery(Page<Teacher> pageParam, TeacherQuery teacherQuery);
}
