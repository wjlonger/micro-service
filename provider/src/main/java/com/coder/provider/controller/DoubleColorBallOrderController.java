package com.coder.provider.controller;

import com.coder.base.model.DoubleColorBallOrder;
import com.coder.base.service.DoubleColorBallOrderService;
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
@RequestMapping("/doublecolorballorder")
public class DoubleColorBallOrderController{

    @Autowired
    private DoubleColorBallOrderService doubleColorBallOrderService;

    public DoubleColorBallOrder selectByPrimaryKey(Integer id) {
        return doubleColorBallOrderService.selectByPrimaryKey(id);
    }

    public PageInfo<DoubleColorBallOrder> selectPage(int pageIndex, int pageSize, DoubleColorBallOrder doubleColorBallOrder) {
        return doubleColorBallOrderService.selectPage(pageIndex, pageSize, doubleColorBallOrder);
    }

    public List<DoubleColorBallOrder> selectAll(DoubleColorBallOrder doubleColorBallOrder) {
        return doubleColorBallOrderService.selectAll(doubleColorBallOrder);
    }

    public int deleteByPrimaryKey(Integer id) {
        return doubleColorBallOrderService.deleteByPrimaryKey(id);
    }

    public int insert(DoubleColorBallOrder doubleColorBallOrder) {
        return doubleColorBallOrderService.insert(doubleColorBallOrder);
    }

    public int insertSelective(DoubleColorBallOrder doubleColorBallOrder) {
        return doubleColorBallOrderService.insertSelective(doubleColorBallOrder);
    }

    public int insertToBatch(List<DoubleColorBallOrder> doubleColorBallOrders) {
        if(!CollectionUtils.isNullOrEmptyStrict(doubleColorBallOrders)){
            return doubleColorBallOrderService.insertToBatch(doubleColorBallOrders);
        }
        return 0;
    }

    public int updateByPrimaryKeySelective(DoubleColorBallOrder doubleColorBallOrder) {
        return doubleColorBallOrderService.updateByPrimaryKeySelective(doubleColorBallOrder);
    }

    public int updateByPrimaryKey(DoubleColorBallOrder doubleColorBallOrder) {
        return doubleColorBallOrderService.updateByPrimaryKey(doubleColorBallOrder);
    }

    public int save(DoubleColorBallOrder doubleColorBallOrder) {
        return doubleColorBallOrderService.save(doubleColorBallOrder);
    }

    public int findCount(DoubleColorBallOrder doubleColorBallOrder) {
        return doubleColorBallOrderService.findCount(doubleColorBallOrder);
    }
}
