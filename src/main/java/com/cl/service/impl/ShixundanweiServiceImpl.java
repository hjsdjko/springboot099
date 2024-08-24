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


import com.cl.dao.ShixundanweiDao;
import com.cl.entity.ShixundanweiEntity;
import com.cl.service.ShixundanweiService;
import com.cl.entity.view.ShixundanweiView;

@Service("shixundanweiService")
public class ShixundanweiServiceImpl extends ServiceImpl<ShixundanweiDao, ShixundanweiEntity> implements ShixundanweiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShixundanweiEntity> page = this.selectPage(
                new Query<ShixundanweiEntity>(params).getPage(),
                new EntityWrapper<ShixundanweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShixundanweiEntity> wrapper) {
		  Page<ShixundanweiView> page =new Query<ShixundanweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShixundanweiView> selectListView(Wrapper<ShixundanweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShixundanweiView selectView(Wrapper<ShixundanweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
