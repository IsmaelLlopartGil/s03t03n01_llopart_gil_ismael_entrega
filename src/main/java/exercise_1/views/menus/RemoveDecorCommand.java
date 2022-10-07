package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;
import exercise_1.controllers.StoreController;
import exercise_1.models.Decor;
import exercise_1.views.Message;

public class RemoveDecorCommand extends Command{
	
	StoreController storeController;
	
	protected RemoveDecorCommand(StoreController storeController) {
		super(Message.REMOVE_DECOR_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		Decor decor = new Decor(Input.readString("Introdueix el nom: "));
		
		if (storeController.ifExistItem(decor)) {
			storeController.removeItem(decor);
			System.out.println("Producte de decoració eliminat");
			Input.readString("Prem intro");
		} else {
			System.out.println("Producte de decoració no trobat");
			Input.readString("Prem intro");
		}
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
