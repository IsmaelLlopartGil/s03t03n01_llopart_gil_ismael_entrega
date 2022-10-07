package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;
import exercise_1.controllers.StoreController;
import exercise_1.models.Tree;
import exercise_1.views.BuildItemView;
import exercise_1.views.Message;

public class CreateTreeCommand extends Command {
	
	StoreController storeController;
	
	protected CreateTreeCommand(StoreController storeController) {
		super(Message.CREATE_TREE_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		
		Tree treeItem= new Tree(Input.readString("Introdueix el nom: "));	
		
		if (storeController.ifExistItem(treeItem)) {
			storeController.addItem(treeItem);
			System.out.println("El producte ja existeix, s'hi ha afegit una unitat");
			Input.readString("Prem intro");
		} else {
			new BuildItemView(treeItem).build();
			treeItem.setHeight(Input.readString("Introdueix l'alçada: ")); 
			storeController.addItem(treeItem);
		}
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
