package com.ruoyi.project.blog.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 博客用户对象 blog_user
 * 
 * @author vicent
 * @date 2021-07-06
 */
public class BlogUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private String userId;

    /** 登录名 */
    @Excel(name = "登录名")
    private String loginName;

    /** 登录密码 */
    @Excel(name = "登录密码")
    private String password;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 性别（0男 1女 2未知） */
    @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getLoginName()
    {
        return loginName;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getNickName()
    {
        return nickName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("loginName", getLoginName())
            .append("password", getPassword())
            .append("phone", getPhone())
            .append("sex", getSex())
            .append("createTime", getCreateTime())
            .append("nickName", getNickName())
            .append("remark", getRemark())
            .toString();
    }
}
