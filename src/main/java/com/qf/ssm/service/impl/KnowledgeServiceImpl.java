package com.qf.ssm.service.impl;

import com.qf.ssm.dao.KnowledgeDao;
import com.qf.ssm.pojo.Knowledge;
import com.qf.ssm.service.KnowledgeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class KnowledgeServiceImpl implements KnowledgeService {

    @Resource
    private KnowledgeDao knowledgeDao;

    @Override
    public List<Knowledge> getAll() {
        return knowledgeDao.getAll();
    }
}
