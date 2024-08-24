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

import com.cl.entity.ShixunjiandingEntity;
import com.cl.entity.view.ShixunjiandingView;

import com.cl.service.ShixunjiandingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实训鉴定
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@RestController
@RequestMapping("/shixunjianding")
public class ShixunjiandingController {
    @Autowired
    private ShixunjiandingService shixunjiandingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShixunjiandingEntity shixunjianding,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			shixunjianding.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShixunjiandingEntity> ew = new EntityWrapper<ShixunjiandingEntity>();

		PageUtils page = shixunjiandingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixunjianding), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShixunjiandingEntity shixunjianding, 
		HttpServletRequest request){
        EntityWrapper<ShixunjiandingEntity> ew = new EntityWrapper<ShixunjiandingEntity>();

		PageUtils page = shixunjiandingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixunjianding), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShixunjiandingEntity shixunjianding){
       	EntityWrapper<ShixunjiandingEntity> ew = new EntityWrapper<ShixunjiandingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shixunjianding, "shixunjianding")); 
        return R.ok().put("data", shixunjiandingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShixunjiandingEntity shixunjianding){
        EntityWrapper< ShixunjiandingEntity> ew = new EntityWrapper< ShixunjiandingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shixunjianding, "shixunjianding")); 
		ShixunjiandingView shixunjiandingView =  shixunjiandingService.selectView(ew);
		return R.ok("查询实训鉴定成功").put("data", shixunjiandingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShixunjiandingEntity shixunjianding = shixunjiandingService.selectById(id);
		shixunjianding = shixunjiandingService.selectView(new EntityWrapper<ShixunjiandingEntity>().eq("id", id));
        return R.ok().put("data", shixunjianding);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShixunjiandingEntity shixunjianding = shixunjiandingService.selectById(id);
		shixunjianding = shixunjiandingService.selectView(new EntityWrapper<ShixunjiandingEntity>().eq("id", id));
        return R.ok().put("data", shixunjianding);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShixunjiandingEntity shixunjianding, HttpServletRequest request){
    	shixunjianding.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixunjianding);
        shixunjiandingService.insert(shixunjianding);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShixunjiandingEntity shixunjianding, HttpServletRequest request){
    	shixunjianding.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixunjianding);
        shixunjiandingService.insert(shixunjianding);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShixunjiandingEntity shixunjianding, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shixunjianding);
        shixunjiandingService.updateById(shixunjianding);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShixunjiandingEntity> list = new ArrayList<ShixunjiandingEntity>();
        for(Long id : ids) {
            ShixunjiandingEntity shixunjianding = shixunjiandingService.selectById(id);
            shixunjianding.setSfsh(sfsh);
            shixunjianding.setShhf(shhf);
            list.add(shixunjianding);
        }
        shixunjiandingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shixunjiandingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
