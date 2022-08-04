package com.group.voluntaryfilling.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.voluntaryfilling.entity.CollegeInfo;
import com.group.voluntaryfilling.entity.vo.CollegeQuery;
import com.group.voluntaryfilling.entity.vo.CollegeVo;
import com.group.voluntaryfilling.entity.vo.SuggestionCollegeVo;
import com.group.voluntaryfilling.service.CollegeInfoService;
import com.group.voluntaryfilling.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author z-chun
 * @since 2022-05-15
 */
@RestController
@RequestMapping("/college")
public class CollegeInfoController {
    @Autowired
    private CollegeInfoService collegeInfoService;

    //1 条件查询学校带分页的方法
    @PostMapping("{pageIndex}/{pageSize}")
    public R queryCollegeByCondition(@PathVariable Integer pageIndex, @PathVariable Integer pageSize,
                                  @RequestBody(required = false) CollegeQuery collegeQuery) {

        PageHelper.startPage(pageIndex, pageSize);
        List<CollegeVo> list = collegeInfoService.queryCollegeByCondition(pageIndex, pageSize, collegeQuery);
        PageInfo pageInfo = new PageInfo(list);

        System.out.println("总页数: " + pageInfo.getPages());
        System.out.println("总记录数: " + pageInfo.getTotal());
        System.out.println("当前页数: " + pageInfo.getPageNum());
        System.out.println("当前页面记录数量: " + pageInfo.getSize());
        return R.ok().data("items", pageInfo);
    }

    //2 按学校代码查询
    @GetMapping("Info/{collegeCode}")
    public R queryCollegeInfo(@PathVariable String collegeCode)
    {
        QueryWrapper<CollegeInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("college_code", collegeCode);
        List<CollegeInfo> collegeInfoList = collegeInfoService.list(wrapper);
        return R.ok().data("collegeInfoList", collegeInfoList);
    }


    // 4、根据分数和选科列出推荐学校
    @GetMapping("suggestion/{grade}/{section}")
    public R queryCollegeByGrade(@PathVariable("grade") Integer grade, @PathVariable("section") String section, @RequestParam(value = "minAdmissionIndex", defaultValue = "0") Double minAdmissionIndex, @RequestParam(value = "maxAdmissionIndex", defaultValue = "10") Double maxAdmissionIndex)
    {
        List<SuggestionCollegeVo> list = collegeInfoService.queryCollegeByGrade(grade, section);
        list = list.stream().filter((c) -> c.getAdmissionIndex() >= minAdmissionIndex && c.getAdmissionIndex() <= maxAdmissionIndex).collect(Collectors.toList());
        if(list != null)
            return R.ok().data("suggestions", list);
        else
            return R.ok().message("未找到任何数据");
    }
}

