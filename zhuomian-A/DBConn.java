package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	

	    // ������ݿ�����
	    public static Connection getConnection() {

	        Connection con = null;
	        try {
	            // ����MySql��������
	            Class.forName("com.mysql.jdbc.Driver");
	            // ��������
	            con = DriverManager.getConnection(
	                    //  �������˿ںţ����������������ݿ⣺image
	                    "jdbc:mysql://localhost:3306/image"
	                            + "?useUnicode=true&characterEncoding=utf8",
	                    "root", // �û���
	                    "123456"); // ����
	            // �������ݿ�����
	        } catch (Exception e) {
	        	e.printStackTrace();
	            System.out.printf("���ݿ�����ʧ��\n");
	        }

	        return con;
	    }

	    public static void main(String[] args) {
			Connection con = DBConn.getConnection();
			if(con == null)
			{
				System.out.println("NO!");
			}
			else
			{
				System.out.println("YES!");
			}
		}
}
//��Ů
