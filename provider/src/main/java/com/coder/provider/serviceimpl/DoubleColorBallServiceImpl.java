package com.coder.provider.serviceimpl;

import com.coder.base.model.DoubleColorBall;
import com.coder.base.service.DoubleColorBallService;
import com.coder.provider.mapper.DoubleColorBallMapper;
import com.coder.util.CollectionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("doubleColorBallService")
public class DoubleColorBallServiceImpl implements DoubleColorBallService {

    @Autowired
    private DoubleColorBallMapper doubleColorBallMapper;

    @Override
    public int insert(DoubleColorBall doubleColorBall) {
        return doubleColorBallMapper.insert(doubleColorBall);
    }

    @Override
    public int insertSelective(DoubleColorBall doubleColorBall) {
        return doubleColorBallMapper.insertSelective(doubleColorBall);
    }

    @Override
    public int insertToBatch(List<DoubleColorBall> doubleColorBalls) {
        if(!CollectionUtils.isNullOrEmptyStrict(doubleColorBalls)){
            return doubleColorBallMapper.insertToBatch(doubleColorBalls);
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DoubleColorBall doubleColorBall) {
        return doubleColorBallMapper.updateByPrimaryKey(doubleColorBall);
    }

    @Override
    public int updateSelectiveByPrimaryKey(DoubleColorBall doubleColorBall) {
        return doubleColorBallMapper.updateSelectiveByPrimaryKey(doubleColorBall);
    }

    @Override
    public DoubleColorBall selectByPrimaryKey(Integer id) {
        return doubleColorBallMapper.selectByPrimaryKey(id);
    }

    @Override
    public DoubleColorBall selectByProperty(DoubleColorBall doubleColorBall) {
        return doubleColorBallMapper.selectByProperty(doubleColorBall);
    }

    @Override
    public List<DoubleColorBall> selectAll(DoubleColorBall doubleColorBall) {
        if(doubleColorBall == null){
            doubleColorBall = new DoubleColorBall();
        }
        List<DoubleColorBall> doubleColorBalls = doubleColorBallMapper.selectByVo(doubleColorBall);
        if(CollectionUtils.isNullOrEmptyStrict(doubleColorBalls)){
            return new ArrayList<>();
        }
        return doubleColorBalls;
    }

    @Override
    public PageInfo<DoubleColorBall> selectPage(int pageIndex, int pageSize, DoubleColorBall doubleColorBall) {
        PageHelper.startPage(pageIndex,pageSize);
        List<DoubleColorBall> doubleColorBalls = doubleColorBallMapper.selectByVo(doubleColorBall);
        return new PageInfo<>(doubleColorBalls);
    }

    @Override
    public int save(DoubleColorBall doubleColorBall) {
        if(doubleColorBall == null){
            return 0;
        }
        DoubleColorBall temp = doubleColorBallMapper.selectByPrimaryKey(doubleColorBall.getId());
        if(temp == null){
            return insert(doubleColorBall);
        }
        return updateSelectiveByPrimaryKey(doubleColorBall);
    }

    @Override
    public int findCount(DoubleColorBall doubleColorBall) {
        return doubleColorBallMapper.findCount(doubleColorBall);
    }
}
