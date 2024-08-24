package com.cl.entity.view;

import com.cl.entity.ZizhushenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 自主申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@TableName("zizhushenqing")
public class ZizhushenqingView  extends ZizhushenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZizhushenqingView(){
	}
 
 	public ZizhushenqingView(ZizhushenqingEntity zizhushenqingEntity){
 	try {
			BeanUtils.copyProperties(this, zizhushenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
