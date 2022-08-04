package com.group.voluntaryfilling.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *  大学详细信息
 * </p>
 *
 * @author z-chun
 * @since 2022-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CollegeInfo对象", description="")
public class CollegeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String cnName;

    private Integer ranking;

    private String simpleName;

    private String enName;

    private String collegeCode;

    private String province;

    private String area;

    private String creationTime;

    private String girlProportion;

    private String boyProportion;

    private String natureType;

    private String collegeType;

    private String affiliation;

    private String simpleLabel;

    private String art;

    private String nef;

    private String too;

    private String keyPoint;

    private String isPrivate;

    private String worldRank;

    private String totalRank;

    private String masterPoint;

    private String doctorPoint;

    private String worldClass;

    private String topUniversity;

    private String totalLabel;

    private String description;

    private String bachelorJunior;

    private String phoneNum;

    private String email;

    private String address;

    private String website;

    private String celebrity;

    private String evaluation;

    private String employment;

    private String suggestMajor;

    private String imgId;


}
