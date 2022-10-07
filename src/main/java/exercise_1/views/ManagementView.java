package exercise_1.views;

import exercise_1.controllers.ManagementController;
import exercise_1.types.StateValue;
import exercise_1.views.menus.ManagementMenu;

public class ManagementView {

	public void interact(ManagementController managementController) {
		
        do {
        	System.out.println( "\n" + Message.MANAGEMENT_MENU_TITLE);
        	System.out.println(Message.HORIZONTAL_LINE);
            new ManagementMenu(managementController).run();
        } while (managementController.getStateValue() == StateValue.STORE_SELECTOR);
		
	}
}

