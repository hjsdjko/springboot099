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
 * 校内实训
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@TableName("xiaoneishixun")
public class XiaoneishixunEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiaoneishixunEntity() {
		
	}
	
	public XiaoneishixunEntity(T t) {
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
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 实训情况
	 */
					
	private String shixunqingkuang;
	
	/**
	 * 参与情况
	 */
					
	private Integer canyuqingkuang;
	
	/**
	 * 进展
	 */
					
	private String jinzhan;
	
	
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
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：实训情况
	 */
	public void setShixunqingkuang(String shixunqingkuang) {
		this.shixunqingkuang = shixunqingkuang;
	}
	/**
	 * 获取：实训情况
	 */
	public String getShixunqingkuang() {
		return shixunqingkuang;
	}
	/**
	 * 设置：参与情况
	 */
	public void setCanyuqingkuang(Integer canyuqingkuang) {
		this.canyuqingkuang = canyuqingkuang;
	}
	/**
	 * 获取：参与情况
	 */
	public Integer getCanyuqingkuang() {
		return canyuqingkuang;
	}
	/**
	 * 设置：进展
	 */
	public void setJinzhan(String jinzhan) {
		this.jinzhan = jinzhan;
	}
	/**
	 * 获取：进展
	 */
	public String getJinzhan() {
		return jinzhan;
	}

}
