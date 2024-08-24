package com.cl.dao;

import com.cl.entity.XiaowaishixunchengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaowaishixunchengjiView;


/**
 * 校外实训成绩
 * 
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface XiaowaishixunchengjiDao extends BaseMapper<XiaowaishixunchengjiEntity> {
	
	List<XiaowaishixunchengjiView> selectListView(@Param("ew") Wrapper<XiaowaishixunchengjiEntity> wrapper);

	List<XiaowaishixunchengjiView> selectListView(Pagination page,@Param("ew") Wrapper<XiaowaishixunchengjiEntity> wrapper);
	
	XiaowaishixunchengjiView selectView(@Param("ew") Wrapper<XiaowaishixunchengjiEntity> wrapper);
	

}
