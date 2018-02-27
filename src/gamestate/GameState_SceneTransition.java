package gamestate;

import java.awt.Graphics2D;

import managers.SceneManager;
import map.Scene;

public class GameState_SceneTransition extends GameState {
    
    private GameState prevState;
    
    private Scene oldScene;
    private Scene newScene;
    
    private int frameCount;
    private int fadeColor;

    public GameState_SceneTransition(GameState prevState, Scene newScene, int fadeColor) {
	super();
	this.prevState = prevState;
	this.oldScene = SceneManager.currentScene;
	this.newScene = newScene;
	this.fadeColor = fadeColor;
	frameCount = 0;
    }

    @Override
    public void draw(Graphics2D g) {
	
    }

    @Override
    public void processInput() {
	// do nothing
	
    }

    @Override
    public void tick() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void loadResources() {
	newScene.loadResources();
    }

}
