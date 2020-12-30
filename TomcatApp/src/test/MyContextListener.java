package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * 	���ϰ� ���� ��û�� �����⵵ ���� ������, �� ������ �����ϴ� ������ �̺�Ʈ��
 * ������ �� �ִ� ServletContextListener�� �̿��Ͽ�, ServletContext ��ü��
 * ���𰡸� �۾��غ���
 * */
public class MyContextListener implements ServletContextListener{
	
	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("���ø����̼��� ��ٽ��۰� �Բ� �����Ǿ���");
		//���ø����̼��� ������ ������ ����, ���Ǻ��ٺ� �ξ� ���� ��ư��� ServletContext�� 
		//����Ͻ� ��ü��(Service, DAO...)
		ServletContext context = sc.getServletContext();
		context.setAttribute("msg","�� ���� ���");
		
		String contextConfigLocation= context.getInitParameter("contextConfigLocation");
		System.out.println("���ø����̼� �����ɶ� �޸𸮿� �÷��� ����� "+ contextConfigLocation);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		System.out.println("���ø����̼��� ��ٽ��۰� �Բ� �����Ǿ���");
	}
	
	

}
