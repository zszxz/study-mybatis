package com.zszxz.typehandler.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


/**
 * @Author lsc
 * <p> 一个无聊的业务逻辑 输入的是时间戳，到数据库中的是 timestamp 格式 输出的又是时间戳 </p>
 */
@MappedJdbcTypes(JdbcType.TIMESTAMP)
@MappedTypes(Long.class)
public class TimeStringHandler<T> extends BaseTypeHandler<T> {


    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T t, JdbcType jdbcType) throws SQLException {
        // 将 时间戳转为 LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond((java.lang.Long) t), ZoneOffset.ofHours(8));
        // 参数设置
        System.out.println("业务逻辑1");
        preparedStatement.setString(i,localDateTime.toString());
    }

    public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("业务逻辑2");
        String time = resultSet.getString(s);
        LocalDateTime localDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Long second = localDateTime.toEpochSecond(ZoneOffset.ofHours(8));
        return (T) second;
    }

    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("业务逻辑3");
        String time = resultSet.getString(i);
        LocalDateTime localDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Long second = localDateTime.toEpochSecond(ZoneOffset.ofHours(8));
        return (T) second;
    }

    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("业务逻辑4");
        String time = callableStatement.getString(i);
        LocalDateTime localDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Long second = localDateTime.toEpochSecond(ZoneOffset.ofHours(8));
        return (T) second;
    }
}
