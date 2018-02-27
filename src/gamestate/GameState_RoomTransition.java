package gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import entity.Exit;
import entity.Player;
import entity.RoomExit;
import loaders.RoomLoader;
import main.Screen;
import managers.ActorManager;
import managers.GamePad;
import managers.GameStateManager;
import managers.SceneManager;
import map.Room;

public class GameState_RoomTransition extends GameState {

    private GameState prevState;

    private Room currentRoom;
    private Room nextRoom;
    
    private RoomExit exit;

    public static final int TRANSITION_UP = 0;
    public static final int TRANSITION_DOWN = 1;
    public static final int TRANSITION_LEFT = 2;
    public static final int TRANSITION_RIGHT = 3;
    public static final int TRANSITION_FADEBLACK = 4;
    public static final int TRANSITION_FADEWHITE = 5;
    
    public static final int NUM_FRAMES = 60;    
    private int frameCounter;
    private int amountToChange;

    private int transitionType;

    private boolean isDone;

    public GameState_RoomTransition(GameState prevState, Room currentRoom, RoomExit exit) {
	this.prevState = prevState;
	this.currentRoom = currentRoom;
	this.exit = exit;
	transitionType = exit.getTransitionType();
	GamePad.releaseAll();
	if (transitionType != TRANSITION_FADEBLACK && transitionType != TRANSITION_FADEWHITE) {
	    this.nextRoom = RoomLoader.loadRoom(exit.getOtherRoomIndex());
	} else {
	    this.nextRoom = null;
	}
	
	
	
	frameCounter = 0;
	amountToChange = 0;
	
	isDone = false;
    }

    @Override
    public void draw(Graphics2D g) {
	if (transitionType == TRANSITION_FADEBLACK || transitionType == TRANSITION_FADEWHITE) {
	    drawFade(g);
	} else {
	    currentRoom.draw(g);
	    nextRoom.draw(g);
	}
    }

    private void drawFade(Graphics2D g) {
	SceneManager.currentScene.getCurrentRoom().draw(g);
	BufferedImage img = Screen.getImage();
	int[] pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	for (int i = 0; i < pixels.length; i ++) {
	    int rgb = pixels[i];
	    Color c = new Color(rgb);
	    int red = c.getRed();
	    int green = c.getGreen();
	    int blue = c.getBlue();

	    if (transitionType == TRANSITION_FADEBLACK) {
		red -= amountToChange;
		green -= amountToChange;
		blue -= amountToChange;
		
		if (red < 0) red = 0;
		if (green < 0) green = 0;
		if (blue < 0) blue = 0;
	    } else {

		red += amountToChange;
		green += amountToChange;
		blue += amountToChange;
		
		if (red > 255) red = 255;
		if (green > 255) green = 255;
		if (blue > 255) blue = 255;
	    }

	    Color c2 = new Color(red, green, blue);
	    pixels[i] = c2.getRGB();
	}
	g.drawImage(img, 0, 0, null);
	
    }

    @Override
    public void processInput() {
	// pausing during loading causes the game to crash
    }

    @Override
    public void tick() {
	
	isDone = frameCounter == NUM_FRAMES;
	
	if (!isDone) {
	    switch (transitionType) {
	    case TRANSITION_UP:
		moveUp();
		break;
	    case TRANSITION_DOWN:
		moveDown();
		break;
	    case TRANSITION_LEFT:
		moveLeft();
		break;
	    case TRANSITION_RIGHT:
		moveRight();
		break;
	    case TRANSITION_FADEBLACK:
		fade();
		break;
	    case TRANSITION_FADEWHITE:
		fade();
	    default:
		break;
	    }
	    frameCounter++;
	} else {
	    frameCounter = 0;
	    GameStateManager.changeGameState(prevState);
	}
    }

    private void fade() {// 255 / 30 = 8.5
	System.out.println(frameCounter);
	if (frameCounter == NUM_FRAMES / 2) {
	    System.out.println("///////////////// loading from rommtrans");
	    ActorManager.clearActors();
	    this.nextRoom = RoomLoader.loadRoom(exit.getOtherRoomIndex());
	    SceneManager.currentScene.setCurrentRoom(nextRoom);
	    Player p = ActorManager.getPlayer();
	    p.setTileMap(nextRoom.getTileMap());
	    p.setXTile(exit.getPlayerSpawnX());
	    p.setYTile(exit.getPlayerSpawnY());
	    nextRoom.getTileMap().setFocusPoint(p.getXTile(), p.getYTile());
	} else {
	    if (frameCounter < NUM_FRAMES / 2) {
		amountToChange = frameCounter * (255 / (NUM_FRAMES / 2));
	    } else {
		amountToChange = (NUM_FRAMES - frameCounter) * (255 / (NUM_FRAMES / 2));
	    }
	}
    }

    private void moveRight() {
	// TODO Auto-generated method stub

    }

    private void moveLeft() {
	// TODO Auto-generated method stub

    }

    private void moveDown() {
	// TODO Auto-generated method stub

    }

    private void moveUp() {
	currentRoom.getCamera().setY(currentRoom.getCamera().getY() - 1);
	nextRoom.getCamera().setY(currentRoom.getCamera().getY() - 1);
	// getters & setters for max &min
	// nxt.set(nxt.max + max.h - (curr.y - curr.min))
	
	
    }

    @Override
    public void loadResources() {
	// Shouldn't need any
    }

}
