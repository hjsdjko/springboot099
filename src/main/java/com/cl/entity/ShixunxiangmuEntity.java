package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 实训项目
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@TableName("shixunxiangmu")
public class ShixunxiangmuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShixunxiangmuEntity() {
		
	}
	
	public ShixunxiangmuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 校内名称
	 */
					
	private String xiaoneimingcheng;
	
	/**
	 * 实训名称
	 */
					
	private String shixunmingcheng;
	
	/**
	 * 实训目标
	 */
					
	private String shixunmubiao;
	
	/**
	 * 实训内容
	 */
					
	private String shixunneirong;
	
	/**
	 * 描述
	 */
					
	private String miaoshu;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：校内名称
	 */
	public void setXiaoneimingcheng(String xiaoneimingcheng) {
		this.xiaoneimingcheng = xiaoneimingcheng;
	}
	/**
	 * 获取：校内名称
	 */
	public String getXiaoneimingcheng() {
		return xiaoneimingcheng;
	}
	/**
	 * 设置：实训名称
	 */
	public void setShixunmingcheng(String shixunmingcheng) {
		this.shixunmingcheng = shixunmingcheng;
	}
	/**
	 * 获取：实训名称
	 */
	public String getShixunmingcheng() {
		return shixunmingcheng;
	}
	/**
	 * 设置：实训目标
	 */
	public void setShixunmubiao(String shixunmubiao) {
		this.shixunmubiao = shixunmubiao;
	}
	/**
	 * 获取：实训目标
	 */
	public String getShixunmubiao() {
		return shixunmubiao;
	}
	/**
	 * 设置：实训内容
	 */
	public void setShixunneirong(String shixunneirong) {
		this.shixunneirong = shixunneirong;
	}
	/**
	 * 获取：实训内容
	 */
	public String getShixunneirong() {
		return shixunneirong;
	}
	/**
	 * 设置：描述
	 */
	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	/**
	 * 获取：描述
	 */
	public String getMiaoshu() {
		return miaoshu;
	}

}
