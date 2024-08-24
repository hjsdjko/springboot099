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

import com.cl.entity.ShixunxiangmuEntity;
import com.cl.entity.view.ShixunxiangmuView;

import com.cl.service.ShixunxiangmuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实训项目
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@RestController
@RequestMapping("/shixunxiangmu")
public class ShixunxiangmuController {
    @Autowired
    private ShixunxiangmuService shixunxiangmuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShixunxiangmuEntity shixunxiangmu,
		HttpServletRequest request){
        EntityWrapper<ShixunxiangmuEntity> ew = new EntityWrapper<ShixunxiangmuEntity>();

		PageUtils page = shixunxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixunxiangmu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShixunxiangmuEntity shixunxiangmu, 
		HttpServletRequest request){
        EntityWrapper<ShixunxiangmuEntity> ew = new EntityWrapper<ShixunxiangmuEntity>();

		PageUtils page = shixunxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixunxiangmu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShixunxiangmuEntity shixunxiangmu){
       	EntityWrapper<ShixunxiangmuEntity> ew = new EntityWrapper<ShixunxiangmuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shixunxiangmu, "shixunxiangmu")); 
        return R.ok().put("data", shixunxiangmuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShixunxiangmuEntity shixunxiangmu){
        EntityWrapper< ShixunxiangmuEntity> ew = new EntityWrapper< ShixunxiangmuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shixunxiangmu, "shixunxiangmu")); 
		ShixunxiangmuView shixunxiangmuView =  shixunxiangmuService.selectView(ew);
		return R.ok("查询实训项目成功").put("data", shixunxiangmuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShixunxiangmuEntity shixunxiangmu = shixunxiangmuService.selectById(id);
		shixunxiangmu = shixunxiangmuService.selectView(new EntityWrapper<ShixunxiangmuEntity>().eq("id", id));
        return R.ok().put("data", shixunxiangmu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShixunxiangmuEntity shixunxiangmu = shixunxiangmuService.selectById(id);
		shixunxiangmu = shixunxiangmuService.selectView(new EntityWrapper<ShixunxiangmuEntity>().eq("id", id));
        return R.ok().put("data", shixunxiangmu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShixunxiangmuEntity shixunxiangmu, HttpServletRequest request){
    	shixunxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixunxiangmu);
        shixunxiangmuService.insert(shixunxiangmu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShixunxiangmuEntity shixunxiangmu, HttpServletRequest request){
    	shixunxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixunxiangmu);
        shixunxiangmuService.insert(shixunxiangmu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShixunxiangmuEntity shixunxiangmu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shixunxiangmu);
        shixunxiangmuService.updateById(shixunxiangmu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shixunxiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
