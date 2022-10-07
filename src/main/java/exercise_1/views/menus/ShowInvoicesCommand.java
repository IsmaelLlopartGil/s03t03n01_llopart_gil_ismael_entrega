package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;

import exercise_1.controllers.StoreController;
import exercise_1.views.Message;

public class ShowInvoicesCommand extends Command {

	private StoreController storeController;
	
	public ShowInvoicesCommand (StoreController storeController) {
		super(Message.SHOW_INVOICES_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		System.out.println(storeController.getInvoiceList().toString());
		Input.readString("Prem intro");

	}

	@Override
	public boolean isActive() {
		return true;
	}
}
