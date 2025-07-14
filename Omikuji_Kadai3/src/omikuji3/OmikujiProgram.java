package omikuji3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OmikujiProgram {

	static OmikujiDB omikujiDB;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//DBにおみくじが格納されているかチェック
//		omikujiDB.checkDB();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputDateString;

		//おみくじの結果が出たらまた誕生日入力に戻る
		while (true) {

			//誕生日を入力してもらう
			System.out.println("誕生日を入力してください　例:20011009");
			//入力された日付をinputDateStringに代入
			inputDateString = br.readLine();
			if (!isValidDate(inputDateString)) {
				continue;
			}
			fortuneTelling(inputDateString);

			System.out.println("\n" + "おみくじを続けますか？　yes/no");
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String answer = br2.readLine();
			if (answer.equals("yes")) {
				continue;
			} else {
				System.out.println("おみくじプログラムを終了します");
				break;
			}
		}
	}

	//日付の妥当性チェック
	private static boolean isValidDate(String inputDateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//日時解析を厳密に行う
		sdf.setLenient(false);
		//入力された日付が正しいかチェック
		try {
			sdf.parse(inputDateString);
			//正しかったらおみくじを出す
			return true;

		} catch (ParseException e) {
			//存在しない日付の場合、メッセージを出力
			System.out.println("正しい日付を入力してください");
			return false;

		}

	}

	//おみくじを出すメソッド
	public static void fortuneTelling(String birthday) {
		
	}

}