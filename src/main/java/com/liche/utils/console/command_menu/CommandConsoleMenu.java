package com.liche.utils.console.command_menu;

import java.util.*;
import com.liche.utils.io.*;

public class CommandConsoleMenu {

	private List<Command> options;

	public CommandConsoleMenu() {
		options = new ArrayList<>();
	}

	public void addOption(Command option) {
		options.add(option);
	}

	public void run() {
		int userOption;

		for (int i = 0; i < options.size(); i++) {
			System.out.print(i + "- " + options.get(i).getTitle() + "\n");
		}

		userOption = Input.readInt("", new Range(0, options.size() - 1));
		options.get(userOption).execute();

	}
}
