package exercise_1.views;

import exercise_1.controllers.StoreController;
import exercise_1.types.StateValue;
import exercise_1.views.menus.StoreMenu;

public class StoreView {

	public void interact(StoreController storeController) {
		
        do {
        	storeController.associate();
        	System.out.println(storeController.getFlowerShopName());
        	storeController.save();
        	System.out.println( "\n" + Message.STORE_MENU_TITLE + " " + storeController.getFlowerShopName().toUpperCase());
        	System.out.println(Message.HORIZONTAL_LINE);
            new StoreMenu(storeController).run();
            
        } while (storeController.getStateValue() == StateValue.MAIN);
		
	}
}
