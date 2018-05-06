package ca.ws.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ca.ws.dao.StudentDao;
import ca.ws.domain.Student;
import ca.ws.exception.StudentNotExistException;
import ca.ws.utils.XmlUtils;

public class Main {

	public static void main(String[] args) {

		try {
			System.out.println("添加用户(a)	删除用户(b)	查找用户(c)"); 
			System.out.print("请输入操作类型：");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String type = br.readLine();
			
			if("a".equals(type)){
				System.out.println("请输入学生姓名");
				String name = br.readLine();

				System.out.println("请输入学生准考证号");
				String examid = br.readLine();

				System.out.println("请输入学生身份证号");
				String idcard = br.readLine();

				System.out.println("请输入学生所在地");
				String location = br.readLine();
				
				System.out.println("请输入学生成绩");
				String grade = br.readLine();
				
				Student s = new Student();
				s.setExamid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);
				
				StudentDao dao = new StudentDao();
				dao.add(s);
				
				System.out.println("添加成功");

			}else if("b".equals(type)){
				System.out.println("请输入要删除的学生姓名");
				String name = br.readLine();
				
				try{
					StudentDao dao = new StudentDao();
					dao.delete(name);
					System.out.print("删除成功");
				}catch(StudentNotExistException e){
					System.out.println("您要删除的用户不存在");
				}
				
				
			}else if("c".equals(type)){
				System.out.println("请输入要查询的学生准考证号");
				String examid = br.readLine();
				
				StudentDao dao = new StudentDao();
				Student s = dao.find(examid);
				if(s != null)
					System.out.println(s.getName());
				else
					System.out.println("您要查询的用户不存在");
			}else{
				System.out.print("不支持您的操作");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("对不起，出错了");
		}
		
	}

}
