package com.qf.ssm.service;

import com.github.pagehelper.PageInfo;
import com.qf.ssm.pojo.User;

public interface UserService {
    PageInfo<User> getPageData(int pageNum, int pageSize);
}
