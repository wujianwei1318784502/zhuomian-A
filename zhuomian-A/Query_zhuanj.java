package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Query_zhuanj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Query_zhuanj() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setContentType("text/html;charset=utf-8");
			
	
	PrintWriter out = resp.getWriter();
	req.setCharacterEncoding("UTF-8");
	// 接收参数
	// id
	myzhuanji_bean bean = new myzhuanji_bean();
	List< myzhuanji_info> data = bean.getAll();
	int i = 0;
	
	//封装成JSON
	out.println("[");
	Iterator< myzhuanji_info > iter = data.iterator();
	while( iter.hasNext() ){
		myzhuanji_info info = iter.next();
	 out.println("{");
	 out.println("\"id\":\"" + info.getId() + "\",");
	 out.println("\"name\":\"" + info.getName() + "\",");
	 out.println("\"author\":\"" + info.getAuthor() + "\",");
	 out.println("\"describle\":\"" + info.getDescribe() + "\",");
	 out.println("\"url_1\":\"" + info.getUrl_1() + "\",");
	 out.println("\"url_2\":\"" + info.getUrl_2() + "\",");
	 out.println("\"url_3\":\"" + info.getUrl_3() + "\",");
	 out.println("\"url_4\":\"" + info.getUrl_4() + "\",");
	 out.println("\"url_5\":\"" + info.getUrl_5() + "\",");
	 out.println("\"url_6\":\"" + info.getUrl_6() + "\"");
	 out.println("}");
	 ++i;
	 if( i < data.size() ){
		 out.println(",");
	 }
		
	}
	out.println("]");
	
	out.flush();
	out.close();

	}

}
