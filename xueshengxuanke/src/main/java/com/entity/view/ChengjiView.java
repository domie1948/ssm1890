package com.entity.view;

import com.entity.ChengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 成绩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-02
 */
@TableName("chengji")
public class ChengjiView extends ChengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 jiaoshi
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
				* 性别的值
				*/
				private String jssexValue;
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

		//级联表 kecheng
			/**
			* 课程名称
			*/
			private String kcname;

		//级联表 yonghu
			/**
			* 名称
			*/
			private String name;
			/**
			* 账号
			*/
			private String username;
			/**
			* 密码
			*/
			private String password;
			/**
			* 头像
			*/
			private String imgPhoto;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 身份证
			*/
			private String idNumber;
			/**
			* 身份
			*/
			private String role;

	public ChengjiView() {

	}

	public ChengjiView(ChengjiEntity chengjiEntity) {
		try {
			BeanUtils.copyProperties(this, chengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
















				//级联表的get和set jiaoshi
					/**
					* 获取： 名称
					*/
					public String getJsname() {
						return jsname;
					}
					/**
					* 设置： 名称
					*/
					public void setJsname(String jsname) {
						this.jsname = jsname;
					}
					/**
					* 获取： 账号
					*/
					public String getJsusername() {
						return jsusername;
					}
					/**
					* 设置： 账号
					*/
					public void setJsusername(String jsusername) {
						this.jsusername = jsusername;
					}
					/**
					* 获取： 密码
					*/
					public String getJspassword() {
						return jspassword;
					}
					/**
					* 设置： 密码
					*/
					public void setJspassword(String jspassword) {
						this.jspassword = jspassword;
					}
					/**
					* 获取： 头像
					*/
					public String getJsimgPhoto() {
						return jsimgPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setJsimgPhoto(String jsimgPhoto) {
						this.jsimgPhoto = jsimgPhoto;
					}
					/**
					* 获取： 性别
					*/
					public Integer getJssexTypes() {
						return jssexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setJssexTypes(Integer jssexTypes) {
						this.jssexTypes = jssexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getJssexValue() {
							return jssexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setJssexValue(String jssexValue) {
							this.jssexValue = jssexValue;
						}
					/**
					* 获取： 手机号
					*/
					public String getJsphone() {
						return jsphone;
					}
					/**
					* 设置： 手机号
					*/
					public void setJsphone(String jsphone) {
						this.jsphone = jsphone;
					}
					/**
					* 获取： 身份证
					*/
					public String getJsidNumber() {
						return jsidNumber;
					}
					/**
					* 设置： 身份证
					*/
					public void setJsidNumber(String jsidNumber) {
						this.jsidNumber = jsidNumber;
					}
					/**
					* 获取： 身份
					*/
					public String getJsrole() {
						return jsrole;
					}
					/**
					* 设置： 身份
					*/
					public void setJsrole(String jsrole) {
						this.jsrole = jsrole;
					}





				//级联表的get和set kecheng
					/**
					* 获取： 课程名称
					*/
					public String getKcname() {
						return kcname;
					}
					/**
					* 设置： 课程名称
					*/
					public void setKcname(String kcname) {
						this.kcname = kcname;
					}










				//级联表的get和set yonghu
					/**
					* 获取： 名称
					*/
					public String getName() {
						return name;
					}
					/**
					* 设置： 名称
					*/
					public void setName(String name) {
						this.name = name;
					}
					/**
					* 获取： 账号
					*/
					public String getUsername() {
						return username;
					}
					/**
					* 设置： 账号
					*/
					public void setUsername(String username) {
						this.username = username;
					}
					/**
					* 获取： 密码
					*/
					public String getPassword() {
						return password;
					}
					/**
					* 设置： 密码
					*/
					public void setPassword(String password) {
						this.password = password;
					}
					/**
					* 获取： 头像
					*/
					public String getImgPhoto() {
						return imgPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setImgPhoto(String imgPhoto) {
						this.imgPhoto = imgPhoto;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 手机号
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 手机号
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 身份证
					*/
					public String getIdNumber() {
						return idNumber;
					}
					/**
					* 设置： 身份证
					*/
					public void setIdNumber(String idNumber) {
						this.idNumber = idNumber;
					}
					/**
					* 获取： 身份
					*/
					public String getRole() {
						return role;
					}
					/**
					* 设置： 身份
					*/
					public void setRole(String role) {
						this.role = role;
					}






}
