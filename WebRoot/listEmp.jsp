<%@ page import="java.util.*, entity.*, java.text.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	String username = (String)session.getAttribute("user");
	if(username == null){
		response.sendRedirect("login.do");
		return;
	}
	SimpleDateFormat sdf = new SimpleDateFormat();
 %>
<html>
	<head>
		<title>emplist</title>
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
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Gender
							</td>
							<td>
								Age
							</td>
							<td>
								Operation
							</td>
						</tr>
						 <c:forEach var="e" items="${all}" varStatus="status">
						<tr class="row${status.index % 2 + 1 }">
							<td>
								${e.id}
							</td>
							<td>
								${e.name }
							</td>
							<td>
								${e.gender }
							</td>
							<td>
								${e.age }
							</td>
							<td>
								<a href="delete.do?id=${e.id }" onclick="return confirm('Are you sure delete ${e.name}?')">delete emp</a>&nbsp;&nbsp;
								<a href="update.do?id=${e.id }" onclick="return confirm('Are you sure modify ${e.name}')">update emp</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>

