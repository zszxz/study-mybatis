package com.zszxz.config.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author lsc
 * <p> 知识追寻者，字符串类型处理器</p>
 */
// 指定关联jdbc会改变泛型指定
//@MappedJdbcTypes(JdbcType.VARCHAR)
public class StringTypeHandler extends BaseTypeHandler<String> {

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        // 指定java参数类型(String)对应数据库类型(varchar)
        preparedStatement.setString(i,s);
    }

    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getString(s);
    }

    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i);
    }

    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }
}
