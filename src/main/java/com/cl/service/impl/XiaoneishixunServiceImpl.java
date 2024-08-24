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


import com.cl.dao.XiaoneishixunDao;
import com.cl.entity.XiaoneishixunEntity;
import com.cl.service.XiaoneishixunService;
import com.cl.entity.view.XiaoneishixunView;

@Service("xiaoneishixunService")
public class XiaoneishixunServiceImpl extends ServiceImpl<XiaoneishixunDao, XiaoneishixunEntity> implements XiaoneishixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoneishixunEntity> page = this.selectPage(
                new Query<XiaoneishixunEntity>(params).getPage(),
                new EntityWrapper<XiaoneishixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoneishixunEntity> wrapper) {
		  Page<XiaoneishixunView> page =new Query<XiaoneishixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiaoneishixunView> selectListView(Wrapper<XiaoneishixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoneishixunView selectView(Wrapper<XiaoneishixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<XiaoneishixunEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<XiaoneishixunEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<XiaoneishixunEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
