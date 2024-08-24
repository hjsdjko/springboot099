package com.cl.dao;

import com.cl.entity.XueshengpingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengpingjiaView;


/**
 * 学生评价
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface XueshengpingjiaDao extends BaseMapper<XueshengpingjiaEntity> {
	
	List<XueshengpingjiaView> selectListView(@Param("ew") Wrapper<XueshengpingjiaEntity> wrapper);

	List<XueshengpingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengpingjiaEntity> wrapper);
	
	XueshengpingjiaView selectView(@Param("ew") Wrapper<XueshengpingjiaEntity> wrapper);
	

}
