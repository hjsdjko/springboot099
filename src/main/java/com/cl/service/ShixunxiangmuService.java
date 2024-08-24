package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShixunxiangmuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixunxiangmuView;


/**
 * 实训项目
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ShixunxiangmuService extends IService<ShixunxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShixunxiangmuView> selectListView(Wrapper<ShixunxiangmuEntity> wrapper);
   	
   	ShixunxiangmuView selectView(@Param("ew") Wrapper<ShixunxiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShixunxiangmuEntity> wrapper);
   	

}

