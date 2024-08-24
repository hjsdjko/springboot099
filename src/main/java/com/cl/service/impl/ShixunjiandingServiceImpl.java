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


import com.cl.dao.ShixunjiandingDao;
import com.cl.entity.ShixunjiandingEntity;
import com.cl.service.ShixunjiandingService;
import com.cl.entity.view.ShixunjiandingView;

@Service("shixunjiandingService")
public class ShixunjiandingServiceImpl extends ServiceImpl<ShixunjiandingDao, ShixunjiandingEntity> implements ShixunjiandingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShixunjiandingEntity> page = this.selectPage(
                new Query<ShixunjiandingEntity>(params).getPage(),
                new EntityWrapper<ShixunjiandingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShixunjiandingEntity> wrapper) {
		  Page<ShixunjiandingView> page =new Query<ShixunjiandingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShixunjiandingView> selectListView(Wrapper<ShixunjiandingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShixunjiandingView selectView(Wrapper<ShixunjiandingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
