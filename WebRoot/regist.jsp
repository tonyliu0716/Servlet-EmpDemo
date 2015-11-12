<%@ page language="java" import="java.util.*, java.text.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<%= sdf.format(new Date()) %>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="list.do">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						REGIST:
					</h1>
					<form action="check.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									User Name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
									<span style="color:red">${error_user }</span>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									Real Name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									PassWord:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									Gender:
								</td>
								<td valign="middle" align="left">
									M
									<input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
									F
									<input type="radio" class="inputgri" name="sex" value="f"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									Code:
									<img id="num" src="image.do" />
									<a href="regist.jsp">Change</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="code" />
									<span style="color:red">${error_code}
									</span>
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
