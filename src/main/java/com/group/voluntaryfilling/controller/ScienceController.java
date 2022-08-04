package com.group.voluntaryfilling.controller;


import com.group.voluntaryfilling.entity.vo.RankVo;
import com.group.voluntaryfilling.service.ScienceService;
import com.group.voluntaryfilling.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author z-chun
 * @since 2022-05-15
 */
@RestController
@RequestMapping("/grades")
public class ScienceController {

    @Autowired
    private ScienceService scienceService;

    // 3、根据分数和选课查询排位
    @GetMapping("{section}/{score}/rank")
    public R getRank(@PathVariable String section, @PathVariable Integer score)
    {
        RankVo rankVo = null;
        if(section.equals("理科")){
            rankVo = scienceService.getScienceRank(score);
        }else{
            rankVo = scienceService.getArtsRank(score);
        }

        if(rankVo != null){
            return R.ok().data("rank", rankVo);
        }else{
            return R.error().message("没有找到当前分数的排位");
        }
    }
}

