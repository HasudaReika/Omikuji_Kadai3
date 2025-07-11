package omikuji3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBManager;

/**
 * DBから値の取得と結果の書き込みができるかテストするクラス
 */
public class DB {
	public static void main(String[] args) {
		//検索処理を実行
		select();
	}

	//DBから全てのおみくじを取得　OmikujiReaderでリストに格納
	public static void select() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//DBに接続
			connection = DBManager.getConnection();
			//SQLを準備
			String sql = "SELECT omikuji_code, fortune_name, negaigoto, akinai, gakumon " +
					"FROM fortune_master f LEFT OUTER JOIN omikuji o " +
					"ON f.fortune_code = o.fortune_code ";
			//ステートメントを作成
			preparedStatement = connection.prepareStatement(sql);
			//SQLを実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("fortune_name") + "\t");
				System.out.print(resultSet.getString("negaigoto") + "\t");
				System.out.print(resultSet.getString("akinai") + "\t");
				System.out.println(resultSet.getString("gakumon"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//クローズ処理
			DBManager.close(resultSet);
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}
}
