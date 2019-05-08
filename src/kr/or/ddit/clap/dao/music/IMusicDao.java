/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여
 * service에 전달하는 DAO의 interface
 * @author Hansoo
 *
 */

package kr.or.ddit.clap.dao.music;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.clap.vo.genre.GenreDetailVO;
import kr.or.ddit.clap.vo.genre.GenreVO;
import kr.or.ddit.clap.vo.music.MusicVO;

public interface IMusicDao {

	public List<MusicVO> selectListAll();

	public List<MusicVO> searchList(MusicVO vo);

	public List<GenreVO> showGenre();

	public String selectGenreNO(String genreName);

	public String selectGenreDetailNO(String genreName);

	public List<GenreDetailVO> showGenreDetail(String genreNo);

	public MusicVO selectMusicDetailInfo(String musicNo);

	public int insertMusic(MusicVO vo);

	public int selectMusicLikeCnt(String musicNo);

	public int updateMusicInfo(MusicVO vo);

	public int deleteMusic(String musicNo);

	public List<Map> newMusicSelete(String genre_no);

	public List<Map> selectSinger(String sing_no);

	public List<Map> selectAlbum(String alb_no);

	public List<String> albumMusNoSelect(String alb_no);

	public List<Map> genreMusicSelete(String gen_detail_no);
	
	public List<Map> gameSelect();

	// 가수 좋아요 여부 채크
	public int checkHeartYN(Map<String, String> map);

	// 가수 라이크 취소
	public int deleteMusicLike(Map<String, String> map);

	// 가수 라이크 등록
	public int insertMusicLike(Map<String, String> map);

	// 가수 댓글 조회
	public List<Map<String, String>> selectMusReply(String singerNo);

	// 가수 댓글 등록
	public int insertMusReply(Map<String, String> map);

	// 가수 댓글 삭제
	public int deleteMusReply(String id);
}
