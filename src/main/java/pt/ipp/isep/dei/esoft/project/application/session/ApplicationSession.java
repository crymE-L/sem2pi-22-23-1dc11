package pt.ipp.isep.dei.esoft.project.application.session;

import pt.ipp.isep.dei.esoft.project.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class ApplicationSession {
	/**
	 * Even though it's a list, we're always going to work with the index 0
	 */
	private final List<Object> user = new ArrayList<>();

	public Object getCurrentUser() {
		try {
			return this.user.get(0);
		} catch (Exception exception) {
			return null;
		}
	}

	public void setCurrentUser(Object user) {
		this.user.add(0, user);
	}
}
