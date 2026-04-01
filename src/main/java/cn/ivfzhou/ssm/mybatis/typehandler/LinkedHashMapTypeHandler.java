package cn.ivfzhou.ssm.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

/**
 * 自定义 MyBatis TypeHandler，用于将 filter_chain 表的查询结果映射为 {@link LinkedHashMap}。
 * <p>filter_chain 表的每行包含 url 和 filter 两个字段，该 Handler 将多行数据
 * 组装成一个 LinkedHashMap&lt;url, filter&gt;，以保证 Shiro 过滤器链的顺序性。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.mybatis.mapper.UserMapper#findFilterChainDefinitionMap()
 */
public class LinkedHashMapTypeHandler extends BaseTypeHandler<LinkedHashMap<String, String>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LinkedHashMap<String, String> parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public LinkedHashMap<String, String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put(rs.getString("url"), rs.getString("filter"));
        while (rs.next()) {
            filterChainDefinitionMap.put(rs.getString("url"), rs.getString("filter"));
        }
        return filterChainDefinitionMap;
    }

    @Override
    public LinkedHashMap<String, String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public LinkedHashMap<String, String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
