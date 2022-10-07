package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;
import exercise_1.controllers.StoreController;
import exercise_1.views.Message;

public class ShowStockCommand extends Command {

	private StoreController storeController;
	
	public ShowStockCommand (StoreController storeController) {
		super(Message.SHOW_STOCK_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		System.out.println( "\n" +
				"STOCK: \n" +
				Message.HORIZONTAL_LINE + "\n" +
				String.format("%-12s", "Nom:") + String.format("%-14s", "Quantitat:") + String.format("%-12s", "Categoria:") + "\n" +
				Message.HORIZONTAL_LINE + "\n" +
				storeController.getStockText());
		Input.readString("Intro per continuar");
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
