package com.group.voluntaryfilling.mapper;

import com.group.voluntaryfilling.entity.CollegeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.voluntaryfilling.entity.vo.CollegeInfoVo;
import com.group.voluntaryfilling.entity.vo.CollegeVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-05-15
 */
public interface CollegeInfoMapper extends BaseMapper<CollegeInfo> {

    String getLowestRankByScience(Integer grade);

    String getLowestRankByArts(Integer grade);

    List<CollegeVo> queryCollegeByCondition(String province, String collegeType, String totalLabel, String simpleName, String major);

    List<CollegeVo> queryCollegeByGrade(int minGrade, String section);
}
