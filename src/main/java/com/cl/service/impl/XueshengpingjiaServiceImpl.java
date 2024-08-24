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


import com.cl.dao.XueshengpingjiaDao;
import com.cl.entity.XueshengpingjiaEntity;
import com.cl.service.XueshengpingjiaService;
import com.cl.entity.view.XueshengpingjiaView;

@Service("xueshengpingjiaService")
public class XueshengpingjiaServiceImpl extends ServiceImpl<XueshengpingjiaDao, XueshengpingjiaEntity> implements XueshengpingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengpingjiaEntity> page = this.selectPage(
                new Query<XueshengpingjiaEntity>(params).getPage(),
                new EntityWrapper<XueshengpingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengpingjiaEntity> wrapper) {
		  Page<XueshengpingjiaView> page =new Query<XueshengpingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XueshengpingjiaView> selectListView(Wrapper<XueshengpingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengpingjiaView selectView(Wrapper<XueshengpingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
