package com.liyuan.demo.form.hero;

import com.liyuan.demo.util.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel
public class HeroUpdateForm {

	@ApiModelProperty(value = "", required = true)
	@NotNull(message = "不能为空")
	private Integer id;

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