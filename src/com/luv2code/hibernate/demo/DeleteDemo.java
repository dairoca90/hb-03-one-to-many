package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory 	= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		try {
			
			/*
			//create the objects 
			Instructor instructor = new Instructor("Chad","Darby","darby@luv2code.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Luv to code!!");
			//asociate the objects
			*/
			
			//create the objects 
			Instructor instructor = new Instructor("Madhu","Patel","madhu@luv2code.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com","Guitar");
			//asociate the objects
			
			instructor.setInstructorDatail(instructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instrcutor 
			//Note: this will also save the details object
			//because of Cascade.ALL
			System.out.println("Saving Instructor");
			
			session.save(instructor);
			
			session.getTransaction().commit();
			System.out.println("Done ... ");
		}finally {
			factory.close();
		}
	}	

}
