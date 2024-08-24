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

import com.cl.entity.ShixundanweiEntity;
import com.cl.entity.view.ShixundanweiView;

import com.cl.service.ShixundanweiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实训单位
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@RestController
@RequestMapping("/shixundanwei")
public class ShixundanweiController {
    @Autowired
    private ShixundanweiService shixundanweiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShixundanweiEntity shixundanwei,
		HttpServletRequest request){
        EntityWrapper<ShixundanweiEntity> ew = new EntityWrapper<ShixundanweiEntity>();

		PageUtils page = shixundanweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixundanwei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShixundanweiEntity shixundanwei, 
		HttpServletRequest request){
        EntityWrapper<ShixundanweiEntity> ew = new EntityWrapper<ShixundanweiEntity>();

		PageUtils page = shixundanweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixundanwei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShixundanweiEntity shixundanwei){
       	EntityWrapper<ShixundanweiEntity> ew = new EntityWrapper<ShixundanweiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shixundanwei, "shixundanwei")); 
        return R.ok().put("data", shixundanweiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShixundanweiEntity shixundanwei){
        EntityWrapper< ShixundanweiEntity> ew = new EntityWrapper< ShixundanweiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shixundanwei, "shixundanwei")); 
		ShixundanweiView shixundanweiView =  shixundanweiService.selectView(ew);
		return R.ok("查询实训单位成功").put("data", shixundanweiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShixundanweiEntity shixundanwei = shixundanweiService.selectById(id);
		shixundanwei = shixundanweiService.selectView(new EntityWrapper<ShixundanweiEntity>().eq("id", id));
        return R.ok().put("data", shixundanwei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShixundanweiEntity shixundanwei = shixundanweiService.selectById(id);
		shixundanwei = shixundanweiService.selectView(new EntityWrapper<ShixundanweiEntity>().eq("id", id));
        return R.ok().put("data", shixundanwei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShixundanweiEntity shixundanwei, HttpServletRequest request){
    	shixundanwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixundanwei);
        shixundanweiService.insert(shixundanwei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShixundanweiEntity shixundanwei, HttpServletRequest request){
    	shixundanwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixundanwei);
        shixundanweiService.insert(shixundanwei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShixundanweiEntity shixundanwei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shixundanwei);
        shixundanweiService.updateById(shixundanwei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shixundanweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
