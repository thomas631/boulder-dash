package fr.enssat.BoulderDash.views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.enssat.BoulderDash.models.LevelModel;


/**
 * InformationPanel
 *
 * Information panel element.
 *
 * @author      Colin Leverger <me@colinleverger.fr>
 * @since       2015-06-20
 */
public class InformationPanel extends JPanel implements Observer {
	private LevelModel levelModel;
	private JTextArea text;

    /**
     * Class constructor
     */
	public InformationPanel(LevelModel levelModel) {
		this.levelModel = levelModel;
		this.text = new JTextArea();
		this.levelModel.getGameInformationsModel().addObserver(this);
		this.text.setText("Score : " + levelModel.getGameInformationsModel().getScore() + 
				"\nRemaining diamonds : " + levelModel.getGameInformationsModel().getRemainingsDiamonds());
		this.add(this.text);
	}

    /**
     * Updates the panel
     *
     * @param   o    Observable item
     * @param   arg  Object item
     */
	@Override
	public void update(Observable o, Object arg) {
		this.text.setText("Score : " + this.levelModel.getGameInformationsModel().getScore() +
				"\nRemaining diamonds : " + this.levelModel.getGameInformationsModel().getRemainingsDiamonds());
	}
}
