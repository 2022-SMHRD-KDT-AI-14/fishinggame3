package maingame;

import method.UserDAO;
import method.UserDTO;

public class EX_view {

	public static void main(String[] args) {
		
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO("aaa","111");
		
//		dao.select();
		
//		dao.selectMoney("abc1443");
//		dao.insert( "bbb", "bbb");
		dao.select();
	}
}
