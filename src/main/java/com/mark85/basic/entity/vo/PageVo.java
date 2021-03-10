package com.mark85.basic.entity.vo;

import com.mark85.basic.base.BasePage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 分页视图对象
 *
 * @author zhangzichen
 * @date 2021/03/10 13:06
 */
@Data
public class PageVo<T> {
    /**
     * 分页数据
     */
    @ApiModelProperty(value = "分页数据")
    private List<T> records;
    /**
     * 总条数
     */
    @ApiModelProperty(value = "总条数")
    private Integer total;

    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private Integer pages;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer current;

    /**
     * 查询数量
     */
    @ApiModelProperty(value = "查询数量")
    private Integer size;

    /**
     * 设置当前页和每页显示的数量
     * @param basePage 分页表单
     * @return 返回分页信息
     */
    @ApiModelProperty(hidden = true)
    public PageVo<T> setCurrentAndSize(BasePage<?> basePage){
        BeanUtils.copyProperties(basePage,this);
        return this;
    }

    /**
     * 设置总记录数
     * @param total 总记录数
     */
    @ApiModelProperty(hidden = true)
    public void setTotal(Integer total) {
        this.total = total;
        this.setPages(this.total % this.size > 0 ? this.total / this.size + 1 : this.total / this.size);
    }
}
