package managers;

import java.awt.Graphics2D;

import loaders.RoomLoader;
import map.Room;
import map.Scene;

public final class SceneManager {

    public static Scene currentScene;
    
    public static void draw(Graphics2D g) {
	currentScene.draw(g);
    }
    
    public static void tick() {
	currentScene.tick();
    }
    
    public static void loadResources() {
	currentScene.loadResources();
    }

}
