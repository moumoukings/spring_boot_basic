package com.mark85.basic.controller.other;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mark85.basic.entity.query.UserPageQuery;
import com.mark85.basic.entity.response.UserPageResp;
import com.mark85.basic.entity.vo.ResultVo;
import com.mark85.basic.service.UserDoService;
import com.mark85.basic.utils.ResultVoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * PageHelp案例
 *
 * @author zhangzichen
 * @date 2021/03/12 14:17
 */
@RestController
@RequestMapping(value = "/pageHelp")
@Api(tags = "PageHelp")
public class PageHelpDemoController {

    @Autowired
    private UserDoService userDoService;

    @ApiOperation("获取用户列表")
    @PostMapping("/pageUser")
    public ResultVo pageUser(@Validated UserPageQuery pageQuery) {
        //设置分页条件
        PageHelper.startPage(pageQuery.getCurrentPage(), pageQuery.getPageSize());
        List<UserPageResp> list = userDoService.page(pageQuery);
        //返回分页数据
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultVoUtil.success(pageInfo);
    }
}
