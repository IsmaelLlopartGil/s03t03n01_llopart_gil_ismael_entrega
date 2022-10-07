package exercise_1.views.menus;

import com.liche.utils.console.command_menu.CommandConsoleMenu;
import exercise_1.controllers.ManagementController;

public class ManagementMenu extends CommandConsoleMenu {

	public ManagementMenu(ManagementController managementController) {
		this.addOption(new ExitCommand(managementController));
		this.addOption(new NewStoreCommand(managementController));	
		String[] gamesNames = managementController.getShopNames();
		
		for (String title : gamesNames) {
			this.addOption(new SelectedShopCommand(managementController, title));
		}
	}
}
