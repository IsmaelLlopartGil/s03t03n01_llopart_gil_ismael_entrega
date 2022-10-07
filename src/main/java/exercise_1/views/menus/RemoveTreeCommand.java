package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;
import exercise_1.controllers.StoreController;
import exercise_1.models.Tree;
import exercise_1.views.Message;

public class RemoveTreeCommand extends Command{

	StoreController storeController;
	
	protected RemoveTreeCommand(StoreController storeController) {
		super(Message.REMOVE_TREE_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		Tree tree = new Tree(Input.readString("Introdueix el nom: "));
		
		if (storeController.ifExistItem(tree)) {
			storeController.removeItem(tree);
			System.out.println("Producte arbre eliminat");
			Input.readString("Prem intro");
		} else {
			System.out.println("Producte arbre no trobat");
			Input.readString("Prem intro");
		}
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
