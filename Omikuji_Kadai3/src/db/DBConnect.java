package db;
/**
 * dbに接続できるかテストするクラス
 */
import java.sql.Connection;

public class DBConnect {

	public static void main(String[] args) {

		Connection connection = null;
		try {
			connection = DBManager.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//DBとの接続を切断
			DBManager.close(connection);
		}
	}

}
