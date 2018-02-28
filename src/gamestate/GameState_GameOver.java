package gamestate;

import java.awt.Graphics2D;

import main.Screen;

import managers.ActorManager;
import managers.GamePad;
import managers.GameStateManager;
import managers.ResourceManager;

import map.TileMap;

import sprite.SpriteSheet;

import text.LabelBox;
import text.MenuBox;

import managers.SaveManager;
import save.SaveData;

import loaders.SaveFileLoader;

public class GameState_GameOver extends GameState {

	// options
	private String[] options = {
		"YES",
		"NO"
	};
	
	// menu Box
	private MenuBox menu;
	
	// selected choice
	private int currentChoice;
	
	// tile map
	private TileMap background_tiles;
	
	private LabelBox gameOverLabel;
	
	public GameState_GameOver() {
		super();
		currentChoice = 0;
		background_tiles = new TileMap(
			"spritesheet_startmenu",
			"tilemap_startmenu"); 	
		gameOverLabel = new LabelBox("GAME OVER", 56, 32);
		menu = new MenuBox("DO YOU WANT TO CONTINUE?", options, 60, 100);
	}
	
	@Override
	public void draw(Graphics2D g) {
		background_tiles.draw(g);
		gameOverLabel.draw(g);
		menu.draw(g);
	}
	
	private void makeDecision() {
		int decision = menu.getCurrentChoice();
		switch (decision) {
		case 0:
			if (SaveManager.currentSaveData == null) {
				SaveManager.currentSaveData = SaveFileLoader.loadSaveFile("save0");
			}
			GameStateManager.changeGameState(new GameState_Play());
			break;
		case 1:
			GameStateManager.changeGameState(new GameState_TitleScreen());
			break;
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

	@Override
	public void processInput() {
		if (GamePad.wasJustPressed(GamePad.BUTTON_UP)) {
			menu.decreaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_DOWN)) {
			menu.increaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
			makeDecision();
		}
	}

}
