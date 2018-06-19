package com.liyuan.demo.domain.po.hero;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HeroPo implements Serializable {

	private static final long serialVersionUID = 3221700752972709820L;
	/**
	 * 
	*/
	private Integer id;
	/**
	 * 
	*/
	private Integer type;
	/**
	 * 
	*/
	private String name;
	/**
	 * 
	*/
	private Date createtime;
	/**
	 * 
	*/
	private String describe;
	/**
	 * 
	*/
	private String skill;
}