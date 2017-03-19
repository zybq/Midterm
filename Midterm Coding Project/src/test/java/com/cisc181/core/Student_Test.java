package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;


import com.cisc181.eNums.eMajor;

public class Student_Test {
	private static ArrayList<Student> studentList;
	private static DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
	private static ArrayList<Course> courseList;
	private static ArrayList<Semester> semesterList;
	private static ArrayList<Section> sectionList;
	private static ArrayList<Enrollment> enrollmentList;
	
	@BeforeClass
	public static void setup() throws PersonException, ParseException {
		studentList = new ArrayList<Student>();
		courseList= new ArrayList<Course>();
		semesterList = new ArrayList<Semester>();
		sectionList=new  ArrayList<Section>();
		enrollmentList =new ArrayList<Enrollment>();
		
		studentList.add(new Student("Cat","Mid","Yu",dateformat.parse("1996-11-16"), eMajor.PHYSICS,
				"Address1", "(302)-666-9999", "q@udel.edu"));
		studentList.add(new Student("Chan","Mid","Yu",dateformat.parse("1995-11-24"), eMajor.NURSING,
				"Address1", "(302)-555-9999", "w@udel.edu"));
		studentList.add(new Student("Shang","Mid","Cat",dateformat.parse("1994-08-30"), eMajor.COMPSI,
				"Address1", "(302)-444-9999", "se@udel.edu"));
		studentList.add(new Student("Huang","Mid","Lee",dateformat.parse("1996-11-19"), eMajor.CHEM,
				"Address1", "(302)-222-9999", "sidra@udel.edu"));
		studentList.add(new Student("Chang","Mid","Yu",dateformat.parse("1997-10-30"), eMajor.PHYSICS,
				"Address1", "(302)-111-9999", "sie@udel.edu"));
		studentList.add(new Student("May","Miss","Yu",dateformat.parse("1996-01-30"), eMajor.COMPSI,
				"Address1", "(302)-333-9999", "sira@udel.edu"));
		studentList.add(new Student("Chang","M","Yu",dateformat.parse("1993-06-30"), eMajor.PHYSICS,
				"Address1", "(302)-232-9999", "sidrra@udel.edu"));
		studentList.add(new Student("Jack","M","Yu",dateformat.parse("1992-11-30"), eMajor.NURSING,
				"Address1", "(302)-121-9999", "siewdra@udel.edu"));
		studentList.add(new Student("Chang","M","Yu",dateformat.parse("1994-07-30"), eMajor.CHEM,
				"Address1", "(302)-234-9999", "sidqwra@udel.edu"));
		studentList.add(new Student("Chang","M","Jass",dateformat.parse("1996-05-30"), eMajor.COMPSI,
				"Address1", "(302)-717-9999", "sidqrra@udel.edu"));
		
		courseList.add(new Course("Business", 100, eMajor.BUSINESS));
		courseList.add(new Course("Chemistry", 100, eMajor.CHEM));
		courseList.add(new Course("PHYSICS", 100, eMajor.PHYSICS));
		
		semesterList.add(new Semester(dateformat.parse("2015-06-30"),dateformat.parse("2015-12-30") ));
		semesterList.add(new Semester(dateformat.parse("2016-01-30"),dateformat.parse("2016-06-30") ));
		
		sectionList.add(new Section(courseList.get(0).getCourseID(),semesterList.get(0).getSemesterID(),1001));
		sectionList.add(new Section(courseList.get(0).getCourseID(),semesterList.get(1).getSemesterID(),1002));
		sectionList.add(new Section(courseList.get(1).getCourseID(),semesterList.get(0).getSemesterID(),1003));
		sectionList.add(new Section(courseList.get(1).getCourseID(),semesterList.get(1).getSemesterID(),1004));
		sectionList.add(new Section(courseList.get(2).getCourseID(),semesterList.get(0).getSemesterID(),1005));
		sectionList.add(new Section(courseList.get(2).getCourseID(),semesterList.get(1).getSemesterID(),1006));
		
		//Enroll the ten students in each of the Sections.
		for (int i=0; i<studentList.size(); i++){
			for (int j=0; j<sectionList.size(); j++){
				enrollmentList.add(new Enrollment(studentList.get(i).getStudentID(), sectionList.get(j).getSectionID()));
			}
		}
		
		//Set all the students' grades to 80 for the convenience.
		for (int i=0; i<enrollmentList.size(); i++){
			enrollmentList.get(i).SetGrade(80);
		}
	}

	@Test
	public void enrollmentTest() {
		assertEquals(enrollmentList.size(),60);	
	}
	
	@Test
	public void gpaTest(){
		// Each students' GPA
		for (int i=0;i<studentList.size(); i++){
			double gpa=0;
			for (int j=i; j<enrollmentList.size(); j=j+studentList.size()){
				gpa += enrollmentList.get(j).GetGrade();
			
			}	
			assertEquals((int)gpa/sectionList.size(),80);
		}
			
		
	}
	
	@Test
	public void averageTest(){
		// The average grade for each student.
		for (int i=0;i<sectionList.size(); i++){
			double gpa=0;
			for (int j=i; j<enrollmentList.size(); j=j+sectionList.size()){
				gpa += enrollmentList.get(j).GetGrade();
			
			}	
			assertEquals((int)gpa/studentList.size(),80);
		}
		
	}
	

	@Test
	public void replaceMajorTest() {
		// Change the first student from PHYSCS major to BUSINESS
		studentList.get(0).setMajor(eMajor.BUSINESS);
		assertEquals(studentList.get(0).getMajor(), eMajor.BUSINESS);
	}
}