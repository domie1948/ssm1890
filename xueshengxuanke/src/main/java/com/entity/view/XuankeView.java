package com.entity.view;

import com.entity.XuankeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 选课
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-02
 */
@TableName("xuanke")
public class XuankeView extends XuankeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 学科的值
		*/
		private String kemuValue;
		/**
		* 课程性质的值
		*/
		private String xingzhiValue;



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

	public XuankeView() {

	}

	public XuankeView(XuankeEntity xuankeEntity) {
		try {
			BeanUtils.copyProperties(this, xuankeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 学科的值
			*/
			public String getKemuValue() {
				return kemuValue;
			}
			/**
			* 设置： 学科的值
			*/
			public void setKemuValue(String kemuValue) {
				this.kemuValue = kemuValue;
			}
			/**
			* 获取： 课程性质的值
			*/
			public String getXingzhiValue() {
				return xingzhiValue;
			}
			/**
			* 设置： 课程性质的值
			*/
			public void setXingzhiValue(String xingzhiValue) {
				this.xingzhiValue = xingzhiValue;
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













}
