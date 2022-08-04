package com.group.voluntaryfilling.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.voluntaryfilling.entity.CollegeInfo;
import com.group.voluntaryfilling.entity.vo.CollegeQuery;
import com.group.voluntaryfilling.entity.vo.CollegeVo;
import com.group.voluntaryfilling.entity.vo.SuggestionCollegeVo;
import com.group.voluntaryfilling.mapper.CollegeInfoMapper;
import com.group.voluntaryfilling.service.CollegeInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-05-15
 */
@Service
public class CollegeInfoServiceImpl extends ServiceImpl<CollegeInfoMapper, CollegeInfo> implements CollegeInfoService {

    @Override
    public List<CollegeVo> queryCollegeByCondition(int pageIndex, int pageSize, CollegeQuery collegeQuery) {

        // 多条件组合查询
        // mybatis学过 动态sql
        String province = collegeQuery.getProvince();
        String collegeType = collegeQuery.getCollegeType();
        String totalLabel = collegeQuery.getTotalLabel();
        String simpleName = collegeQuery.getSimpleName();
        String major = collegeQuery.getMajor();

        List<CollegeVo> collegeVoList = baseMapper.queryCollegeByCondition(province, collegeType, totalLabel, simpleName, major);

        return collegeVoList;
    }

    @Override
    public List<SuggestionCollegeVo> queryCollegeByGrade(Integer grade, String section) {

        int minGrade = grade - 30;

        //得到minGrade分数以上的所有学校列表
        List<CollegeVo> collegeVoList = baseMapper.queryCollegeByGrade(minGrade, section);

        //grade分的最低排位
        String lowestRank = null;
        if(section.equals("理科")){
            lowestRank = baseMapper.getLowestRankByScience(grade - 1);
        }else{
            lowestRank = baseMapper.getLowestRankByArts(grade - 1);
        }
        int rank = Integer.parseInt(lowestRank) - 1;
        System.out.println(grade + "分的最低排位是：" + rank);

        // 返回建议填报学校列表
        List<SuggestionCollegeVo> suggestionCollegeVoList = new ArrayList<>();

        // 录取指数实现逻辑
        // 遍历所有minGrade分数以上的学校
        for(CollegeVo collegeVo : collegeVoList)
        {
            SuggestionCollegeVo suggestionCollegeVo = new SuggestionCollegeVo();
            suggestionCollegeVo.setCollegeVo(collegeVo);
            // 得到改学校的最低录取分
            int nowCollegeLowestScore = collegeVo.getLowestScore();

            //录取分大于等于该学校最低录取分的录取人数之和
            int nowTotal = 0;
            for(CollegeVo collegeVo1 : collegeVoList)
            {
                if(nowCollegeLowestScore <= collegeVo1.getLowestScore())
                    nowTotal += collegeVo1.getAdmissionNumber();
            }
            // 录取指数
            double admissionIndex = 1.0 * nowTotal / rank;
            suggestionCollegeVo.setAdmissionIndex(admissionIndex);
            suggestionCollegeVoList.add(suggestionCollegeVo);
        }
        return suggestionCollegeVoList;
    }
}
