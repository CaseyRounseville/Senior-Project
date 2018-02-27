package gamestate;

// import java.awt.Color;
 import java.awt.Graphics2D;
// import java.awt.event.KeyEvent;
// import java.util.ArrayList;

// import sprite.SpriteSheet;
// import text.DialogBox;
// import text.TextBox;
// import managers.ActorManager;
// import managers.GamePad;
// import managers.GameStateManager;
// import managers.ResourceManager;
// import map.Background;
// import map.TileMap;
// import entity.Coin;
// import entity.Door;
// import entity.Enemy;
// import entity.EnemyA;
// import entity.ExtraLife;
// import entity.HUD;
// import entity.Heart;
// import entity.Item;
// import entity.Key;
// import entity.Player;

public class GameState_Level1 extends GameState {

	// // layers
	// private TileMap layer_back;
	// private Background bg;
	// private TileMap layer_middle;
	// private TileMap layer_front;
	
	// // sprites
	// private SpriteSheet tileSprites;

	// // tile constants
	// // private static final byte CLOUD = 0;

	// // items
	// //private ArrayList<Item> actormanager;
	// private int numCoinsCollected;

	// // enemies
	// //private ArrayList<Enemy> actormanager;
	
	// // doors
	// //private ArrayList<Door> actormanager;
	
	// // player
	// private Player player;
	
	// // hud
	// private HUD hud;
	
	// // player stats display (debug)
	// private boolean shouldDrawPlayerStats;
	
	// // pause button
	// //private boolean pauseKey;

	public GameState_Level1() {
		super();
		
		// //bg = new Background("C:/Users/Casey R/Downloads/simple java game 3/32x32 tiles/16x16 tiles/background_test.png", -0.5f);
		// layer_back = new TileMap("spritesheet_test", "tilemap_level1_layer_back");
		// layer_middle = new TileMap("spritesheet_test",
		// "tilemap_level1_layer_middle");
		// layer_front = new TileMap("spritesheet_test",
		// "tilemap_level1_layer_front");
		// init_player();
		// hud = new HUD(player);
		// init_itemList();
		// numCoinsCollected = 0;
		// init_enemyList();
		// init_doorList();
		// shouldDrawPlayerStats = false;
		// System.out.println("hi");
	}
	
	private void init_enemyList() {
		// //	actormanager = new ArrayList<Enemy>();
		// ActorManager.addActor(new EnemyA(5.0f, 5.0f, layer_middle));
	}

