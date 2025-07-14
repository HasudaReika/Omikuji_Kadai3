//package omikuji3;
//
///*
// * もう使わないクラス
// */
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.time.LocalDate;
//
//import db.DBManager;
//
//public class OmikujiReader {
//
//	//全てのおみくじオブジェクトを格納するリストを作成　Omikuji_programでランダムに取得
//	//	private List<Omikuji> allOmikuji = new ArrayList<Omikuji>();
//
//
//	//今日の日付を取得
//		LocalDate now = LocalDate.now();
//		Date today = Date.valueOf(now);
//
//	//おみくじオブジェクトを作成しリストに追加
//	public Omikuji loadOmikuji() {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
////
//		try {
//			//DBに接続
//			connection = DBManager.getConnection();
//
////			//SQLを準備
////			//テーブルからおみくじコード、運勢名、願い事、商い、学問を取得
////			String sql = "SELECT omikuji_code, fortune_name, negaigoto, akinai, gakumon " +
////					"FROM fortune_master f LEFT OUTER JOIN omikuji o " +
////					"ON f.fortune_code = o.fortune_code " +
////					" order by random () limit 1";
////			//ステートメントを作成
////			preparedStatement = connection.prepareStatement(sql);
////			//SQLを実行
////			resultSet = preparedStatement.executeQuery();
////
//			//resultテーブルに占った日と誕生日が一致する占い結果があるかチェック
//			String checkOmikuji = "select omikuji.omikuji_code, fortune_master.fortune_name, omikuji.negaigoto, omikuji.akinai, omikuji.gakumon\n"
//					+ "from result\n"
//					+ "join omikuji on result.omikuji_code = omikuji.omikuji_code\n"
//					+ "join fortune_master on omikuji.fortune_code = fortune_master.fortune_code\n"
//					+ "where result.fortune_telling_ate = ? and result.birthday = ?";
//			
//			
//			//入力値をバインド
//			preparedStatement.setDate(1, today);
//			preparedStatement.setInt(2, );
//
//			
//			//ステートメントを準備
//			preparedStatement = connection.prepareStatement(checkOmikuji);
//			//SQLを実行
//			resultSet = preparedStatement.executeQuery();
//
//			//レコードを１行ずつ取得し、各値を変数に代入
//			while (resultSet.next()) {
//				int omikujiCode = resultSet.getInt("omikuji_code");
//				String fortuneName = resultSet.getString("fortune_name");
//				String negaigoto = resultSet.getString("negaigoto");
//				String akinai = resultSet.getString("akinai");
//				String gakumon = resultSet.getString("gakumon");
//
//				//おみくじオブジェクトを作成
//				return new Omikuji(omikujiCode, fortuneName, negaigoto, akinai, gakumon);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			//クローズ処理
//			DBManager.close(resultSet);
//			DBManager.close(preparedStatement);
//			DBManager.close(connection);
//		}
//		return null;
//	}
//
//	//	//全てのおみくじをOmikuji_programで返す
//	//	public List<Omikuji> getAllOmikuji() {
//	//		return allOmikuji;
//	//
//	//	}
//
//}
