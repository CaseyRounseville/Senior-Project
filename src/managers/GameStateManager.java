package managers;

import java.awt.Graphics2D;

import gamestate.GameState;
import gamestate.GameState_TitleScreen;

public final class GameStateManager {

    //private State[] states;
    //private int currentState;
    public static GameState currentState = new GameState_TitleScreen();

    public GameStateManager() {
	//GameState_TitleScreen gamestate = new GameState_TitleScreen(this, new ActorManager());
	//GameState_TitleScreen.loadResources();
	currentState = new GameState_TitleScreen();
    }

    public static void draw(Graphics2D g) {
	currentState.draw(g);
    }

    public static void tick() {
	currentState.tick();
    }
    
    public static void processInput() {
	currentState.processInput();
    }

    public static void changeGameState(GameState gameState) {
	//gameState.loadResources();
	currentState = gameState;
    }

}
