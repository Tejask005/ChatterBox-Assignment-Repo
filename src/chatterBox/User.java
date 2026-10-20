package chatterBox;

public abstract class User {

	@Override
	public boolean equals(Object obj) {
		return obj instanceof User;
	}

}
