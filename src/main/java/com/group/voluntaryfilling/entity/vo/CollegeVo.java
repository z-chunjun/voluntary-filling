package com.group.voluntaryfilling.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CollegeVo {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "中文名称")
    private String cnName;

    private String direction;

    private String simpleName;

    private Integer ranking;

    @ApiModelProperty(value = "大学招生代码")
    private String collegeCode;

    private String province;

    @ApiModelProperty(value = "大学类型 /综合/医药/理工/艺术")
    private String collegeType;

    @ApiModelProperty(value = "985 211")
    private String simpleLabel;

    private String totalLabel;

    private String imgId;

    private String section;

    private Integer admissionNumber;

    private Integer lowestScore;

    private String lowestRank;
}
