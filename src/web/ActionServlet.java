package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import dao.UserDao;
import entity.Employee;
import entity.User;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取URI
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		
		//根据URI进行分发：
		if(uri.equals("/list")){
			HttpSession session = request.getSession();
			String uname = (String)session.getAttribute("user");
			if(uname == null){
				response.sendRedirect("login.jsp");
				return;
			}
			try{
				EmployeeDao dao = new EmployeeDao();
				List<Employee> emps = dao.findAll();
				//进行转发
				request.setAttribute("all", emps);
				request.getRequestDispatcher("listEmp.jsp").forward(request, response);
			
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(uri.equals("/add")){
			try{
				String name = request.getParameter("name");
				String gender = request.getParameter("gender");
				int age = Integer.parseInt(request.getParameter("age"));
				EmployeeDao dao = new EmployeeDao();
				Employee emp = new Employee();
				emp.setName(name);
				emp.setGender(gender);
				emp.setAge(age);
				dao.save(emp);
				//重定向到list.do
				response.sendRedirect("list.do");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(uri.equals("/delete")){
			try{
				int id = Integer.parseInt(request.getParameter("id"));
				EmployeeDao dao = new EmployeeDao();
				Employee emp = dao.findOne(id);
				dao.delete(emp);
				//重定向到list.do
				response.sendRedirect("list.do");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(uri.equals("/update")){
			try{
				int id = Integer.parseInt(request.getParameter("id"));
				EmployeeDao dao = new EmployeeDao();
				Employee e = dao.findOne(id);
				//转发到JSP进行显示：
				request.setAttribute("emp", e);
				request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(uri.equals("/modify")){
			try{
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String gender = request.getParameter("gender");
				int age = Integer.parseInt(request.getParameter("age"));
				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setGender(gender);
				e.setAge(age);
				EmployeeDao dao = new EmployeeDao();
				dao.modify(e);
				//重定向到list.do
				response.sendRedirect("list.do");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(uri.equals("/regist")){
			try{
				response.sendRedirect("regist.jsp");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(uri.equals("/check")){
			
			String username = request.getParameter("username");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String gender = request.getParameter("sex");
			String code = request.getParameter("code");
			//获取session中存的code
			HttpSession session = request.getSession();
			String number = (String)session.getAttribute("code");
			if( !code.equals(number)){
				System.out.println("111");
				request.setAttribute("error_code", "Wrong Code!");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
				return;
			}
			try{		
				UserDao dao = new UserDao();
				User user = dao.findByUserName(username);
				if(user.getUsername() != null){
					//转发：不为空，说明已经注册了
					request.setAttribute("error_user", "User Name is already used! Try another one.");
					request.getRequestDispatcher("regist.jsp").forward(request, response);
				}else{
					//为空：说明是第一次注册，插入数据库后重定向到登陆页面
					user = new User();					
					user.setUsername(username);
					user.setName(name);
					user.setPwd(pwd);
					user.setGender(gender);
					
					dao.save(user);
					response.sendRedirect("login.jsp");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(uri.equals("/login")){
			String username = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String code = request.getParameter("code");
			
			HttpSession session = request.getSession();
			String ucode = (String)session.getAttribute("code");
			if(!code.equals(ucode)){
				//转发错误信息到login.jsp
				request.setAttribute("error_code", "Wrong Code!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			UserDao dao = new UserDao();
			try{
				User user = dao.findByUserName(username);
				if(user.getUsername() != null){
					if(user.getPwd().equals( pwd )){
						//重定向到list.do
						session = request.getSession();
						session.setAttribute("user", user.getName());
						response.sendRedirect("list.do");
					}else{
						//绑定数据后转发回去
						request.setAttribute("error_pwd", "UserName or PassWord is not correct!");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}else{
					//说明该用户没有注册
					response.sendRedirect("regist.jsp");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(uri.equals("/image")){
			//1.准备一张空白的有尺寸的图片：
			BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
			//2.获取图片的画笔对象
			Graphics g = image.getGraphics();
			//3.设置画笔颜色
			Random ran = new Random();
			g.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
			//4.绘制一个矩形的背景,从（0，0）开始画出一个背景 100为宽，30为高
			g.fillRect(0, 0, 100, 30);
			//5.调用自定义方法，获取长度为5的字母数字组合的字符串
			String number = getNumber(5);
			HttpSession session = request.getSession();
			session.setAttribute("code", number);
			//6.更换画笔颜色
			g.setColor(new Color(0, 0, 0));
			//7.设置字体
			g.setFont(new Font(null, Font.BOLD, 24));
			//8.画出字符串及干扰线
			g.drawString(number, 5, 25);
			for(int i = 0; i < 8; i++){
				g.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
				g.drawLine(ran.nextInt(100), ran.nextInt(30), ran.nextInt(100), ran.nextInt(30));
			}
			//9.设置相应流的数据格式
			response.setContentType("image/jpeg");
			//10.获取输出流
			OutputStream ops = response.getOutputStream();
			//11.存储图片到流中
			ImageIO.write(image, "jpeg", ops);
			ops.close();
		}
	}
	//获取字符串的方法：
	public String getNumber(int length){
		String[] array = {"1","2","3","4","5","6","7","8","9","0","A","B","C","D","E","F","G"
				,"H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String str = "";
		Random ran = new Random();
		for(int i = 0; i < length; i++){
			str += array[ ran.nextInt(array.length) ];
		}
		return str;
	}
}
