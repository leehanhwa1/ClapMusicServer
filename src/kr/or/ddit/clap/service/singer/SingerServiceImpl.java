/**
 * Singleton 패턴을 적용한 
 * ISingerService를 구현한 클래스
 * @author Hansoo
 * 
 *
 */
package kr.or.ddit.clap.service.singer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.Signer;
import java.util.List;
import java.util.Map;

import kr.or.ddit.clap.dao.singer.SingerDaoImpl;
import kr.or.ddit.clap.vo.singer.SingerVO;

public class SingerServiceImpl extends UnicastRemoteObject implements ISingerService  {
	
	SingerDaoImpl singerDao; //사용할 Dao의  멤버변수를 선언
	private static SingerServiceImpl service;//Singleton패턴 
	
	private SingerServiceImpl() throws RemoteException {
		super();
		singerDao =  SingerDaoImpl.getInstance();//Singleton패턴
	}
	
	public static SingerServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new SingerServiceImpl();
		}
		return service;
	}
	
	
	// 각 메서드에서는 생성된 Dao객체를 이용하여 작업에 맞는 Dao객체의 메서드를 호출한다.
	
	@Override
	public List<SingerVO> selectListAll() throws RemoteException {
		
		return singerDao.selectListAll();
	}

	@Override
	public List<SingerVO> searchList(SingerVO vo) throws RemoteException {
		
		return singerDao.searchList(vo);
	}

	@Override
	public SingerVO singerDetailInfo(String singerNo) throws RemoteException {
		
		return singerDao.singerDetailInfo(singerNo);
	}

	@Override
	public int selectSingerLikeCnt(String singerNo) throws RemoteException {
		return singerDao.selectSingerLikeCnt(singerNo);
	}

	@Override
	public int updateSingerInfo(SingerVO vo) throws RemoteException {
		return singerDao.updateSingerInfo(vo);
	}

	@Override
	public int insertSinger(SingerVO vo) throws RemoteException {
		return singerDao.insertSinger(vo);
	}

	@Override
	public int deleteSinger(String singerNo) throws RemoteException {
		return singerDao.deleteSinger(singerNo);
	}

	@Override
	public int checkHeartYN(Map<String, String> map) throws RemoteException {
		return singerDao.checkHeartYN(map);
	}

	@Override
	public int deleteSingerLike(Map<String, String> map) throws RemoteException {
		return singerDao.deleteSingerLike(map);
	}

	@Override
	public int insertSingerLike(Map<String, String> map) throws RemoteException {
		return singerDao.insertSingerLike(map);
	}

	@Override
	public List<Map<String,String>> selectReply(String singerNo) throws RemoteException {
		return singerDao.selectReply(singerNo);
	}

	@Override
	public int insertReply(Map<String, String> map) throws RemoteException {
		// TODO Auto-generated method stub
		return singerDao.insertReply(map);
	}

	@Override
	public int insertBlackCnt(String id) throws RemoteException {
		return singerDao.insertBlackCnt(id);
	}

	@Override
	public int deleteSigerReply(String id) throws RemoteException {
		return singerDao.deleteSigerReply(id);
	}

	

}
