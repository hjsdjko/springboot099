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
 * 实训单位
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@TableName("shixundanwei")
public class ShixundanweiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShixundanweiEntity() {
		
	}
	
	public ShixundanweiEntity(T t) {
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
	 * 单位名称
	 */
					
	private String danweimingcheng;
	
	/**
	 * 单位介绍
	 */
					
	private String danweijieshao;
	
	/**
	 * 地址
	 */
					
	private String dizhi;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 实训岗位
	 */
					
	private String shixungangwei;
	
	/**
	 * 实训内容
	 */
					
	private String shixunneirong;
	
	
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
	 * 设置：单位名称
	 */
	public void setDanweimingcheng(String danweimingcheng) {
		this.danweimingcheng = danweimingcheng;
	}
	/**
	 * 获取：单位名称
	 */
	public String getDanweimingcheng() {
		return danweimingcheng;
	}
	/**
	 * 设置：单位介绍
	 */
	public void setDanweijieshao(String danweijieshao) {
		this.danweijieshao = danweijieshao;
	}
	/**
	 * 获取：单位介绍
	 */
	public String getDanweijieshao() {
		return danweijieshao;
	}
	/**
	 * 设置：地址
	 */
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	/**
	 * 获取：地址
	 */
	public String getDizhi() {
		return dizhi;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：实训岗位
	 */
	public void setShixungangwei(String shixungangwei) {
		this.shixungangwei = shixungangwei;
	}
	/**
	 * 获取：实训岗位
	 */
	public String getShixungangwei() {
		return shixungangwei;
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

}
