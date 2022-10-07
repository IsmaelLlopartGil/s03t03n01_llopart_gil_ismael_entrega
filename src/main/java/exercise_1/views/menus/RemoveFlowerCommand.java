package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;
import exercise_1.controllers.StoreController;
import exercise_1.models.Flower;
import exercise_1.views.Message;

public class RemoveFlowerCommand extends Command{

	StoreController storeController;
	
	protected RemoveFlowerCommand(StoreController storeController) {
		super(Message.REMOVE_FLOWER_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		Flower flower = new Flower(Input.readString("Introdueix el nom: "));
		
		if (storeController.ifExistItem(flower)) {
			storeController.removeItem(flower);
			System.out.println("Producte flor eliminat");
			Input.readString("Prem intro");
		} else {
			System.out.println("Producte flor no trobat");
			Input.readString("Prem intro");
		}
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
