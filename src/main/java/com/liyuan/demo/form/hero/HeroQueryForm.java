package com.liyuan.demo.form.hero;

import com.liyuan.demo.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class HeroQueryForm extends BaseQueryForm {

	@ApiModelProperty(value = "")
	private Integer id;

	@ApiModelProperty(value = "列表")
	private List<Integer> idList;

	@ApiModelProperty(value = "")
	private Integer type;

	@ApiModelProperty(value = "")
	private String name;

	@ApiModelProperty(value = "")
	private String describe;

	@ApiModelProperty(value = "")
	private String skill;

}