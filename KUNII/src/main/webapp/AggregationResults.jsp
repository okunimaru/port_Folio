<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>アンケート集計結果</title>
<link rel="stylesheet" href="./CSS/port_Folio.css">
</head>

<body>
	
		<div class="header2">
			<nav class="navbar">
				<h2 class="logo">Voices</h2>
				<ul class="menu">
				<li><a href="<%= request.getContextPath() %>/Main.jsp">ホーム</a></li>
				<li><a href="<%= request.getContextPath() %>/MainServlet">先輩たちの声</a></li>
				<li><a href="<%= request.getContextPath() %>/Form.jsp">お問い合わせ</a></li>
				</ul>
			</nav>
		</div>
		<script>
			const navbar = document.querySelector(".navbar");
			 const menu = document.querySelector(".menu");
		      window.addEventListener("scroll", () => {
		        if (window.pageYOffset >= menu.offsetTop) {
		          //stickyクラスをnavbarに付与する。
		          navbar.classList.add("sticky");
		        } else {
		          navbar.classList.remove("sticky");
		        }
		      });
		</script>	
		
		<div class="text-area">
				<h1 class="title">IT業界って実際どうなの！？先輩方の声！！</h1>
				<!-- 値を表示するテーブルの作成 -->
				<table border="1">
					<tr>
						<th>ID</th>
						<th>性別</th>
						<th>年齢</th>
						<th>職種</th>
						<th>SE職アドバイス</th>
						<th>インフラ職アドバイス</th>
						<th>やりがい</th>
						
					</tr>
					<!-- リスト化された値を取得する -->
					<%
					List<Map<String, Object>> resultList = (List<Map<String, Object>>)request.getAttribute("resultList");
					if (resultList != null) {
						for (Map<String, Object> row : resultList) {
					%>
					<tr>
						<td><%=row.get("id")%></td>
						<td><%=row.get("gender")%></td>
						<td><%=row.get("age")%></td>
						<td><%=row.get("job")%></td>
						<td><%=row.get("SE_Advice")%></td>
						<td><%=row.get("infrastructure_Advice")%></td>
						<td><%=row.get("Rewarding")%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="4">データがありません</td>
					</tr>
					<%
					}
					%>
				</table>
		</div>
		
	
	
  	<footer class="footer">
		<div class="container">
			<ul class="nav">
				<li><a href="<%= request.getContextPath() %>/Main.jsp">ホーム</a></li>
				<li><a href="<%= request.getContextPath() %>/MainServlet">先輩たちの声</a></li>
				<li><a href="<%= request.getContextPath() %>/Form.jsp">お問い合わせ</a></li>
			</ul>
		</div>
	<p class="copy">Port Folio @Oku-ni</p>
	</footer> 
</body>

</html>