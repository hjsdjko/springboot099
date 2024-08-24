package com.cl.dao;

import com.cl.entity.ZizhushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZizhushenqingView;


/**
 * 自主申请
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ZizhushenqingDao extends BaseMapper<ZizhushenqingEntity> {
	
	List<ZizhushenqingView> selectListView(@Param("ew") Wrapper<ZizhushenqingEntity> wrapper);

	List<ZizhushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ZizhushenqingEntity> wrapper);
	
	ZizhushenqingView selectView(@Param("ew") Wrapper<ZizhushenqingEntity> wrapper);
	

}
