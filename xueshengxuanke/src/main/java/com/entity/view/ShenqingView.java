package com.entity.view;

import com.entity.ShenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生选课
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-02
 */
@TableName("shenqing")
public class ShenqingView extends ShenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否同意的值
		*/
		private String shifouValue;

		private String kechengname;

	public String getKechengname() {
		return kechengname;
	}

	public void setKechengname(String kechengname) {
		this.kechengname = kechengname;
	}

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

		//级联表 xuanke
			/**
			* 课程名称
			*/
			private Integer kechengId;
			/**
			* 学科
			*/
			private Integer kemuTypes;
				/**
				* 学科的值
				*/
				private String kemuValue;
			/**
			* 教师名称
			*/
			private Integer jiaoshiId;
			/**
			* 课程性质
			*/
			private Integer xingzhiTypes;
				/**
				* 课程性质的值
				*/
				private String xingzhiValue;
			/**
			* 上课时间
			*/
			private String shijian;
			/**
			* 上课地点
			*/
			private String didian;
			/**
			* 学分
			*/
			private Double xuefen;
			/**
			* 周学时
			*/
			private String zhouxueshi;
			/**
			* 容量
			*/
			private Integer rongliang;
			/**
			* 已选
			*/
			private Integer yixuan;
			/**
			* 余量
			*/
			private Integer yuliang;
			/**
			* 备注
			*/
			private String beizhuContent;

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

	public ShenqingView() {

	}

	public ShenqingView(ShenqingEntity shenqingEntity) {
		try {
			BeanUtils.copyProperties(this, shenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 是否同意的值
			*/
			public String getShifouValue() {
				return shifouValue;
			}
			/**
			* 设置： 是否同意的值
			*/
			public void setShifouValue(String shifouValue) {
				this.shifouValue = shifouValue;
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










				//级联表的get和set xuanke
					/**
					* 获取： 课程名称
					*/
					public Integer getKechengId() {
						return kechengId;
					}
					/**
					* 设置： 课程名称
					*/
					public void setKechengId(Integer kechengId) {
						this.kechengId = kechengId;
					}
					/**
					* 获取： 学科
					*/
					public Integer getKemuTypes() {
						return kemuTypes;
					}
					/**
					* 设置： 学科
					*/
					public void setKemuTypes(Integer kemuTypes) {
						this.kemuTypes = kemuTypes;
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
					* 获取： 教师名称
					*/
					public Integer getJiaoshiId() {
						return jiaoshiId;
					}
					/**
					* 设置： 教师名称
					*/
					public void setJiaoshiId(Integer jiaoshiId) {
						this.jiaoshiId = jiaoshiId;
					}
					/**
					* 获取： 课程性质
					*/
					public Integer getXingzhiTypes() {
						return xingzhiTypes;
					}
					/**
					* 设置： 课程性质
					*/
					public void setXingzhiTypes(Integer xingzhiTypes) {
						this.xingzhiTypes = xingzhiTypes;
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
					/**
					* 获取： 上课时间
					*/
					public String getShijian() {
						return shijian;
					}
					/**
					* 设置： 上课时间
					*/
					public void setShijian(String shijian) {
						this.shijian = shijian;
					}
					/**
					* 获取： 上课地点
					*/
					public String getDidian() {
						return didian;
					}
					/**
					* 设置： 上课地点
					*/
					public void setDidian(String didian) {
						this.didian = didian;
					}
					/**
					* 获取： 学分
					*/
					public Double getXuefen() {
						return xuefen;
					}
					/**
					* 设置： 学分
					*/
					public void setXuefen(Double xuefen) {
						this.xuefen = xuefen;
					}
					/**
					* 获取： 周学时
					*/
					public String getZhouxueshi() {
						return zhouxueshi;
					}
					/**
					* 设置： 周学时
					*/
					public void setZhouxueshi(String zhouxueshi) {
						this.zhouxueshi = zhouxueshi;
					}
					/**
					* 获取： 容量
					*/
					public Integer getRongliang() {
						return rongliang;
					}
					/**
					* 设置： 容量
					*/
					public void setRongliang(Integer rongliang) {
						this.rongliang = rongliang;
					}
					/**
					* 获取： 已选
					*/
					public Integer getYixuan() {
						return yixuan;
					}
					/**
					* 设置： 已选
					*/
					public void setYixuan(Integer yixuan) {
						this.yixuan = yixuan;
					}
					/**
					* 获取： 余量
					*/
					public Integer getYuliang() {
						return yuliang;
					}
					/**
					* 设置： 余量
					*/
					public void setYuliang(Integer yuliang) {
						this.yuliang = yuliang;
					}
					/**
					* 获取： 备注
					*/
					public String getBeizhuContent() {
						return beizhuContent;
					}
					/**
					* 设置： 备注
					*/
					public void setBeizhuContent(String beizhuContent) {
						this.beizhuContent = beizhuContent;
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
