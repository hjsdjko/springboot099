package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShixunbaogaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixunbaogaoView;


/**
 * 实训报告
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ShixunbaogaoService extends IService<ShixunbaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShixunbaogaoView> selectListView(Wrapper<ShixunbaogaoEntity> wrapper);
   	
   	ShixunbaogaoView selectView(@Param("ew") Wrapper<ShixunbaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShixunbaogaoEntity> wrapper);
   	

}

