package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import text.LabelBox;
import main.Screen;
import managers.ActorManager;
import managers.GamePad;
import managers.GameStateManager;
import managers.ResourceManager;

public class GameState_TitleScreen extends GameState {

	private LabelBox title;
	private LabelBox pressStart;
	private LabelBox version;
	
	public GameState_TitleScreen() {
		super();
		//loadResources();
		title = new LabelBox("TITLE SCREEN", 100, 100);
		pressStart = new LabelBox("PRESS ENTER", 100, 120);
		version = new LabelBox("VERSION 10.0", 100, 140);
	}

	@Override
	public void processInput() {
		if (GamePad.wasJustPressed(GamePad.BUTTON_START)) {
			GameStateManager.changeGameState(new GameState_StartMenu());
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		//	g.setFont(new Font("MSSansSerif", Font.PLAIN, (int) (15)));
		g.fillRect(0, 0, Screen.WIDTH, Screen.HEIGHT);
		//	g.setColor(Color.WHITE);
		//	g.drawString("title screen", Screen.WIDTH / 3, Screen.HEIGHT / 3);
		//	g.drawString("<version 8.0>press enter", 0,
		//		Screen.HEIGHT / 2);
		title.draw(g);
		pressStart.draw(g);
		version.draw(g);
	}

	@Override
	public void tick() {
		// do nothing
	}

	@Override
	public void loadResources() {
		ResourceManager.clearTextures();
		ResourceManager.clearTileMaps();
		
		ResourceManager.loadTexture("spritesheet_text");
	}

}
