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


import com.cl.dao.ShixunbaogaoDao;
import com.cl.entity.ShixunbaogaoEntity;
import com.cl.service.ShixunbaogaoService;
import com.cl.entity.view.ShixunbaogaoView;

@Service("shixunbaogaoService")
public class ShixunbaogaoServiceImpl extends ServiceImpl<ShixunbaogaoDao, ShixunbaogaoEntity> implements ShixunbaogaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShixunbaogaoEntity> page = this.selectPage(
                new Query<ShixunbaogaoEntity>(params).getPage(),
                new EntityWrapper<ShixunbaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShixunbaogaoEntity> wrapper) {
		  Page<ShixunbaogaoView> page =new Query<ShixunbaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShixunbaogaoView> selectListView(Wrapper<ShixunbaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShixunbaogaoView selectView(Wrapper<ShixunbaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
