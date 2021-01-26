package com.koreait.fashionshop.client.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koreait.fashionshop.exception.LoginRequiredException;
import com.sun.org.apache.bcel.internal.classfile.Signature;

//������ �α����� �ʿ��� ���� ���θ� ó���ϱ� ���� �ǵ�� ��Ʈ�ѷ��� ���� �ʰ�,
//���� �� ��ü�� ����ȭ ���� AOP�����ϰڴ�
public class MemberSessionCheckAspect {

	private static final Logger logger = LoggerFactory.getLogger(MemberSessionCheckAspect.class);
	
	public Object sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable{

		Object target = joinPoint.getTarget();//����ȣ���Ϸ����ߴ� ��ü
		logger.debug("���� ȣ���Ϸ� �ߴ� ��ü�� "+target);
		String methodName = joinPoint.getSignature().getName();
		logger.debug("���� ȣ���Ϸ� �ߴ� �޼���� "+methodName);
		Object[] args = joinPoint.getArgs();//���� ȣ���Ϸ��ߴ� �޼����� �Ű������� �� �� �ִ�

		//���� ��û�� ������ ������ �ִ����� �Ǵ��Ͽ�, ������ ����		
		//������ ��� ���ؼ��� HttpServletRequest�� �ʿ��ϴ�
		HttpServletRequest request = null;
		for(Object obj : args) {
			logger.debug("�Ű��������� "+obj );
			if(obj instanceof HttpServletRequest ) {//request��ü���
				request=(HttpServletRequest)obj;				
			}
		}
		
		Object result=null;
		
		//1. ������ ���ٸ�? ���ܸ� �߻���ų ����->ExceptionHanler�� ���ļ� Ŭ���̾�Ʈ���� ������ ����ó��
		//2. ������ �ִٸ�? �״�� ���� ȣ���Ϸ� �ߴ� �޼��� ���� ��������
		HttpSession session = null;
		session = request.getSession();
		//MemberController�� �α��� �޼��忡 �ɾ�� member
		if(session.getAttribute("member")==null) {
			throw new LoginRequiredException("�α����� �ʿ��� ���� �Դϴ�");
		}else {
			//���� ��û�� �帧�� �״�� �������! ��
			//���� ȣ���Ϸ��ߴ� �޼��带 ��� ȣ��
			result = joinPoint.proceed();//���⼭ ���ܰ� �߻��ϹǷ� ����ó������ ���� �׳� throws����
		}
		
		//���� Ŭ���̾�Ʈ ����: �޼��� ȣ�� �� ���������� ��ȯ���� �� �ִ�
		return result;
		
	}
}
