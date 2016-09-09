package org.vite.publishing.controller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.vite.publishing.bean.VitePublishingAuthor;

import antlr.Version;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class RunMeTask extends HibernateDaoSupport 
{
	public void printMe() {
		  int day, month, year;
	      int second, minute, hour;
	      GregorianCalendar date = new GregorianCalendar();
	 
	      day = date.get(Calendar.DAY_OF_MONTH);
	      month = date.get(Calendar.MONTH);
	      year = date.get(Calendar.YEAR);
	 
	      second = date.get(Calendar.SECOND);
	      minute = date.get(Calendar.MINUTE);
	      hour = date.get(Calendar.HOUR);
	      
		try {
			Transaction trns = null;
			Session session = null;
			
			try {
				DriverManager.getConnection(
						"jdbc:mysql://204.93.216.11:3306/kneibarg_vite_publishing?user=kneibarg_test&password=test2014");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (!getSessionFactory().isClosed()) {
				session = getSessionFactory().openSession();
			} else {
				session = getSessionFactory().getCurrentSession();
			}
			trns = session.beginTransaction();	
			SQLQuery q = session.createSQLQuery("select 1 from DUAL");
			List<Object[]> entities = q.list();
			//List<VitePublishingAuthor> loginUser = getHibernateTemplate().loadAll(VitePublishingAuthor.class);
			if (q != null) {
				for (int i=0; i<1; i++) {
					// Print out the current time of day so we can make sure we only run this every 4 hours. 
					System.out.println("Current date is  "+day+"/"+(month+1)+"/"+year);
				    System.out.println("Current time is  "+hour+" : "+minute+" : "+second);
					System.out.println(entities.toString());
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
			
	}
	
}
