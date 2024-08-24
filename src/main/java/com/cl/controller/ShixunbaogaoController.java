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

import com.cl.entity.ShixunbaogaoEntity;
import com.cl.entity.view.ShixunbaogaoView;

import com.cl.service.ShixunbaogaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实训报告
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@RestController
@RequestMapping("/shixunbaogao")
public class ShixunbaogaoController {
    @Autowired
    private ShixunbaogaoService shixunbaogaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShixunbaogaoEntity shixunbaogao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			shixunbaogao.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShixunbaogaoEntity> ew = new EntityWrapper<ShixunbaogaoEntity>();

		PageUtils page = shixunbaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixunbaogao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShixunbaogaoEntity shixunbaogao, 
		HttpServletRequest request){
        EntityWrapper<ShixunbaogaoEntity> ew = new EntityWrapper<ShixunbaogaoEntity>();

		PageUtils page = shixunbaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixunbaogao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShixunbaogaoEntity shixunbaogao){
       	EntityWrapper<ShixunbaogaoEntity> ew = new EntityWrapper<ShixunbaogaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shixunbaogao, "shixunbaogao")); 
        return R.ok().put("data", shixunbaogaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShixunbaogaoEntity shixunbaogao){
        EntityWrapper< ShixunbaogaoEntity> ew = new EntityWrapper< ShixunbaogaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shixunbaogao, "shixunbaogao")); 
		ShixunbaogaoView shixunbaogaoView =  shixunbaogaoService.selectView(ew);
		return R.ok("查询实训报告成功").put("data", shixunbaogaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShixunbaogaoEntity shixunbaogao = shixunbaogaoService.selectById(id);
		shixunbaogao = shixunbaogaoService.selectView(new EntityWrapper<ShixunbaogaoEntity>().eq("id", id));
        return R.ok().put("data", shixunbaogao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShixunbaogaoEntity shixunbaogao = shixunbaogaoService.selectById(id);
		shixunbaogao = shixunbaogaoService.selectView(new EntityWrapper<ShixunbaogaoEntity>().eq("id", id));
        return R.ok().put("data", shixunbaogao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShixunbaogaoEntity shixunbaogao, HttpServletRequest request){
    	shixunbaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixunbaogao);
        shixunbaogaoService.insert(shixunbaogao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShixunbaogaoEntity shixunbaogao, HttpServletRequest request){
    	shixunbaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixunbaogao);
        shixunbaogaoService.insert(shixunbaogao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShixunbaogaoEntity shixunbaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shixunbaogao);
        shixunbaogaoService.updateById(shixunbaogao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shixunbaogaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
