package com.liyuan.demo.vo.property;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class PropertyVo {

	@ApiModelProperty(value = "", required = true)
	private Integer id;

	@ApiModelProperty(value = "")
	private String name;

}