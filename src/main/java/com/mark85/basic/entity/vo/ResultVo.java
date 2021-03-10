package com.mark85.basic.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 固定返回格式
 *
 * @author zhangzichen
 * @date 2021/03/10 12:52
 */
@Data
@ApiModel("固定返回格式")
public class ResultVo {

    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty(value = "提示信息")
    private String message;

    /**
     * 具体的内容
     */
    @ApiModelProperty(value = "响应数据")
    private Object data;

}
