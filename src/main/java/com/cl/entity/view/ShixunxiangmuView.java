package com.cl.entity.view;

import com.cl.entity.ShixunxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 实训项目
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@TableName("shixunxiangmu")
public class ShixunxiangmuView  extends ShixunxiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShixunxiangmuView(){
	}
 
 	public ShixunxiangmuView(ShixunxiangmuEntity shixunxiangmuEntity){
 	try {
			BeanUtils.copyProperties(this, shixunxiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
