package exercise_1.views;
import exercise_1.controllers.ManagementController;
import exercise_1.controllers.StoreController;

public class ConsoleView implements View{

	private ManagementView managementView;
	private StoreView storeView;
	
	public ConsoleView() {
		this.managementView=new ManagementView();
		this.storeView= new StoreView();
	}
	
	@Override
	public void visit(ManagementController managementController) {
		this.managementView.interact(managementController);
	}

	@Override
	public void visit(StoreController shopController) {
		this.storeView.interact(shopController);
	}
}
