package com.mark85.basic.controller.user;

import com.mark85.basic.demo.user.AddUserDemo;
import com.mark85.basic.demo.user.ListUserDemo;
import com.mark85.basic.entity.vo.ResultVo;
import com.mark85.basic.entity.vo.UserVo;
import com.mark85.basic.enums.ResultEnum;
import com.mark85.basic.service.UserDoService;
import com.mark85.basic.utils.ResultVoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author zhangzichen
 * @since 2021-03-10
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserDoController {

    @Autowired
    private UserDoService userDoService;

    /**
     * 添加用户
     * @param userDemo 表单数据
     * @return 成功或者失败
     */
    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public ResultVo addUser(@Validated @RequestBody AddUserDemo userDemo){
        if(userDoService.addUser(userDemo)){
            return ResultVoUtil.success();
        }else{
            return ResultVoUtil.error(ResultEnum.ADD_ERROR);
        }
    }

    /**
     * 获取用户列表
     * @param listUserDemo 表单数据
     * @return 用户列表
     */
    @ApiOperation("获取用户列表")
    @GetMapping("/listUser")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = UserVo.class)
    )
    public ResultVo listUser(@Validated ListUserDemo listUserDemo){
        return ResultVoUtil.success(userDoService.listUser(listUserDemo));
    }

    /**
     * 删除用户
     * @param id 用户编号
     * @return 成功或者失败
     */
    @ApiOperation("删除用户")
    @DeleteMapping("/deleteUser/{id}")
    public ResultVo deleteUser(@PathVariable("id") String id){
        userDoService.deleteUser(id);
        return ResultVoUtil.success();
    }

}
