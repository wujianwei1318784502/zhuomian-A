package util;

import java.sql.Connection;
import util.myimage_info;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class myimage_bean {
	
	public List<myimage_info> getAll(){
		List< myimage_info > data = 
				new ArrayList< myimage_info >();
		
		
		Connection conn = DBConn.getConnection();// ȡ������
		try{
			
			String sql = "select *  from  myimage";
			java.sql.PreparedStatement st = 
					conn.prepareStatement( sql );
			
			ResultSet rs = st.executeQuery(  );//ִ�в�ѯ���
			System.out.println( "��ѯ���Ϊ��" +rs);
			
			while( rs.next() ){
				
				// id
				String id = rs.getString( "id" );// id
				// id
				
				String name = rs.getString( "name" );
				// name
				String like = 
						rs.getString("like");
				String url = 
						rs.getString("url");
				String type = 
						rs.getString("type");
				
				myimage_info info = new myimage_info(id,name,like,url,type);
				data.add( info );
				
			}
			
		}
		catch( SQLException e ){
			e.printStackTrace();
			System.out.printf( "���ݿ��ѯʧ��\n" + e.getMessage()  );
		}
		finally{
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "�ر�����ʧ��\n" + e.getMessage()  );
				}// try
			}// if
			
		}// finally

		return data;
	}
	////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////
	
	//�޸�
		public boolean up_like( String id,String like){
			
			// ��ȡ����
			Connection conn = DBConn.getConnection();
			int count = -1;
			
			try{
				String sql = " update myimage "
						+ "  set `like` = ? "
						+ "  where `id` = ?  ";
				PreparedStatement st = conn.prepareStatement(  sql );
				int i = 1;
				
				st.setString(i, like);
				++i;
				// like
				
				//   id
				st.setString(i,id);
				++i;
				
				System.out.printf("sql = %s\n", st.toString());
				
				count = st.executeUpdate(  );//ִ�����
				//System.out.printf( "�޸���%d����¼", count );
			}
			catch( SQLException e ){
				//System.out.printf( "�޸�ʧ��:" + e.getMessage() );
				return false;
			}
			finally{
				if( conn != null ){
					try{
						conn.close();
					}
					catch( SQLException e ){
						//System.out.printf( "�ر�����ʧ��\n" + e.getMessage()  );
					}// try
				}// if
				
			}// finally
			
			return true;
		}
		public boolean add( myimage_info info ){
			
			// ��ȡ����
			Connection conn = DBConn.getConnection();
			
			int count = -1;
			
			try{
				String sql = " insert  myimage "
						+ "  (`id`,`name`,`like`,`url`,`type`) "
						+ "  values(?, ?, ?, ?, ?) ";
				//System.out.println(sql);
				PreparedStatement st = conn.prepareStatement(  sql );
				int i = 1;
				
				//  id
				st.setString( i, info.getId() );
				++i;
				//   name
				st.setString(i, info.getName() );
				++i;
				st.setString(i, info.getLike() );
				++i;
				st.setString(i, info.getUrl() );
				++i;
				st.setString(i, info.getType() );
				++i;
				
				//System.out.printf("sql = %s\n", st.toString());
				
				count = st.executeUpdate(  );// ִ�����
				//System.out.printf( "����%d����¼", count );
			}
			catch( SQLException e ){
				e.printStackTrace();
				//System.out.printf( "����ʧ��:" + e.getMessage() );
				return false;
			}
			finally{
				if( conn != null ){
					try{
						conn.close();
					}
					catch( SQLException e ){
						//System.out.printf( "�ر�����ʧ��\n" + e.getMessage()  );
					}// try
				}// if
				
			}// finally
			
			return true;
		}
		public myimage_info get_by_id(String id)
		{
			
			// ��ȡ����
							myimage_info info = new myimage_info();
							info.setId(id);
						Connection conn = DBConn.getConnection();
						int count = -1;
							
						try{
							String sql = " select from myimage "
									+ "  where `id` = ?  ";
							PreparedStatement st = conn.prepareStatement(  sql );
							int i = 1;				
							//   id
							st.setString(i, id );
							++i;
							
							ResultSet rs = st.executeQuery(  );//ִ�в�ѯ���
							System.out.println( "��ѯ���Ϊ��" +rs);
							
							System.out.printf( "������%d����¼", count );
						}
						catch( SQLException e ){
							//System.out.printf( "����ʧ��:" + e.getMessage() );
							
						}
						finally{
							if( conn != null ){
								try{
									conn.close();
								}
								catch( SQLException e ){
									//System.out.printf( "�ر�����ʧ��\n" + e.getMessage()  );
								}// try
							}// if
								
						}// finally
							
						return info;
		}
		public boolean del_id( String id ){
			
			// ��ȡ����
			Connection conn = DBConn.getConnection();
			int count = -1;
				
			try{
				String sql = " delete from myimage "
						+ "  where `id` = ?  ";
				PreparedStatement st = conn.prepareStatement(  sql );
				int i = 1;				
				//   id
				st.setString(i, id );
				++i;
				
				System.out.printf("sql = %s\n", st.toString());
									count = st.executeUpdate(  );//ִ�����
				System.out.printf( "ɾ����%d����¼", count );
			}
			catch( SQLException e ){
				//System.out.printf( "ɾ��ʧ��:" + e.getMessage() );
				return false;
			}
			finally{
				if( conn != null ){
					try{
						conn.close();
					}
					catch( SQLException e ){
						//System.out.printf( "�ر�����ʧ��\n" + e.getMessage()  );
					}// try
				}// if
					
			}// finally
				
			return true;
		}
		//int id, String name, String like,String url,String type
	  public static void main(String[] args) {
			Connection con = DBConn.getConnection();
			myimage_bean bean = new myimage_bean();
			bean.getAll();
			bean.up_like("1003","1");
			System.out.println(bean.get_by_id("1002").getId());
			System.out.println(bean.get_by_id("1002"));
			myimage_info info  = new myimage_info("3001","���ɫ","1","ssdd","abd");
			bean.add(info);
			
			//myimage_info info  = new myimage_info("1019","���ɫ","1","ssdd","abd");
			
			//bean.add(info);
			//bean.del_id("1008");
			//System.out.println(bean.getAll());
			
		}
}
