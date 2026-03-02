package com.qsp.student_management_system.controller;

import java.util.Scanner;
import java.util.*;

import com.qsp.student_management_system.dao.StudentData;
import com.qsp.student_management_system.entity.Student;

public class ProvideData {
	static Scanner sc=new Scanner(System.in);
	static StudentData sd=new StudentData();

	public static void choice1() {
		System.out.println("Enter your ID");
		int sid = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter your Name");
		String name = sc.nextLine();
		
		System.out.println("Enter your Age");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter your Email");
		String email = sc.nextLine();
		
		System.out.println("Enter your Gender");
		String gender = sc.nextLine();
		
		//Passing user data
		Student std=new Student();
		std.setSid(sid);
		std.setName(name);
		std.setAge(age);
		std.setEmail(email);
		std.setGender(gender);
		
	 	Boolean b= sd.save(std);
	 	
	 	if(b) {
	 		System.out.println("Data Inserted....");
	 	}
	 	else {
			System.out.println("Data Not Inserted");
	 	}
		
	}

	public static void main(String[] args) {
		while (true) {

			System.out.println("-----Student Data-----");
			System.out.println(" ");

			System.out.println("Press 1 To insert student record");
			System.out.println("Press 2 To fetch all student record");
			System.out.println("Press 3 To fetch student data based on sid");
			System.out.println("Press 4 To update a student record");
			System.out.println("Press 5 To delete a record from database");
			System.out.println("Press 6 To exit from project");

			System.err.println("Please Enter your choice");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				choice1();
				break;

			case 2:
				StudentData st = new StudentData();
				// List<Student> li = st.getallstudent();
				st.getallstudent();
				break;
			case 3:
				System.out.println("Please Enter your Id");
				int sid = sc.nextInt();
				Student smd = sd.BasedOnId(sid);
				System.out.println("SID : " + smd.getSid());
				System.out.println("SID : " + smd.getName());
				System.out.println("SID : " + smd.getAge());
				System.out.println("SID : " + smd.getEmail());
				System.out.println("SID : " + smd.getGender());
				break;

			case 4: {
				System.out.println("enter sid");
				int sid2 = sc.nextInt();
				sc.next();
				System.out.println("enter updated name");
				String name = sc.nextLine();

				boolean b = sd.updatestudentdata(sid2, name);

				if (b) {
					System.out.println("Data updated");
				} else {
					System.out.println("Data is not updated");
				}
			}
				break;

			case 5:
				System.out.println("Enter Sid");
				int sid1 = sc.nextInt();
				boolean std = sd.deleteStudent(sid1);
				if (std) {
					System.out.println("Deleted");
				} else {
					System.out.println("Not Deleted!");
				}
				break;
			case 6: {
				System.exit(1);
				sc.close();
				System.out.println("Running successfull");
			}
			default:
				System.out.println("Please Enter Preffered choice");
				break;
			}

		}

	}
}
