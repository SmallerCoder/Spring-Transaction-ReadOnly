package wokao666.club.myapp.model;

public class User {

	private int Id;
	private String NAME;
	private String MOBILE;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getMOBILE() {
		return MOBILE;
	}

	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}

	public User(String nAME, String mOBILE) {
		super();
		NAME = nAME;
		MOBILE = mOBILE;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [NAME=" + NAME + ", MOBILE=" + MOBILE + "]";
	}

}
