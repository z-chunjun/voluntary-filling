package com.group.voluntaryfilling.service;

import com.group.voluntaryfilling.entity.Science;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group.voluntaryfilling.entity.vo.RankVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-05-15
 */
public interface ScienceService extends IService<Science> {
    RankVo getScienceRank(Integer score);

    RankVo getArtsRank(Integer score);
}
