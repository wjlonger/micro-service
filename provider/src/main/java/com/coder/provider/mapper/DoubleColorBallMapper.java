package com.coder.provider.mapper;

import com.coder.base.model.DoubleColorBall;

import java.util.List;

public interface DoubleColorBallMapper {

    int insert(DoubleColorBall doubleColorBall);

    int insertSelective(DoubleColorBall doubleColorBall);

    int insertToBatch(List<DoubleColorBall> doubleColorBalls);

    int updateByPrimaryKey(DoubleColorBall doubleColorBall);

    int updateSelectiveByPrimaryKey(DoubleColorBall doubleColorBall);

    DoubleColorBall selectByPrimaryKey(Integer integer);

    DoubleColorBall selectByProperty(DoubleColorBall doubleColorBall);

    List<DoubleColorBall> selectByVo(DoubleColorBall doubleColorBall);

    int findCount(DoubleColorBall doubleColorBall);
}