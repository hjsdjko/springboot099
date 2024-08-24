package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZizhushenqingDao;
import com.cl.entity.ZizhushenqingEntity;
import com.cl.service.ZizhushenqingService;
import com.cl.entity.view.ZizhushenqingView;

@Service("zizhushenqingService")
public class ZizhushenqingServiceImpl extends ServiceImpl<ZizhushenqingDao, ZizhushenqingEntity> implements ZizhushenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZizhushenqingEntity> page = this.selectPage(
                new Query<ZizhushenqingEntity>(params).getPage(),
                new EntityWrapper<ZizhushenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZizhushenqingEntity> wrapper) {
		  Page<ZizhushenqingView> page =new Query<ZizhushenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZizhushenqingView> selectListView(Wrapper<ZizhushenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZizhushenqingView selectView(Wrapper<ZizhushenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
