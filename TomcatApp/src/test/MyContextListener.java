package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * 	톰켓과 같은 요청이 들어오기도 이전 시점인, 즉 서버를 가동하는 시점의 이벤트를
 * 감지할 수 있는 ServletContextListener를 이용하여, ServletContext 객체에
 * 무언가를 작업해보자
 * */
public class MyContextListener implements ServletContextListener{
	
	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("어플리케이션이 톰겟시작과 함께 가동되었어");
		//어플리케이션의 전역적 정보를 가진, 세션보다보 훨씬 오래 살아가는 ServletContext에 
		//비즈니스 객체들(Service, DAO...)
		ServletContext context = sc.getServletContext();
		context.setAttribute("msg","난 오래 살아");
		
		String contextConfigLocation= context.getInitParameter("contextConfigLocation");
		System.out.println("어플리케이션 가동될때 메모리에 올려질 빈들은 "+ contextConfigLocation);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		System.out.println("어플리케이션이 톰겟시작과 함께 중지되었어");
	}
	
	

}
