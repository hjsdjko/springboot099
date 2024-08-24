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


import com.cl.dao.XiaowaishixunchengjiDao;
import com.cl.entity.XiaowaishixunchengjiEntity;
import com.cl.service.XiaowaishixunchengjiService;
import com.cl.entity.view.XiaowaishixunchengjiView;

@Service("xiaowaishixunchengjiService")
public class XiaowaishixunchengjiServiceImpl extends ServiceImpl<XiaowaishixunchengjiDao, XiaowaishixunchengjiEntity> implements XiaowaishixunchengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaowaishixunchengjiEntity> page = this.selectPage(
                new Query<XiaowaishixunchengjiEntity>(params).getPage(),
                new EntityWrapper<XiaowaishixunchengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaowaishixunchengjiEntity> wrapper) {
		  Page<XiaowaishixunchengjiView> page =new Query<XiaowaishixunchengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiaowaishixunchengjiView> selectListView(Wrapper<XiaowaishixunchengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaowaishixunchengjiView selectView(Wrapper<XiaowaishixunchengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
