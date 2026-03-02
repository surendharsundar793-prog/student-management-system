package com.qsp.student_management_system.dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qsp.student_management_system.connection.GetConnectionObject;
import com.qsp.student_management_system.entity.Student;

public class StudentData {
	Connection c = GetConnectionObject.getconnection();

	public boolean save(Student std) {

		String SQL = "insert into student values(?,?,?,?,?)";

		try {
			PreparedStatement prt = c.prepareStatement(SQL);

			prt.setInt(1, std.getSid());
			prt.setString(2, std.getName());
			prt.setInt(3, std.getAge());
			prt.setString(4, std.getEmail());
			prt.setString(5, std.getGender());

			int update = prt.executeUpdate();

			return update > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public void getallstudent() {
		String query = "select * from student";
		List<Student> liststd = new ArrayList<Student>();

		try {
			PreparedStatement prt = c.prepareStatement(query);
			ResultSet res = prt.executeQuery();

			while (res.next()) {
				int sid = res.getInt("sid");
				String name = res.getString("name");
				int age = res.getInt("age");
				String email = res.getString("email");
				String gender = res.getString("gender");

				// bind this individual data into object
				Student std = new Student();
				std.setSid(sid);
				std.setName(name);
				std.setAge(age);
				std.setEmail(email);
				std.setGender(gender);

				// we have add this object into list
				liststd.add(std);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Student s : liststd) {
			System.out.println("Sid :" + s.getSid());
			System.out.println("Name :" + s.getName());
			System.out.println("Age :" + s.getAge());
			System.out.println("Email :" + s.getEmail());
			System.out.println("Gender :" + s.getGender());
			System.out.println("----------------------------------");
		}

	}

	public Student BasedOnId(int sid) {
		String id = "select * from student where sid = ?";
		Student std = null;
		try {
			PreparedStatement ps = c.prepareStatement(id);
			ps.setInt(1, sid);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				int data = res.getInt("sid");
				String name = res.getString("name");
				int age = res.getInt("age");
				String email = res.getString("email");
				String gender = res.getString("gender");

				std = new Student();
				std.setSid(data);
				std.setName(name);
				std.setAge(age);
				std.setEmail(email);
				std.setGender(gender);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return std;
	}
	
	public boolean updatestudentdata(int sid,String name) {
		String update = "update student set name = ? where sid = ?";
		try {
			PreparedStatement pt=c.prepareStatement(update);
			pt.setInt(2, sid);
			pt.setString(1, name);
			
			int row = pt.executeUpdate();
			
			return row > 0;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
		
	}

	public boolean deleteStudent(int sid) {
		String delete = "delete from Student where sid=?";
		
		try {
			PreparedStatement pstm = c.prepareStatement(delete);
			
			pstm.setInt(1,sid);
			int row = pstm.executeUpdate();
			return row > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return false;
		
	}
	
}
