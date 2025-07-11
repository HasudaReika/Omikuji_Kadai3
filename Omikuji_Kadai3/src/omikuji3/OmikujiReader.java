package omikuji3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBManager;

public class OmikujiReader {

	//全てのおみくじオブジェクトを格納するリストを作成　Omikuji_programでランダムに取得
	private List<Omikuji> allOmikuji = new ArrayList<Omikuji>();

	//おみくじリーダーのコンストラクタ
	public OmikujiReader() {
		//おみくじオブジェクトを作成しリストに追加するメソッドを呼び出す
		loadOmikuji();
	}

	//おみくじオブジェクトを作成しリストに追加
	public void loadOmikuji() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
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
				int omikujiCode = resultSet.getInt("omikuji_code");
				String fortuneName = resultSet.getString("fortune_name");
				String negaigoto = resultSet.getString("negaigoto");
				String akinai = resultSet.getString("akinai");
				String gakumon = resultSet.getString("gakumon");

				//おみくじオブジェクトを作成
				Omikuji omikujiObject = new Omikuji(omikujiCode, fortuneName, negaigoto, akinai, gakumon);
				allOmikuji.add(omikujiObject);

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

	//全てのおみくじをOmikuji_programで返す
	public List<Omikuji> getAllOmikuji() {
		return allOmikuji;

	}

}
