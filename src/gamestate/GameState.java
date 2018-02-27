package gamestate;

import java.awt.Graphics2D;

import managers.ActorManager;
import managers.GameStateManager;

public abstract class GameState {
	
	//protected String[] resourceList;
	
	public GameState() {
	    //ActorManager.clearActors();
	    loadResources();
	}
	
//	public void changeGameState(GameState gameState) {
//		gamestatemanager.changeGameState(gameState);
//	}
	
//	public GameStateManager getGameStateManager() {
//		return gamestatemanager;
//	}
	
	public abstract void draw(Graphics2D g);
	
	public abstract void processInput();
	
	public abstract void tick();
	
	public abstract void loadResources();

//	public ActorManager getActorManager() {
//	    return actormanager;
//	}

}
