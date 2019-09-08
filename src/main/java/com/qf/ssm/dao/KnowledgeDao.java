package com.qf.ssm.dao;

import com.qf.ssm.base.BaseDao;
import com.qf.ssm.pojo.Knowledge;

import java.util.List;

public interface KnowledgeDao extends BaseDao<Knowledge> {

    List<Knowledge> getAll();

}
