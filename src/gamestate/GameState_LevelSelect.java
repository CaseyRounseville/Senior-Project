package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import main.Screen;
import managers.ActorManager;
import managers.GamePad;
import managers.GameStateManager;
import managers.ResourceManager;
import map.TileMap;
import sprite.SpriteSheet;
import text.MenuBox;

public class GameState_LevelSelect extends GameState {
	
	// menu options
	private String[] options = {
		"TITLE SCREEN", 
		"START MENU",
		"LEVEL SELECT",
		"LEVEL 1", 
		"LEVEL 2",
		"LEVEL 3",
		"GAME COMPLETE",
		"GAME OVER"
	};
	
	// menuBox
	private MenuBox menuBox;
	
	// tile map
	private TileMap background_tiles;
	
	// selected choice
	//private int currentChoice;

	public GameState_LevelSelect() {
		super();
		background_tiles = new TileMap("spritesheet_startmenu", "tilemap_startmenu");
		//currentChoice = 0;
		menuBox = new MenuBox("LEVEL SELECT:", options, 60, 40);
	}

	@Override
	public void draw(Graphics2D g) {
		background_tiles.draw(g);
		menuBox.draw(g);
	}

	@Override
	public void processInput() {
		if (GamePad.wasJustPressed(GamePad.BUTTON_UP)) {
			menuBox.decreaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_DOWN)) {
			menuBox.increaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
			makeDecision();
		}
	}
	
	private void makeDecision() {
		int decision = menuBox.getCurrentChoice();
		switch (decision) {
		case 0:
			GameStateManager.changeGameState(new GameState_TitleScreen());
			break;
		case 1:
			GameStateManager.changeGameState(new GameState_StartMenu());
			break;
		case 2:
			GameStateManager.changeGameState(new GameState_LevelSelect());
			break;
		case 3:
			GameStateManager.changeGameState(new GameState_FileSelect());
			break;
		case 4:
			GameStateManager.changeGameState(new GameState_FileSelect());
			break;
		case 5:
			GameStateManager.changeGameState(new GameState_FileSelect());
			break;
		case 6:
			GameStateManager.changeGameState(new GameState_GameComplete());
			break;
		case 7:
			GameStateManager.changeGameState(new GameState_GameOver());
		default:
			// do nothing
		}
	}
	
	@Override
	public void tick() {
		// do nothing
	}

	@Override
	public void loadResources() {
		ResourceManager.clearTextures();
		ResourceManager.clearTileMaps();
		
		ResourceManager.loadTexture("spritesheet_startmenu");
		ResourceManager.loadTexture("spritesheet_text");
		
		ResourceManager.loadTileMap("tilemap_startmenu");
	}

}
