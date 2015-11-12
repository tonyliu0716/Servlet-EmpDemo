package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao {
	//根据用户名找用户对象：
	public User findByUserName(String username) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = new User();
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from nerdluv.t_user where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String userna = rs.getString("username");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				user.setId(id);
				user.setUsername(userna);
				user.setPwd(pwd);
				user.setName(name);
				user.setGender(gender);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}
	
	//保存实体信息到数据库：
	public void save(User user) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into nerdluv.t_user(username, pwd, name, gender) values(?,?,?,?);");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getName());
			ps.setString(4, user.getGender());
			ps.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
