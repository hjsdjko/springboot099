package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RichenganpaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RichenganpaiView;


/**
 * 日程安排
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface RichenganpaiService extends IService<RichenganpaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RichenganpaiView> selectListView(Wrapper<RichenganpaiEntity> wrapper);
   	
   	RichenganpaiView selectView(@Param("ew") Wrapper<RichenganpaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RichenganpaiEntity> wrapper);
   	

}

