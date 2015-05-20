package lrp.mygdx.game;

import com.badlogic.gdx.Game;

import vue.screen.ImageLancement;



public class MyGdxGame extends Game{

	@Override
	public void create() {

		setScreen(new ImageLancement(this));

	}
}
