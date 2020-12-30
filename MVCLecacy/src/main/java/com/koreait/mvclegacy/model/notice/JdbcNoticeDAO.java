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

/*스프링이 지원하는 DB연동 기술에는 여러가지가 있다
 * [Mybatis]
 * SQL Mapper : 쿼리문과 자바객체간 매핑
 * 
 * [JDBC 자체]
 * 
 * [Hibernate]
 * ORM(Object Realation Mapping) : 자바 객체와 관곟ㅇ db와의 매핑
 * 
 * [JPA]...
 * 
 * */
@Repository
public class JdbcNoticeDAO implements NoticeDAO{
	private static final Logger logger = LoggerFactory.getLogger(JdbcNoticeDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;//쿼리 수행 객레


	//목록 가져오기
	public List selectAll() {
		List list = null;
		String sql="select * from notice order by notice_id desc";
								// 매개 순서:쿼리문, 바인드변수로 배열 처리, 매핑객체(ResultSet의 데이터를 담는 객체)
		list = jdbcTemplate.query(sql,new Object[] {},new RowMapper<Notice>(){
			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
				logger.debug("mapRow메서드 호출, rowNum:"+rowNum);
				
				Notice notice = new Notice();//empty 생성
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
				Notice notice = new Notice();//empty 생성
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


	//DML 은 전부 update메서드를 이용한다, insert, delete같은 메서드는 없다,
	//JdbcTemplate에서!
	@Override
	public void insert(Notice notice) throws DMLException{
		String sql= "insert into notice(notice_id, title, writer, content)";
		sql+= " values(seq_notice.nextval,?,?,?)";
		int result = jdbcTemplate.update(sql,notice.getTitle(),notice.getWriter(),notice.getContent());//가변형이므로 매개변수는 계속 늘어남
		//result=0;
		if(result==0) {
			//여기서 try~catch문 XX ,호출자에게 전달
			throw new DMLException("등록에 실패하였습니다");
		}
	}


	@Override
	public void update(Notice notice) throws DMLException{
		String sql ="update notice set title=?,writer=?,content=? where notice_id=?";
		int result = jdbcTemplate.update(sql, notice.getTitle(),notice.getWriter(),notice.getContent(), notice.getNotice_id());
		result=0;
		if(result==0) {
			throw new DMLException("수정 실패");
		}
	}


	@Override
	public void delete(int notice_id) throws DMLException{
		String sql ="delete from notice where notice_id = ?";
		int result=jdbcTemplate.update(sql,notice_id);
		result=0;
		if(result==0) {
			throw new DMLException("삭제에 실패");
		}
		
	}

}
