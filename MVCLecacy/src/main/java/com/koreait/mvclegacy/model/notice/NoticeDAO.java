package com.koreait.mvclegacy.model.notice;

import java.util.List;

import com.koreait.mvclegacy.exception.DMLException;
import com.koreait.mvclegacy.model.domain.Notice;

//Enterprise ���߿����� �Ը� ũ�� ������  �� ��������(MVC) ��ü���� ����ȭ�Ǿ� �մ�.
//�� �������� �ִ�. �̶� �и��� ��ü���� ����� �����Ѱ� (O), Ÿ��Ʈ(����)�Ѱ�(X)
//������ ���� ����!! �� ��ü�� ���յ��� ���ߴ� ���� ����!! �� ����� ������ ����� �ٷ� DI
//�� �������� ���� ��ü�� �������� ����, �ܺο��� ���Թ޵�, ���Թ޴� ��ü�� �ش� �ڷ����� �����ڷ�������
//���ڴ� ���̴�!!
public interface NoticeDAO {
	public List selectAll() ;
	public Notice select(int notice_id); 
	public void insert(Notice notice) ;
	public void update(Notice notice) ;
	public void delete(int notice_id) ;
}