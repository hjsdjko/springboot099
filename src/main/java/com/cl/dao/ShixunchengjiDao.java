package com.cl.dao;

import com.cl.entity.ShixunchengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixunchengjiView;


/**
 * 实训成绩
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ShixunchengjiDao extends BaseMapper<ShixunchengjiEntity> {
	
	List<ShixunchengjiView> selectListView(@Param("ew") Wrapper<ShixunchengjiEntity> wrapper);

	List<ShixunchengjiView> selectListView(Pagination page,@Param("ew") Wrapper<ShixunchengjiEntity> wrapper);
	
	ShixunchengjiView selectView(@Param("ew") Wrapper<ShixunchengjiEntity> wrapper);
	

}
