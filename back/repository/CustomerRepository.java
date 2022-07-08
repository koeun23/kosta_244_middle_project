
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.projectdto.Customer;



public interface CustomerRepository {
	/*
	 * 회원정보리스트에 회원 추가
	 * @throws AddException 상품번호가 중복될 시에*/
	public void insert(Customer product) throws AddException;
	/*
	 * 회원리스트의 모든 요소 선택
	 * @throws FindException 상품목록이 아무것도 없을때*/
	public List<Customer> selectAll() throws FindException;
	/*
	 * 회원번호로 유저 찾기
	 */
	public Customer selectByUserNo(String userNo) throws FindException;
}