package menu;

import java.awt.Graphics2D;

import text.MenuBox;

public class Menu {
	private MenuBox menuBox;
	
	private MenuAction[] actions;
	
	public Menu(MenuBox menuBox, MenuAction[] actions) {
		this.menuBox = menuBox;
		this.actions = actions;
		
		menuBox.setCurrentChoice(0);
	}
	
	public void draw(Graphics2D g) {
		menuBox.draw(g);
	}
	
	public void tick() {
		menuBox.tick();
	}
	
	public void increaseCurrentChoice() {
		menuBox.increaseCurrentChoice();
	}
	
	public void decreaseCurrentChoice() {
		menuBox.decreaseCurrentChoice();
	}
	
	public void setCurrentChoice(int currentChoice) {
		menuBox.setCurrentChoice(currentChoice);
	}
	
	public void makeDecision() {
		actions[menuBox.getCurrentChoice()].perform();
	}
}