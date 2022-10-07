package exercise_1.views.menus;

import com.liche.utils.console.command_menu.Command;
import exercise_1.controllers.Controller;
import exercise_1.types.StateValue;
import exercise_1.views.Message;

public class ExitCommand extends Command {

	private Controller controller;

	public ExitCommand(Controller controller) {
		super(Message.EXIT_COMMAND_TITLE.toString());
		this.controller = controller;
	}

	@Override
	public void execute() {
		controller.setState(StateValue.EXIT);
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
