package com.coder.provider.mapper;

import com.coder.base.model.DoubleColorBallOrder;

import java.util.List;

public interface DoubleColorBallOrderMapper {

    DoubleColorBallOrder selectByPrimaryKey(Integer id);

    List<DoubleColorBallOrder> selectByVo(DoubleColorBallOrder doubleColorBallOrder);

    int deleteByPrimaryKey(Integer id);

    int insert(DoubleColorBallOrder doubleColorBallOrder);

    int insertSelective(DoubleColorBallOrder doubleColorBallOrder);

    int insertToBatch(List<DoubleColorBallOrder> doubleColorBallOrders);

    int updateByPrimaryKeySelective(DoubleColorBallOrder doubleColorBallOrder);

    int updateByPrimaryKey(DoubleColorBallOrder doubleColorBallOrder);

    int findCount(DoubleColorBallOrder doubleColorBallOrder);
}