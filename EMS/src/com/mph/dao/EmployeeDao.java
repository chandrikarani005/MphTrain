package com.mph.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.mph.model.Employee;
import com.mph.util.MyDbConn;

public class EmployeeDao {
	Connection con;
	Statement st;
	PreparedStatement pr;
	ResultSet rs;
	
		public void insert_emp(Employee emp)
		{
		con=MyDbConn.myDBConnection();
		try {
			pr=con.prepareStatement("insert into mphemp(eid,ename)values(?,?)");
			pr.setInt(1, emp.getEid());
			pr.setString(2, emp.getEname());
			int noofrows=pr.executeUpdate();
			System.out.println(noofrows +" row inserted succesfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		public void view_emp()
		{
			con=MyDbConn.myDBConnection();
			try {
				st=con.createStatement();
				rs=st.executeQuery("select *from mphemp");
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void insertRecord(Employee emp)
		{
			con=MyDbConn.myDBConnection();
			
			try {
				CallableStatement cs= con.prepareCall("{call insertproc(?,?) }");
				cs.setInt(1, emp.getEid());
				cs.setString(2, emp.getEname());
				cs.execute();
				System.out.println("Procedure executed succesfully and records inserted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void rsmd()
		{
			con=MyDbConn.myDBConnection();
			HashMap<Long,HashMap<String,Object>> hmap=new HashMap<Long,HashMap<String,Object>>();
			try {
				st=con.createStatement();
				rs=st.executeQuery("select *from mphemp");
				
				ResultSetMetaData md = rs.getMetaData();
				System.out.println(md.getColumnCount());
				
				while(rs.next())
				{
					HashMap<String,Object> row =new HashMap<String,Object>();
					for(int i=1;i<=md.getColumnCount();i++)
					{
						row.put(md.getColumnName(i), rs.getObject(i));
						hmap.put(rs.getLong("eid"), row);
						
					}
				}
				System.out.println(hmap);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void type_forward_only_rs()
		{
			con=MyDbConn.myDBConnection();
			try {
				pr=con.prepareStatement("select * from mphemp",ResultSet.TYPE_FORWARD_ONLY);
				rs=pr.executeQuery();
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					
				}
				System.out.println(rs.getType());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void type_scroll_insensitive_rs()
		{
			con=MyDbConn.myDBConnection();
			try {
				pr = con.prepareStatement("select * from mphemp",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs = pr.executeQuery();
				

				while (rs.next()) {
					
					System.out.println(rs.getString(2));
				}
				System.out.println(rs.getType());
				
				System.out.println("Move Cursor to Ist position");
				rs.first();
				System.out.println(rs.getString("ename"));
				
				System.out.println("Move Cursor to Last position");
				rs.last();
				System.out.println(rs.getString("ename"));
				
				System.out.println("Move Cursor to previous position");
				rs.previous();
				System.out.println(rs.getString("ename"));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void type_scroll_sensitive_rs()
		{
			con=MyDbConn.myDBConnection();
			try {
				pr = con.prepareStatement("select eid,ename from mphemp where eid=1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs = pr.executeQuery();
				
				//System.out.println("Before insertion");
				System.out.println("Before updation");
				while (rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					rs.updateInt("eid", 100);
					rs.updateString("ename","anjali");
					rs.updateRow();
				}
				//rs.first();
				//rs.moveToCurrentRow();
			
				//rs.insertRow();
				
				
				System.out.println("Insertion completed");
				System.out.println("After Insert");
				
					//System.out.println(rs.getInt("eid"));
					//System.out.println(rs.getString("ename"));

				System.out.println(rs.getType());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void batch_update()
		{

			con=MyDbConn.myDBConnection();
			try {
				st=con.createStatement();
				st.addBatch("update mphemp set ename='arjun' where eid=100");
				st.addBatch("update mphemp set eid=5 where ename='abhinav'");
				st.addBatch("update mphemp set eid=6 where ename='akhila'");
				st.addBatch("update mphemp set eid=1 where eid=100");
				st.addBatch("update mphemp set eid=7 where ename='archana'");
				
				int[] count=st.executeBatch();
				
				for(int i=0;i<count.length;i++)
				{
					System.out.println(i+" "+count[i]+"times");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
}
