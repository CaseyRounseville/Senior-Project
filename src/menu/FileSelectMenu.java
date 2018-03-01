package menu;

import text.MenuBox;

import gamestate.GameState_Play;

import managers.GameStateManager;
import managers.SaveManager;

import loaders.SaveFileLoader;

public class FileSelectMenu extends Menu {
	private static final String[] options;
	private static final MenuAction[] actions;
	private static final MenuBox menuBox;
	
	static {
		options = new String[] {
			"FILE 1",
			"FILE 2",
			"FILE 3"
		};
		
		actions = new MenuAction[] {
			() -> { SaveManager.currentSaveData = SaveFileLoader.loadSaveFile("save0"); GameStateManager.changeGameState(new GameState_Play()); },
			() -> { SaveManager.currentSaveData = SaveFileLoader.loadSaveFile("save1"); GameStateManager.changeGameState(new GameState_Play()); },
			() -> { SaveManager.currentSaveData = SaveFileLoader.loadSaveFile("save2"); GameStateManager.changeGameState(new GameState_Play()); }
		};
		
		menuBox = new MenuBox("SELECT A FILE", options, 60, 76);
	}
	
	public FileSelectMenu() {
		super(menuBox, actions);
	}
}