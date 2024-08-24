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

import com.cl.entity.XiaowaishixunchengjiEntity;
import com.cl.entity.view.XiaowaishixunchengjiView;

import com.cl.service.XiaowaishixunchengjiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 校外实训成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@RestController
@RequestMapping("/xiaowaishixunchengji")
public class XiaowaishixunchengjiController {
    @Autowired
    private XiaowaishixunchengjiService xiaowaishixunchengjiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaowaishixunchengjiEntity xiaowaishixunchengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xiaowaishixunchengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiaowaishixunchengjiEntity> ew = new EntityWrapper<XiaowaishixunchengjiEntity>();

		PageUtils page = xiaowaishixunchengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaowaishixunchengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaowaishixunchengjiEntity xiaowaishixunchengji, 
		HttpServletRequest request){
        EntityWrapper<XiaowaishixunchengjiEntity> ew = new EntityWrapper<XiaowaishixunchengjiEntity>();

		PageUtils page = xiaowaishixunchengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaowaishixunchengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaowaishixunchengjiEntity xiaowaishixunchengji){
       	EntityWrapper<XiaowaishixunchengjiEntity> ew = new EntityWrapper<XiaowaishixunchengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaowaishixunchengji, "xiaowaishixunchengji")); 
        return R.ok().put("data", xiaowaishixunchengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaowaishixunchengjiEntity xiaowaishixunchengji){
        EntityWrapper< XiaowaishixunchengjiEntity> ew = new EntityWrapper< XiaowaishixunchengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaowaishixunchengji, "xiaowaishixunchengji")); 
		XiaowaishixunchengjiView xiaowaishixunchengjiView =  xiaowaishixunchengjiService.selectView(ew);
		return R.ok("查询校外实训成绩成功").put("data", xiaowaishixunchengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaowaishixunchengjiEntity xiaowaishixunchengji = xiaowaishixunchengjiService.selectById(id);
		xiaowaishixunchengji = xiaowaishixunchengjiService.selectView(new EntityWrapper<XiaowaishixunchengjiEntity>().eq("id", id));
        return R.ok().put("data", xiaowaishixunchengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaowaishixunchengjiEntity xiaowaishixunchengji = xiaowaishixunchengjiService.selectById(id);
		xiaowaishixunchengji = xiaowaishixunchengjiService.selectView(new EntityWrapper<XiaowaishixunchengjiEntity>().eq("id", id));
        return R.ok().put("data", xiaowaishixunchengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaowaishixunchengjiEntity xiaowaishixunchengji, HttpServletRequest request){
    	xiaowaishixunchengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaowaishixunchengji);
        xiaowaishixunchengjiService.insert(xiaowaishixunchengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaowaishixunchengjiEntity xiaowaishixunchengji, HttpServletRequest request){
    	xiaowaishixunchengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaowaishixunchengji);
        xiaowaishixunchengjiService.insert(xiaowaishixunchengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaowaishixunchengjiEntity xiaowaishixunchengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaowaishixunchengji);
        xiaowaishixunchengjiService.updateById(xiaowaishixunchengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaowaishixunchengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
