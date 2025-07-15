package db;

/**
 * dbに接続できるかテストするクラス
 */
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

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
