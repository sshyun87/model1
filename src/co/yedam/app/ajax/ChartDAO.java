package co.yedam.app.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.yedam.appboard.DAO;

public class ChartDAO extends DAO {
	
	public List<Map<String, Object>> getDetpCnt(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			String sql = "select department_name, count(employee_id) cnt" + 
						 " from employees e, departments d" +
						 " where e.department_id = d.department_id"+
						 " group by d.DEPARTMENT_ID, d.DEPARTMENT_NAME";
			psmt =conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("department_name", rs.getString(1));  //컬럼 인덱스
				map.put("cnt", rs.getInt("cnt"));		  //컬럼명
				list.add(map);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
		return list;
	}

}
