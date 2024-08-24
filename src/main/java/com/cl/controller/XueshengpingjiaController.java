package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XueshengpingjiaEntity;
import com.cl.entity.view.XueshengpingjiaView;

import com.cl.service.XueshengpingjiaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生评价
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@RestController
@RequestMapping("/xueshengpingjia")
public class XueshengpingjiaController {
    @Autowired
    private XueshengpingjiaService xueshengpingjiaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengpingjiaEntity xueshengpingjia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengpingjia.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengpingjiaEntity> ew = new EntityWrapper<XueshengpingjiaEntity>();

		PageUtils page = xueshengpingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengpingjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengpingjiaEntity xueshengpingjia, 
		HttpServletRequest request){
        EntityWrapper<XueshengpingjiaEntity> ew = new EntityWrapper<XueshengpingjiaEntity>();

		PageUtils page = xueshengpingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengpingjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengpingjiaEntity xueshengpingjia){
       	EntityWrapper<XueshengpingjiaEntity> ew = new EntityWrapper<XueshengpingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengpingjia, "xueshengpingjia")); 
        return R.ok().put("data", xueshengpingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengpingjiaEntity xueshengpingjia){
        EntityWrapper< XueshengpingjiaEntity> ew = new EntityWrapper< XueshengpingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengpingjia, "xueshengpingjia")); 
		XueshengpingjiaView xueshengpingjiaView =  xueshengpingjiaService.selectView(ew);
		return R.ok("查询学生评价成功").put("data", xueshengpingjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengpingjiaEntity xueshengpingjia = xueshengpingjiaService.selectById(id);
		xueshengpingjia = xueshengpingjiaService.selectView(new EntityWrapper<XueshengpingjiaEntity>().eq("id", id));
        return R.ok().put("data", xueshengpingjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengpingjiaEntity xueshengpingjia = xueshengpingjiaService.selectById(id);
		xueshengpingjia = xueshengpingjiaService.selectView(new EntityWrapper<XueshengpingjiaEntity>().eq("id", id));
        return R.ok().put("data", xueshengpingjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengpingjiaEntity xueshengpingjia, HttpServletRequest request){
    	xueshengpingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengpingjia);
        xueshengpingjiaService.insert(xueshengpingjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueshengpingjiaEntity xueshengpingjia, HttpServletRequest request){
    	xueshengpingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengpingjia);
        xueshengpingjiaService.insert(xueshengpingjia);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengpingjiaEntity xueshengpingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengpingjia);
        xueshengpingjiaService.updateById(xueshengpingjia);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengpingjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
