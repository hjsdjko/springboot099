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

import com.cl.entity.RichenganpaiEntity;
import com.cl.entity.view.RichenganpaiView;

import com.cl.service.RichenganpaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 日程安排
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@RestController
@RequestMapping("/richenganpai")
public class RichenganpaiController {
    @Autowired
    private RichenganpaiService richenganpaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RichenganpaiEntity richenganpai,
		HttpServletRequest request){
        EntityWrapper<RichenganpaiEntity> ew = new EntityWrapper<RichenganpaiEntity>();

		PageUtils page = richenganpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, richenganpai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RichenganpaiEntity richenganpai, 
		HttpServletRequest request){
        EntityWrapper<RichenganpaiEntity> ew = new EntityWrapper<RichenganpaiEntity>();

		PageUtils page = richenganpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, richenganpai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RichenganpaiEntity richenganpai){
       	EntityWrapper<RichenganpaiEntity> ew = new EntityWrapper<RichenganpaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( richenganpai, "richenganpai")); 
        return R.ok().put("data", richenganpaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RichenganpaiEntity richenganpai){
        EntityWrapper< RichenganpaiEntity> ew = new EntityWrapper< RichenganpaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( richenganpai, "richenganpai")); 
		RichenganpaiView richenganpaiView =  richenganpaiService.selectView(ew);
		return R.ok("查询日程安排成功").put("data", richenganpaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RichenganpaiEntity richenganpai = richenganpaiService.selectById(id);
		richenganpai = richenganpaiService.selectView(new EntityWrapper<RichenganpaiEntity>().eq("id", id));
        return R.ok().put("data", richenganpai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RichenganpaiEntity richenganpai = richenganpaiService.selectById(id);
		richenganpai = richenganpaiService.selectView(new EntityWrapper<RichenganpaiEntity>().eq("id", id));
        return R.ok().put("data", richenganpai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RichenganpaiEntity richenganpai, HttpServletRequest request){
    	richenganpai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(richenganpai);
        richenganpaiService.insert(richenganpai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RichenganpaiEntity richenganpai, HttpServletRequest request){
    	richenganpai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(richenganpai);
        richenganpaiService.insert(richenganpai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RichenganpaiEntity richenganpai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(richenganpai);
        richenganpaiService.updateById(richenganpai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        richenganpaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
