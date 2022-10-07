package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;
import exercise_1.controllers.StoreController;
import exercise_1.models.Decor;
import exercise_1.types.Material;
import exercise_1.views.BuildItemView;
import exercise_1.views.Message;

public class CreateDecorCommand extends Command{

	StoreController storeController;
	
	protected CreateDecorCommand(StoreController storeController) {
		super(Message.CREATE_DECOR_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		
		Decor decorItem= new Decor(Input.readString("Introdueix el nom: "));
		
		if (storeController.ifExistItem(decorItem)) {
			storeController.addItem(decorItem);
			System.out.println("El producte ja existeix, s'hi ha afegit una unitat");
			Input.readString("Prem intro");
			
		} else {
			new BuildItemView(decorItem).build();
			String material;
			
			do {
				material = Input.readString("Escriu el material: (f= fusta, p= plàstic)");
			
				if (material.toLowerCase().equals("p"))  {
					decorItem.setMaterial(Material.PLASTIC);
				} else if (material.toLowerCase().equals("f"))  {
					decorItem.setMaterial(Material.WOOD);
				}
			} while(!material.toLowerCase().equals("p") && !material.toLowerCase().equals("f"));
			
			storeController.addItem(decorItem);
		}
	}

	@Override
	public boolean isActive() {
		return true;
	}

	
}
