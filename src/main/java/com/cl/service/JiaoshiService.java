package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaoshiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoshiView;


/**
 * 教师
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface JiaoshiService extends IService<JiaoshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoshiView> selectListView(Wrapper<JiaoshiEntity> wrapper);
   	
   	JiaoshiView selectView(@Param("ew") Wrapper<JiaoshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoshiEntity> wrapper);
   	

}

