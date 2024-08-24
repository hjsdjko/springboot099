package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShixundanweiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixundanweiView;


/**
 * 实训单位
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface ShixundanweiService extends IService<ShixundanweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShixundanweiView> selectListView(Wrapper<ShixundanweiEntity> wrapper);
   	
   	ShixundanweiView selectView(@Param("ew") Wrapper<ShixundanweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShixundanweiEntity> wrapper);
   	

}

