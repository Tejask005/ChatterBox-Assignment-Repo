package chatterBox;

public class GuestUser extends User {

	@Override
	public boolean equals(Object obj) {
		return obj instanceof GuestUser;
	}

}
