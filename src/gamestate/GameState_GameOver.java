package gamestate;

// import java.awt.Color;
// import java.awt.Font;
 import java.awt.Graphics2D;
// import java.awt.event.KeyEvent;

// import main.Screen;
// import managers.ActorManager;
// import managers.GamePad;
// import managers.GameStateManager;
// import managers.ResourceManager;
// import map.TileMap;
// import sprite.SpriteSheet;
// import text.LabelBox;
// import text.MenuBox;

public class GameState_GameOver extends GameState {

	// // options
	// private String[] options = {
	// "YES",
	// "NO"
	// };
	
	// // menu Box
	// private MenuBox menu;
	
	// // selected choice
	// private int currentChoice;
	
	// // tile map
	// private TileMap background_tiles;
	
	// private static final SpriteSheet backgroundSprites = new SpriteSheet("spritesheet_startmenu", 16, 16);
	
	// private LabelBox gameOverLabel;
	
	// // level that the player lost on
	// private GameState level;
	
	public GameState_GameOver(GameState level) {
		// super();
		// currentChoice = 0;
		// background_tiles = new TileMap(
		// backgroundSprites,
		// "tilemap_startmenu"
		// ); 	
		// gameOverLabel = new LabelBox("GAME OVER", 56, 32);
		// menu = new MenuBox("DO YOU WANT TO CONTINUE?", options, 60, 100);
		// this.level = level;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// background_tiles.draw(g);
		// //	g.setFont(new Font("MSSansSarif", Font.BOLD, 30));
		// //	g.setColor(Color.RED);
		// //	g.drawString("GAME OVER", Screen.WIDTH / 4, 50);
		// gameOverLabel.draw(g);
		// menu.draw(g);
		// //	g.setColor(Color.BLACK);
		// //	g.setFont(new Font("MSSansSarif", Font.PLAIN, 20));
		// //	g.drawString("Do you want to continue?", Screen.WIDTH / 5, Screen.HEIGHT / 3);
		// //	drawOptions(g);
	}
	
	private void drawOptions(Graphics2D g) {
		// for(int option = 0; option < options.length; option++) {
			// if(option == currentChoice) {
				// g.setFont(new Font("MSSansSarif", Font.PLAIN, 20));
				// g.setColor(Color.RED);
			// } else {
				// g.setFont(new Font("MSSansSarif", Font.PLAIN, 15));
				// g.setColor(Color.BLACK);
			// }
			// g.drawString(options[option], Screen.WIDTH / 3 + option * 100, Screen.HEIGHT / 2);
		// }
	}

	// @Override
	// public void keyPressed(int key) {
	// if (key == KeyEvent.VK_UP) {
	// menu.decreaseCurrentChoice();
	// } else if (key == KeyEvent.VK_DOWN) {
	// menu.increaseCurrentChoice();
	// } else if (key == KeyEvent.VK_ENTER) {
	// makeDecision();
	// }
	// }
	
	private void makeDecision() {
		//	if (options[currentChoice].equals("yes")) {
		//	    if (level instanceof GameState_Level1)
		//		level = new GameState_Level1(getGameStateManager(), actormanager);
		//	changeGameState(level);
		//	} else if (options[currentChoice].equals("no")) {
		//	    changeGameState(new GameState_TitleScreen(getGameStateManager(), actormanager));
		//	}
		// int decision = menu.getCurrentChoice();
		// switch (decision) {
		// case 0:
			// if (level instanceof GameState_Level1)
			// level = new GameState_Level1();
			// GameStateManager.changeGameState(level);
			// break;
		// case 1:
			// GameStateManager.changeGameState(new GameState_TitleScreen());
			// break;
		// default:
			// // do nothing
		// }
	}

	// @Override
	// public void keyReleased(int key) {
	// // do nothing
	// }

	@Override
	public void tick() {
		// do nothing
	}

	@Override
	public void loadResources() {
		// ResourceManager.clearTextures();
		// ResourceManager.clearTileMaps();
		
		// ResourceManager.loadTexture("spritesheet_startmenu");
		// ResourceManager.loadTexture("spritesheet_text");
		
		// ResourceManager.loadTileMap("tilemap_startmenu");
	}

	@Override
	public void processInput() {
		// if (GamePad.wasJustPressed(GamePad.BUTTON_UP)) {
		// menu.decreaseCurrentChoice();
		// } else if (GamePad.wasJustPressed(GamePad.BUTTON_DOWN)) {
		// menu.increaseCurrentChoice();
		// } else if (GamePad.isDown()) {}
	}

}
