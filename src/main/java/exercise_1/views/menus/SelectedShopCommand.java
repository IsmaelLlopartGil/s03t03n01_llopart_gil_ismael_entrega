package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import exercise_1.controllers.ManagementController;
import exercise_1.types.StateValue;

public class SelectedShopCommand extends Command {

	private ManagementController managementController;

	public SelectedShopCommand(ManagementController managementController, String title) {
		super(title);
		this.managementController = managementController;
	}

	@Override
	public void execute() {
		
		managementController.associate();
		managementController.load(title);
		managementController.setState(StateValue.MAIN);
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
