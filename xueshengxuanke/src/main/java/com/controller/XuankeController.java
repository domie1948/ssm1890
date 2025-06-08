package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.ShenqingEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.XuankeEntity;

import com.entity.view.XuankeView;
import com.entity.JiaoshiEntity;
import com.entity.KechengEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 选课
 * 后端接口
 * @author
 * @email
 * @date 2021-04-02
*/
@RestController
@Controller
@RequestMapping("/xuanke")
public class XuankeController {
    private static final Logger logger = LoggerFactory.getLogger(XuankeController.class);

    @Autowired
    private XuankeService xuankeService;


    @Autowired
    private ShenqingService shenqingService;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private JiaoshiService jiaoshiService;
    @Autowired
    private KechengService kechengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "学生".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        if(StringUtil.isNotEmpty(role) && "教师".equals(role)){
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = xuankeService.queryPage(params);

        //字典表数据转换
        List<XuankeView> list =(List<XuankeView>)page.getList();
        for(XuankeView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuankeEntity xuanke = xuankeService.selectById(id);
        if(xuanke !=null){
            //entity转view
            XuankeView view = new XuankeView();
            BeanUtils.copyProperties( xuanke , view );//把实体数据重构到view中

            //级联表
            JiaoshiEntity jiaoshi = jiaoshiService.selectById(xuanke.getJiaoshiId());
            if(jiaoshi != null){
                BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiaoshiId(jiaoshi.getId());
            }
            //级联表
            KechengEntity kecheng = kechengService.selectById(xuanke.getKechengId());
            if(kecheng != null){
                BeanUtils.copyProperties( kecheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setKechengId(kecheng.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XuankeEntity xuanke, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuanke:{}",this.getClass().getName(),xuanke.toString());
        Wrapper<XuankeEntity> queryWrapper = new EntityWrapper<XuankeEntity>()
            .eq("kecheng_id", xuanke.getKechengId())
            .eq("kemu_types", xuanke.getKemuTypes())
            .eq("jiaoshi_id", xuanke.getJiaoshiId())
            .eq("xingzhi_types", xuanke.getXingzhiTypes())
            .eq("shijian", xuanke.getShijian())
            .eq("didian", xuanke.getDidian())
            .eq("zhouxueshi", xuanke.getZhouxueshi())
            .eq("rongliang", xuanke.getRongliang())
            .eq("yixuan", xuanke.getYixuan())
            .eq("yuliang", xuanke.getYuliang())
            .eq("beizhu_content", xuanke.getBeizhuContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuankeEntity xuankeEntity = xuankeService.selectOne(queryWrapper);
        if(xuankeEntity==null){
            xuanke.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      xuanke.set
        //  }
            xuanke.setYuliang(xuanke.getRongliang());
            xuankeService.insert(xuanke);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuankeEntity xuanke, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xuanke:{}",this.getClass().getName(),xuanke.toString());
        //根据字段查询是否有相同数据
        Wrapper<XuankeEntity> queryWrapper = new EntityWrapper<XuankeEntity>()
            .notIn("id",xuanke.getId())
            .andNew()
            .eq("kecheng_id", xuanke.getKechengId())
            .eq("kemu_types", xuanke.getKemuTypes())
            .eq("jiaoshi_id", xuanke.getJiaoshiId())
            .eq("xingzhi_types", xuanke.getXingzhiTypes())
            .eq("shijian", xuanke.getShijian())
            .eq("didian", xuanke.getDidian())
            .eq("zhouxueshi", xuanke.getZhouxueshi())
            .eq("rongliang", xuanke.getRongliang())
            .eq("yixuan", xuanke.getYixuan())
            .eq("yuliang", xuanke.getYuliang())
            .eq("beizhu_content", xuanke.getBeizhuContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuankeEntity xuankeEntity = xuankeService.selectOne(queryWrapper);
        if(xuankeEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xuanke.set
            //  }
            xuankeService.updateById(xuanke);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xuankeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 退课
    */
    @RequestMapping("/delete1")
    public R delete1(Integer id){
        ShenqingEntity shenqing = shenqingService.selectById(id);
        if(shenqing == null){
            return R.error();
        }
        XuankeEntity xuanke = xuankeService.selectById(shenqing.getXuankeId());
        if(xuanke == null){
            return R.error();
        }
        xuanke.setYuliang(xuanke.getYuliang()+1);
        xuanke.setYixuan(xuanke.getYixuan()-1);
        boolean b1 = xuankeService.updateById(xuanke);
        if(b1){
            shenqingService.deleteById(id);
            return R.ok();
        }
            return R.error();
    }


    /**
     * 选课
     */
    @RequestMapping("/xuanke")
    public R xuanke(Integer id, HttpServletRequest request){
        XuankeEntity xuanke = xuankeService.selectById(id);
        if(xuanke == null){
            return R.error();
        }
        if(xuanke.getYuliang() < 1){
            return R.error("这门课以选完");
        }
        ShenqingEntity shenqing = new ShenqingEntity();
        shenqing.setJiaoshiId(xuanke.getJiaoshiId());
        shenqing.setShifouTypes(0);
        shenqing.setYonghuId((Integer) request.getSession().getAttribute("userId"));
        shenqing.setXuankeId(id);
        Wrapper<ShenqingEntity> queryWrapper = new EntityWrapper<ShenqingEntity>()
                .eq("xuanke_id", shenqing.getXuankeId())
                .eq("yonghu_id", shenqing.getYonghuId())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenqingEntity shenqingEntity = shenqingService.selectOne(queryWrapper);
        if(shenqingEntity!=null){
            return R.error("已经选过这门课了");
        }
        boolean insert = shenqingService.insert(shenqing);
        if(insert){
            return R.ok();
        }else{
            return R.error();
        }
    }
    /**
     * 同意
     */
    @RequestMapping("/tongyi")
    public R tongyi(Integer id, HttpServletRequest request){
        ShenqingEntity shenqing = shenqingService.selectById(id);
        if(shenqing == null){
            return R.error();
        }
        XuankeEntity xuanke = xuankeService.selectById(shenqing.getXuankeId());
        if(xuanke == null){
            return R.error();
        }
        shenqing.setShifouTypes(1);
        boolean b = shenqingService.updateById(shenqing);
        if(b){
            xuanke.setYuliang(xuanke.getYuliang()-1);
            xuanke.setYixuan(xuanke.getYixuan()+1);
            boolean b1 = xuankeService.updateById(xuanke);
            if(b1){
                return R.ok();
            }
        }
        return R.error();
    }



}

