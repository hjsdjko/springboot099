package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XueshengpingjiaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengpingjiaView;


/**
 * 学生评价
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface XueshengpingjiaService extends IService<XueshengpingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengpingjiaView> selectListView(Wrapper<XueshengpingjiaEntity> wrapper);
   	
   	XueshengpingjiaView selectView(@Param("ew") Wrapper<XueshengpingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengpingjiaEntity> wrapper);
   	

}

