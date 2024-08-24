package com.cl.dao;

import com.cl.entity.RichenganpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RichenganpaiView;


/**
 * 日程安排
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface RichenganpaiDao extends BaseMapper<RichenganpaiEntity> {
	
	List<RichenganpaiView> selectListView(@Param("ew") Wrapper<RichenganpaiEntity> wrapper);

	List<RichenganpaiView> selectListView(Pagination page,@Param("ew") Wrapper<RichenganpaiEntity> wrapper);
	
	RichenganpaiView selectView(@Param("ew") Wrapper<RichenganpaiEntity> wrapper);
	

}
