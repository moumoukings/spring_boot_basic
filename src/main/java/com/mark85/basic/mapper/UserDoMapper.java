package com.mark85.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mark85.basic.demo.user.ListUserDemo;
import com.mark85.basic.entity.UserDo;
import com.mark85.basic.entity.vo.UserVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author zhangzichen
 * @since 2021-03-10
 */
public interface UserDoMapper extends BaseMapper<UserDo> {

    /**
     * 获取用户列表
     *
     * @param listUserDemo 表单数据
     * @return 用户列表
     */
    @Select("SELECT id,nickname,username,birthday FROM `user` WHERE `status`= #{status} AND `is_deleted`= 'false' LIMIT #{current},#{size}")
    List<UserVo> listUser(ListUserDemo listUserDemo);
}
