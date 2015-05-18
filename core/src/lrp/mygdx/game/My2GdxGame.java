package lrp.mygdx.game;

import com.badlogic.gdx.Game;
import vue.sceens.ImageLancement;



public class My2GdxGame extends Game{

	@Override
	public void create() {

		setScreen(new ImageLancement(this));

	}
}
