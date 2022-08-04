package com.group.voluntaryfilling.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *  大学专业信息
 * </p>
 *
 * @author z-chun
 * @since 2022-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MajorScore对象", description="")
public class MajorScore implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String year;

    private String collegeName;

    private String enrollmentCode;

    private String direction;

    private String section;

    private String major;

    private String majorCode;

    private String batch;

    private String highestScore;

    private String highestLineDifference;

    private String highestRank;

    private String lowestScore;

    private String lowestLineDifference;

    private String lowestRank;

    private String averageScore;

    private String averageLineDifference;

    private String averageRank;

    private String actualAdmissionNumber;


}
