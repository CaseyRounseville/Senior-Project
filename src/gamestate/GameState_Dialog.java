package gamestate;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import managers.GamePad;
import managers.GameStateManager;
import managers.ResourceManager;
import text.DialogBox;
import text.TextBox;

public class GameState_Dialog extends GameState {

    private GameState prevState;
    private DialogBox dialogBox;
    
    public GameState_Dialog(GameState prevState, DialogBox dialogBox) {
	super();
	this.prevState = prevState;
	this.dialogBox = dialogBox;
    }
    
    public void draw(Graphics2D g) {
	prevState.draw(g);
	dialogBox.draw(g);
    }
    
    public void tick() {
	dialogBox.tick();
    }
    
    public void setDialogBox(DialogBox dialogBox) {
	this.dialogBox = dialogBox;
    }
    
    public void processInput() {
	if (GamePad.wasJustPressed(GamePad.BUTTON_X)) {
	    if (dialogBox.isWaiting()) {
		dialogBox.advanceText();
	    } else if (dialogBox.isDone()) {
		prevState.loadResources();
		GameStateManager.changeGameState(prevState);
	    }
	}
    }

    @Override
    public void loadResources() {
	ResourceManager.clearTextures();
	ResourceManager.clearTileMaps();
	
	ResourceManager.loadTexture("spritesheet_text");
    }

}
