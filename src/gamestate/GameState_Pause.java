package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import managers.GamePad;
import managers.GameStateManager;
import managers.ResourceManager;
import text.LabelBox;
import text.TextBox;
import entity.Player;

public class GameState_Pause extends GameState {

    private GameState prevState;
    //private Player player;
 // pause button
   // private boolean pauseKey;
    private TextBox textBox;
    
    public GameState_Pause(GameState prevState) {
	super();
	this.prevState = prevState;
	//this.player = player;
	textBox = new LabelBox("GAME PAUSED", 56, 32);
    }

    @Override
    public void draw(Graphics2D g) {
	prevState.draw(g);
	g.setColor(Color.PINK);
	g.setFont(new Font("Lucida Console", Font.PLAIN, 14));
	g.drawString("paused", 30, 30);
	g.drawString("press enter to resume game", 30, 50);
	g.drawString("press 1 to advance frame", 30, 70);
	textBox.draw(g);
    }

    @Override
    public void processInput() {
	if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
	    prevState.loadResources();
	    GameStateManager.changeGameState(prevState);
	} else if (GamePad.wasJustPressed(GamePad.BUTTON_1)) {
	    prevState.tick();
	}
    }

    @Override
    public void tick() {
	textBox.tick();
    }

    @Override
    public void loadResources() {
	ResourceManager.clearTextures();
	ResourceManager.clearTileMaps();
	
	ResourceManager.loadTexture("spritesheet_text");
    }

}
