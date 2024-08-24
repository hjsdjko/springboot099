package com.cl.dao;

import com.cl.entity.XiaowaishixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaowaishixunView;


/**
 * 校外实训
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface XiaowaishixunDao extends BaseMapper<XiaowaishixunEntity> {
	
	List<XiaowaishixunView> selectListView(@Param("ew") Wrapper<XiaowaishixunEntity> wrapper);

	List<XiaowaishixunView> selectListView(Pagination page,@Param("ew") Wrapper<XiaowaishixunEntity> wrapper);
	
	XiaowaishixunView selectView(@Param("ew") Wrapper<XiaowaishixunEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaowaishixunEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaowaishixunEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaowaishixunEntity> wrapper);



}
