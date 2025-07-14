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
	

//		//csvからプロパティファイルの形式に
//		String csv = "omikuji.csv";
//		String propertiesFile = "omikuji.properties";
//		int omkujiCount = 0;
//		
//		try (BufferedReader br = new BufferedReader(new FileReader (csv));
//				FileOutputStream fos = new FileOutputStream(propertiesFile)){
//			String line;
//			while ((line = br.readLine()) != null) {
//				String[] values = line.split(",", 4);
//				omkujiCount ++;
//				
//				String fortuneName = values[0];
//				String negaigoto = values[1];
//				String akinai = values[2];
//				String gakumon = values[3];
//				System.out.println(omkujiCount + ".fortuneName=" + fortuneName);
//				System.out.println(omkujiCount + ".negaigoto=" + negaigoto);
//				System.out.println(omkujiCount + ".akinai=" + akinai);
//				System.out.println(omkujiCount + ".gakumon=" + gakumon);
//			}
//			
//		} catch (IOException e) {
//			System.out.println("プロパティファイルに変換できませんでした");
//			e.printStackTrace();
//		}
//	
	}

}
