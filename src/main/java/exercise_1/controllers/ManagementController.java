package exercise_1.controllers;

import exercise_1.models.FlowerShop;
import exercise_1.models.Session;
import exercise_1.models.DAO.SessionDAO;

public class ManagementController extends Controller implements AceptorController {

	public ManagementController(Session session, SessionDAO sessionDAO) {
		super(session, sessionDAO);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

	public void setFlowerShop(FlowerShop flowerShop) {
		session.setFlowerShop(flowerShop);
	}

	public String[] getShopNames() {
		return sessionDAO.getShopNames();
	}
	
	public void load (String name) {
		sessionDAO.load(name);
	}
	
	public void associate() {
		this.sessionDAO.associate(session);
		
	}
}

