package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShixunchengjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixunchengjiView;


/**
 * 实训成绩
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ShixunchengjiService extends IService<ShixunchengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShixunchengjiView> selectListView(Wrapper<ShixunchengjiEntity> wrapper);
   	
   	ShixunchengjiView selectView(@Param("ew") Wrapper<ShixunchengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShixunchengjiEntity> wrapper);
   	

}

