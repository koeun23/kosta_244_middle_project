import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.projectdto.Notice;



public interface NoticeRepository {
	/**
	 * 공지사항을 추가한다
	 * @param notice 공지사항
	 * @throws AddException 
	 */
	public void insert(Notice notice) throws AddException;
	
	/**
	 * 공지사항 글번호로 공지사항 정보들을 반환한다
	 * @param boardNo 공지사항 글번호
	 * @return 공지사항
	 * @throws FindException
	 */
	public List<Notice> selectByBoardNo(int boardNo) throws FindException;
	
}
