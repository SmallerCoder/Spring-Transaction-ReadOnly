package wokao666.club.myapp.model;

public class MchtUser {

	private String USER_NAME;
	private long USER_ID;

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public long getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}

	@Override
	public String toString() {
		return "MchtUser [USER_NAME=" + USER_NAME + ", USER_ID=" + USER_ID + "]";
	}

	public MchtUser() {
	}

	public MchtUser(String uSER_NAME, long uSER_ID) {
		super();
		USER_NAME = uSER_NAME;
		USER_ID = uSER_ID;
	}
}
