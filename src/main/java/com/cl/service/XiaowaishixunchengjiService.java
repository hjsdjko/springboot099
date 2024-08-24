package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiaowaishixunchengjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaowaishixunchengjiView;


/**
 * 校外实训成绩
 *
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
public interface XiaowaishixunchengjiService extends IService<XiaowaishixunchengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaowaishixunchengjiView> selectListView(Wrapper<XiaowaishixunchengjiEntity> wrapper);
   	
   	XiaowaishixunchengjiView selectView(@Param("ew") Wrapper<XiaowaishixunchengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaowaishixunchengjiEntity> wrapper);
   	

}

