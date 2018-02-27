package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import sprite.SpriteSheet;
import text.MenuBox;
import main.Screen;
import managers.ActorManager;
import managers.GamePad;
import managers.GameStateManager;
import managers.ResourceManager;
import map.TileMap;

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
    
    //menu box
    private MenuBox menuBox;
    
    // menu options
    private String[] options = {
	    "START",
	    "VIEW CONTROLS",
	    "LEVEL SELECT_<DEBUG>",
	    "QUIT"
    };
    
    // selected choice
    private int currentChoice;
    
    public GameState_StartMenu() {
	super();
	background_tiles = new TileMap("spritesheet_startmenu", "tilemap_startmenu");
	currentChoice = 0;
	menuBox = new MenuBox("WELCOME BACK", options, 60, 76);
    }

    @Override
    public void draw(Graphics2D g) {
	background_tiles.draw(g);
	//drawOptions(g);
	menuBox.draw(g);
    }

    @Override
    public void processInput() {
	if (GamePad.wasJustPressed(GamePad.BUTTON_UP)) {
	    currentChoice--;
	    if (currentChoice < 0) {
		currentChoice = options.length - 1;
	    }
	    menuBox.decreaseCurrentChoice();
	} else if (GamePad.wasJustPressed(GamePad.BUTTON_DOWN)) {
	    currentChoice++;
	    if (currentChoice >= options.length) {
		currentChoice = 0;
	    }
	    menuBox.increaseCurrentChoice();
	} else if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
	    makeDecision();
	} else if (GamePad.wasJustPressed(GamePad.BUTTON_X)) {
	    Screen.darken();
	}
    }
    
    private void makeDecision() {
	int decision = menuBox.getCurrentChoice();
	switch (decision) {
    	case 0:
    	    GameStateManager.changeGameState(new GameState_FileSelect());;
    	    break;
    	case 1:
    	    GameStateManager.changeGameState(new GameState_ControlsScreen());
    	    break;
    	case 2:
    	    GameStateManager.changeGameState(new GameState_LevelSelect());
    	    break;
    	case 3:
    	    System.exit(0);
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

}
