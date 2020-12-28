//�� Ŭ������ ���� : ������ ���࿡ �ʿ��� SqlSession�� �� ����
//�� �� �ֵ��ΰ� ���뼺�� ����Ͽ� ������ ��ü, Ư�� �� ��ü �ν��Ͻ���
//���ø����̼� ������ 1���� �־� �ϹǷ� SingleTon�������� ��������
package com.study.springfinal.mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

//�츮�� ���� �Ϲ�Ŭ������ component��� ǥ���ؾ� �޸𸮿� �÷��ش�
@Component
public class MybatisConfigManager {
	//2. �����ڸ� �������Ƿ�, ���� Ŭ�������� �ν��Ͻ��� �������� ������ ����� ����� ����
	//���� ���� Ŭ���� getter��������
	private static MybatisConfigManager instance;
	String resource ;
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;
	
	private MybatisConfigManager(){//1. �����ڸ� ���, �ƹ��� new���ϰ�
		 
		resource = "com/study/springfinal/mybatis/config/config.xml";
		 try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//2. getter����
	//3. getter���� �Ǿ�����, ���� �ν��Ͻ� �޼��� �̹Ƿ� new�� �������� ȣ���� �� �ֱ� ������
	//�� � ��ü�� �� �޼��鸣 ȣ�� �� �� ����(new�� ���Ƴ�������)
	//�ذ�å: new���� �ʰ� �Ʒ��� �޼��带 ȣ���� �� �ֵ��� static�޼���� ��������
	public static MybatisConfigManager getInstance() {
		//4. �� �޼��� ȣ��� instance������ null�̶�� , ���⼭ �ν��Ͻ��� �����ؼ� 
		//null���� �ƴ� ���� ���������� ó������
		if(instance==null) {
			instance = new MybatisConfigManager();
		}
		return instance;
	}
	
	//SqlSession���, �ݱ�
	public SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
	public void close(SqlSession sqlSession) {
		if(sqlSession!=null) {
			sqlSession.close();
		}
	}
	
}
