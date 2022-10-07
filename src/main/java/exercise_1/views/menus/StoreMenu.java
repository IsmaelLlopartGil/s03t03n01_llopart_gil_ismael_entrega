package exercise_1.views.menus;

import com.liche.utils.console.command_menu.CommandConsoleMenu;
import exercise_1.controllers.StoreController;

public class StoreMenu extends CommandConsoleMenu{

	public StoreMenu (StoreController storeController) {
		this.addOption(new ExitCommand(storeController));
		this.addOption(new ReturnToManagementMenuCommand(storeController));
		this.addOption(new CreateDecorCommand(storeController));
		this.addOption(new CreateFlowerCommand(storeController));
		this.addOption(new CreateTreeCommand(storeController));
		this.addOption(new RemoveDecorCommand(storeController));
		this.addOption(new RemoveFlowerCommand(storeController));
		this.addOption(new RemoveTreeCommand(storeController));
		this.addOption(new ShowStockCommand(storeController));
		this.addOption(new GenerateInvoiceCommand(storeController));
		this.addOption(new ShowInvoicesCommand(storeController));
		this.addOption(new ShowEarningsCommand(storeController));
		this.addOption(new ShowTotalValueCommand(storeController));
	}
}
