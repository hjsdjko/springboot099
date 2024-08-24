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


import com.cl.dao.JiaoshiDao;
import com.cl.entity.JiaoshiEntity;
import com.cl.service.JiaoshiService;
import com.cl.entity.view.JiaoshiView;

@Service("jiaoshiService")
public class JiaoshiServiceImpl extends ServiceImpl<JiaoshiDao, JiaoshiEntity> implements JiaoshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoshiEntity> page = this.selectPage(
                new Query<JiaoshiEntity>(params).getPage(),
                new EntityWrapper<JiaoshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoshiEntity> wrapper) {
		  Page<JiaoshiView> page =new Query<JiaoshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiaoshiView> selectListView(Wrapper<JiaoshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoshiView selectView(Wrapper<JiaoshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
