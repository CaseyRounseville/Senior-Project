package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import sprite.SpriteSheet;
import main.Screen;
import managers.ActorManager;
import managers.GamePad;
import managers.GameStateManager;
import managers.ResourceManager;
import map.TileMap;

import menu.Menu;
import menu.StartMenu;

public class GameState_StartMenu extends GameState {

	// tile constants
	/*private static final byte SCREW = 0;
	private static final byte BAR_LEFTEDGE = 1;
	private static final byte BAR_RIGHTEDGE = 2;
	private static final byte BAR_VERTICALMIDDLE = 3;
	private static final byte BAR_TOPEDGE = 4;
	private static final byte BAR_BOTTOMEDGE = 5;
	private static final byte BAR_HORIZONTALMIDDLE = 6;
	private static final byte BLANK = 7;*/
	
	// tilemap
	private TileMap background_tiles;
	
	private Menu startMenu;
	
	public GameState_StartMenu() {
		super();
		background_tiles = new TileMap("spritesheet_startmenu", "tilemap_startmenu");
		startMenu = new StartMenu();
	}

	@Override
	public void draw(Graphics2D g) {
		background_tiles.draw(g);
		//drawOptions(g);
		startMenu.draw(g);
	}

	@Override
	public void processInput() {
		if (GamePad.wasJustPressed(GamePad.BUTTON_UP)) {
			startMenu.decreaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_DOWN)) {
			startMenu.increaseCurrentChoice();
		} else if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
			startMenu.makeDecision();
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
