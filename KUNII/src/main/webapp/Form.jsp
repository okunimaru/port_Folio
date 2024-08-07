<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせフォーム</title>
<link rel="stylesheet" href="./CSS/port_Folio.css">
</head>
<body>
	<div class="header3">
		<nav class="navbar">
			<h2 class="logo">Form</h2>
			<ul class="menu">
				<li><a href="<%=request.getContextPath()%>/Main.jsp">ホーム</a></li>
				<li><a href="<%=request.getContextPath()%>/MainServlet">先輩たちの声</a></li>
				<li><a href="<%=request.getContextPath()%>/Form.jsp">お問い合わせ</a></li>
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
	<div class="height-100">
		<form action="#">
			<div>
				<label for="name">お名前</label> <input type="text" placeholder="名前を入力" id="name"
					name="your-name">
			</div>
			<div>
				<label for="email">メールアドレス</label> <input type="email" placeholder="メールアドレスを入力"id="email"
					name="your-youremail">
					
			<div>
				<label for="message">メッセージ</label>
				<textarea placeholder="メッセージを入力"id="message" name="your-message"></textarea>
				
				
			</div>

			<input type="submit" class="button" value="送信">
		</form>
	</div>
	<footer class="footer">
		<div class="container">
			<ul class="nav">
				<li><a href="<%=request.getContextPath()%>/Main.jsp">ホーム</a></li>
				<li><a href="<%=request.getContextPath()%>/MainServlet">先輩たちの声</a></li>
				<li><a href="<%=request.getContextPath()%>/Form.jsp">お問い合わせ</a></li>
			</ul>
		</div>
		<p class="copy">Port Folio @Oku-ni</p>
	</footer>
</body>
</html>