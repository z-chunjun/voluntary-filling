package com.group.voluntaryfilling.service.impl;

import com.group.voluntaryfilling.entity.Science;
import com.group.voluntaryfilling.entity.vo.RankVo;
import com.group.voluntaryfilling.mapper.ScienceMapper;
import com.group.voluntaryfilling.service.ScienceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-05-15
 */
@Service
public class ScienceServiceImpl extends ServiceImpl<ScienceMapper, Science> implements ScienceService {

    @Override
    public RankVo getScienceRank(Integer score) {
        RankVo rankVo = baseMapper.getScienceRank(score);
        String highestRank = rankVo.getRank();
        rankVo.setHighestRank(highestRank);

        String lowestRank = String.valueOf(Integer.parseInt(highestRank) - rankVo.getNumber() + 1);
        rankVo.setLowestRank(lowestRank);
        return rankVo;
    }

    @Override
    public RankVo getArtsRank(Integer score) {
        RankVo rankVo = baseMapper.getArtsRank(score);
        String highestRank = rankVo.getRank();
        rankVo.setHighestRank(highestRank);

        String lowestRank = String.valueOf(Integer.parseInt(highestRank) - rankVo.getNumber() + 1);
        rankVo.setLowestRank(lowestRank);
        return rankVo;
    }
}
