package com.cl.dao;

import com.cl.entity.ShixunxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixunxiangmuView;


/**
 * 实训项目
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ShixunxiangmuDao extends BaseMapper<ShixunxiangmuEntity> {
	
	List<ShixunxiangmuView> selectListView(@Param("ew") Wrapper<ShixunxiangmuEntity> wrapper);

	List<ShixunxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<ShixunxiangmuEntity> wrapper);
	
	ShixunxiangmuView selectView(@Param("ew") Wrapper<ShixunxiangmuEntity> wrapper);
	

}
