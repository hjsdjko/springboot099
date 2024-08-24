package com.cl.dao;

import com.cl.entity.ShixunbaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixunbaogaoView;


/**
 * 实训报告
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ShixunbaogaoDao extends BaseMapper<ShixunbaogaoEntity> {
	
	List<ShixunbaogaoView> selectListView(@Param("ew") Wrapper<ShixunbaogaoEntity> wrapper);

	List<ShixunbaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<ShixunbaogaoEntity> wrapper);
	
	ShixunbaogaoView selectView(@Param("ew") Wrapper<ShixunbaogaoEntity> wrapper);
	

}
