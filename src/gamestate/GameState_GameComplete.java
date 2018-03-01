package gamestate;

import java.awt.Graphics2D;

import managers.GameStateManager;
import managers.GamePad;
import managers.ResourceManager;

import map.TileMap;

import menu.Menu;
import menu.YouWinMenu;

public class GameState_GameComplete extends GameState {
	
	private Menu youWinMenu;
	
	// tile map
	private TileMap background_tiles;
	
	public GameState_GameComplete() {
		super();
		youWinMenu = new YouWinMenu();
		background_tiles = new TileMap(
			"spritesheet_startmenu",
			"tilemap_startmenu"); 
	}

	@Override
	public void draw(Graphics2D g) {
		background_tiles.draw(g);
		youWinMenu.draw(g);

	}
	
	public void tick() {
		// nothing
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
		// there is only one option
		if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
			youWinMenu.makeDecision();
		}
	}
}
