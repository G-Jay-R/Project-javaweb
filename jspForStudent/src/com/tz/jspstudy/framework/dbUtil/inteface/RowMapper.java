package com.tz.jspstudy.framework.dbUtil.inteface;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 行映射的接口,通过传人的ResultSet对象将每一条记录映射成对应的对象
 */
public interface RowMapper<T> {

	/**
	 * 每一行数据要映射的对象
	 * 
	 * @param rs
	 *            结果集对象
	 * @param rownum
	 *            当前结果集映射的行号
	 * @return
	 */
	public T mappingRow(ResultSet rs, int rownum) throws SQLException;

}
