package com.cl.dao;

import com.cl.entity.ShixundanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixundanweiView;


/**
 * 实训单位
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ShixundanweiDao extends BaseMapper<ShixundanweiEntity> {
	
	List<ShixundanweiView> selectListView(@Param("ew") Wrapper<ShixundanweiEntity> wrapper);

	List<ShixundanweiView> selectListView(Pagination page,@Param("ew") Wrapper<ShixundanweiEntity> wrapper);
	
	ShixundanweiView selectView(@Param("ew") Wrapper<ShixundanweiEntity> wrapper);
	

}
