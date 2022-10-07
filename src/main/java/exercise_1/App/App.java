package exercise_1.App;

import java.util.HashMap;
import java.util.Map;
import com.liche.utils.io.Input;
import exercise_1.controllers.*;
import exercise_1.models.DAO.SessionDAO;
import exercise_1.models.fileDAO.SessionFileDAO;
import exercise_1.models.sqlDAO.SessionSQL_DAO;
import exercise_1.views.*;

public class App {

	private View view;
	private Logic logic;
	private Map<String, SessionDAO> sessionDaoMap;

	public App() {
		this.view = new ConsoleView();
		this.sessionDaoMap = new HashMap<>();
		this.sessionDaoMap.put("file", new SessionFileDAO());
		this.sessionDaoMap.put("sql", new SessionSQL_DAO());
	}

	private void persistenceSelector() {
		String persistenceOption = "";

		do {
			persistenceOption = Input
					.readString("Introdueix el tipus de persistència: (file= fitxers, sql= Base de dades)");
		} while (!persistenceOption.equals("file") && !persistenceOption.equals("sql"));

		SessionDAO sessionDAO = this.sessionDaoMap.get(persistenceOption);
		this.logic = new Logic(sessionDAO);
		run();
	}

	private void run() {
		AceptorController aceptorController;

		do {
			aceptorController = logic.getController();

			if (aceptorController != null)
				aceptorController.accept(this.view);

		} while (aceptorController != null);
	}

	public static void main(String[] args) {
		new App().persistenceSelector();
	}
}
