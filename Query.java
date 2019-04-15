package util;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import util.myimage_bean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Query extends HttpServlet {
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
		myimage_bean bean = new myimage_bean();
		List< myimage_info> data = bean.getAll();
		int i = 0;
		
		//封装成JSON
		out.println("[");
		Iterator< myimage_info > iter = data.iterator();
		while( iter.hasNext() ){
			
			myimage_info info = iter.next();
		 out.println("{");
		 out.println("\"id\":\"" + info.getId() + "\",");
		 out.println("\"name\":\"" + info.getName() + "\",");
		 out.println("\"like\":\"" + info.getLike() + "\",");
		 out.println("\"url\":\"" + info.getUrl() + "\",");
		 out.println("\"type\":\"" + info.getType() + "\"");
		
		 out.println("}");
		 ++i;
		 if( i < data.size() ){
			 out.println(",");
		 }
		 	//System.out.println(info);
			System.out.printf( "AAAAAA!!%s\n", info.toString()  );
			
		}
		out.println("]");
		out.flush();
		out.close();
	}

}
//out.println("\"id\":\"" + info.getId() + "\",");
//out.println("\"name\":\"" + info.getName() + "\",");
//out.println("\"like\":\"" + info.getLike() + "\"");
//out.println("\"url\":\"" + info.getUrl() + "\",");
//out.println("\"type\":\"" + info.getType() + "\",");
