package com.mark85.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mark85.basic.demo.user.AddUserDemo;
import com.mark85.basic.demo.user.ListUserDemo;
import com.mark85.basic.entity.UserDo;
import com.mark85.basic.entity.query.UserPageQuery;
import com.mark85.basic.entity.response.UserPageResp;
import com.mark85.basic.entity.vo.PageVo;
import com.mark85.basic.entity.vo.UserVo;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author zhangzichen
 * @since 2021-03-10
 */
public interface UserDoService extends IService<UserDo> {

    /**
     * 添加用户
     *
     * @param userDemo 表单数据
     * @return true 或者 false
     */
    boolean addUser(AddUserDemo userDemo);

    /**
     * 获取用户列表
     *
     * @param listUserDemo 表单数据
     * @return 用户列表
     */
    PageVo<UserVo> listUser(ListUserDemo listUserDemo);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(String id);

    /**
     * 用pageHelp分页
     * @param pageQuery
     * @return
     */
    List<UserPageResp> page(UserPageQuery pageQuery);
}
