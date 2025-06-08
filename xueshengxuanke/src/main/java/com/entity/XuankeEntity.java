package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 选课
 *
 * @author 
 * @email
 * @date 2021-04-02
 */
@TableName("xuanke")
public class XuankeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuankeEntity() {

	}

	public XuankeEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 课程名称
     */
    @TableField(value = "kecheng_id")

    private Integer kechengId;


    /**
     * 学科
     */
    @TableField(value = "kemu_types")

    private Integer kemuTypes;


    /**
     * 教师名称
     */
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 课程性质
     */
    @TableField(value = "xingzhi_types")

    private Integer xingzhiTypes;


    /**
     * 上课时间
     */
    @TableField(value = "shijian")

    private String shijian;


    /**
     * 上课地点
     */
    @TableField(value = "didian")

    private String didian;


    /**
     * 学分
     */
    @TableField(value = "xuefen")

    private Double xuefen;


    /**
     * 周学时
     */
    @TableField(value = "zhouxueshi")

    private String zhouxueshi;


    /**
     * 容量
     */
    @TableField(value = "rongliang")

    private Integer rongliang;


    /**
     * 已选
     */
    @TableField(value = "yixuan")

    private Integer yixuan;


    /**
     * 余量
     */
    @TableField(value = "yuliang")

    private Integer yuliang;


    /**
     * 备注
     */
    @TableField(value = "beizhu_content")

    private String beizhuContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：课程名称
	 */
    public Integer getKechengId() {
        return kechengId;
    }


    /**
	 * 获取：课程名称
	 */

    public void setKechengId(Integer kechengId) {
        this.kechengId = kechengId;
    }
    /**
	 * 设置：学科
	 */
    public Integer getKemuTypes() {
        return kemuTypes;
    }


    /**
	 * 获取：学科
	 */

    public void setKemuTypes(Integer kemuTypes) {
        this.kemuTypes = kemuTypes;
    }
    /**
	 * 设置：教师名称
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：教师名称
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：课程性质
	 */
    public Integer getXingzhiTypes() {
        return xingzhiTypes;
    }


    /**
	 * 获取：课程性质
	 */

    public void setXingzhiTypes(Integer xingzhiTypes) {
        this.xingzhiTypes = xingzhiTypes;
    }
    /**
	 * 设置：上课时间
	 */
    public String getShijian() {
        return shijian;
    }


    /**
	 * 获取：上课时间
	 */

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }
    /**
	 * 设置：上课地点
	 */
    public String getDidian() {
        return didian;
    }


    /**
	 * 获取：上课地点
	 */

    public void setDidian(String didian) {
        this.didian = didian;
    }
    /**
	 * 设置：学分
	 */
    public Double getXuefen() {
        return xuefen;
    }


    /**
	 * 获取：学分
	 */

    public void setXuefen(Double xuefen) {
        this.xuefen = xuefen;
    }
    /**
	 * 设置：周学时
	 */
    public String getZhouxueshi() {
        return zhouxueshi;
    }


    /**
	 * 获取：周学时
	 */

    public void setZhouxueshi(String zhouxueshi) {
        this.zhouxueshi = zhouxueshi;
    }
    /**
	 * 设置：容量
	 */
    public Integer getRongliang() {
        return rongliang;
    }


    /**
	 * 获取：容量
	 */

    public void setRongliang(Integer rongliang) {
        this.rongliang = rongliang;
    }
    /**
	 * 设置：已选
	 */
    public Integer getYixuan() {
        return yixuan;
    }


    /**
	 * 获取：已选
	 */

    public void setYixuan(Integer yixuan) {
        this.yixuan = yixuan;
    }
    /**
	 * 设置：余量
	 */
    public Integer getYuliang() {
        return yuliang;
    }


    /**
	 * 获取：余量
	 */

    public void setYuliang(Integer yuliang) {
        this.yuliang = yuliang;
    }
    /**
	 * 设置：备注
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xuanke{" +
            "id=" + id +
            ", kechengId=" + kechengId +
            ", kemuTypes=" + kemuTypes +
            ", jiaoshiId=" + jiaoshiId +
            ", xingzhiTypes=" + xingzhiTypes +
            ", shijian=" + shijian +
            ", didian=" + didian +
            ", xuefen=" + xuefen +
            ", zhouxueshi=" + zhouxueshi +
            ", rongliang=" + rongliang +
            ", yixuan=" + yixuan +
            ", yuliang=" + yuliang +
            ", beizhuContent=" + beizhuContent +
            ", createTime=" + createTime +
        "}";
    }
}
