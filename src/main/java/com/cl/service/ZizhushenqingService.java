package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZizhushenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZizhushenqingView;


/**
 * 自主申请
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ZizhushenqingService extends IService<ZizhushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZizhushenqingView> selectListView(Wrapper<ZizhushenqingEntity> wrapper);
   	
   	ZizhushenqingView selectView(@Param("ew") Wrapper<ZizhushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZizhushenqingEntity> wrapper);
   	

}

