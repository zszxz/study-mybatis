package com.zszxz.plugin.config;

import com.zszxz.plugin.entity.Order;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;


import java.time.LocalDateTime;
import java.util.Properties;

/**
 * @Author lsc
 * <p> mybatis 插件</p>
 */
@Intercepts({ @Signature(type = Executor.class, method = "update"
        , args = { MappedStatement.class, Object.class}) })
public class AddPlugin  implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        String sqlId = mappedStatement.getId();
        // 参数-此时为order 对象
        Object parameter = invocation.getArgs()[1];
        // 参数：com.zszxz.plugin.entity.Order@48503868
        System.out.print("参数："+parameter);
        // 拦截参数，对参数进行增强
        Order order = (Order) parameter;
        order.setCreate_time(LocalDateTime.now());
        // 此时插入数据库，会有时间插入
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    public void setProperties(Properties properties) {

    }
}
