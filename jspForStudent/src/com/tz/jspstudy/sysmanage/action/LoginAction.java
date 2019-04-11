package com.tz.jspstudy.sysmanage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tz.jspstudy.framework.struts.servlet.Action;
import com.tz.jspstudy.framework.struts.servlet.ActionForm;
import com.tz.jspstudy.framework.struts.servlet.ActionForward;
import com.tz.jspstudy.framework.struts.servlet.DispatchProcessor;
import com.tz.jspstudy.sysmanage.formbean.LoginForm;  

/**
 * 类描述：  登陆和用户管理的控制器
 *		   注意这里不是一个servlet ，是一个普通的action的java类
 * 类名称：com.tz.htmlservlet.sysmanage.action.LoginAction       
 * 创建人：keven  
 * 创建时间：2016年7月30日 下午7:26:42     
 * @version   V1.0
 */
public class LoginAction extends Action {

	private  Log logger = LogFactory.getLog(LoginAction.class);

	public ActionForward execute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		LoginForm loginForm = (LoginForm)form;
		
		
		logger.info("已经进入了登陆验证业务处理类LoginAction，进行用户名和密码的验证");
		logger.info("loginForm.getUserName()----"+loginForm.getUserName());
		logger.info("loginForm.getPassword()---"+loginForm.getPassword());
		logger.info("已经进入了登陆验证业务处理类LoginAction，验证完毕，准备forward跳转");

		boolean flag =true;
		//转发回界面
		if(flag)
			return new ActionForward("pages/main/main.html",false);
		else
			return new ActionForward("error.html");
	}
	
	
}
