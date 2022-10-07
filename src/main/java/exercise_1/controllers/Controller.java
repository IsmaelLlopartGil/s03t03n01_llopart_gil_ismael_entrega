package exercise_1.controllers;

import exercise_1.models.Session;
import exercise_1.models.DAO.SessionDAO;
import exercise_1.types.StateValue;

public abstract class Controller {

	protected Session session;
	protected SessionDAO sessionDAO;

	public Controller(Session session, SessionDAO sessionDAO) {
		this.session = session;
		this.sessionDAO = sessionDAO;
	}

	public void setState(StateValue stateValue) {
		this.session.setValueState(stateValue);
	}

	public StateValue getStateValue() {
		return session.getValueState();
	}
}
