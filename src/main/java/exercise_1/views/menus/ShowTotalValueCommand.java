package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;

import exercise_1.controllers.StoreController;
import exercise_1.views.Message;

public class ShowTotalValueCommand extends Command {
	
	private StoreController storeController;
	
	public ShowTotalValueCommand (StoreController storeController) {
		super(Message.SHOW_TOTAL_VALUE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		System.out.println ("Total value: " + storeController.getTotalVAlue() + "€");
		Input.readString("Prem intro");
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
