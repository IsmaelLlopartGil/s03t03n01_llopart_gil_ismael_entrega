package com.liche.utils.console.command_menu;

public abstract class Command {

	protected String title;
	
	protected Command(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public abstract void execute();
	
	public abstract boolean isActive();
	

}
