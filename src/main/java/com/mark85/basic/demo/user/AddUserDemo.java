package com.mark85.basic.demo.user;

import com.mark85.basic.base.BaseEntity;
import com.mark85.basic.entity.UserDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 添加用户
 *
 * @author zhangzichen
 * @date 2021/03/10 14:08
 */
@Data
@ApiModel(value = "添加用户需要的表单数据")
@EqualsAndHashCode(callSuper = false)
public class AddUserDemo extends BaseEntity<UserDo> {
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    @NotEmpty(message = "昵称不能为为空")
    @Length(min = 1, max = 10, message = "昵称长度限制为1~10")
    private String nickname;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    @Past(message = "生日时间必须小于当前时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 1, max = 16, message = "用户名长度限制为1~16")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码：包含字符、数字、特殊符号8-20位")
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[._~!@#$^&*])[A-Za-z0-9._~!@#$^&*]{8,20}$", message = "密码不符合规范")
    private String password;

    /**
     * 构造实体
     *
     * @return 实体对象
     */
    @Override
    public UserDo buildEntity() {
        UserDo user = new UserDo();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}
