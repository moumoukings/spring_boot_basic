package com.mark85.basic.entity.query;

import com.mark85.basic.base.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

/**
 * 用户分页查询
 *
 * @author zhangzichen
 * @date 2021/03/10 13:07
 */
@Data
@ApiModel("用户分页查询模型")
public class UserPageQuery extends BasePageQuery {

    /**
     * 用户状态
     */
    @ApiModelProperty(value = "用户状态")
    @NotEmpty(message = "用户状态不能为空")
    @Range(min =  -1 , max = 1 , message = "用户状态有误")
    private String status;

}
