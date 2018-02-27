package managers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import loaders.RoomLoader;
import map.Tile;
import entity.Actor;
import entity.Coin;
import entity.Door;
import entity.Enemy;
import entity.EnemyA;
import entity.Exit;
import entity.ExtraLife;
import entity.Heart;
import entity.Item;
import entity.Key;
import entity.Player;
import entity.RoomExit;
import entity.RoomExitDoor;
import entity.WaterBox;
import gamestate.GameState_RoomTransition;

public final class ActorManager {
    
    public static Player player;
    public static List<Actor> actors = new ArrayList<Actor>();
    
    public ActorManager(/*Player p*/) {
//	//player = p;
//	player = new Player(0, 0, null);
//	actors = new ArrayList<Actor>();
    }
    
    public static void addActor(Actor a) {
	actors.add(a);
    }
    
    /**
     * @return
     */
    public static boolean checkActorCollisions() {
	for (int i = 0; i < actors.size(); i++) {
	    if (player.collidesWith(actors.get(i))) {
		// maybe include a collide with player method in tangibleActor class?
		// actor - tangible/intangibleActor - items/doors/entities - ...
		Actor actor = actors.get(i);
		if (actor instanceof Item) {
		    if (actor instanceof Coin) {
			if (actor.getCurrentAnimation_int() != Item.ANIMATION_COLLECTED) {
			    player.collectCoin();
			    ((Coin) actor).collect();
			    return true;
			}
		    } else if (actor instanceof Heart) {
			if (actor.getCurrentAnimation_int() != Item.ANIMATION_COLLECTED) {
			    player.collectHeart();
			    ((Heart) actor).collect();
			    return true;
			}
		    } else if (actor instanceof Key) {
			if (actor.getCurrentAnimation_int() != Item.ANIMATION_COLLECTED) {
			    player.collectKey();
			    ((Key) actor).collect();
			    return true;
			}
		    } else if (actor instanceof ExtraLife) {
			if (actor.getCurrentAnimation_int() != Item.ANIMATION_COLLECTED) {
			    player.collectExtraLife();
			    ((ExtraLife) actor).collect();
			    return true;
			}
		    }
		} else if (actor instanceof Enemy) {
		    if (actor instanceof EnemyA) {
			player.takeDamage((Enemy) actor);
			return true;
		    }
		} else if (actor instanceof Door) {
		    if (player.getVX() < 0) {
			player.setVX(0);
			player.setXTile(actor.getXTile() + ((float) (actor.getCollWidth() / (2 * 16f))) + ((float) (player.getCollWidth() / (2 * 16f))));
			if (player.getKeys() > 0) {
			    player.useKey();
			    ((Door) actor).open();
			}
		    } else if (player.getVX() > 0) {
			player.setVX(0);
			player.setXTile(actor.getXTile() - ((float) (actor.getCollWidth() / (2 * 16f))) - ((float) (player.getCollWidth() / (2 * 16f))));
			if (player.getKeys() > 0) {
			    player.useKey();
			    ((Door) actor).open();
			}
		    }
		    return true;
		} else if (actor instanceof Exit) {
		    if (actor instanceof RoomExit) {
			if (actor instanceof RoomExitDoor) {
			    if (actor.contains(player)) {
				if (GamePad.wasJustPressed(GamePad.BUTTON_UP)) {
				    GameStateManager.changeGameState(
					    new GameState_RoomTransition(
						    GameStateManager.currentState,
						    SceneManager.currentScene.getCurrentRoom(),
						    (RoomExit) actor
					    )
				    );
				    
				}
			    }
			}
		    }
		    
		} else if (actor instanceof WaterBox) {
		    int waterLevel = actor.getYPix() - actor.getCollHeight() / 2;
		    //System.out.println(player.getYPix() + "       " + waterLevel);

		    if (player.getYPix() >= waterLevel) {
			player.setYTile(Tile.convertPixelsToTiles(waterLevel));
			player.setFalling(false);
			player.setVY(0);
			player.setCurrentAnimation(Player.ANIMATION_SWIMMING);
			player.setSwimming(true);
		    }
		}
	    }
	}
	return false;
    }
    
    public static void tickActors() {
	player.tick();
	for (int i = 0; i < actors.size(); i++) {
	    actors.get(i).tick();
	}
    }
    
