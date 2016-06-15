package com.anbo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.anbo.dao.impl.UserDAOImpl;
import com.anbo.po.Article;
import com.anbo.po.UserBean;
import com.anbo.service.Impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
   private UserBean user;
   private UserDAOImpl usedao=new UserDAOImpl();
   private static final Logger logger = Logger.getLogger(UserAction.class);//日志记录
  // private static Log logger = LogFactory.getLog(UserAction.class);
   private List<UserBean> usersList;
   private UserServiceImpl userService;
   private int pageIndex;//当前的分页索引值

   
	public int getPageIndex() {
	return pageIndex;
}


public void setPageIndex(int pageIndex) {
	this.pageIndex = pageIndex;
}


	public UserServiceImpl getUserService() {
	return userService;
}


public void setUserService(UserServiceImpl userService) {
	this.userService = userService;
}


	//验证登陆信息
	public String test(){
		
		//this.usedao.loginCheck(user);
		user=this.usedao.selectUser(user);
	    if(user!=null){
	    	System.out.println("welcome");
	    	
	    }else{
	    	System.out.println("please login again.....");
	    }
		return showAllUser();
	}
	

	/**
	 * 验证用户登录信息，map参数
	 * @return
	 */
	public String checkUserInfo(){
		 HttpServletRequest request=ServletActionContext.getRequest();
		 System.out.println(request.getAttribute("xin"));
		 
		 
		logger.info("可以用log代替system.out输出相关信息啦~~~~~~~~~");
		//System.out.println("------------------------sadfsdfdfadfsdf------------------------------"+user.getLoginName());
		Map<String,String> map=new HashMap<String,String>();
		map.put("loginName",user.getLoginName());
		map.put("loginPwd",user.getLoginPwd());
		boolean flag=userService.selectUserInfoByParam(map);
		if(flag){
			System.out.println("ok");
			
		}else{
			System.out.println("no");
		}
		
		 int userCount=userService.selectUserCount();
			request.setAttribute("count", userCount);
			
			System.out.println("userCount ="+request.getAttribute("count"));
			//Map session = ActionContext.getContext().getSession(); 
			//session.put("pageIndex", pageIndex);
		return  "showAllUser";//showUserForDialog()是跳转到普通页面的
	}
	
	//此action继承struts2的ActionSupport类后，从这个类里实现的方法，自动调用，验证信息
	public void validate(){
		logger.info("啊哈哈哈哈哈哈  "+user.getLoginName());
		if(user.getLoginName()==null||user.getLoginName().equals("")){
			this.addFieldError("name", "用户名不能为空！");
		}
	}
	
	//显示所有用户
	public String showAllUser(){
		//MyBatisQueryParamAdapter mqAdapter = new MyBatisQueryParamAdapter();
		   HttpServletRequest request=ServletActionContext.getRequest();
		   Map<String,Integer> map=new HashMap<String, Integer>();
		   map.put("start", 0);
		   map.put("end", 3);
		   usersList =  userService.getPaginationUsers(map);
		   System.out.println("分页取的的数据    ===="+usersList.get(0).getLoginName());
		usersList=userService.showAllUsers();
		int userCount=userService.selectUserCount();
		request.setAttribute("count", userCount);
		
		System.out.println("userCount ="+request.getAttribute("count"));
		 JSONArray ul = JSONArray.fromObject(usersList);
		   System.out.println("转成json后==  "+ul.toString());
		return "showAllUser";
	}
	
	//分页
	public void showPageUser() throws IOException{
		 logger.info("jjjjjjjjjjjjjjjjjjjjj");
		  int tempPageIndex=0;
		  HttpServletResponse response=ServletActionContext.getResponse();
		  response.setCharacterEncoding("UTF-8");
		  PrintWriter out=response.getWriter();
		  System.out.println("pageIndex   ="+pageIndex);
		  
		   Map<String,Integer> map=new HashMap<String, Integer>();
		   if(pageIndex==0){
			   tempPageIndex=0; 
		   }else{
			   tempPageIndex=pageIndex*2+pageIndex;
		   }
		   System.out.println("tempPageIndex   ="+tempPageIndex);
		   map.put("start", tempPageIndex);
		   map.put("end", 3);
		   usersList =  userService.getPaginationUsers(map);
		   for(int i=0;i<usersList.size();i++){
			   System.out.println(usersList.get(i));
			   
		   }
		   System.out.println("分页取的的数据    ===="+usersList.get(0).getLoginName());
		   //将数据转成json格式
		   JSONArray ul = JSONArray.fromObject(usersList);
		   System.out.println("转成json后==  "+ul.toString());
		   out.print(ul.toString());
		  
	}
	
	public void testJson(){
		System.out.println("转成json后== dddddddddddddddddddddd ");
		 HttpServletResponse response=ServletActionContext.getResponse();
		  response.setCharacterEncoding("UTF-8");
		  try {
			PrintWriter out=response.getWriter();
			out.print("hehe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//查询所有用户
	public String showUserForDialog(){
		//MyBatisQueryParamAdapter mqAdapter = new MyBatisQueryParamAdapter();
		
		usersList=userService.showAllUsers();
		logger.info("usersList  "+usersList);
		return "toShowUser";
	}
	//ajax提交表单测试
	public void tests(){
		System.out.println("提交到action "+user.getLoginName());
		
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("utf-8");//设置中文乱码编码格式
			PrintWriter out=response.getWriter();
			out.write("一切都会好起来的");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//添加用户信息
	public String addUsers(){
		System.out.println("add users................"+user.getLoginName());
		/*boolean flag=usedao.addUsers(user);*/
		System.out.println("birthday~~~~~~~~~~  "+user.getBirthday());
		int maxId=userService.selectMaxUserId();
		logger.debug("查询出的最大编号是  "+maxId);
		user.setUserId(maxId+1);
		
		//java.sql.Timestamp tp=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd mm:dd:ss");
		 System.out.println("时间 = "+df.format(new java.util.Date()));
		 user.setBirthday(df.format(new java.util.Date()));
		  boolean flag=userService.addUsers(user);
		System.out.println("heheheh"+flag);
		
		return showAllUser();
	}
	//根据用户id，查看用户文章
	public String showArticleByUserId(){
		System.out.println("hahahahahahahahah===================");
		List<Article> la=userService.selectArticleByUserId(user.getUserId());
		System.out.println("ar=== "+la.get(0).getUser().getLoginName());
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listArticle", la);
		return "toShowArticles";
	}

	//————————————————————————get&set————————————————————————————
	 public UserDAOImpl getUsedao() {
		return usedao;
		}
		
		public void setUsedao(UserDAOImpl usedao) {
			this.usedao = usedao;
		}



		public List<UserBean> getUsersList() {
		return usersList;
		}
		
		public void setUsersList(List<UserBean> usersList) {
			this.usersList = usersList;
		}

		public UserBean getUser() {
		return user;
	    }

		public void setUser(UserBean user) {
			this.user = user;
		}
}
