package gamestate;

 import java.awt.Graphics2D;
// import java.awt.event.KeyEvent;
// import java.util.ArrayList;

// import managers.ActorManager;
// import managers.GamePad;
// import managers.GameStateManager;
// import map.TileMap;
// import sprite.SpriteSheet;
// import entity.Coin;
// import entity.Item;
// import entity.Player;

public class GameState_Level2 extends GameState {

	// // layers
	// private TileMap layer_back;
	// private TileMap layer_middle;
	// private TileMap layer_front;
	
	// // sprites
	// private static final SpriteSheet sprites = new SpriteSheet("spritesheet_level2", 16, 16);

	// // player
	// Player player;

	public GameState_Level2() {
		super();
		// //actormanager = new ArrayList<Item>();
		// layer_back = new TileMap(sprites, 
		// "tilemap_level2_layer_back");
		// layer_middle = new TileMap(sprites,
		// "tilemap_level2_layer_middle");
		// //layer_front = new TileMap("C:/Users/Casey R/Downloads/simple java game 3/32x32 tiles/16x16 tiles/spritesheet_test.png",
		// //	"C:/Users/Casey R/Downloads/simple java game 3/tilemap_level2_layer_front.txt", 1.0f);
		// init_player();
		// init_itemList();
	}

	private void init_itemList() {
		// ActorManager.clearActors();
		// ActorManager.addActor(new Coin(5.0f, 6.0f, layer_middle));
		// ActorManager.addActor(new Coin(7.0f, 10.0f, layer_middle));
		// ActorManager.addActor(new Coin(21.0f, 3.0f, layer_middle));
		// ActorManager.addActor(new Coin(4.9f, 6.0f, layer_middle));
		// ActorManager.addActor(new Coin(14.0f, 6.0f, layer_middle));
		// ActorManager.addActor(new Coin(13.0f, 6.0f, layer_middle));
		// ActorManager.addActor(new Coin(11.0f, 6.0f, layer_middle));
	}

	private void init_player() {
		// //player = new Player(2.0f, 28.0f, layer_middle);
		// ActorManager.getPlayer().setTileMap(layer_middle);
		// player = ActorManager.getPlayer();
	}

	@Override
	public void draw(Graphics2D g) {
		// layer_back.draw(g);
		// layer_middle.draw(g);
		// ActorManager.drawActors(g);
		// //player.draw(g);
		// //drawItems(g);
		// //layer_front.draw(g);
	}

	/*public void drawItems(Graphics2D g) {
	for (int i = 0; i < actormanager.size(); i++) {
		if (actormanager.get(i).isOnScreen(player)) {
		actormanager.get(i).draw(g);
		}
	}
	}*/

	@Override
	public void processInput() {
		//	if (GamePad.isDownNow(GamePad.BUTTON_LEFT)) {
		//	    player.setHoldingLeft(true);
		//	} else if (GamePad.isDownNow(GamePad.BUTTON_RIGHT) {
		//	    player.setHoldingRight(true);
		//	} else if (GamePad.isDownNow(GamePad.BUTTON_UP)) {
		//	    player.setHoldingUp(true);
		//	} else if (GamePad.isDownNow(GamePad.BUTTON_DOWN)) {
		//	    player.setHoldingDown(true);
		//	} else if (GamePad.isDownNow(GamePad.BUTTON_X)) {
		//	    player.setHoldingJump(true);
		//	}
	}

	@Override
	public void tick() {
		// //player.move();
		// ActorManager.checkActorCollisions();
		// ActorManager.tickActors();
		// ActorManager.moveActors();
		// layer_back.setFocusPoint(player.getXTile(), player.getYTile());
		// layer_middle.setFocusPoint(player.getXTile(), player.getYTile());
		// //layer_front.setFocusPoint(player.getXTile(), player.getYTile());	
	}

	@Override
	public void loadResources() {
		// TODO Auto-generated method stub
		
	}

}
