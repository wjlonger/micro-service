package com.coder.provider.controller;

import com.coder.base.service.DoubleColorBallService;
import com.coder.provider.mapper.DoubleColorBallMapper;
import com.coder.base.model.DoubleColorBall;
import com.coder.util.CollectionUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/doublecolorball")
public class DoubleColorBallController{

    @Autowired
    private DoubleColorBallService doubleColorBallService;

    public int insert(DoubleColorBall doubleColorBall) {
        return doubleColorBallService.insert(doubleColorBall);
    }

    public int insertSelective(DoubleColorBall doubleColorBall) {
        return doubleColorBallService.insertSelective(doubleColorBall);
    }

    public int insertToBatch(List<DoubleColorBall> doubleColorBalls) {
        if(!CollectionUtils.isNullOrEmptyStrict(doubleColorBalls)){
            return doubleColorBallService.insertToBatch(doubleColorBalls);
        }
        return 0;
    }

    public int updateByPrimaryKey(DoubleColorBall doubleColorBall) {
        return doubleColorBallService.updateByPrimaryKey(doubleColorBall);
    }

    public int updateSelectiveByPrimaryKey(DoubleColorBall doubleColorBall) {
        return doubleColorBallService.updateSelectiveByPrimaryKey(doubleColorBall);
    }

    public DoubleColorBall selectByPrimaryKey(Integer id) {
        return doubleColorBallService.selectByPrimaryKey(id);
    }

    public DoubleColorBall selectByProperty(DoubleColorBall doubleColorBall) {
        return doubleColorBallService.selectByProperty(doubleColorBall);
    }

    public List<DoubleColorBall> selectAll(DoubleColorBall doubleColorBall) {
        return doubleColorBallService.selectAll(doubleColorBall);
    }

    public PageInfo<DoubleColorBall> selectPage(int pageIndex, int pageSize, DoubleColorBall doubleColorBall) {
        return doubleColorBallService.selectPage(pageIndex, pageSize, doubleColorBall);
    }

    public int save(DoubleColorBall doubleColorBall) {
        return doubleColorBallService.save(doubleColorBall);
    }

    public int findCount(DoubleColorBall doubleColorBall) {
        return doubleColorBallService.findCount(doubleColorBall);
    }
}
