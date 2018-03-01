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

import managers.SaveManager;
import save.SaveData;

import loaders.SaveFileLoader;

import menu.Menu;
import menu.GameOverMenu;

public class GameState_GameOver extends GameState {

	private Menu gameOverMenu;
	
	// tile map
	private TileMap background_tiles;
	
	private LabelBox gameOverLabel;
	
	public GameState_GameOver() {
		super();
		background_tiles = new TileMap(
			"spritesheet_startmenu",
			"tilemap_startmenu"); 	
		gameOverLabel = new LabelBox("GAME OVER", 56, 32);
		gameOverMenu = new GameOverMenu();
	}
	
	@Override
	public void draw(Graphics2D g) {
		background_tiles.draw(g);
		gameOverLabel.draw(g);
		gameOverMenu.draw(g);
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
			gameOverMenu.decreaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_DOWN)) {
			gameOverMenu.increaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
			gameOverMenu.makeDecision();
		}
	}

}
