package com.mark85.basic.demo.user;

import com.mark85.basic.base.BasePage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

/**
 * d
 *
 * @author zhangzichen
 * @date 2021/03/10 14:11
 */
@Data
@ApiModel("获取用户列表需要的表单数据")
@EqualsAndHashCode(callSuper = false)
public class ListUserDemo extends BasePage<ListUserDemo> {

    /**
     * 用户状态
     */
    @ApiModelProperty("用户状态")
    @NotEmpty(message = "用户状态不能为空")
    @Range(min =  -1 , max = 1 , message = "用户状态有误")
    private String status;
}