	private void init_itemList() {
		// // actormanager = new ArrayList<Item>();

		// // coins
		// ActorManager.addActor(new Coin(6.0f, 59.0f, layer_middle));
		// ActorManager.addActor(new Coin(10.0f, 59.0f, layer_middle));
		// ActorManager.addActor(new Coin(3.0f, 59.0f, layer_middle));
		// ActorManager.addActor(new Coin(6.0f, 58.0f, layer_middle));
		// ActorManager.addActor(new Coin(6.0f, 49.0f, layer_middle));
		// ActorManager.addActor(new Coin(6.0f, 50.0f, layer_middle));
		// ActorManager.addActor(new Coin(6.0f, 51.0f, layer_middle));
		// ActorManager.addActor(new Coin(8.0f, 8.0f, layer_middle));
		// ActorManager.addActor(new Coin(9.0f, 7.0f, layer_middle));
		// ActorManager.addActor(new Coin(10.0f, 7.0f, layer_middle));
		// ActorManager.addActor(new Coin(11.0f, 7.0f, layer_middle));
		// ActorManager.addActor(new Coin(12.0f, 8.0f, layer_middle));
		
		// // keys
		// ActorManager.addActor(new Key(9.0f, 13.5f, layer_middle));
		// ActorManager.addActor(new Key(2.0f, 28.5f, layer_middle));
		// // items.add(new Key(1.0f, 1.0f, layer_middle));
		
		// // hearts
		// ActorManager.addActor(new Heart(15.0f, 13.0f, layer_middle));
		// ActorManager.addActor(new Heart(16.0f, 13.0f, layer_middle));
		// ActorManager.addActor(new Heart(17.0f, 13.0f, layer_middle));
		// ActorManager.addActor(new Heart(15.0f, 12.0f, layer_middle));
		// ActorManager.addActor(new Heart(16.0f, 12.0f, layer_middle));
		// ActorManager.addActor(new Heart(17.0f, 12.0f, layer_middle));
		// ActorManager.addActor(new Heart(15.0f, 11.0f, layer_middle));
		// ActorManager.addActor(new Heart(16.0f, 11.0f, layer_middle));
		// ActorManager.addActor(new Heart(17.0f, 11.0f, layer_middle));
		// ActorManager.addActor(new Heart(70.4375f, 51.0f, layer_middle));
		// ActorManager.addActor(new Heart(69.4375f, 50.0f, layer_middle));
		// ActorManager.addActor(new Heart(68.4375f, 50.0f, layer_middle));
		// ActorManager.addActor(new Heart(67.4375f, 51.0f, layer_middle));
		// ActorManager.addActor(new Heart(67.4375f, 52.0f, layer_middle));
		// ActorManager.addActor(new Heart(68.4375f, 51.0f, layer_middle));
		// ActorManager.addActor(new Heart(69.4375f, 51.0f, layer_middle));
		// ActorManager.addActor(new Heart(69.4375f, 52.0f, layer_middle));
		// ActorManager.addActor(new Heart(69.4375f, 53.0f, layer_middle));
		// ActorManager.addActor(new Heart(68.4375f, 52.0f, layer_middle));
		// ActorManager.addActor(new Heart(71.4375f, 50.0f, layer_middle));
		// ActorManager.addActor(new Heart(72.4375f, 50.0f, layer_middle));
		// ActorManager.addActor(new Heart(73.4375f, 51.0f, layer_middle));
		// ActorManager.addActor(new Heart(73.4375f, 52.0f, layer_middle));
		// ActorManager.addActor(new Heart(72.4375f, 51.0f, layer_middle));
		// ActorManager.addActor(new Heart(72.4375f, 52.0f, layer_middle));
		// ActorManager.addActor(new Heart(72.4375f, 53.0f, layer_middle));
		// ActorManager.addActor(new Heart(71.4375f, 54.0f, layer_middle));
		// ActorManager.addActor(new Heart(71.4375f, 53.0f, layer_middle));
		// ActorManager.addActor(new Heart(71.4375f, 52.0f, layer_middle));
		// ActorManager.addActor(new Heart(71.4375f, 51.0f, layer_middle));
		// ActorManager.addActor(new Heart(70.4375f, 55.0f, layer_middle));
		// ActorManager.addActor(new Heart(70.4375f, 54.0f, layer_middle));
		// ActorManager.addActor(new Heart(70.4375f, 53.0f, layer_middle));
		// ActorManager.addActor(new Heart(70.4375f, 52.0f, layer_middle));
		// ActorManager.addActor(new Heart(69.4375f, 54.0f, layer_middle));
		// ActorManager.addActor(new Heart(68.4375f, 53.0f, layer_middle));
		
		// // 1 ups
		// ActorManager.addActor(new ExtraLife(10.0f, 5.0f, layer_middle));
	}
	
	private void init_doorList() {
		// //doors = new ArrayList<Door>();
		// ActorManager.addActor(new Door(20.5f, 12.5f, layer_middle));
		// ActorManager.addActor(new Door(4.5f, 33.0f, layer_middle));
	}

	private void init_player() {
		// //player = new Player(2.0f, 2.0f, layer_middle);
		// System.out.println("init player");
		// player = new Player(2,3, layer_middle);
		// ActorManager.setPlayer(player);
	}

	@Override
	public void draw(Graphics2D g) {
		// layer_back.draw(g);
		// //bg.draw(g);
		// layer_middle.draw(g);
		// ActorManager.drawActors(g);
		// /*player.draw(g);
	// drawEnemies(g);
	// drawItems(g);
	// drawDoors(g);*/
		// hud.draw(g);
		// if (shouldDrawPlayerStats) {
			// g.setColor(Color.WHITE);
			// g.drawString("xtile: " + player.getXTile(), 100, 100);
			// g.drawString("ytile: " + player.getYTile(), 100, 120);
			// g.drawString("falling: " + player.isFalling(), 100, 140);
			// g.drawString("climbing: " + player.isClimbing(), 100, 160);
			// g.drawString("vy: " + player.getVY(), 10, 20);
			// g.drawString("vx: " + player.getVX(), 10, 30);	    
			// if (player.isHoldingUp()) {
				// g.drawString("O", 140, 180);
			// } else {
				// g.drawString("X", 140, 180);
			// }
			// if (player.isHoldingLeft()) {
				// g.drawString("O", 130, 200);
			// } else {
				// g.drawString("X", 130, 200);
			// }
			// if (player.isHoldingRight()) {
				// g.drawString("O", 150, 200);
			// } else {
				// g.drawString("X", 150, 200);
			// }
			// if (player.isHoldingDown()) {
				// g.drawString("O", 140, 220);
			// } else {
				// g.drawString("X", 140, 220);
			// }
		// }
		// //g.drawImage(tileSprites.getSprite(5), 100, 100, null);
		// //layer_front.draw(g);
	}

