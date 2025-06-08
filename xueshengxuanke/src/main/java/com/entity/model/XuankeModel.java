package com.entity.model;

import com.entity.XuankeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 选课
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-02
 */
public class XuankeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课程名称
     */
    private Integer kechengId;


    /**
     * 学科
     */
    private Integer kemuTypes;


    /**
     * 教师名称
     */
    private Integer jiaoshiId;


    /**
     * 课程性质
     */
    private Integer xingzhiTypes;


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


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


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
	 * 获取：课程名称
	 */
    public Integer getKechengId() {
        return kechengId;
    }


    /**
	 * 设置：课程名称
	 */
    public void setKechengId(Integer kechengId) {
        this.kechengId = kechengId;
    }
    /**
	 * 获取：学科
	 */
    public Integer getKemuTypes() {
        return kemuTypes;
    }


    /**
	 * 设置：学科
	 */
    public void setKemuTypes(Integer kemuTypes) {
        this.kemuTypes = kemuTypes;
    }
    /**
	 * 获取：教师名称
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：教师名称
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：课程性质
	 */
    public Integer getXingzhiTypes() {
        return xingzhiTypes;
    }


    /**
	 * 设置：课程性质
	 */
    public void setXingzhiTypes(Integer xingzhiTypes) {
        this.xingzhiTypes = xingzhiTypes;
    }
    /**
	 * 获取：上课时间
	 */
    public String getShijian() {
        return shijian;
    }


    /**
	 * 设置：上课时间
	 */
    public void setShijian(String shijian) {
        this.shijian = shijian;
    }
    /**
	 * 获取：上课地点
	 */
    public String getDidian() {
        return didian;
    }


    /**
	 * 设置：上课地点
	 */
    public void setDidian(String didian) {
        this.didian = didian;
    }
    /**
	 * 获取：学分
	 */
    public Double getXuefen() {
        return xuefen;
    }


    /**
	 * 设置：学分
	 */
    public void setXuefen(Double xuefen) {
        this.xuefen = xuefen;
    }
    /**
	 * 获取：周学时
	 */
    public String getZhouxueshi() {
        return zhouxueshi;
    }


    /**
	 * 设置：周学时
	 */
    public void setZhouxueshi(String zhouxueshi) {
        this.zhouxueshi = zhouxueshi;
    }
    /**
	 * 获取：容量
	 */
    public Integer getRongliang() {
        return rongliang;
    }


    /**
	 * 设置：容量
	 */
    public void setRongliang(Integer rongliang) {
        this.rongliang = rongliang;
    }
    /**
	 * 获取：已选
	 */
    public Integer getYixuan() {
        return yixuan;
    }


    /**
	 * 设置：已选
	 */
    public void setYixuan(Integer yixuan) {
        this.yixuan = yixuan;
    }
    /**
	 * 获取：余量
	 */
    public Integer getYuliang() {
        return yuliang;
    }


    /**
	 * 设置：余量
	 */
    public void setYuliang(Integer yuliang) {
        this.yuliang = yuliang;
    }
    /**
	 * 获取：备注
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }


    /**
	 * 设置：备注
	 */
    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
