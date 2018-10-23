package com.coder.provider.serviceimpl;

import com.coder.base.model.SysUser;
import com.coder.base.service.SysUserService;
import com.coder.provider.mapper.SysUserMapper;
import com.coder.provider.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser selectByProperty(SysUser sysUser) {
        return sysUserMapper.selectByProperty(sysUser);
    }

//    @Override
//    public SysUser selectByPrimaryKey(Integer id) {
//        SysUser sysUser = sysUserRepository.findById(id);
//        if(sysUser == null){
//            sysUser = sysUserMapper.selectByPrimaryKey(id);
//            if(sysUser != null){
//                sysUserRepository.save(sysUser);
//            }
//        }
//        return sysUser;
//    }
//
//    @Override
//    public List<SysUser> selectAll(SysUser sysUser) {
//        if(sysUser == null){
//            sysUser = new SysUser();
//        }
//        List<SysUser> users = sysUserMapper.selectByVo(sysUser);
//        if(CollectionUtils.isNullOrEmptyStrict(users)){
//            return new ArrayList<>();
//        }
//        return users;
//    }
//
//    @Override
//    public PageInfo<SysUser> selectPage(int pageIndex, int pageSize, SysUser sysUser) {
//        PageHelper.startPage(pageIndex, pageSize);
//        List<SysUser> sysUsers = sysUserMapper.selectByVo(sysUser);
//        return new PageInfo(sysUsers);
//    }

//    @Override
//    public int deleteByPrimaryKey(Integer id) {
//        sysUserRepository.deleteById(String.valueOf(id));
//        return sysUserMapper.deleteByPrimaryKey(id);
//    }
//
//    @Override
//    public int deleteByVo(SysUser sysUser) {
//        sysUserRepository.delete(sysUser);
//        return sysUserMapper.deleteByVo(sysUser);
//    }
//
//    @Override
//    public int insert(SysUser sysUser) {
//        sysUserRepository.save(sysUser);
//        return sysUserMapper.insert(sysUser);
//    }
//
//    @Override
//    public int insertSelective(SysUser sysUser) {
//        sysUserRepository.save(sysUser);
//        return sysUserMapper.insertSelective(sysUser);
//    }
//
//    @Override
//    public int insertToBatch(List<SysUser> sysUsers) {
//        if(!CollectionUtils.isNullOrEmptyStrict(sysUsers)){
//            return sysUserMapper.insertToBatch(sysUsers);
//        }
//        return 0;
//    }
//
//    @Override
//    public int updateByPrimaryKeySelective(SysUser sysUser) {
//        sysUserRepository.save(sysUser);
//        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
//    }
//
//    @Override
//    public int updateByPrimaryKey(SysUser sysUser) {
//        sysUserRepository.save(sysUser);
//        return sysUserMapper.updateByPrimaryKey(sysUser);
//    }

    /**
     * 该方法默认按照主键去查，
     * 如果查得到则更新
     * 如果查不到则插入
     * 如果有其它业务需求，请自行编写业务代码
     * @param sysUser
     * @return
     */
//    @Override
//    public int save(SysUser sysUser) {
//        if(sysUser == null){
//            return 0;
//        }
//        SysUser temp = sysUserMapper.selectByPrimaryKey(sysUser.getId());
//        if(temp == null){
//            return insert(sysUser);
//        }
//        return updateByPrimaryKeySelective(sysUser);
//    }
//
//    @Override
//    public int findCount(SysUser sysUser) {
//        return sysUserMapper.findCount(sysUser);
//    }
//
//    @Override
//    public List<SysRole> selectRoleByPrimaryKey(Integer id) {
//        return sysUserMapper.selectRoleByPrimaryKey(id);
//    }
//
//    @Override
//    public List<SysMenu> selectMenuByPrimaryKey(Integer id) {
//        return sysUserMapper.selectMenuByPrimaryKey(id);
//    }
}
