package exercise_1.controllers;

public interface ControllerVisitor {

    void visit(ManagementController managementController);
	void visit(StoreController shopController);
}
