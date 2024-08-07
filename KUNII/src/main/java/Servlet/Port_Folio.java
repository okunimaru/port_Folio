package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Port_Folio
 */
@WebServlet("/Port_Folio")
public class Port_Folio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		//HTMLの記述を行う
		out.println("<html>");
		out.println("<head>");
		out.println("<title>確認画面</title>");
		// CSSファイルのリンクを出力*/
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"/port_Folio.css\">"); 
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>入力情報を確認して登録のボタンを押してください</h2>");
		out.println("<form action=\"Port_Folio\" method=\"get\">");
		//取得した値をinputedGenderに格納する
		String inputedGender = req.getParameter("gender");
		//nullの場合の対処
		if (inputedGender == null) {
			inputedGender = "回答なし";
		} else if (inputedGender.equals("man")) {
			inputedGender = "男性";
		} else if (inputedGender.equals("woman")) {
			inputedGender = "女性";
		} else {
			inputedGender = "回答しない";
		}

		out.println("性別：<strong>" + inputedGender + "</strong><br/>");
		//取得した値をinputedAgeに格納する
		String inputedAge = req.getParameter("age");
		//nullの対処
		if (inputedAge == null) {
			inputedAge = "年齢不明";
		} else if (inputedAge.equals("20over")) {
			inputedAge = "20~30歳";
		} else if (inputedAge.equals("30over")) {
			inputedAge = "30~40歳";
		} else if (inputedAge.equals("40over")) {
			inputedAge = "40~50歳";
		} else if (inputedAge.equals("50over")) {
			inputedAge = "50~60歳";
		} else {
			inputedAge = "60~歳";
		}
		out.println("年齢：<strong>" + inputedAge + "</strong><br/>");
		//取得した値をinputedjobに格納する
		String inputedJob = req.getParameter("job");
		//nullの対処
		if (inputedJob == null) {
			inputedJob = "その他";
		} else if (inputedJob.equals("SE")) {
			inputedJob = "開発関係";
		} else if (inputedJob.equals("infrastructure")) {
			inputedJob = "インフラ関係";
		} else {
			inputedJob = "その他";
		}
		//取得した値をinputedSE_Adviceに格納する
		String inputedSE_Advice = req.getParameter("SE_Advice");
		//nullの対処
		if (inputedSE_Advice == null) {
			inputedSE_Advice = "解答なし";
		} 
		//取得した値をinputedinfrastructure_Adviceに格納する
		String inputedinfrastructure_Advice = req.getParameter("infrastructure_Advice");
		//nullの対処
		if (inputedinfrastructure_Advice == null) {
			inputedinfrastructure_Advice = "解答なし";
		} 
		//取得した値をinputedRewardingに格納する
		String inputedRewarding = req.getParameter("Rewarding");
		//nullの対処
		if (inputedRewarding == null) {
			inputedRewarding = "解答なし";
		} 
		//HTML文の記述
		out.println("職種：<strong>" + inputedJob + "</strong><br/>");
		out.println("開発：<br/><strong>" + req.getParameter("SE_Advice") + "</strong><br/>");
		out.println("インフラ：<br/><strong>" + req.getParameter("infrastructure_Advice") + "</strong><br/>");
		out.println("やりがい：<br/><strong>" + req.getParameter("Rewarding") + "</strong><br/>");
		out.println("<input type=\"hidden\" name =\"gender\" value=\""+ inputedGender + "\" />");
		out.println("<input type=\"hidden\" name =\"age\" value=\"" + inputedAge + "\" />");
		out.println("<input type=\"hidden\" name =\"job\" value=\"" + inputedJob + "\" />");
		out.println("<input type=\"hidden\" name =\"SE_Advice\" value=\"" + inputedSE_Advice + "\" />");
		out.println("<input type=\"hidden\" name =\"infrastructure_Advice\" value=\"" + inputedinfrastructure_Advice + "\" />");
		out.println("<input type=\"hidden\" name =\"Rewarding\" value=\"" + inputedRewarding + "\" />");
		out.println("<input type=\"submit\" value=\"登録\" />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String gender = req.getParameter("gender");
       String age = req.getParameter("age");
       String job = req.getParameter("job");
       String SE_Advice = req.getParameter("SE_Advice");
       String infrastructure_Advice = req.getParameter("infrastructure_Advice");
       String Rewarding = req.getParameter("Rewarding");
       
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
       
       try {
    	   //データベースに接続
    	   connection = Database.getConnection();
    	 
    	   //SQL文を準備
    	   String sql = "INSERT INTO datas (gender,age,job,SE_Advice,infrastructure_Advice,Rewarding)"
    	   		+ " VALUES (?, ?, ?, ?, ?, ?)";
    	   preparedStatement = connection.prepareStatement(sql);
    	   
    	  // パラメータを設定
	        preparedStatement.setString(1, gender);
	        preparedStatement.setString(2, age);
	        preparedStatement.setString(3, job);
	        preparedStatement.setString(4, SE_Advice);
	        preparedStatement.setString(5, infrastructure_Advice);
	        preparedStatement.setString(6, Rewarding);
	        
	      //SQLを実行
	        int rowsAffected = preparedStatement.executeUpdate();
	        
	        if (rowsAffected > 0) {
	        	//成功時の処理（確認ページの表示）
	        	String success = """
	        	<html>
                <head>
                <meta charset="UTF-8">
                <title>登録成功</title>
                </head>
                <body>	       
                <p>登録成功しました</p>
                <a href="Main.jsp">Webサイトへ</a>
                </body>
                </html>		
	        			""";
	        			 String formattedHtml = String.format(success);
	            res.setContentType("text/html;charset=UTF-8");
	            res.getWriter().println(formattedHtml);
	        } else {
	            // 失敗時の処理
	            res.getWriter().println("データベースへの保存に失敗しました。");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // 例外処理
	        res.getWriter().println("データベースエラー: " + e.getMessage());
	    } finally {
	        // リソースを解放
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
		
	}

}