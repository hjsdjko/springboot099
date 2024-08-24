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

import com.cl.entity.ZizhushenqingEntity;
import com.cl.entity.view.ZizhushenqingView;

import com.cl.service.ZizhushenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 自主申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@RestController
@RequestMapping("/zizhushenqing")
public class ZizhushenqingController {
    @Autowired
    private ZizhushenqingService zizhushenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZizhushenqingEntity zizhushenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			zizhushenqing.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZizhushenqingEntity> ew = new EntityWrapper<ZizhushenqingEntity>();

		PageUtils page = zizhushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zizhushenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZizhushenqingEntity zizhushenqing, 
		HttpServletRequest request){
        EntityWrapper<ZizhushenqingEntity> ew = new EntityWrapper<ZizhushenqingEntity>();

		PageUtils page = zizhushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zizhushenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZizhushenqingEntity zizhushenqing){
       	EntityWrapper<ZizhushenqingEntity> ew = new EntityWrapper<ZizhushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zizhushenqing, "zizhushenqing")); 
        return R.ok().put("data", zizhushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZizhushenqingEntity zizhushenqing){
        EntityWrapper< ZizhushenqingEntity> ew = new EntityWrapper< ZizhushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zizhushenqing, "zizhushenqing")); 
		ZizhushenqingView zizhushenqingView =  zizhushenqingService.selectView(ew);
		return R.ok("查询自主申请成功").put("data", zizhushenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZizhushenqingEntity zizhushenqing = zizhushenqingService.selectById(id);
		zizhushenqing = zizhushenqingService.selectView(new EntityWrapper<ZizhushenqingEntity>().eq("id", id));
        return R.ok().put("data", zizhushenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZizhushenqingEntity zizhushenqing = zizhushenqingService.selectById(id);
		zizhushenqing = zizhushenqingService.selectView(new EntityWrapper<ZizhushenqingEntity>().eq("id", id));
        return R.ok().put("data", zizhushenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZizhushenqingEntity zizhushenqing, HttpServletRequest request){
    	zizhushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zizhushenqing);
        zizhushenqingService.insert(zizhushenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZizhushenqingEntity zizhushenqing, HttpServletRequest request){
    	zizhushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zizhushenqing);
        zizhushenqingService.insert(zizhushenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZizhushenqingEntity zizhushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zizhushenqing);
        zizhushenqingService.updateById(zizhushenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZizhushenqingEntity> list = new ArrayList<ZizhushenqingEntity>();
        for(Long id : ids) {
            ZizhushenqingEntity zizhushenqing = zizhushenqingService.selectById(id);
            zizhushenqing.setSfsh(sfsh);
            zizhushenqing.setShhf(shhf);
            list.add(zizhushenqing);
        }
        zizhushenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zizhushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
