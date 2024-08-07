

//PrintWriter
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;				//GenericServletなど
import javax.servlet.annotation.WebServlet;			//アノテーション機能
import javax.servlet.http.HttpServlet;				//HttpServletなど
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")									//マッピング名を指名
public class Test extends HttpServlet {					//HttpServletクラスを継承
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {				//doGet()をオーバーライド
		
		//ここからdoGetメソッドの内容を記述
		response.setContentType("text/html;charset=UTF-8");		//コンテンツタイプを取得
		PrintWriter out = response.getWriter();					//PrintWriterを取得
		out.println("<html>");									//PrintWriterを出力
		out.println("<head>");
		out.println("<title>はじめたてのサーブレット</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>サーブレットをデビューしました!</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
