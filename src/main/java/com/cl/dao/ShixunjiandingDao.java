package com.cl.dao;

import com.cl.entity.ShixunjiandingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixunjiandingView;


/**
 * 实训鉴定
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ShixunjiandingDao extends BaseMapper<ShixunjiandingEntity> {
	
	List<ShixunjiandingView> selectListView(@Param("ew") Wrapper<ShixunjiandingEntity> wrapper);

	List<ShixunjiandingView> selectListView(Pagination page,@Param("ew") Wrapper<ShixunjiandingEntity> wrapper);
	
	ShixunjiandingView selectView(@Param("ew") Wrapper<ShixunjiandingEntity> wrapper);
	

}
