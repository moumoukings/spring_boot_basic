package com.mark85.basic.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户分页查询返回值
 *
 * @author zhangzichen
 * @date 2021/03/12 15:09
 */
@Data
@ApiModel("用户分页查询返回值")
public class UserPageResp {
    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    private Long id;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private Date birthday;
}
