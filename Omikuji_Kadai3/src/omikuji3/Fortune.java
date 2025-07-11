package omikuji3;
import java.util.ResourceBundle;

public interface Fortune {
	
	//プロパティを読み込む
//	String DISP_STR = loadProperties();
	//願い事、商い、学問を表示するメソッド
	String disp();
	String DISP_STR = ResourceBundle.getBundle("fortune").getString("DISP_STR");
//	System.out.println("DISP_STR");
	
	
	
	//プロパティを読み込むメソッド
//	static String loadProperties() {
//		Properties properties = new Properties();
//		try (InputStream input = Fortune.class.getClassLoader().getResourceAsStream("fortune.properties")){
//			if (input == null) {
//				System.out.println("ng");
//			}
//			properties.load(input);
//			return properties.getProperty("DISP_STR", "今日の運勢は%sです");
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
}
