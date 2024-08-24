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


import com.cl.dao.ShixunchengjiDao;
import com.cl.entity.ShixunchengjiEntity;
import com.cl.service.ShixunchengjiService;
import com.cl.entity.view.ShixunchengjiView;

@Service("shixunchengjiService")
public class ShixunchengjiServiceImpl extends ServiceImpl<ShixunchengjiDao, ShixunchengjiEntity> implements ShixunchengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShixunchengjiEntity> page = this.selectPage(
                new Query<ShixunchengjiEntity>(params).getPage(),
                new EntityWrapper<ShixunchengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShixunchengjiEntity> wrapper) {
		  Page<ShixunchengjiView> page =new Query<ShixunchengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShixunchengjiView> selectListView(Wrapper<ShixunchengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShixunchengjiView selectView(Wrapper<ShixunchengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
