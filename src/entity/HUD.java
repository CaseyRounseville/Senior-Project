package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.Screen;
import sprite.SpriteSheet;
import text.LabelBox;

public class HUD {
    
    private Player player;
    private int playerHealth;
    private int playerCoins;
    private int playerLives;
    private int playerKeys;
    
    // labels
    private LabelBox coins;
    private LabelBox lives;
    private LabelBox keys;
        
    private static final SpriteSheet sprites = new SpriteSheet("spritesheet_hud", 16, 16);
    private byte[][] layout = {
	    {12, 12, 12, 12, 12, 12,  0,  1,  1,  1,  1,  1,  1,  2,  12, 12, 12, 12, 12, 12},
	    {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12}
    };
    
    public HUD(Player player) {
	this.player = player;
	playerHealth = player.getHealth();
	playerLives = player.getLives();
	playerCoins = player.getCoins();
	playerKeys = player.getKeys();
	
	coins = new LabelBox(":" + playerCoins, 272, 0);
	lives = new LabelBox(":" + playerLives, 48, 0);
	keys = new LabelBox(((char) 76 + 32) + ":" + playerKeys, 290, 8);
	
    }
    
    public void calculateHearts(int[] hearts) {
	int qHearts = playerHealth;
	for (int i = 0; i < hearts.length; i++) {
	    qHearts -= 4;
	    if (qHearts >= 0) {
		hearts[i] = 3;
	    } else {
		switch (qHearts) {
		case -1:
		    hearts[i] = 4;
		    break;
		case -2:
		    hearts[i] = 5;
		    break;
		case -3:
		    hearts[i] = 6;
		    break;
		default:
		    hearts[i] = 7;
		    break;
		}
	    }
	}
    }
    
    public void draw(Graphics2D g) {
	int[] hearts = new int[6];
	calculateHearts(hearts);
	
	// draw background hud
	for (int row = 0; row < layout.length; row++) {
	    for (int col = 0; col < layout[row].length; col ++) {
		g.drawImage(
			sprites.getSprite(layout[row][col]),
			col * 16,
			row * 16,
			null
		);
	    }
	}
	
	// draw hearts
	for (int i = 0; i < hearts.length; i++) {
	    g.drawImage(
		sprites.getSprite(hearts[i]),
		Screen.WIDTH / 2 - hearts.length / 2 * 16 + i * 16,
		0,
		null		
	    );
	}
	
	// draw coins, lives, and keys
	//g.setFont(new Font("Lucida Console", Font.PLAIN, 16));
	//g.setFont(new Font("Tahoma", Font.BOLD, 16));
//	g.setFont(new Font("MSSansSerif", Font.PLAIN, 15));
//	g.setColor(Color.WHITE);
//	g.drawString("" + playerCoins, 272, 14);
//	g.drawString("" + playerLives, 48, 14);
//	g.drawString("" + playerKeys, 288, 28);
	coins.draw(g);
	lives.draw(g);
	keys.draw(g);
    }
    
    public void tick() {
	playerHealth = player.getHealth();
	playerLives = player.getLives();
	playerCoins = player.getCoins();
	playerKeys = player.getKeys();
	
	coins = new LabelBox("" + (char) (107) + ":" + playerCoins, 256, 0);
	lives = new LabelBox("" + (char) (108) + ":" + playerLives, 0, 0);
	keys = new LabelBox("" + (char) 108 + ":" + playerKeys, 256, 8);
    }
}
