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
 *  理科录取信息
 * </p>
 *
 * @author z-chun
 * @since 2022-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Science对象", description="")
public class Science implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer score;

    private Integer number;

    private String rank;

}
