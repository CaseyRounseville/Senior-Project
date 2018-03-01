package menu;

import text.MenuBox;

import gamestate.GameState_TitleScreen;

import managers.GameStateManager;

public class YouWinMenu extends Menu {
	private static final String[] options;
	private static final MenuAction[] actions;
	private static final MenuBox menuBox;
	
	static {
		options = new String[] {
			"OK"
		};
		
		actions = new MenuAction[] {
			() -> { GameStateManager.changeGameState(new GameState_TitleScreen()); }
		};
		
		menuBox = new MenuBox("YOU WIN", options, 60, 76);
	}
	
	public YouWinMenu() {
		super(menuBox, actions);
	}
}