package com.tz.jspstudy.framework.page;

import java.io.IOException;
import java.util.Properties;
import com.tz.jspstudy.framework.page.dto.PageObject;
import com.tz.jspstudy.framework.util.StringUtils;

/**
 * 转化传入的sql字符串为分页形式sql
 * 类描述：  
 * 类名称：com.tz.jspstudy.framework.page.PageSqlUtils       
 * 创建人：keven  
 * 创建时间：2016年8月10日 下午9:10:36     
 * @version   V1.0
 */
public class PageSqlUtils {
    private static Properties initProp=new Properties();
    private static int dbType = 0;
    static{
        try {
            initProp.load(PageSqlUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dbType = StringUtils.isNotNull(initProp.getProperty("dbType"))?new Integer(initProp.getProperty("dbType")):1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

    public static String getTotalRowsSql(String sql){
    	StringBuffer pageSql = new StringBuffer();
    	pageSql.append(" SELECT COUNT(*) FROM ");
 		pageSql.append(" ("+sql+") Y " );
 		return pageSql.toString();
    }
    
    
    public static String getPageSql(String sql,PageObject page){
    	String pageSql = "";
    	if(dbType==1){
        	StringBuffer pageSqlBuffer = new StringBuffer();
        	pageSqlBuffer.append(" SELECT Y.* FROM ");
        	pageSqlBuffer.append(" (");
        	pageSqlBuffer.append(" SELECT M.*,ROWNUM AS RN FROM ("+sql+" ) M ");   	 		 
        	pageSqlBuffer.append("  ) Y ");
        	pageSqlBuffer.append(" WHERE Y.RN BETWEEN "+page.getBegRow()+" AND "+page.getEndRow());
        	pageSql = pageSqlBuffer.toString();
    	}else if(dbType==2){
    		StringBuffer pageSqlBuffer = new StringBuffer();
    		int beginRowForMySql= page.getBegRow()-1;
        	int pageSize = page.getEndRow()-page.getBegRow()+1;
        	pageSqlBuffer.append(sql);
        	pageSqlBuffer.append(" limit "+beginRowForMySql+","+pageSize);
        	pageSql = pageSqlBuffer.toString();
    	}else{
    		System.out.println("未知的数据库,需要补充转换方法");
    	}
    	return pageSql;
    }
      
   
    
}
