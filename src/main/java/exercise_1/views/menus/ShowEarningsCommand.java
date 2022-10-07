package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;

import exercise_1.controllers.StoreController;
import exercise_1.views.Message;

public class ShowEarningsCommand extends Command {
	
	private StoreController storeController;
	
	public ShowEarningsCommand (StoreController storeController) {
		super(Message.SHOW_EARNINGS_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		System.out.println ("Total guanys: " + storeController.getEarnings() + "€");
		Input.readString("Prem intro");
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
