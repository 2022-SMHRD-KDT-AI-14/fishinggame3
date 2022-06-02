package shop;

public class ShopDTO {

	private String ID;
	private String PW;
	private int MONEY;

	public int getMONEY() {
		return MONEY;
	}

	public void setMONEY(int mONEY) {
		MONEY = mONEY;
	}

	public ShopDTO(String iD, String pW) {
		this.ID = iD;
		this.PW = pW;

	}

	public ShopDTO() {

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}
}
