package com.entity.model;

import com.entity.JiaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 用户表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-02
 */
public class JiaoshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 名称
     */
    private String jsname;


    /**
     * 账号
     */
    private String jsusername;


    /**
     * 密码
     */
    private String jspassword;


    /**
     * 头像
     */
    private String jsimgPhoto;


    /**
     * 性别
     */
    private Integer jssexTypes;


    /**
     * 手机号
     */
    private String jsphone;


    /**
     * 身份证
     */
    private String jsidNumber;


    /**
     * 身份
     */
    private String jsrole;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：名称
	 */
    public String getJsname() {
        return jsname;
    }


    /**
	 * 设置：名称
	 */
    public void setJsname(String jsname) {
        this.jsname = jsname;
    }
    /**
	 * 获取：账号
	 */
    public String getJsusername() {
        return jsusername;
    }


    /**
	 * 设置：账号
	 */
    public void setJsusername(String jsusername) {
        this.jsusername = jsusername;
    }
    /**
	 * 获取：密码
	 */
    public String getJspassword() {
        return jspassword;
    }


    /**
	 * 设置：密码
	 */
    public void setJspassword(String jspassword) {
        this.jspassword = jspassword;
    }
    /**
	 * 获取：头像
	 */
    public String getJsimgPhoto() {
        return jsimgPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setJsimgPhoto(String jsimgPhoto) {
        this.jsimgPhoto = jsimgPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getJssexTypes() {
        return jssexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setJssexTypes(Integer jssexTypes) {
        this.jssexTypes = jssexTypes;
    }
    /**
	 * 获取：手机号
	 */
    public String getJsphone() {
        return jsphone;
    }


    /**
	 * 设置：手机号
	 */
    public void setJsphone(String jsphone) {
        this.jsphone = jsphone;
    }
    /**
	 * 获取：身份证
	 */
    public String getJsidNumber() {
        return jsidNumber;
    }


    /**
	 * 设置：身份证
	 */
    public void setJsidNumber(String jsidNumber) {
        this.jsidNumber = jsidNumber;
    }
    /**
	 * 获取：身份
	 */
    public String getJsrole() {
        return jsrole;
    }


    /**
	 * 设置：身份
	 */
    public void setJsrole(String jsrole) {
        this.jsrole = jsrole;
    }

    }
