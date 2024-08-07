package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // データベースに接続
            connection = Database.getConnection();

            // SQL文を準備
            String sql = "SELECT * FROM datas";
            preparedStatement = connection.prepareStatement(sql);

            // SQLを実行し、結果を取得
            resultSet = preparedStatement.executeQuery();

            // 結果をリストに格納
            List<Map<String, Object>> dataList = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, Object> data = new HashMap<>();
                data.put("id", resultSet.getInt("id"));
                data.put("gender", resultSet.getString("gender"));
                data.put("age", resultSet.getString("age"));
                data.put("job", resultSet.getString("job"));
                data.put("SE_Advice", resultSet.getString("SE_Advice"));
                data.put("infrastructure_Advice", resultSet.getString("infrastructure_Advice"));
                data.put("Rewarding", resultSet.getString("Rewarding"));
                dataList.add(data);
            }

            // リクエスト属性にリストを設定
            req.setAttribute("resultList", dataList);

            // JSPにフォワード
            req.getRequestDispatcher("/AggregationResults.jsp").forward(req, res);

        } catch (SQLException e) {
            e.printStackTrace();
            res.getWriter().println("データベースエラー: " + e.getMessage());
        } finally {
            // リソースを解放
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
