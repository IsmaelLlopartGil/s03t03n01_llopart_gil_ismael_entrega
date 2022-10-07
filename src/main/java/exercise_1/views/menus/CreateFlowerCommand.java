package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import com.liche.utils.io.Input;

import exercise_1.controllers.StoreController;
import exercise_1.models.Flower;
import exercise_1.types.Color;
import exercise_1.views.BuildItemView;
import exercise_1.views.Message;

public class CreateFlowerCommand extends Command {
	
	StoreController storeController;
	
	protected CreateFlowerCommand(StoreController storeController) {
		super(Message.CREATE_FLOWER_COMMAND_TITLE.toString());
		this.storeController = storeController;
	}

	@Override
	public void execute() {
		
		Flower flowerItem= new Flower(Input.readString("Introdueix el nom: "));		
		
		if (storeController.ifExistItem(flowerItem)) {
			storeController.addItem(flowerItem);
			System.out.println("El producte ja existeix, s'hi ha afegit una unitat");
			Input.readString("Prem intro");
		} else {
			new BuildItemView(flowerItem).build();
			String color;
			
			do {
				color = Input.readString("Escriu el color: (b= blanc, g= groc, v= vermell)");
			
				switch (color.toLowerCase()) {
				
				case "b":
					flowerItem.setColor(Color.WHITE);
					break;
					
				case "g":
					flowerItem.setColor(Color.YELLOW);
					break;
					
				case "v":
					flowerItem.setColor(Color.RED);
					break;
					
				default:
					break;
				}
				
			} while(!color.toLowerCase().equals("b") && !color.toLowerCase().equals("g") && !color.toLowerCase().equals("v"));
			
			storeController.addItem(flowerItem);
		}
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
