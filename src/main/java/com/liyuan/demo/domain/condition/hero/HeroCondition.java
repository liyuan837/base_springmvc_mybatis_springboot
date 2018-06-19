package com.liyuan.demo.domain.condition.hero;

import com.liyuan.demo.domain.condition.BaseCondition;
import lombok.Data;

import java.util.List;

@Data
public class HeroCondition extends BaseCondition {

	/**
	 * 
	*/
	private Integer id;
	/**
	 * 列表
	*/
	private List<Integer> idList;
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
	private String describe;
	/**
	 * 
	*/
	private String skill;
}