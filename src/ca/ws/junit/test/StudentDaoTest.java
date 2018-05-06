package ca.ws.junit.test;

import org.junit.Test;

import ca.ws.dao.StudentDao;
import ca.ws.domain.Student;

public class StudentDaoTest {
	
	@Test
	public void testAdd(){
		
		StudentDao dao = new StudentDao();
		Student s = new Student();
		s.setExamid("121");
		s.setGrade(89);
		s.setIdcard("121");
		s.setLocation("北京");
		s.setName("王五");
		dao.add(s);
	}

	@Test
	public void testFind(){
		
		StudentDao dao = new StudentDao();
 		Student s = dao.find("121");
 		System.out.println(s.getName());
 		
	}

	@Test
	public void testDelete(){
		
		StudentDao dao = new StudentDao();
		dao.delete("王五");
 		
	}
}
