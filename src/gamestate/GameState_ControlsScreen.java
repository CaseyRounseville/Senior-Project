package gamestate;

 import java.awt.Graphics2D;

import sprite.SpriteSheet;

import text.LabelBox;

import main.Screen;

import managers.ActorManager;
import managers.GameStateManager;
import managers.ResourceManager;
import managers.GamePad;

import map.TileMap;

public class GameState_ControlsScreen extends GameState {

	// tilemap
	private TileMap background_tiles;
	private TileMap controls_tiles;
	
	// controls
	//private String[] controls = { "left", "right", "run", "jump", "pause" };
	
	private LabelBox[] controls;
	private LabelBox goBack;

	public GameState_ControlsScreen() {
		super();
		background_tiles = new TileMap(
		//"C:/Users/Casey R/Downloads/simple java game 3/32x32 tiles/16x16 tiles/spritesheet_startmenu.png",
		"spritesheet_startmenu",
		"tilemap_startmenu"
		);
		controls_tiles = new TileMap(
		//"C:/Users/Casey R/Downloads/simple java game 3/32x32 tiles/16x16 tiles/spritesheet_controlsmenu.png",
		"spritesheet_controlsmenu",
		"tilemap_controlsmenu"
		);
		controls = new LabelBox[] {
			new LabelBox("LEFT", 32, 56),
			new LabelBox("RIGHT", 32, 88),
			new LabelBox("RUN", 32, 120),
			new LabelBox("JUMP", 32, 152),
			new LabelBox("PAUSE", 32, 184)
		};
		goBack = new LabelBox("PRESS ENTER TO GO BACK", 68, 216);
	}

	@Override
	public void draw(Graphics2D g) {
		// draw background
		background_tiles.draw(g);
		// draw controls descriptions
		//drawControls(g);
		for (int i = 0; i < controls.length; i++) {
			controls[i].draw(g);
		}
		// draw controls images
		controls_tiles.draw(g);
		goBack.draw(g);
	}

	@Override
	public void tick() {

	}

	@Override
	public void loadResources() {
		ResourceManager.clearTextures();
		ResourceManager.clearTileMaps();
		
		ResourceManager.loadTexture("spritesheet_controlsmenu");
		ResourceManager.loadTexture("spritesheet_startmenu");
		ResourceManager.loadTexture("spritesheet_text");
		
		ResourceManager.loadTileMap("tilemap_controlsmenu");
		ResourceManager.loadTileMap("tilemap_startmenu");
	}
	
	@Override
	public void processInput() {
		if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
			GameStateManager.changeGameState(new GameState_StartMenu());
		}
	}

}
