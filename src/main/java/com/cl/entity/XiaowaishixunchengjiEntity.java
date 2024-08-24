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
 * 校外实训成绩
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 14:54:49
 */
@TableName("xiaowaishixunchengji")
public class XiaowaishixunchengjiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiaowaishixunchengjiEntity() {
		
	}
	
	public XiaowaishixunchengjiEntity(T t) {
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
	 * 实训名称
	 */
					
	private String shixunmingcheng;
	
	/**
	 * 实训内容
	 */
					
	private String shixunneirong;
	
	/**
	 * 实训日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shixunriqi;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 成绩
	 */
					
	private Integer chengji;
	
	
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
	 * 设置：实训日期
	 */
	public void setShixunriqi(Date shixunriqi) {
		this.shixunriqi = shixunriqi;
	}
	/**
	 * 获取：实训日期
	 */
	public Date getShixunriqi() {
		return shixunriqi;
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
	 * 设置：成绩
	 */
	public void setChengji(Integer chengji) {
		this.chengji = chengji;
	}
	/**
	 * 获取：成绩
	 */
	public Integer getChengji() {
		return chengji;
	}

}
