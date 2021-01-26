package com.koreait.fashionshop.model.bank.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.WithdrawFailException;
import com.koreait.fashionshop.model.common.Bell;

@Repository
public class JdbcKbankDAO implements KbankDAO{
	
	//DI�� ������ �פ��� ��ü�� ���� �������� ����, �ܺηκ��� ���Թ���
	//��ü�� ���յ��� ��ȭ��Ű�� ����
	//�׷��ٸ� ���յ� ���� ���ֹ����� ����� �ִ°�?O  AOP
	

	@Autowired
	private JdbcTemplate jdbcTemplate;//root-context.xml�� spring jdbc��� ����߱� ������ ��밡��, jdbcTemplate�� id�� ���ƾ� ��

	//���
	public void withdraw(int money) throws WithdrawFailException{
		int result= jdbcTemplate.update("update kbank set total=total-?", money);
		if(result==0) {
			throw new WithdrawFailException("Sorry Withdraw fail");
		}
	}

}
