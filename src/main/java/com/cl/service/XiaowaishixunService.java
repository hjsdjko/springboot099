package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiaowaishixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaowaishixunView;


/**
 * 校外实训
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface XiaowaishixunService extends IService<XiaowaishixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaowaishixunView> selectListView(Wrapper<XiaowaishixunEntity> wrapper);
   	
   	XiaowaishixunView selectView(@Param("ew") Wrapper<XiaowaishixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaowaishixunEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XiaowaishixunEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XiaowaishixunEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XiaowaishixunEntity> wrapper);



}

