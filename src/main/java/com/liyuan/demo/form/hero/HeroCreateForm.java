package com.liyuan.demo.form.hero;

import com.liyuan.demo.annotation.equallength.EqualLength;
import com.liyuan.demo.util.DateUtil;
import com.liyuan.demo.util.ValidUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel
public class HeroCreateForm {

	@ApiModelProperty(value = "")
	private Integer type;

	@ApiModelProperty(value = "")
	private String name;

	@ApiModelProperty(value = ",格式为:" + DateUtil.FORMAT)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date createtime;

	@ApiModelProperty(value = "")
	private String describe;

	@ApiModelProperty(value = "")
	private String skill;

}