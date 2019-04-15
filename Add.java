package util;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;

import util.myimage_bean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		
		req.setCharacterEncoding("UTF-8");
	    // 接收参数
	    // id
	    String id = req.getParameter("id");
	    
	    // name
	    String url = req.getParameter("url");
	 	// url
	    String like = req.getParameter("like");
	    
	    String name = req.getParameter("name");
	    
	    String type = req.getParameter("type");
	    
	    //int id, String name, String like,String url,String type　
	    myimage_bean bean = new myimage_bean();
	    myimage_info info = new myimage_info(id, name,like,url,type);
	    boolean result = bean.add(info);
	    System.out.println("result = " + result);
	 	// 返回执行结果
	    if(result){
	    	out.println(1);
	    }
	    else{
	    	out.println(0);
	    }
		out.flush();
		out.close();
	}
	

}
