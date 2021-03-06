package com.qf.ssm.service.impl;

import com.qf.ssm.dao.SysUserDao;
import com.qf.ssm.pojo.SysUser;
import com.qf.ssm.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    @Override
    public SysUser getSysUserByName(String name) {
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("nickname", name);
        return sysUserDao.selectOneByExample(example);
    }
}
