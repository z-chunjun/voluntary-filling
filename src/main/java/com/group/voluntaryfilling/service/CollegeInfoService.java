package com.group.voluntaryfilling.service;

import com.group.voluntaryfilling.entity.CollegeInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group.voluntaryfilling.entity.vo.CollegeInfoVo;
import com.group.voluntaryfilling.entity.vo.CollegeQuery;
import com.group.voluntaryfilling.entity.vo.CollegeVo;
import com.group.voluntaryfilling.entity.vo.SuggestionCollegeVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-05-15
 */
public interface CollegeInfoService extends IService<CollegeInfo> {

    List<CollegeVo> queryCollegeByCondition(int pageIndex, int pageSize, CollegeQuery collegeQuery);

    List<SuggestionCollegeVo> queryCollegeByGrade(Integer grade, String section);
}
