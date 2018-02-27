package map;

import java.awt.Graphics2D;
import java.util.List;

import main.Screen;
import managers.ActorManager;
import entity.Exit_OLD;
import entity.Player;

public class Room {

    private TileMap tilemap;
    private List<Exit_OLD> exits;

    public Room(TileMap tilemap) {
	this.tilemap = tilemap;
	// load actors according to record flags
    }
    
    public Camera getCamera() {
        return tilemap.getCamera();
    }
    
    public void draw(Graphics2D g) {
	//tilemap.setFocusPoint(ActorManager.getPlayer().getXTile(), ActorManager.getPlayer().getYTile());
	tilemap.draw(g);
	ActorManager.drawActors(g);
    }
    
    public void setTileMap(TileMap tm) {
	this.tilemap = tm;
    }

    public TileMap getTileMap() {
	return tilemap;
    }
    
    public void tick() {
	ActorManager.moveActors();
	ActorManager.checkCollisions();
	ActorManager.tickActors();
	ActorManager.updateActorList();
	
	// move camera
	Player player = ActorManager.getPlayer();
//	Camera c = getCamera();
//	c.setX(player.getXPix() - 80);
//	c.setY(player.getYPix() - 60);
//	c.fixBounds(tilemap.getNumRows(), tilemap.getNumCols());
	tilemap.setFocusPoint(player.getXTile(), player.getYTile());
	
    }

}
