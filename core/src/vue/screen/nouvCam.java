package vue.screen;

import java.util.Vector;

//import vue.Cercle;
import vue.Ligne;
import lrp.mygdx.game.MyGdxGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import controleur.AdaptEcran;

public class nouvCam implements Screen{
	MyGdxGame game;
	 Texture otarie;
	 TextureRegion MonOtarie;
	 SpriteBatch batch;
	 OrthographicCamera camera;
	 BitmapFont fontPerso;
	 LabelStyle style;
	 Label titre;
	 
	 private Stage stage;

		private int nbC =0;
		//private Vector<Cercle> TCercle = new Vector<Cercle>();

		private float x ;
		private float y ;

		private boolean dep = false;
		private float x1 ;
		private float y1 ;
		boolean visible = false;

		Vector<Vector<Float>> contenu = new Vector<Vector<Float>>();
	 
	 int x0, y0; // position du doigt

		int lastx0; // précédente position du 1er doigt
		int lasty0; // précédente position du 1er doigt

		public static float vitesse_deplacement_camera = 20;


		private int limite_image_maxLargeur; // limite déplacement camera
		public static int limite_image_minHauteur = 0; // limite déplacement camera
		public static int limite_image_minLargeur = 0; // limite déplacement camera
	private float largeur_Ecran;
	private float hauteur_Ecran;
	 
	 public nouvCam(MyGdxGame g) {

			game = g;
			//supprimer MyGD2GdxGame de toute les constructeur
			

		}

	

	@Override
	public void resize(int width, int height) {
		
		  camera.setToOrtho(false,width,height);
		
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {

		MonOtarie.getTexture().dispose();
		  batch.dispose();
	}

	@Override
	public void show() {
		largeur_Ecran = AdaptEcran.setEcranLargeur(420);
		hauteur_Ecran = AdaptEcran.setEcranLargeur(250);
		 // load assets
		  otarie=new Texture(Gdx.files.internal("map3.png"));
		  limite_image_maxLargeur = otarie.getWidth() / 2;
		  MonOtarie=new TextureRegion(otarie,0,0,1024,512);
		  limite_image_maxLargeur = otarie.getWidth() / 2;
		  batch=new SpriteBatch();
		  // create viewport
		  camera=new OrthographicCamera();
		  
		  
		  batch = new SpriteBatch();
			stage = new Stage();

			/*

			//cercles amerique
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(50), AdaptEcran.setEcranLargeur(230), AdaptEcran.setEcranLargeur(11)));
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(70), AdaptEcran.setEcranLargeur(190), AdaptEcran.setEcranLargeur(11)));
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(110), AdaptEcran.setEcranLargeur(120), AdaptEcran.setEcranLargeur(11)));
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(110), AdaptEcran.setEcranLargeur(80), AdaptEcran.setEcranLargeur(11)));
			
			//europe
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(210), AdaptEcran.setEcranLargeur(230), AdaptEcran.setEcranLargeur(11)));
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(250), AdaptEcran.setEcranLargeur(240), AdaptEcran.setEcranLargeur(11)));
			//afrique
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(230), AdaptEcran.setEcranLargeur(170), AdaptEcran.setEcranLargeur(11)));
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(250), AdaptEcran.setEcranLargeur(110), AdaptEcran.setEcranLargeur(11)));
			//russi
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(290), AdaptEcran.setEcranLargeur(220), AdaptEcran.setEcranLargeur(11)));
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(370), AdaptEcran.setEcranLargeur(230), AdaptEcran.setEcranLargeur(11)));
			//australie
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(340), AdaptEcran.setEcranLargeur(120), AdaptEcran.setEcranLargeur(11)));
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(380), AdaptEcran.setEcranLargeur(130), AdaptEcran.setEcranLargeur(11)));


			//ajouter au stage
			while(nbC < TCercle.size()){
				stage.addActor(TCercle.get(nbC));
				nbC++;
			}
			nbC =0;
			
			*/
			//l'ecriture
			fontPerso = new BitmapFont(Gdx.files.internal("default.fnt"));
			style = new LabelStyle(fontPerso, Color.BLACK);
			titre = new Label(null, style);
		
			stage.draw();
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1,1,1, 1);
		  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		  manipulerJeu();
		  // render our images
		  batch.setProjectionMatrix(camera.combined);
		  batch.begin();
		  fontPerso = new BitmapFont(Gdx.files.internal("default.fnt")
					 ,Gdx.files.internal("default.png"), false);
					style = new LabelStyle(fontPerso, new Color(Color.YELLOW));//fonte et couleur
					titre = new Label("Interface de jeu", style);
					titre.setPosition(5, 5);//positionne à l'écran
		  batch.draw(MonOtarie,0,40,largeur_Ecran,hauteur_Ecran);
		  batch.end();
		  
		  calculePoint();
		  
		  if(visible){while(nbC < contenu.size()){

				Ligne l4 = new Ligne();
				l4.dessiner(contenu.get(nbC).get(0), contenu.get(nbC).get(1), 
						contenu.get(nbC).get(2), contenu.get(nbC).get(3));

				nbC++;}
			}nbC=0;

/*
			while(nbC < TCercle.size()){
				TCercle.get(nbC).dessiner(batch, Color.RED, ""+nbC);
				nbC++;
			}
			nbC=0;
			*/
			titre.setText("hgfghgfdghjgfdgh");
			titre.setPosition(1,1);

			stage.addActor(titre);
			stage.draw();
			
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void calculePoint(){

		if (Gdx.input.isTouched()){

			if(!dep){
				x = Gdx.input.getX();
				y = (Gdx.graphics.getHeight()-Gdx.input.getY());
/*
				while(nbC < TCercle.size()){
					if(x< TCercle.get(nbC).getX()+25 && x> TCercle.get(nbC).getX()-25 && y< TCercle.get(nbC).getY()+25  && y> TCercle.get(nbC).getY()-25){
						x = Gdx.input.getX();
						y = (Gdx.graphics.getHeight()-Gdx.input.getY());
						dep= true;
						System.out.println("prem's");
					}
					nbC++;
				}
				nbC=0;
*/

			}

			else if(dep){
				x1 = Gdx.input.getX();
				y1 = (Gdx.graphics.getHeight()-Gdx.input.getY());
/*
				while(nbC < TCercle.size()){
					if(x1< TCercle.get(nbC).getX()+25 && x1> TCercle.get(nbC).getX()-25 && y1< TCercle.get(nbC).getY()+25  && y1> TCercle.get(nbC).getY()-25){
						if(x!=x1)
							if(zoneVerification(x,y,x1,y1)){
								Vector<Float> ligne = new Vector<Float>();
								ligne.add(x);
								ligne.add(y);
								ligne.add(x1);
								ligne.add(y1);
								contenu.add(ligne);
								System.out.println(contenu);
								visible=true;
								dep=false;
							}
					}
					nbC++;
				}
				nbC=0;
*/
			}

		}
	}

	public boolean zoneVerification(float x,float y,float x1,float y1){
		boolean unisiter = true;

		for(int i=0;i<contenu.size();i++){
			if(contenu.get(i).get(0).equals(x) && contenu.get(i).get(1).equals(y) && contenu.get(i).get(2).equals(x1) && contenu.get(i).get(3).equals(y1)){
				unisiter = false;
			}
		}
		return unisiter;

	}
	
	public void manipulerJeu()

	{

		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}
			
		});

	}

}
