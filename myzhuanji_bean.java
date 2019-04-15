package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class myzhuanji_bean {

	public List<myzhuanji_info> getAll(){
		List< myzhuanji_info > data = 
				new ArrayList< myzhuanji_info >();
		
		
		Connection conn = DBConn.getConnection();// 取得连接
		try{
			
			String sql = "select *  from  zhuanji";
			java.sql.PreparedStatement st = 
					conn.prepareStatement( sql );
			
			ResultSet rs = st.executeQuery(  );//执行查询语句
			System.out.println( "查询结果为：" +rs);
			
			while( rs.next() ){
				
				// id
				String id = rs.getString( "id" );// id
				// id
				
				String name = rs.getString( "name" );
				// name
				String author = 
						rs.getString("author");
				String describe = 
						rs.getString("describe");
				String url_1 = 
						rs.getString("url_1");
				String url_2 = 
						rs.getString("url_2");
				String url_3 = 
						rs.getString("url_3");
				String url_4 = 
						rs.getString("url_4");
				String url_5 = 
						rs.getString("url_5");
				String url_6 = 
						rs.getString("url_6");
				
				myzhuanji_info info = new myzhuanji_info(id,name,author,describe,url_1,url_2,url_3,url_4,url_5,url_6);
				data.add( info );
				
			}
			
		}
		catch( SQLException e ){
			e.printStackTrace();
			System.out.printf( "数据库查询失败\n" + e.getMessage()  );
		}
		finally{
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "关闭连接失败\n" + e.getMessage()  );
				}// try
			}// if
			
		}// finally

		return data;
	}
	public static void main(String[] args) {
		Connection con = DBConn.getConnection();
		myzhuanji_bean bean = new myzhuanji_bean();
		bean.getAll();
		System.out.println(bean.getAll().get(0).getAuthor());
		System.out.println(bean.getAll().get(0).getDescribe());
	}
	
}