    public static void updateActorList() {
	for (int i = 0; i < actors.size(); i++) {
	    Actor actor = actors.get(i);
	    if (actor instanceof Item) {
		if (((Item) actor).getCurrentAnimation_int() == Item.ANIMATION_COLLECTED) {
		    if (((Item) actor).getCurrentAnimation_animation().hasBeenPlayedOnce()) {
			actors.remove(i);
			i--;
		    }
		}
	    } else if (actor instanceof Enemy) {
		
	    } else if (actor instanceof Door) {
		if (actor.getCurrentAnimation_int() == Door.UNLOCKED && actor.getCurrentAnimation_animation().hasBeenPlayedOnce()) {
		    actors.remove(i);
		    i--;
		}
	    }
	}
    }
    
    public static void drawActors(Graphics2D g) {
	
	for (int i = 0; i < actors.size(); i++) {
	    actors.get(i).draw(g);
	}
	player.draw(g);
    }
    
    public static void moveActors() {
	player.move();
	for (int i = 0; i < actors.size(); i++) {
	    actors.get(i).move();
	}
    }
    
    /*public void checkTileCollisions() {
	player.checkTileCollisions();
	for (int i = 0; i < actors.size(); i++) {
	    actors.get(i).checkTileCollisions();
	}
    }*/
    
    public static void checkCollisions() {// create stepPlayer and step actor methods
	// variables to use
	int iterationsY;
	int iterationsX;
	float remainderY;
	float remainderX;
	boolean shouldCheckRemainderY;
	boolean shouldCheckRemainderX;
	float intervalY;
	float intervalX;
	
	// player
	
//	player.move();
	
        iterationsY = Math.abs((int) player.getVY());//(int) Math.abs(player.vy);
	iterationsX = Math.abs((int) player.getVX());//(int) Math.abs(player.vx);
	remainderY = Math.signum(player.getVY()) * (Math.abs(player.getVY()) - iterationsY);//(int) (Math.abs(player.vy)));
	remainderX = Math.signum(player.getVX()) * (Math.abs(player.getVX()) - iterationsX);//(int) (Math.abs(player.vx)));
	shouldCheckRemainderY = true;
	shouldCheckRemainderX = true;
	intervalY = Math.signum(player.getVY());
	intervalX = Math.signum(player.getVX());
	
	for (int iy = 0, ix = 0; iy < iterationsY || ix < iterationsX; iy++, ix++) {
	    // vertical
	    if (iy < iterationsY) {
		boolean wasTileCollisionY = false;
		boolean wasActorCollisionY = false;
		wasTileCollisionY = player.stepY(intervalY);
		if (!wasTileCollisionY) {
		    wasActorCollisionY = checkActorCollisions();
		    if (wasActorCollisionY) {
			shouldCheckRemainderY = false;
			iy = iterationsY;
		    }
		} else {
		    shouldCheckRemainderY = false;
		    iy = iterationsY;
		}
	    }
	    if (ix < iterationsX) {
		boolean wasTileCollisionX = false;
		boolean wasActorCollisionX = false;
		System.out.println("int");
		wasTileCollisionX = player.stepX(intervalX);
		if (!wasTileCollisionX) {
		    wasActorCollisionX = checkActorCollisions();
		    if (wasActorCollisionX) {
			shouldCheckRemainderX = false;
			ix = iterationsX;
		    }
		} else {
		    shouldCheckRemainderX = false;
		    ix = iterationsX;
		}
	    }
	}
	if (shouldCheckRemainderY) {
	    boolean wasTileCollisionY = false;
	    wasTileCollisionY = player.stepY(remainderY);
	    if (!wasTileCollisionY) {
		checkActorCollisions();
	    }
	}
	if (shouldCheckRemainderX) {
	    boolean wasTileCollisionX = false;
	    wasTileCollisionX = player.stepX(remainderX);
	    if (!wasTileCollisionX) {
		checkActorCollisions();
	    }
	}
    }

    public static void clearActors() {
	actors.clear();
    }
    
    public static Player getPlayer() {
	return player;
    }
    
    public static void setPlayer(Player p) {
	player = p;
    }
    
    public static void processInput() {
	//player.processInput();
    }
}
