package gamestate;

import java.awt.Graphics2D;

import entity.Player;
import text.DialogBox;
import loaders.SceneLoader;
import managers.ActorManager;
import managers.GamePad;
import managers.GameStateManager;
import managers.SaveManager;
import managers.SceneManager;

public class GameState_Play extends GameState {

    public GameState_Play() {
	SceneManager.currentScene = SceneLoader.loadScene("scene_testscene");
	SceneManager.loadResources();
	SceneManager.currentScene.setCurrentRoom(0);
	ActorManager.setPlayer(
		new Player(
			2,
			2,
			SceneManager.currentScene.getCurrentRoom().getTileMap()
		)
	);
	if (SceneManager.currentScene == null) System.out.println("SCENE NULL:::::::::::::::::::::::::");
	
	
    }

    @Override
    public void draw(Graphics2D g) {
	SceneManager.draw(g);
    }

    @Override
    public void processInput() {
	Player player = ActorManager.getPlayer();
	if (!player.isDead()) {
	    if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
		player.setHoldingLeft(false);
		player.setHoldingRight(false);
		player.setHoldingUp(false);
		player.setHoldingDown(false);
		GameStateManager.changeGameState(new GameState_Pause(this));
	    } /*else if (key == KeyEvent.VK_2) {
		shouldDrawPlayerStats = !shouldDrawPlayerStats;
	    }*/ else if (GamePad.wasJustPressed(GamePad.BUTTON_3)) {
		GameStateManager.changeGameState(new GameState_Dialog(this, null));
		((GameState_Dialog) GameStateManager.currentState).setDialogBox(new DialogBox("YOU FOUND A KEY! YOU CAN USE IT TO OPEN A LOCKED DOOR. LOOK, THERE IS ONE OVER THERE. TO OPEN THE DOOR, WALK UP TO IT.", 32, 32));
	    }
	}
    }

    @Override
    public void tick() {
	//System.out.println(SaveManager.currentSaveData.getSceneRecord(0));
	Player player = ActorManager.getPlayer();
	if (player.isDead()) {
	    if (player.getCurrentAnimation_animation().hasBeenPlayedOnce()) {
		if (player.getLives() == 0) {
		    GameStateManager.changeGameState(new GameState_GameOver());
		} else {
		    player.reset();
		    player.setXTile(2.0f);
		    player.setYTile(2.0f);
		    player.setVX(0.0f);
		    player.setVY(0.0f);
		}
	    }
	}
	
	// tick room
	SceneManager.tick();
	
	// tick hud
    }

    @Override
    public void loadResources() {
	if (SceneManager.currentScene != null)
	SceneManager.loadResources();
    }

}
