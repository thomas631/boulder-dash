package fr.enssat.BoulderDash.views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import fr.enssat.BoulderDash.controllers.GameController;
import fr.enssat.BoulderDash.controllers.KeyController;
import fr.enssat.BoulderDash.models.LevelModel;
import fr.enssat.BoulderDash.models.RockfordModel;

//GameView is created by GameController
public class GameView extends JPanel implements Observer {
	private LevelModel levelModel;

	public GameView(GameController gameController, LevelModel levelModel) {
		this.levelModel = levelModel;
		this.levelModel.addObserver(this);

		addKeyListener(new KeyController(this.levelModel));
		setBorder(BorderFactory.createLineBorder(Color.black));
		setFocusable(true);
	}

	public void drawTerrain(int width, int height, Graphics g) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				g.drawImage(this.levelModel.getImage(x, y), x * 16, y * 16, this);
			}
		}
	}

	public void paint(Graphics g) {
		drawTerrain(this.levelModel.getSizeWidth(), this.levelModel.getSizeHeight(), g);
	}

	@Override
	public void update(Observable obs, Object obj) {
		repaint();
	}

}