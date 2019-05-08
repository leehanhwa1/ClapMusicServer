/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여
 * service에 전달하는 DAO의 interface
 * @author Hanhwa
 *
 */
package kr.or.ddit.clap.dao.qna;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.clap.main.DBUtil;
import kr.or.ddit.clap.vo.support.QnaReviewVO;
import kr.or.ddit.clap.vo.support.QnaVO;

public class QnaDaoImpl implements IQnaDao{
	
	private SqlMapClient smc;
	private static QnaDaoImpl dao; // Singleton 패턴
	
	private QnaDaoImpl() {
		smc = DBUtil.getConnection();
	}
	
	public static QnaDaoImpl getInstance() { // Singleton 패턴
		if (dao == null) {
			dao = new QnaDaoImpl();
		}
		return dao;
	}
	
	public List<QnaVO> selectListAll() {
		List<QnaVO> list = new ArrayList<QnaVO>();
		try {

			list = smc.queryForList("qna.selectListAll");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public QnaVO qnaDetailContent(String ContentNo) throws RemoteException {
		QnaVO qVO = new QnaVO();
		try {

			qVO = (QnaVO)smc.queryForObject("qna.qnaDetailContent", ContentNo);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return qVO;
	}

	@Override
	public int insertQna(QnaVO vo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("qna.insertQna", vo);
		} catch(SQLException e) {
			System.out.println("insert실패");
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteQnaContent(String qna_no) {
		
		int cnt = 0;
		try {
			cnt = smc.delete("qna.deleteQnaContent", qna_no);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	// 수정 쿼리
	@Override
	public int updateQna(QnaVO vo) {
		
		int cnt = 0;
		try {
			cnt = smc.update("qna.updateQna", vo);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return cnt;
	}

	@Override
	public int updateCount(String qna_no) {
		
		int cnt = 0;
		try {
			cnt = smc.update("qna.updateCount", qna_no);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int insertQnaReview(QnaReviewVO vo) {
		int cnt =0;
		try {
			Object obj = smc.insert("qna.insertQnaReview", vo);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<QnaReviewVO> selectListReviewAll(String qna_no) {
		List<QnaReviewVO> list = new ArrayList<QnaReviewVO>();
		//int cnt = 0;
		try {
			list = smc.queryForList("qna.selectListReviewAll", qna_no);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<QnaVO> selectQna(String id) {
		List<QnaVO> list = new ArrayList<QnaVO>();
		try {

			list = smc.queryForList("qna.selectQna",id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
		
		
	}
	
