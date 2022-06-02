package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CallOfFishDAO {

	Connection conn; // DB ������ ���� ��ü
	PreparedStatement psmt; // SQL���� �����ϴ� ��ü
	ResultSet rs; // Query�� ������� �޾ƿ��� ��ü

	public void FishName(CallOfFishDTO dto) {
		process12();
		// 3. SQL�� ����
		String sql = "select fishname from fish where grade = ?"; // ?����� ����� �̸� ���
		try {
			psmt = conn.prepareStatement(sql);
			// ?�� �ݵ�� execute���� ������ �Ǿ� �־�� �Ѵ�
			psmt.setInt(1, dto.getGrade());
			rs = psmt.executeQuery();
			while (rs.next()) {
				String fishname = rs.getString("fishname");
				System.out.println(dto.getGrade() + "�� �ش��ϴ� �̸��� " + fishname + "�Դϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. ���� ����
			connend();
		}
	}

	public ArrayList<Integer> FishNo(CallOfFishDTO dto) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		process12();
		// 3. SQL�� ����
		String sql = "select fno from fish where grade = ?"; // ?����� ����� �̸� ���
		try {
			psmt = conn.prepareStatement(sql);
			// ?�� �ݵ�� execute���� ������ �Ǿ� �־�� �Ѵ�
			psmt.setInt(1, dto.getGrade());
			rs = psmt.executeQuery();
			while (rs.next()) {
				int fno = rs.getInt("fno");
				result.add(fno);
//					String fishname = rs.getString("fishname");
//					System.out.println(dto.getGrade() + "�� �ش��ϴ� �̸��� " + fishname + "�Դϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. ���� ����
			connend();
		}
		return result;
	}

	public ArrayList<String> FishAll() {
		ArrayList<String> result = new ArrayList<String>();
		process12();
		// 3. SQL�� ����!
		String sql = "select fno, fishname from fish"; // ?����� ����� �̸� ���
		try {
			psmt = conn.prepareStatement(sql);
			// ?�� �ݵ�� execute���� ������ �Ǿ� �־�� �Ѵ�

			rs = psmt.executeQuery();
			while (rs.next()) {
				String fishname = rs.getString("fishname");
				result.add(fishname);
//					String fishname = rs.getString("fishname");
//					System.out.println(dto.getGrade() + "�� �ش��ϴ� �̸��� " + fishname + "�Դϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. ���� ����
			connend();
		}
		return result;
	}

	public ArrayList<Integer> fscore(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		process12();
		// 3. SQL�� ����
		String sql = "select fscore from fish order by fno asc"; // ?����� ����� �̸� ���
		try {
			psmt = conn.prepareStatement(sql);
			// ?�� �ݵ�� execute���� ������ �Ǿ� �־�� �Ѵ�
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				int fscore = rs.getInt("fscore");
				result.add(fscore);
//					String fishname = rs.getString("fishname");
//					System.out.println(dto.getGrade() + "�� �ش��ϴ� �̸��� " + fishname + "�Դϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. ���� ����
			connend();
		}
		return result;
	}

	public ArrayList<Integer> price(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		process12();
		// 3. SQL�� ����
		String sql = "select price from fish order by fno asc"; // ?����� ����� �̸� ���
		try {
			psmt = conn.prepareStatement(sql);
			// ?�� �ݵ�� execute���� ������ �Ǿ� �־�� �Ѵ�
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				int price = rs.getInt("price");
				result.add(price);
//					String fishname = rs.getString("fishname");
//					System.out.println(dto.getGrade() + "�� �ش��ϴ� �̸��� " + fishname + "�Դϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. ���� ����
			connend();
		}
		return result;
	}
	
	private void connend() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void process12() {
		// 1. ���� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. DB ����
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_4";
		String db_pw = "smhrd4";
		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
