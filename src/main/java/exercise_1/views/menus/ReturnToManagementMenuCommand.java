package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;

import exercise_1.controllers.StoreController;
import exercise_1.types.StateValue;
import exercise_1.views.Message;

public class ReturnToManagementMenuCommand extends Command {

	private StoreController storeController;
	
	public ReturnToManagementMenuCommand(StoreController storeController) {
		super(Message.RETURN_TO_MANAGEMENT_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		storeController.setState(StateValue.STORE_SELECTOR);

	}

	@Override
	public boolean isActive() {
		return true;
	}

}
