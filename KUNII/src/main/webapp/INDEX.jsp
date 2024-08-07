<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--   文字エンコーディングをUTF-8に設定 -->
<meta charset="UTF-8">
<!--   最新のIEにて表示する -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>アンケートサイト</title>
<!-- CSSの適用 -->
<link rel="stylesheet" type="text/css"
	href="./CSS/enquate.css">
</head>

<!--本文  -->
<body>
	<form action="Port_Folio" method="post">
		<H1>
			アンケートのお願い <br />
		</H1>
		<p>
			<strong>
				お忙しいところ皆さまありがとうございます。このアンケートはこれから,
				IT業界を目指したいと思っているけど、<br>
				中々踏み出せない方々に少しでも有益な情報を提供できるサイトを提供したいと考え
				そちらのサイトへの集計結果を目的に行っております。<br />	
				何卒、ご協力の程よろしくお願いします。
			</strong>
		</p>
		<strong>
			<h2>
			<!-- ラジオボタンの項目の挿入 -->
				<span style="color: red;">No1. </span> あなたの性別を教えてください<br /> <input
					type="radio" name="gender" value="man">男性 <input
					type="radio" name="gender" value="woman">女性 <input
					type="radio" name="gender" value="noAnswer">回答しない<br>
			</h2>

			<h2>
				<span style="color: red;">No2. </span> あなたの年齢を教えてください<br /> <input
					type="radio" name="age" value="20over">20~30歳<br /> <input
					type="radio" name="age" value="30over">30~40歳<br /> <input
					type="radio" name="age" value="40over">40~50歳<br /> <input
					type="radio" name="age" value="50over">50~60歳<br /> <input
					type="radio" name="age" value="60over">60歳以降<br />
			</h2>

			<h2>
				<span style="color: red;">No3. </span> あなたの職種を教えてください<br /> <input
					type="radio" name="job" value="SE" />開発関係<br /> <input
					type="radio" name="job" value="infrastructure" />インフラ関係<br /> <input
					type="radio" name="job" value="etc" />その他<br />
			</h2>

			<h2>
			<!-- テキストエリアの挿入 -->
				<span style="color: red;">No4. </span> No3にて開発関係を選ばれた方にお伺いします。<br />
				他業種から未経験で開発関係の職種に転職を考えている方に向けて<br /> アドバイスはありますか？
				<textarea name="SE_Advice" class="c-form-textarea"
					placeholder="コメント欄"></textarea>
			</h2>

			<h2>
				<span style="color: red;">No5. </span> No3にてインフラ関係を選ばられた方にお伺いします。<br />
				他業種から未経験でインフラ関係の職種に転職を考えている方に向けて<br /> アドバイスはありますか？
				 <textarea name="infrastructure_Advice" class="c-form-textarea"
				placeholder="コメント欄"></textarea>
			</h2>
			
			<h2>
				<span style="color: red;">No6. </span>現在の仕事でのやりがいを教えて下さい<br />
				<textarea name="Rewarding" class="c-form-textarea"
					placeholder="コメント欄"></textarea><br />
			</h2>

				<!-- 送信及び取消ボタンの挿入 -->
				 	<input type="submit" value="送信"> 
					<input type="reset" value="取消"><br /><br /> 
			</h2>
			
			<div class="end">
					ご協力ありがとうございました。
					</div>
		</strong>
	</form>
</body>
</html>