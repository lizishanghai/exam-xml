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
			System.out.println("����û�(a)	ɾ���û�(b)	�����û�(c)"); 
			System.out.print("������������ͣ�");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String type = br.readLine();
			
			if("a".equals(type)){
				System.out.println("������ѧ������");
				String name = br.readLine();

				System.out.println("������ѧ��׼��֤��");
				String examid = br.readLine();

				System.out.println("������ѧ�����֤��");
				String idcard = br.readLine();

				System.out.println("������ѧ�����ڵ�");
				String location = br.readLine();
				
				System.out.println("������ѧ���ɼ�");
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
				
				System.out.println("��ӳɹ�");

			}else if("b".equals(type)){
				System.out.println("������Ҫɾ����ѧ������");
				String name = br.readLine();
				
				try{
					StudentDao dao = new StudentDao();
					dao.delete(name);
					System.out.print("ɾ���ɹ�");
				}catch(StudentNotExistException e){
					System.out.println("��Ҫɾ�����û�������");
				}
				
				
			}else if("c".equals(type)){
				System.out.println("������Ҫ��ѯ��ѧ��׼��֤��");
				String examid = br.readLine();
				
				StudentDao dao = new StudentDao();
				Student s = dao.find(examid);
				if(s != null)
					System.out.println(s.getName());
				else
					System.out.println("��Ҫ��ѯ���û�������");
			}else{
				System.out.print("��֧�����Ĳ���");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�Բ��𣬳�����");
		}
		
	}

}
