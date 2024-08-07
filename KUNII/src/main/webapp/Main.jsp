<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>これからIT業界を目指される方々へ</title>
<link rel="stylesheet" href="./CSS/port_Folio.css">
</head>

<body>

<!-- ヘッダー作成 -->
<div class="header1">
    <nav class="navbar">
        <h2 class="logo">Welcom</h2> <!-- ロゴを作成 -->
        
        <!-- ヘッダーに各ページへのリンク機能付きメニューバー作成 -->
        <ul class="menu">
            <li><a href="<%=request.getContextPath()%>/Main.jsp">ホーム</a></li>
            <li><a href="<%=request.getContextPath()%>/MainServlet">先輩たちの声</a></li>
            <li><a href="<%=request.getContextPath()%>/Form.jsp">お問い合わせ</a></li>
        </ul>
    </nav>
</div>

<!-- JavaScriptによるアクション機能をヘッダーへ付与 -->
<script>
    const navbar = document.querySelector(".navbar");
    const menu = document.querySelector(".menu");
    window.addEventListener("scroll", () => {
        if (window.pageYOffset >= menu.offsetTop) {
            navbar.classList.add("sticky");
        } else {
            navbar.classList.remove("sticky");
        }
    });
</script>

<!-- 本文 -->
<div class="honbun">
    <h1>これからIT業界を目指される方々へ</h1>
    <h2>このサイトはこれからIT業界を目指される方々が抱えている不安を少しでも取り除きチャレンジする
        きっかけになればと思い作成いたしました。</h2>
    <h2>実際に働かれている方々のアドバイスを頂きましたのでよろしければ参考にしてください。</h2>
</div>

<!-- フッター作成 -->
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