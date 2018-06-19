package com.liyuan.demo.form.hero;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class HeroDeleteForm {

	@ApiModelProperty(value = "", required = true)
	@NotNull(message = "不能为空")
	private Integer id;

}