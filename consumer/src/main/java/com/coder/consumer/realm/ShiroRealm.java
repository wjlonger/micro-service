package com.coder.consumer.realm;

import com.coder.consumer.service.SysUserService;
import com.coder.base.model.SysPermission;
import com.coder.base.model.SysRole;
import com.coder.base.model.SysUser;
import com.coder.util.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 在认证、授权内部实现机制中都有提到，最终处理都将交给Realm进行处理。
 * 因为在Shiro中，最终是通过Realm来获取应用程序中的用户、角色及权限信息的。
 * 通常情况下，在Realm中会直接从我们的数据源中获取Shiro需要的验证信息。可以说，Realm是专用于安全框架的DAO.
 * Shiro的认证过程最终会交由Realm执行，这时会调用Realm的getAuthenticationInfo(token)方法。
 *
 * 该方法主要执行以下操作:
 * 检查提交的进行认证的令牌信息
 * 根据令牌信息从数据源(通常为数据库)中获取用户信息
 * 对用户信息进行匹配验证。
 * 验证通过将返回一个封装了用户信息的AuthenticationInfo实例。
 * 验证失败则抛出AuthenticationException异常信息。
 * 而在我们的应用程序中要做的就是自定义一个Realm类，继承AuthorizingRealm抽象类，重载doGetAuthenticationInfo()，重写获取用户信息的方法。
 * @author wjl
 */

public class ShiroRealm extends AuthorizingRealm {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private SysUserService sysUserService;

    /**
     * 验证用户身份，
     * 也就是说验证用户输入的账号和密码是否正确
     * Authentication 认证
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        // 从数据库中获取还用户名对应的user
        SysUser sysUser = new SysUser();
        sysUser.setName(token.getUsername());
        SysUser thisUser = sysUserService.selectByProperty(sysUser);
        if(thisUser == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(
                // 用户实体
                thisUser,
                // 密码
                thisUser.getPassword(),
                // realm name
                getName());
    }

    /**
     * Authorization 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        if(!CollectionUtils.isNullOrEmpty(sysUser.getRoleList())){
            for (SysRole role : sysUser.getRoleList()) {
                authorizationInfo.addRole(role.getRname());
                if(!CollectionUtils.isNullOrEmpty(role.getSysPermissionList())){
                    for (SysPermission p : role.getSysPermissionList()) {
                        authorizationInfo.addStringPermission(p.getName());
                    }
                }
            }
        }
        return authorizationInfo;
    }
}