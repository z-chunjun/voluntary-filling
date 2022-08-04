package com.group.voluntaryfilling.mapper;

import com.group.voluntaryfilling.entity.Science;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.voluntaryfilling.entity.vo.RankVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-05-15
 */
public interface ScienceMapper extends BaseMapper<Science> {

    RankVo getScienceRank(Integer score);

    RankVo getArtsRank(Integer score);
}
