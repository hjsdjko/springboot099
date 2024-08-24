package com.cl.dao;

import com.cl.entity.XiaoneishixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoneishixunView;


/**
 * 校内实训
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface XiaoneishixunDao extends BaseMapper<XiaoneishixunEntity> {
	
	List<XiaoneishixunView> selectListView(@Param("ew") Wrapper<XiaoneishixunEntity> wrapper);

	List<XiaoneishixunView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoneishixunEntity> wrapper);
	
	XiaoneishixunView selectView(@Param("ew") Wrapper<XiaoneishixunEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaoneishixunEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaoneishixunEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaoneishixunEntity> wrapper);



}
