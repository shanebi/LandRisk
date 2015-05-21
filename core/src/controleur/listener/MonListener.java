package controleur.listener;

import vue.screen.nouvCam;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;

import controleur.Manager;

public class MonListener implements EventListener {
	private nouvCam nc;

	public MonListener(nouvCam nc) {
		this.nc = nc;
	}

	@Override
	public boolean handle(Event event) {
		
		//nc.getJoueur().setText("OKOKOK");
		event.getStage().draw();

		return false;
	}

}
