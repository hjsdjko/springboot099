package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiaoneishixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoneishixunView;


/**
 * 校内实训
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface XiaoneishixunService extends IService<XiaoneishixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoneishixunView> selectListView(Wrapper<XiaoneishixunEntity> wrapper);
   	
   	XiaoneishixunView selectView(@Param("ew") Wrapper<XiaoneishixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoneishixunEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XiaoneishixunEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XiaoneishixunEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XiaoneishixunEntity> wrapper);



}

