<%@ page language="java" import="java.util.*, java.text.*" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 %>
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<%= sdf.format(new Date()) %>
								<br />
								<a href="regist.do">Regist</a>
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						login
					</h1>
					<form action="login.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
									<span style="color:red">
									${error_pwd}
									</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									Code:
									<img id="num" src="image.do" />
									<a href="javascript:;" onclick="document.getElementById('num').src='image.do?' + (new Date()).getTime()">Change</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="code" />
									<span style="color:red">${error_code}</span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					rlnta@126.com
				</div>
			</div>
		</div>
	</body>
</html>

