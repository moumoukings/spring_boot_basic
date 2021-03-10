package com.mark85.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mark85.basic.demo.user.AddUserDemo;
import com.mark85.basic.demo.user.ListUserDemo;
import com.mark85.basic.entity.UserDo;
import com.mark85.basic.entity.vo.PageVo;
import com.mark85.basic.entity.vo.UserVo;
import com.mark85.basic.enums.ResultEnum;
import com.mark85.basic.exception.CustomException;
import com.mark85.basic.mapper.UserDoMapper;
import com.mark85.basic.service.UserDoService;
import com.mark85.basic.utils.MethodUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author zhangzichen
 * @since 2021-03-10
 */
@Service
public class UserDoServiceImpl extends ServiceImpl<UserDoMapper, UserDo> implements UserDoService {

    @Autowired
    private UserDoMapper userDoMapper;

    /**
     * 添加用户
     *
     * @param userDemo 表单数据
     * @return true 或者 false
     */
    @Override
    public boolean addUser(AddUserDemo userDemo) {
        return save(userDemo.buildEntity());
    }

    /**
     * 获取用户列表
     *
     * @param listUserDemo 表单数据
     * @return 用户列表
     */
    @Override
    public PageVo<UserVo> listUser(ListUserDemo listUserDemo) {
        PageVo<UserVo> pageVo = new PageVo<>();
        pageVo.setCurrentAndSize(listUserDemo);
        pageVo.setTotal(countUser(listUserDemo.getStatus()));
        pageVo.setRecords(userDoMapper.listUser(listUserDemo.calcCurrent()));
        return pageVo;
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        // 如果删除失败抛出异常。 -- 演示而已不推荐这样干
        if(!removeById(id)){
            throw new CustomException(ResultEnum.DELETE_ERROR, MethodUtil.getLineInfo());
        }
    }

    /**
     * 获取用户数量
     * @param status 状态
     * @return 用户数量
     */
    private Integer countUser(String status){
        return count(new QueryWrapper<UserDo>().eq("status",status));
    }
}
