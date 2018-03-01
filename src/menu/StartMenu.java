package menu;

import text.MenuBox;

import gamestate.GameState_LevelSelect;
import gamestate.GameState_ControlsScreen;
import gamestate.GameState_FileSelect;

import managers.GameStateManager;

public class StartMenu extends Menu {
	private static final String[] options;
	private static final MenuAction[] actions;
	private static final MenuBox menuBox;
	
	static {
		options = new String[] {
			"START",
			"VIEW CONTROLS",
			"LEVEL SELECT_<DEBUG>",
			"QUIT"
		};
		
		actions = new MenuAction[] {
			() -> { GameStateManager.changeGameState(new GameState_FileSelect()); },
			() -> { GameStateManager.changeGameState(new GameState_ControlsScreen()); },
			() -> { GameStateManager.changeGameState(new GameState_LevelSelect()); },
			() -> { System.exit(0); }
		};
		
		menuBox = new MenuBox("WELCOME BACK", options, 60, 76);
	}
	
	public StartMenu() {
		super(menuBox, actions);
	}
}