	/*public void drawItems(Graphics2D g) {
	for (int i = 0; i < actormanager.size(); i++) {
		if (actormanager.get(i).isOnScreen(player)) {
		actormanager.get(i).draw(g);
		}
	}
	}
	
	public void drawEnemies(Graphics2D g) {
	for (int i = 0; i < actormanager.size(); i++) {
		if (actormanager.get(i).isOnScreen(player)) {
		actormanager.get(i).draw(g);
		}
	}
	}
	
	public void drawDoors(Graphics2D g) {
	for (int i = 0; i < actormanager.size(); i++) {
		if (actormanager.get(i).isOnScreen(player)) {
		actormanager.get(i).draw(g);
		}
	}
	}*/
	
	public void checkActorCollisions() {
		// ActorManager.checkActorCollisions();	
	}

	@Override
	public void processInput() {
		// if (!player.isDead()) {
			// if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
				// player.setHoldingLeft(false);
				// player.setHoldingRight(false);
				// player.setHoldingUp(false);
				// player.setHoldingDown(false);
				// GameStateManager.changeGameState(new GameState_Pause(this));
			// } /*else if (key == KeyEvent.VK_2) {
		// shouldDrawPlayerStats = !shouldDrawPlayerStats;
		// }*/ else if (GamePad.wasJustPressed(GamePad.BUTTON_3)) {
				// GameStateManager.changeGameState(new GameState_Dialog(this, new DialogBox("YOU FOUND A KEY! YOU CAN USE IT TO OPEN A LOCKED DOOR. LOOK, THERE IS ONE OVER THERE. TO OPEN THE DOOR, WALK UP TO IT.", 32, 32)));
			// }
		// }
	}



	@Override
	public void tick() {
		// if (player.isDead()) {
			// if (player.getCurrentAnimation_animation().hasBeenPlayedOnce()) {
				// if (player.getLives() == 0) {
					// GameStateManager.changeGameState(new GameState_GameOver(this));
				// } else {
					// player.reset();
					// player.setXTile(2.0f);
					// player.setYTile(2.0f);
					// player.setVX(0.0f);
					// player.setVY(0.0f);
				// }
			// }
		// }
		// ActorManager.moveActors();
		// ActorManager.checkCollisions();
		// hud.tick();
		// ActorManager.tickActors();
		// ActorManager.updateActorList();
		// layer_middle.setFocusPoint(player.getXTile(), player.getYTile());
		// layer_front.setFocusPoint(player.getXTile(), player.getYTile());
		// layer_back.setFocusPoint(player.getXTile(), player.getYTile());
		// System.out.println(player.getXTile() + "\t" + player.getYTile());
		// //System.out.println(player.getCoins());
	}

	@Override
	public void loadResources() {
		// ResourceManager.clearTextures();
		// ResourceManager.clearTileMaps();
		
		// ResourceManager.loadTexture("spritesheet_coin_2");
		// ResourceManager.loadTexture("spritesheet_door");
		// ResourceManager.loadTexture("spritesheet_enemyA_test");
		// ResourceManager.loadTexture("spritesheet_extralife");
		// ResourceManager.loadTexture("spritesheet_heart");
		// ResourceManager.loadTexture("spritesheet_hud");
		// ResourceManager.loadTexture("spritesheet_key");
		// ResourceManager.loadTexture("spritesheet_player_test_2");
		// ResourceManager.loadTexture("spritesheet_test");
		// ResourceManager.loadTexture("spritesheet_text");
		
		// ResourceManager.loadTileMap("tilemap_level1_layer_back");
		// ResourceManager.loadTileMap("tilemap_level1_layer_middle");
		// ResourceManager.loadTileMap("tilemap_level1_layer_front");
	}

}
