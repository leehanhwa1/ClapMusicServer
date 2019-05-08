package kr.or.ddit.clap.dao.message;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.clap.main.DBUtil;
import kr.or.ddit.clap.vo.member.LikeVO;
import kr.or.ddit.clap.vo.support.MessageVO;

public class MessageDaoImpl implements IMessageDao{
	
	private SqlMapClient smc;
	private static MessageDaoImpl dao; // Singleton 패턴
	
	private MessageDaoImpl() {
		smc = DBUtil.getConnection();
	}
	
	public static MessageDaoImpl getInstance() { // Singleton 패턴
		if (dao == null) {
			dao = new MessageDaoImpl();
		}
		return dao;
	}

	@Override
	public List<MessageVO> selectMessage(MessageVO vo) {
		List<MessageVO> list = new ArrayList<MessageVO>();
		try {
			
			list = smc.queryForList("message.selectMessage",vo);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return list;
	}

	@Override
	public String selectMessFCnt(MessageVO vo) {
		String	list="";
		try {
			
			list = (String) smc.queryForObject("message.selectMessFCnt",vo);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}

	@Override
	public int updateMessage(MessageVO vo) {
		int cnt = 0;
		try {
			cnt = smc.delete("message.updateMessage",vo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertMessage(MessageVO vo) {
		int cnt = 0;
		try {
		Object obj = smc.insert("message.insertMessage", vo);
		if(obj == null) { //쿼리수행이 성공적으로 끝남
			cnt = 1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int deleteMessage(String no) {
		int cnt = 0;
		try {
			cnt = smc.delete("message.deleteMessage",no);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}