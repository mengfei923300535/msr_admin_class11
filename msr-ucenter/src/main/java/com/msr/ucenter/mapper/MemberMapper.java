package com.msr.ucenter.mapper;

import com.msr.ucenter.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author tom
 * @since 2020-06-15
 */
@Repository
public interface MemberMapper extends BaseMapper<Member> {
    /**
     * @param day
     * @return
     */
    Integer selectRegisterCount(String day);

}
