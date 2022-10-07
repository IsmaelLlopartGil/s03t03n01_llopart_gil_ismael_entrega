package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;

import exercise_1.controllers.ManagementController;
import exercise_1.models.FlowerShop;
import exercise_1.types.StateValue;
import exercise_1.views.Message;

public class NewStoreCommand extends Command {

	private ManagementController managementController;

	public NewStoreCommand(ManagementController managementController) {
		super(Message.NEW_STORE_COMMAND_TITLE.toString());
		this.managementController = managementController;
	}

	@Override
	public void execute() {
		managementController.setFlowerShop(new FlowerShop (Input.readString("Introdueix el nom de la floristeria: ")));
		managementController.setState(StateValue.MAIN);
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
