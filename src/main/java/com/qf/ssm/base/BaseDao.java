package com.qf.ssm.base;

import tk.mybatis.mapper.common.*;

public interface BaseDao<T> extends MySqlMapper<T>,
        ExampleMapper<T>, BaseMapper<T>, IdsMapper<T>, ConditionMapper<T> {
}
