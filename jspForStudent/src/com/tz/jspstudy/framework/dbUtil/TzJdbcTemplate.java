package com.tz.jspstudy.framework.dbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tz.jspstudy.framework.dbUtil.inteface.RowMapper;
import com.tz.jspstudy.framework.page.PageSqlUtils;
import com.tz.jspstudy.framework.page.dto.PageObject;


/**
 * jdbc连接 模板类
 * @author Administrator
 *
 */
public class TzJdbcTemplate{
 
	public  Long  getSequence(){
		Long returnSequence = 0l;
		//建立连接
		Connection con = null;   //创建一个数据库连接  （打开门）
		PreparedStatement pre = null;  //创建预编译语句对象 （推车）
		ResultSet result = null;    // 创建一个结果集对象 （货物）			
		String sql = "SELECT SYS_SEQUENCE.NEXTVAL FROM DUAL ";				
		//连接数据库
		con = DbUtilPro.getConnection();
		try {
			//加载预编译语句
			pre = con.prepareStatement(sql);
			result = (ResultSet) pre.executeQuery(sql);
			while(result.next()){
				returnSequence = result.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtilPro.closeConnection(con, pre, result);
		}
		return returnSequence;
		
	}
	
	/**
	 * 封装增删改操作
	 * 
	 */
	public  int updateTemplate(String sql,Object[] params){
		int rows= 0;
		//建立连接
		Connection con = null;   //创建一个数据库连接  （打开门）
		PreparedStatement pre = null;  //创建预编译语句对象 （推车）
		ResultSet result = null;    // 创建一个结果集对象 （货物）	
		
		//连接数据库
		con = DbUtilPro.getConnection();
		try {
			//加载预编译语句
			pre = con.prepareStatement(sql);
			setParams(params, pre);
			rows= pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtilPro.closeConnection(con, pre, result);
		}
 		
		
		return rows;
	}
	
	
	/**
	 * 利用泛型来返回业务需要的类型
	 * @param mapper
	 * @param sql
	 * @param params
	 * @return
	 */
	public <T> List<T> queryForList(RowMapper<T> mapper, String sql, Object[] params) {
		List<T> results = new ArrayList<T>();
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;		
		try {
			con = DbUtilPro.getConnection();
			pre = con.prepareStatement(sql);
			// 设置参数
			setParams(params,pre);
			// 通过SQL语句操作对象发送
			// executeQuery:执行数据的查询操作(select)
			rs = pre.executeQuery();
			//记录当前结果集循环的行号
			int rownum = 0;
			// 循环获取结果
			while (rs.next()) {
				rownum++;
				results.add(mapper.mappingRow(rs, rownum));
			}
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// 关闭资源
			DbUtilPro.closeConnection(con, pre, rs);
		}
	}
	
	
	/**
	 * 用一个Map对象来表示数据库中的一行记录，列名作为Map的key，值作为Map的value
	 * 如果有多条件记录则将记录对应的Map添加到集合中一起返回
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String,Object>> queryForList(String sql,Object[] params){
		List<Map<String,Object>> mapObjList = new ArrayList<Map<String,Object>>();
		//建立连接
		Connection con = null;   //创建一个数据库连接  （打开门）
		PreparedStatement pre = null;  //创建预编译语句对象 （推车）
		ResultSet result = null;    // 创建一个结果集对象 （货物）		
		//连接数据库
		con = DbUtilPro.getConnection();
		try {
			//加载预编译语句
			pre = con.prepareStatement(sql);
			setParams(params, pre);
			result= pre.executeQuery();
			//得到结果集的元数据对象
			ResultSetMetaData metaData = result.getMetaData();
 			//获取结果集的列数
			int num = metaData.getColumnCount();
			while(result.next()){
				Map<String,Object> mapObj = new HashMap<String,Object>();
				for(int i = 0;i<num;i++){
					//获取某个列名
					String columnName = metaData.getColumnLabel(i+1);
					//根据列名获取值（value）
					mapObj.put(columnName, result.getObject(columnName));
				}
				mapObjList.add(mapObj);
			}
		} catch (SQLException e) {
 			e.printStackTrace();
		}finally{
			DbUtilPro.closeConnection(con, pre, result);
		}
 		
		return mapObjList;
		
	}

	private static void setParams(Object[] params, PreparedStatement pre){
		//设置参数
		if(params!=null){
			for(int i=0;i<params.length;i++){
				//循环赋值
				try {
					pre.setObject(i+1, params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	/**
	 * 加入分页对象利用泛型来返回业务需要的结果集
	 * @param mapper
	 * @param sql
	 * @param params
	 * @return
	 */
	public <T> List<T> queryForList(RowMapper<T> mapper, String sql, Object[] params,PageObject page) {
		 if(null==page){
			 return this.queryForList(mapper, sql, params);
		 }else{//进入分页流程
			 if(page.getPageSize()==-1){
				 return this.queryForList(mapper, sql, params);
			 }else{//进入正儿八经的分页流程了
				 //1:判断是不是第一次进入此功能查询  判断标志 totalRows = -1 需要查询sql记录的总数
				 if(page.getTotalRow()==-1){
					 //查询总数
					 String totalRowSql = PageSqlUtils.getTotalRowsSql(sql);
					 //查询总数
					 int totalRows = this.queryForInteger(totalRowSql, params);
					 page.setTotalRow(totalRows);
				 }
				 //2:将我们原生态的sql转化为分页sql（兼顾屏蔽数据库的差异）
				 String sqlPage = PageSqlUtils.getPageSql(sql, page);				 
				 //3：查询分页sql的结果集
				 return this.queryForList(mapper, sqlPage, params);

			 }
			 
		 }
	}
	
	
	public int queryForInteger(String sql,Object[] params){
		int i = 0;
		//建立连接
		Connection con = null;   //创建一个数据库连接  （打开门）
		PreparedStatement pre = null;  //创建预编译语句对象 （推车）
		ResultSet result = null;    // 创建一个结果集对象 （货物）		
		//连接数据库
		con = DbUtilPro.getConnection();
		try {
			//加载预编译语句
			pre = con.prepareStatement(sql);
			setParams(params, pre);
			result= pre.executeQuery();			 
			while(result.next()){
				i = result.getInt(1);
			}
		} catch (SQLException e) {
 			e.printStackTrace();
		}finally{
			DbUtilPro.closeConnection(con, pre, result);
		}
 		
		return i;
		
	}
	
	
	
	
	
}