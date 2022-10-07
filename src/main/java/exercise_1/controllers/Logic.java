package exercise_1.controllers;

import java.util.HashMap;
import java.util.Map;
import exercise_1.models.Session;
import exercise_1.models.DAO.SessionDAO;
import exercise_1.types.StateValue;

public class Logic {

	private Session session;
	private SessionDAO sessionDAO;
    private Map<StateValue, AceptorController> controllerMap;

    public Logic(SessionDAO sessionDAO) {
        this.session = new Session();
        this.sessionDAO = sessionDAO;
        this.controllerMap = new HashMap<StateValue, AceptorController>();
        this.controllerMap.put(StateValue.STORE_SELECTOR, new ManagementController(this.session, this.sessionDAO));
        this.controllerMap.put(StateValue.MAIN, new StoreController(this.session, this.sessionDAO));
        this.controllerMap.put(StateValue.EXIT, null);
    }

	public AceptorController getController() {
        return this.controllerMap.get(this.session.getValueState());
    }
}
