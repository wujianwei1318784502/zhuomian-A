package util;

import java.io.IOException;
import util.myimage_bean;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {

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
		   String id = req.getParameter("id");
		    
		    // name
		    String url = req.getParameter("url");
		 	// url
		    String like = req.getParameter("like");
		    
		    String name = req.getParameter("name");
		    
		    String type = req.getParameter("type");
	    
	    
	    // 执行　
		myimage_bean bean = new myimage_bean();
	    myimage_info info = new myimage_info();
	    boolean result = bean.del_id(info.getId());
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
