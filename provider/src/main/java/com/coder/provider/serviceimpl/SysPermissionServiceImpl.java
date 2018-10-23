package com.coder.provider.serviceimpl;

import com.coder.base.model.SysPermission;
import com.coder.base.service.SysPermissionService;
import com.coder.provider.mapper.SysPermissionMapper;
import com.coder.util.CollectionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public SysPermission selectByPrimaryKey(Integer id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<SysPermission> selectPage(int pageIndex, int pageSize, SysPermission sysPermission) {
        PageHelper.startPage(pageIndex,pageSize);
        List<SysPermission> sysPermissions = sysPermissionMapper.selectByVo(sysPermission);
        return new PageInfo<>(sysPermissions);
    }

    @Override
    public List<SysPermission> selectAll(SysPermission sysPermission) {
        if(sysPermission == null){
            sysPermission = new SysPermission();
        }
        List<SysPermission> permissions = sysPermissionMapper.selectByVo(sysPermission);
        if(CollectionUtils.isNullOrEmptyStrict(permissions)){
            return new ArrayList<>();
        }
        return permissions;
    }

    @Override
    public SysPermission selectByProperty(SysPermission sysPermission) {
        return sysPermissionMapper.selectByProperty(sysPermission);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByProperty(SysPermission sysPermission) {
        return sysPermissionMapper.deleteByProperty(sysPermission);
    }

    @Override
    public int insert(SysPermission sysPermission) {
        return sysPermissionMapper.insert(sysPermission);
    }

    @Override
    public int insertSelective(SysPermission sysPermission) {
        return sysPermissionMapper.insert(sysPermission);
    }

    @Override
    public int insertToBatch(List<SysPermission> sysPermissions) {
        if(!CollectionUtils.isNullOrEmptyStrict(sysPermissions)){
            return sysPermissionMapper.insertToBatch(sysPermissions);
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(SysPermission sysPermission) {
        return sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
    }

    @Override
    public int updateByPrimaryKey(SysPermission sysPermission) {
        return sysPermissionMapper.updateByPrimaryKey(sysPermission);
    }

    @Override
    public int save(SysPermission sysPermission) {
        if(sysPermission == null){
            return 0;
        }
        SysPermission temp = sysPermissionMapper.selectByPrimaryKey(sysPermission.getId());
        if(temp == null){
            return insert(sysPermission);
        }
        return updateByPrimaryKeySelective(sysPermission);
    }

    @Override
    public int findCount(SysPermission sysPermission) {
        return sysPermissionMapper.findCount(sysPermission);
    }
}
