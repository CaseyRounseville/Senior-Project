package gamestate;

import java.awt.Graphics2D;

import loaders.SaveFileLoader;
import managers.GamePad;
import managers.GameStateManager;
import managers.ResourceManager;
import managers.SaveManager;
import map.TileMap;
import save.SaveData;

import menu.Menu;
import menu.FileSelectMenu;

public class GameState_FileSelect extends GameState {
	
	private Menu fileSelectMenu;
	
	private TileMap background_tiles;
	

	public GameState_FileSelect() {
		background_tiles = new TileMap("spritesheet_startmenu", "tilemap_startmenu");
		fileSelectMenu = new FileSelectMenu();
	}

	@Override
	public void draw(Graphics2D g) {
		background_tiles.draw(g);
		fileSelectMenu.draw(g);
	}

	@Override
	public void processInput() {
		if (GamePad.wasJustPressed(GamePad.BUTTON_UP)) {
			fileSelectMenu.decreaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_DOWN)) {
			fileSelectMenu.increaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
			fileSelectMenu.makeDecision();
		}
	}

	@Override
	public void tick() {

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
