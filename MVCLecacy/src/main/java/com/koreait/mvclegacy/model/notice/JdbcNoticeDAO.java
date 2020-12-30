package com.koreait.mvclegacy.model.notice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.koreait.mvclegacy.exception.DMLException;
import com.koreait.mvclegacy.model.domain.Notice;

/*�������� �����ϴ� DB���� ������� ���������� �ִ�
 * [Mybatis]
 * SQL Mapper : �������� �ڹٰ�ü�� ����
 * 
 * [JDBC ��ü]
 * 
 * [Hibernate]
 * ORM(Object Realation Mapping) : �ڹ� ��ü�� ���ष db���� ����
 * 
 * [JPA]...
 * 
 * */
@Repository
public class JdbcNoticeDAO implements NoticeDAO{
	private static final Logger logger = LoggerFactory.getLogger(JdbcNoticeDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;//���� ���� ����


	//��� ��������
	public List selectAll() {
		List list = null;
		String sql="select * from notice order by notice_id desc";
								// �Ű� ����:������, ���ε庯���� �迭 ó��, ���ΰ�ü(ResultSet�� �����͸� ��� ��ü)
		list = jdbcTemplate.query(sql,new Object[] {},new RowMapper<Notice>(){
			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
				logger.debug("mapRow�޼��� ȣ��, rowNum:"+rowNum);
				
				Notice notice = new Notice();//empty ����
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				
				
				return notice;
			}
			
		});
		return list;
	}


	@Override
	public Notice select(int notice_id) {
		Notice notice=null;
		String sql = "select * from notice where notice_id =?";
		notice= jdbcTemplate.queryForObject(sql,new RowMapper<Notice>(){
			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
				Notice notice = new Notice();//empty ����
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				
				return notice;
			}
			
		},notice_id);	
		return notice;
	}


	//DML �� ���� update�޼��带 �̿��Ѵ�, insert, delete���� �޼���� ����,
	//JdbcTemplate����!
	@Override
	public void insert(Notice notice) throws DMLException{
		String sql= "insert into notice(notice_id, title, writer, content)";
		sql+= " values(seq_notice.nextval,?,?,?)";
		int result = jdbcTemplate.update(sql,notice.getTitle(),notice.getWriter(),notice.getContent());//�������̹Ƿ� �Ű������� ��� �þ
		//result=0;
		if(result==0) {
			//���⼭ try~catch�� XX ,ȣ���ڿ��� ����
			throw new DMLException("��Ͽ� �����Ͽ����ϴ�");
		}
	}


	@Override
	public void update(Notice notice) throws DMLException{
		String sql ="update notice set title=?,writer=?,content=? where notice_id=?";
		int result = jdbcTemplate.update(sql, notice.getTitle(),notice.getWriter(),notice.getContent(), notice.getNotice_id());
		result=0;
		if(result==0) {
			throw new DMLException("���� ����");
		}
	}


	@Override
	public void delete(int notice_id) throws DMLException{
		String sql ="delete from notice where notice_id = ?";
		int result=jdbcTemplate.update(sql,notice_id);
		result=0;
		if(result==0) {
			throw new DMLException("������ ����");
		}
		
	}

}
