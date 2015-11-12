package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

//������������������������������
//���������������������������������������������
public class EmployeeDao {
	//������������������
	public void save(Employee emp) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into nerdluv.singles (name, gender, age) "
					+ "values(?, ?, ?)");
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getGender());
			ps.setInt(3, emp.getAge());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	//������������������������
	public List<Employee> findAll() throws Exception{
		List<Employee> emps = new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from nerdluv.singles");
			rs = ps.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId( rs.getInt("id") );
				emp.setName(rs.getString("name"));
				emp.setPass(rs.getString("pass"));
				emp.setGender(rs.getString("gender"));
				emp.setAge(rs.getInt("age"));
				emp.setType1(rs.getString("type1"));
				emp.setType2(rs.getString("type2"));
				emp.setType3(rs.getString("type3"));
				emp.setType4(rs.getString("type4"));
				emp.setOs(rs.getString("os"));
				emp.setMin(rs.getInt("min"));
				emp.setMax(rs.getInt("max"));
				emps.add(emp);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
		return emps;
	}
	
	//���������������������
	public void modify(Employee emp) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("update nerdluv.singles set name=?,pass=?,gender=?,age=?,"
					+ "type1=?,type2=?,type3=?,type4=?,os=?,min=?,max=? where id=?");
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getPass());
			ps.setString(3, emp.getGender());
			ps.setInt(4, emp.getAge());
			ps.setString(5, emp.getType1());
			ps.setString(6, emp.getType2());
			ps.setString(7, emp.getType3());
			ps.setString(8, emp.getType4());
			ps.setString(9, emp.getOs());
			ps.setInt(10, emp.getMin());
			ps.setInt(11, emp.getMax());
			ps.setInt(12, emp.getId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
	//������������������
	public void delete(Employee emp) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("delete from nerdluv.singles where id=?");
			ps.setInt(1, emp.getId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
	//������id���������������������
	public Employee findOne(int id) throws Exception {
		Employee emp = new Employee();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from nerdluv.singles where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				emp.setId(id);
				emp.setName(rs.getString("name"));
				emp.setPass(rs.getString("pass"));
				emp.setGender(rs.getString("gender"));
				emp.setAge(rs.getInt("age"));
				emp.setType1(rs.getString("type1"));
				emp.setType2(rs.getString("type2"));
				emp.setType3(rs.getString("type3"));
				emp.setType4(rs.getString("type4"));
				emp.setOs(rs.getString("os"));
				emp.setMin(rs.getInt("min"));
				emp.setMax(rs.getInt("max"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
		return emp;
	}
}
