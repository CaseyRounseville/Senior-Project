package gamestate;

import java.awt.Graphics2D;

import managers.GameStateManager;
import managers.GamePad;
import managers.ResourceManager;

import text.MenuBox;

import map.TileMap;

public class GameState_GameComplete extends GameState {
	
	// options
	private String[] options = {
		"OK"
	};
	
	// menu Box
	private MenuBox menu;
	
	// tile map
	private TileMap background_tiles;
	
	public GameState_GameComplete() {
		super();
		menu = new MenuBox("YOU WIN", options, 60, 100);
		background_tiles = new TileMap(
			"spritesheet_startmenu",
			"tilemap_startmenu"); 
	}

	@Override
	public void draw(Graphics2D g) {
		background_tiles.draw(g);
		menu.draw(g);

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
			makeDecision();
		}
	}
	
	private void makeDecision() {
		/*
		how to handle save data here?
		should ask the player to save?
		*/
		
		GameStateManager.changeGameState(new GameState_TitleScreen());
	}
}
