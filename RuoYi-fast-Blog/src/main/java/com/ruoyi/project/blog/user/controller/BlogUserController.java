package com.ruoyi.project.blog.user.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.blog.user.domain.BlogUser;
import com.ruoyi.project.blog.user.service.IBlogUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 博客用户Controller
 * 
 * @author vicent
 * @date 2021-07-06
 */
@Controller
@RequestMapping("/blog/user")
public class BlogUserController extends BaseController
{
    private String prefix = "blog/user";

    @Autowired
    private IBlogUserService blogUserService;

    @RequiresPermissions("blog:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询博客用户列表
     */
    @RequiresPermissions("blog:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BlogUser blogUser)
    {
        startPage();
        List<BlogUser> list = blogUserService.selectBlogUserList(blogUser);
        return getDataTable(list);
    }

    /**
     * 导出博客用户列表
     */
    @RequiresPermissions("blog:user:export")
    @Log(title = "博客用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BlogUser blogUser)
    {
        List<BlogUser> list = blogUserService.selectBlogUserList(blogUser);
        ExcelUtil<BlogUser> util = new ExcelUtil<BlogUser>(BlogUser.class);
        return util.exportExcel(list, "博客用户数据");
    }

    /**
     * 新增博客用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存博客用户
     */
    @RequiresPermissions("blog:user:add")
    @Log(title = "博客用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BlogUser blogUser)
    {
        return toAjax(blogUserService.insertBlogUser(blogUser));
    }

    /**
     * 修改博客用户
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") String userId, ModelMap mmap)
    {
        BlogUser blogUser = blogUserService.selectBlogUserById(userId);
        mmap.put("blogUser", blogUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存博客用户
     */
    @RequiresPermissions("blog:user:edit")
    @Log(title = "博客用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BlogUser blogUser)
    {
        return toAjax(blogUserService.updateBlogUser(blogUser));
    }

    /**
     * 删除博客用户
     */
    @RequiresPermissions("blog:user:remove")
    @Log(title = "博客用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(blogUserService.deleteBlogUserByIds(ids));
    }
}
