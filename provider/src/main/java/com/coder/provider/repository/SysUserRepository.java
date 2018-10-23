package com.coder.provider.repository;

import com.coder.base.model.SysUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysUserRepository extends MongoRepository<SysUser,String> {

    SysUser findById(Integer id);

    SysUser findByName(String name);
}
