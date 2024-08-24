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

import com.cl.entity.ShixunchengjiEntity;
import com.cl.entity.view.ShixunchengjiView;

import com.cl.service.ShixunchengjiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实训成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@RestController
@RequestMapping("/shixunchengji")
public class ShixunchengjiController {
    @Autowired
    private ShixunchengjiService shixunchengjiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShixunchengjiEntity shixunchengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			shixunchengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShixunchengjiEntity> ew = new EntityWrapper<ShixunchengjiEntity>();

		PageUtils page = shixunchengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixunchengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShixunchengjiEntity shixunchengji, 
		HttpServletRequest request){
        EntityWrapper<ShixunchengjiEntity> ew = new EntityWrapper<ShixunchengjiEntity>();

		PageUtils page = shixunchengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixunchengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShixunchengjiEntity shixunchengji){
       	EntityWrapper<ShixunchengjiEntity> ew = new EntityWrapper<ShixunchengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shixunchengji, "shixunchengji")); 
        return R.ok().put("data", shixunchengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShixunchengjiEntity shixunchengji){
        EntityWrapper< ShixunchengjiEntity> ew = new EntityWrapper< ShixunchengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shixunchengji, "shixunchengji")); 
		ShixunchengjiView shixunchengjiView =  shixunchengjiService.selectView(ew);
		return R.ok("查询实训成绩成功").put("data", shixunchengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShixunchengjiEntity shixunchengji = shixunchengjiService.selectById(id);
		shixunchengji = shixunchengjiService.selectView(new EntityWrapper<ShixunchengjiEntity>().eq("id", id));
        return R.ok().put("data", shixunchengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShixunchengjiEntity shixunchengji = shixunchengjiService.selectById(id);
		shixunchengji = shixunchengjiService.selectView(new EntityWrapper<ShixunchengjiEntity>().eq("id", id));
        return R.ok().put("data", shixunchengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShixunchengjiEntity shixunchengji, HttpServletRequest request){
    	shixunchengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixunchengji);
        shixunchengjiService.insert(shixunchengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShixunchengjiEntity shixunchengji, HttpServletRequest request){
    	shixunchengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixunchengji);
        shixunchengjiService.insert(shixunchengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShixunchengjiEntity shixunchengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shixunchengji);
        shixunchengjiService.updateById(shixunchengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shixunchengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
