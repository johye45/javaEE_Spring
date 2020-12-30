package com.koreait.mvclegacy.model.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.koreait.mvclegacy.exception.DMLException;
import com.koreait.mvclegacy.model.domain.Notice;

@Service
public class NoticeService {
	//���Խ�Ű�� �ϴ� �ڷ����� 2�� �̻��� ���, �����ڴ� ������ ������� ���ϴ� ��ü�� ����ؾ� �Ѵ�
	@Autowired//����
	//�ҹ��ڷ� �����ϴ� Ŭ������ �����ָ� �˾Ƽ� �������ش�,�� �κи� mybatisNoticeDAO�ιٲٸ� �ȴ�!
	@Qualifier("mybatisNoticeDAO")
	/*
	 * @Autowired�� Ÿ���� �̿��ؼ� �ڵ������� ���� �����Ѵ�. 
		�ش� Ÿ���� ���� �������� �ʰų�, 2���̻� ������ ��� ��ü�� ������ �� ���ܸ� �߻���Ų��
		�̷��� ���� �����ϱ� ���� ���� @Qualifier
		�������� ���� Ÿ���� ��� �߿� ������ Ư�� ���� �����Ѵ�
	 * */
	private NoticeDAO noticeDAO;//DI�� ���Թޱ� ���ؼ� ���� ��ü�� �����Ѵ�
	
	//CRUD method
	public List selectAll() {
		List list = noticeDAO.selectAll();
		return list;
	}
	
	public Notice select(int notice_id) {
		Notice notice =noticeDAO.select(notice_id);
		return notice;
	}
	
	public void insert(Notice notice) throws DMLException{
		noticeDAO.insert(notice);
	}
	
	public void update(Notice notice) throws DMLException{
		noticeDAO.update(notice);
	}
	
	public void delete(int notice_id) throws DMLException{
		noticeDAO.delete(notice_id);
	}
	
	
}
