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

import menu.Menu;
import menu.LevelSelectMenu;

public class GameState_LevelSelect extends GameState {
	
	// menu
	private Menu levelSelectMenu;
	
	// tile map
	private TileMap background_tiles;

	public GameState_LevelSelect() {
		super();
		background_tiles = new TileMap("spritesheet_startmenu", "tilemap_startmenu");
		//currentChoice = 0;
		levelSelectMenu = new LevelSelectMenu();
	}

	@Override
	public void draw(Graphics2D g) {
		background_tiles.draw(g);
		levelSelectMenu.draw(g);
	}

	@Override
	public void processInput() {
		if (GamePad.wasJustPressed(GamePad.BUTTON_UP)) {
			levelSelectMenu.decreaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_DOWN)) {
			levelSelectMenu.increaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
			levelSelectMenu.makeDecision();
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
