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


import com.cl.dao.ShixunxiangmuDao;
import com.cl.entity.ShixunxiangmuEntity;
import com.cl.service.ShixunxiangmuService;
import com.cl.entity.view.ShixunxiangmuView;

@Service("shixunxiangmuService")
public class ShixunxiangmuServiceImpl extends ServiceImpl<ShixunxiangmuDao, ShixunxiangmuEntity> implements ShixunxiangmuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShixunxiangmuEntity> page = this.selectPage(
                new Query<ShixunxiangmuEntity>(params).getPage(),
                new EntityWrapper<ShixunxiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShixunxiangmuEntity> wrapper) {
		  Page<ShixunxiangmuView> page =new Query<ShixunxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShixunxiangmuView> selectListView(Wrapper<ShixunxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShixunxiangmuView selectView(Wrapper<ShixunxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
