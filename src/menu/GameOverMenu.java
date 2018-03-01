package menu;

import text.MenuBox;

import gamestate.GameState_Play;
import gamestate.GameState_TitleScreen;

import managers.GameStateManager;
import managers.SaveManager;

import loaders.SaveFileLoader;

public class GameOverMenu extends Menu {
	private static final String[] options;
	private static final MenuAction[] actions;
	private static final MenuBox menuBox;
	
	static {
		options = new String[] {
			"YES",
			"NO"
		};
		
		actions = new MenuAction[] {
			() -> {
				if (SaveManager.currentSaveData == null) {
					SaveManager.currentSaveData = SaveFileLoader.loadSaveFile("save0");
				}
				GameStateManager.changeGameState(new GameState_Play());
			},
			() -> { GameStateManager.changeGameState(new GameState_TitleScreen()); }
		};
		
		menuBox = new MenuBox("DO YOU WANT TO CONTINUE?", options, 60, 100);
	}
	
	public GameOverMenu() {
		super(menuBox, actions);
	}
}