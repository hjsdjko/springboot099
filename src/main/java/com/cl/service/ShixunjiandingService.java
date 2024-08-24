package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShixunjiandingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixunjiandingView;


/**
 * 实训鉴定
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ShixunjiandingService extends IService<ShixunjiandingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShixunjiandingView> selectListView(Wrapper<ShixunjiandingEntity> wrapper);
   	
   	ShixunjiandingView selectView(@Param("ew") Wrapper<ShixunjiandingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShixunjiandingEntity> wrapper);
   	

}

