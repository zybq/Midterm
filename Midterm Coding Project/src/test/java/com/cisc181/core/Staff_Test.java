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

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	private static ArrayList<Staff> staffList;
	private static Staff a;
	private static Staff b;
	private static DateFormat dateformat;
	@BeforeClass
	public static void setup() {
		try {
			staffList= new ArrayList<Staff>();
			dateformat=new SimpleDateFormat("yyyy-MM-dd");
			staffList.add(new Staff("Chang","Xiao","Yu",dateformat.parse("1996-11-30"),"250 S Mian,DE", 
					"(302)-777-9999", "ChangY@gmail.com",
					"Monday 13:00-15:00", 2, 2000.0, dateformat.parse("2007-11-30"),
					eTitle.MS));
			staffList.add(new Staff("Alice","Elizabeth","Jones",dateformat.parse("1990-12-30"),"Address2", 
					"(302)-777-4444", "Alice@gmail.com",
					"Friday 12:00-15:00", 2, 2000.0, dateformat.parse("2000-11-30"),
					eTitle.MRS));
			staffList.add(new Staff("Nancy","May","Lee",dateformat.parse("1991-01-30"),"Address3", 
					"(302)-777-3333", "Nancy@gmail.com",
					"Monday 11:00-14:00", 2, 3000.0, dateformat.parse("2007-11-30"),
					eTitle.MS));
			staffList.add(new Staff("Kaly","Feng","Hu",dateformat.parse("1992-07-30"),"Address4", 
					"(302)-777-1111", "Kaly@gmail.com",
					"Friday 8:00-9:00", 2, 4000.0, dateformat.parse("2007-11-30"),
					eTitle.MR));
			staffList.add(new Staff("Lily","Shan","Chen",dateformat.parse("1993-10-30"),"Address5", 
					"(302)-777-2222", "Lily@gmail.com",
					"Friday 11:00-12:00", 2, 2300.0, dateformat.parse("2007-11-30"),
					eTitle.MS));
			
		} catch (PersonException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void staffTest() {
		double average=0;
		for (Staff a:staffList ){
			average+=a.getSalary();	
		}
		average/=staffList.size();
		assertEquals((int)average,2660);
		
	}	
	
	@Test(expected=PersonException.class)
	public void phoneTest() throws PersonException, ParseException{
		dateformat=new SimpleDateFormat("yyyy-MM-dd");
	a = new Staff("Cat","May","Yu",dateformat.parse("1996-11-31"),"Address7", 
					"302-7779799", "sidra@udel.edu",
					"1:00-2:00", 2, 2000.0, dateformat.parse("2007-12-30"),
					eTitle.MS);
	}
	
	@Test(expected=PersonException.class)
	public void dateOBTest() throws PersonException, ParseException{
		dateformat=new SimpleDateFormat("yyyy-MM-dd");
		b = new Staff("Chan","Elizabeth","Lee",dateformat.parse("1840-11-30"),"Address6", 
				"(302)-777-9999", "si@udel.edu",
				"1:00-2:00", 2, 2000.0, dateformat.parse("2007-11-30"),
				eTitle.MS);
		
	}
	
	
}
