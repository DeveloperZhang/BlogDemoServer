package com.ruoyi.project.blog.user.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.blog.user.mapper.BlogUserMapper;
import com.ruoyi.project.blog.user.domain.BlogUser;
import com.ruoyi.project.blog.user.service.IBlogUserService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 博客用户Service业务层处理
 * 
 * @author vicent
 * @date 2021-07-06
 */
@Service
public class BlogUserServiceImpl implements IBlogUserService 
{
    @Autowired
    private BlogUserMapper blogUserMapper;

    /**
     * 查询博客用户
     * 
     * @param userId 博客用户ID
     * @return 博客用户
     */
    @Override
    public BlogUser selectBlogUserById(String userId)
    {
        return blogUserMapper.selectBlogUserById(userId);
    }

    /**
     * 查询博客用户列表
     * 
     * @param blogUser 博客用户
     * @return 博客用户
     */
    @Override
    public List<BlogUser> selectBlogUserList(BlogUser blogUser)
    {
        return blogUserMapper.selectBlogUserList(blogUser);
    }

    /**
     * 新增博客用户
     * 
     * @param blogUser 博客用户
     * @return 结果
     */
    @Override
    public int insertBlogUser(BlogUser blogUser)
    {
        blogUser.setCreateTime(DateUtils.getNowDate());
        return blogUserMapper.insertBlogUser(blogUser);
    }

    /**
     * 修改博客用户
     * 
     * @param blogUser 博客用户
     * @return 结果
     */
    @Override
    public int updateBlogUser(BlogUser blogUser)
    {
        return blogUserMapper.updateBlogUser(blogUser);
    }

    /**
     * 删除博客用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBlogUserByIds(String ids)
    {
        return blogUserMapper.deleteBlogUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除博客用户信息
     * 
     * @param userId 博客用户ID
     * @return 结果
     */
    @Override
    public int deleteBlogUserById(String userId)
    {
        return blogUserMapper.deleteBlogUserById(userId);
    }
}
