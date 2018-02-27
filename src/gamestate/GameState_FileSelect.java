package gamestate;

import java.awt.Graphics2D;

import loaders.SaveFileLoader;
import managers.GamePad;
import managers.GameStateManager;
import managers.ResourceManager;
import managers.SaveManager;
import map.TileMap;
import save.SaveData;
import text.MenuBox;

public class GameState_FileSelect extends GameState {
    
    private MenuBox menuBox;
    private int currentChoice;
    private static final String[] options = {
	"FILE 1",
	"FILE 2",
	"FILE 3"
    };
    private TileMap background_tiles;
    

    public GameState_FileSelect() {
	background_tiles = new TileMap("spritesheet_startmenu", "tilemap_startmenu");
	menuBox = new MenuBox("SELECT A FILE", options, 60, 76);
	currentChoice = 0;
    }

    @Override
    public void draw(Graphics2D g) {
	background_tiles.draw(g);
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
	}
    }
    
    private void makeDecision() {
	int decision = menuBox.getCurrentChoice();
	SaveData save = null;
	switch (decision) {
	case 0:
	    save = SaveFileLoader.loadSaveFile("save0");
	    break;
	case 1:
	    save = SaveFileLoader.loadSaveFile("save1");
	    break;
	case 2:
	    save = SaveFileLoader.loadSaveFile("save2");
	    break;
	default:
	    break;
	}
	SaveManager.currentSaveData = save;
	GameStateManager.changeGameState(new GameState_Play());
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
