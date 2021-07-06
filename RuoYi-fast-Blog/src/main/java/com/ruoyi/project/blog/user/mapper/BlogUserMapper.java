package com.ruoyi.project.blog.user.mapper;

import java.util.List;
import com.ruoyi.project.blog.user.domain.BlogUser;

/**
 * 博客用户Mapper接口
 * 
 * @author vicent
 * @date 2021-07-06
 */
public interface BlogUserMapper 
{
    /**
     * 查询博客用户
     * 
     * @param userId 博客用户ID
     * @return 博客用户
     */
    public BlogUser selectBlogUserById(String userId);

    /**
     * 查询博客用户列表
     * 
     * @param blogUser 博客用户
     * @return 博客用户集合
     */
    public List<BlogUser> selectBlogUserList(BlogUser blogUser);

    /**
     * 新增博客用户
     * 
     * @param blogUser 博客用户
     * @return 结果
     */
    public int insertBlogUser(BlogUser blogUser);

    /**
     * 修改博客用户
     * 
     * @param blogUser 博客用户
     * @return 结果
     */
    public int updateBlogUser(BlogUser blogUser);

    /**
     * 删除博客用户
     * 
     * @param userId 博客用户ID
     * @return 结果
     */
    public int deleteBlogUserById(String userId);

    /**
     * 批量删除博客用户
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBlogUserByIds(String[] userIds);
}
