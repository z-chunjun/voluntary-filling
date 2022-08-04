package com.group.voluntaryfilling.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SuggestionCollegeVo
{
    @ApiModelProperty(value = "普通大学对象")
    private CollegeVo collegeVo;

    @ApiModelProperty(value = "录取指数")
    private Double admissionIndex;

    @ApiModelProperty(value = "录取概率")
    private Integer admissionPossibility;
}
