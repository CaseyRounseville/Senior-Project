package menu;

import text.MenuBox;

import gamestate.GameState_TitleScreen;
import gamestate.GameState_StartMenu;
import gamestate.GameState_LevelSelect;
import gamestate.GameState_FileSelect;
import gamestate.GameState_GameComplete;
import gamestate.GameState_GameOver;

import managers.GameStateManager;

public class LevelSelectMenu extends Menu {
	private static final String[] options;
	private static final MenuAction[] actions;
	private static final MenuBox menuBox;
	
	static {
		options = new String[] {
			"TITLE SCREEN", 
			"START MENU",
			"LEVEL SELECT",
			"LEVEL 1", 
			"LEVEL 2",
			"LEVEL 3",
			"GAME COMPLETE",
			"GAME OVER"
		};
		
		actions = new MenuAction[] {
			() -> { GameStateManager.changeGameState(new GameState_TitleScreen()); },
			() -> { GameStateManager.changeGameState(new GameState_StartMenu()); },
			() -> { GameStateManager.changeGameState(new GameState_LevelSelect()); },
			() -> { GameStateManager.changeGameState(new GameState_FileSelect()); },
			() -> { GameStateManager.changeGameState(new GameState_FileSelect()); },
			() -> { GameStateManager.changeGameState(new GameState_FileSelect()); },
			() -> { GameStateManager.changeGameState(new GameState_GameComplete()); },
			() -> { GameStateManager.changeGameState(new GameState_GameOver()); }
		};
		
		menuBox = new MenuBox("LEVEL SELECCT:", options, 60, 40);
	}
	
	public LevelSelectMenu() {
		super(menuBox, actions);
	}
}