package com.qf.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.ssm.dao.UserDao;
import com.qf.ssm.pojo.User;
import com.qf.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public PageInfo<User> getPageData(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<User> list = userDao.selectAll();

        return PageInfo.of(list);
    }
}
