package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.JiaoshiEntity;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JiaoshiEntity;

import com.service.JiaoshiService;
import com.entity.view.JiaoshiView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 用户表
 * 后端接口
 * @author
 * @email
 * @date 2021-04-02
*/
@RestController
@Controller
@RequestMapping("/jiaoshi")
public class JiaoshiController {
    private static final Logger logger = LoggerFactory.getLogger(JiaoshiController.class);

    @Autowired
    private JiaoshiService jiaoshiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        JiaoshiEntity yonghu = jiaoshiService.selectOne(new EntityWrapper<JiaoshiEntity>().eq("jsusername", username));
        if(yonghu==null || !yonghu.getJspassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(yonghu.getId(),username, "jiaoshi", "教师");
        R r = R.ok();
        r.put("token", token);
        r.put("role","教师");
        r.put("username",yonghu.getJsname());
        r.put("tableName","jiaoshi");
        r.put("userId",yonghu.getId());
        return r;
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JiaoshiEntity yonghu){
        //    	ValidatorUtils.validateEntity(user);
        if(jiaoshiService.selectOne(new EntityWrapper<JiaoshiEntity>().eq("username", yonghu.getJsusername()).orNew().eq("phone",yonghu.getJsphone()).orNew().eq("id_number",yonghu.getJsidNumber())) !=null) {
            return R.error("用户已存在或手机号身份证号已经被使用");
        }
        jiaoshiService.insert(yonghu);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  yonghuId){
        JiaoshiEntity yonghu = new JiaoshiEntity();
        yonghu.setJspassword("123456");
        yonghu.setId(yonghuId);
        jiaoshiService.updateById(yonghu);
        return R.ok();
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrYonghu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JiaoshiEntity yonghu = jiaoshiService.selectById(id);
        return R.ok().put("data", yonghu);
    }


    /**
     * 退出
     */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "教师".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = jiaoshiService.queryPage(params);

        //字典表数据转换
        List<JiaoshiView> list =(List<JiaoshiView>)page.getList();
        for(JiaoshiView c:list){
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
        JiaoshiEntity jiaoshi = jiaoshiService.selectById(id);
        if(jiaoshi !=null){
            //entity转view
            JiaoshiView view = new JiaoshiView();
            BeanUtils.copyProperties( jiaoshi , view );//把实体数据重构到view中

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
    public R save(@RequestBody JiaoshiEntity jiaoshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaoshi:{}",this.getClass().getName(),jiaoshi.toString());
        Wrapper<JiaoshiEntity> queryWrapper = new EntityWrapper<JiaoshiEntity>()
            .eq("jsname", jiaoshi.getJsname())
            .eq("jsusername", jiaoshi.getJsusername())
            .eq("jspassword", jiaoshi.getJspassword())
            .eq("jssex_types", jiaoshi.getJssexTypes())
            .eq("jsphone", jiaoshi.getJsphone())
            .eq("jsid_number", jiaoshi.getJsidNumber())
            .eq("jsrole", jiaoshi.getJsrole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoshiEntity jiaoshiEntity = jiaoshiService.selectOne(queryWrapper);
        if(jiaoshiEntity==null){
            jiaoshi.setJspassword("123456");
            jiaoshiService.insert(jiaoshi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaoshiEntity jiaoshi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaoshi:{}",this.getClass().getName(),jiaoshi.toString());
        //根据字段查询是否有相同数据
        Wrapper<JiaoshiEntity> queryWrapper = new EntityWrapper<JiaoshiEntity>()
            .notIn("id",jiaoshi.getId())
            .andNew()
            .eq("jsname", jiaoshi.getJsname())
            .eq("jsusername", jiaoshi.getJsusername())
            .eq("jspassword", jiaoshi.getJspassword())
            .eq("jssex_types", jiaoshi.getJssexTypes())
            .eq("jsphone", jiaoshi.getJsphone())
            .eq("jsid_number", jiaoshi.getJsidNumber())
            .eq("jsrole", jiaoshi.getJsrole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoshiEntity jiaoshiEntity = jiaoshiService.selectOne(queryWrapper);
        if("".equals(jiaoshi.getJsimgPhoto()) || "null".equals(jiaoshi.getJsimgPhoto())){
                jiaoshi.setJsimgPhoto(null);
        }
        if(jiaoshiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jiaoshi.set
            //  }
            jiaoshiService.updateById(jiaoshi);//根据id更新
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
        jiaoshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

