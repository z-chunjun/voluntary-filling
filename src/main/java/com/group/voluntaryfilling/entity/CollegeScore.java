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
 *  大学录取信息
 * </p>
 *
 * @author z-chun
 * @since 2022-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CollegeScore对象", description="")
public class CollegeScore implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String collegeName;

    private String direction;

    private String section;

    private String batch;

    private String lowestScore;

    private String lowestLineDifference;

    private String lowestRank;

    private String admissionNumber;


}
