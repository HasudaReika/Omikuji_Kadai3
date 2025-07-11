package omikuji3;

import java.io.Serializable;

/*
 * 運勢クラス
 */

public class Omikuji implements Fortune, Serializable {

	protected String fortuneName;
	protected String negaigoto;
	protected String akinai;
	protected String gakumon;
	protected int omikujiCode;

	//コンストラクタで値を取得
	public Omikuji(int omikujiCode, String fortuneName, String negaigoto, String akinai,
			String gakumon) {
		this.omikujiCode = omikujiCode;
		this.fortuneName = fortuneName;
		this.negaigoto = negaigoto;
		this.akinai = akinai;
		this.gakumon = gakumon;
	}

	public String getFortuneName() {
		return fortuneName;
	}

	public void setFortuneName(String fortuneName) {
		this.fortuneName = fortuneName;
	}

	public String getNegaigoto() {
		return negaigoto;
	}

	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}

	public String getAkinai() {
		return akinai;
	}

	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}

	public String getGakumon() {
		return gakumon;
	}

	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}

	public int getOmikujiCode() {
		return omikujiCode;
	}

	public void setOmikujiCode(int omikujiCode) {
		this.omikujiCode = omikujiCode;
	}

	@Override
	public String disp() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format(DISP_STR, this.fortuneName)).append("\n");
		builder.append("願い事：").append(this.negaigoto).append("\n");
		builder.append("商い：").append(this.akinai).append("\n");
		builder.append("学問：").append(this.gakumon);
		return builder.toString();
	}

}
