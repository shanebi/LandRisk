package vue.screen;

import java.util.Vector;

import vue.Ligne;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import controleur.AdaptEcran;

public class NouvCam implements Screen{
	
	 Texture otarie;
	 TextureRegion MonOtarie;
	 SpriteBatch batch;
	 BitmapFont fontPerso;
	 LabelStyle style;
	 Label joueur;
	 Label statue;
	 TextButton bouton1;
	 TextButton bouton3;
	 TextButton bouton10;
	 Skin skin;
	 
	 private Stage stage;

		private int nbC =0;
		private Vector<Cercle> TCercle = new Vector<Cercle>();

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
	private Texture btnUp;
	private Texture btnDown;
	private Texture btnChecked;
	

	

	@Override
	public void resize(int width, int height) {
		
		  //camera.setToOrtho(false,width,height);
		
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
		hauteur_Ecran = AdaptEcran.setEcranLargeur(260);
		 // load assets
		  otarie=new Texture(Gdx.files.internal("map/map3.png"));
		  limite_image_maxLargeur = otarie.getWidth() / 2;
		  MonOtarie=new TextureRegion(otarie,0,0,1024,512);
		  limite_image_maxLargeur = otarie.getWidth() / 2;
		  batch=new SpriteBatch();
		  // create viewport
		  //camera=new OrthographicCamera();
		  
		  
		  batch = new SpriteBatch();
			stage = new Stage();

			

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
			TCercle.add(new Cercle(AdaptEcran.setEcranLargeur(310), AdaptEcran.setEcranLargeur(220), AdaptEcran.setEcranLargeur(11)));
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
			
			
			createBasicSkin();
			
			bouton1 = new TextButton("1", skin); // Use the initialized skin
	        bouton1.setPosition(AdaptEcran.setEcranLargeur(420),AdaptEcran.setEcranLargeur(230));
	        stage.addActor(bouton1);
	        
	        bouton1.addListener( new ClickListener() {              
			    public void clicked(InputEvent event, float x, float y) {
			    	System.out.println("On quitte l'application.");
			    };
			});

	        bouton3 = new TextButton("3", skin); // Use the initialized skin
	        bouton3.setPosition(AdaptEcran.setEcranLargeur(420),AdaptEcran.setEcranLargeur(180));
	        stage.addActor(bouton3);
	        
	        bouton10 = new TextButton("10", skin); // Use the initialized skin
	        bouton10.setPosition(AdaptEcran.setEcranLargeur(420),AdaptEcran.setEcranLargeur(130));
	        stage.addActor(bouton10);
	        
			
			
			//l'ecriture
			fontPerso = new BitmapFont(Gdx.files.internal("default.fnt"));
			style = new LabelStyle(fontPerso, Color.BLACK);
			joueur = new Label(null, style);
			statue = new Label(null, style);
			
		
			stage.draw();
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1,1,1, 1);
		  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		  //manipulerJeu();
		  // render our images
		  batch.begin();
		  batch.draw(MonOtarie,AdaptEcran.setEcranLargeur(0), AdaptEcran.setEcranLargeur(20),largeur_Ecran,hauteur_Ecran);
		  batch.end();
		  
		  calculePoint();
		  
		  if(visible){while(nbC < contenu.size()){

				Ligne l4 = new Ligne();
				l4.dessiner(contenu.get(nbC).get(0), contenu.get(nbC).get(1), 
						contenu.get(nbC).get(2), contenu.get(nbC).get(3));

				nbC++;}
			}nbC=0;


			while(nbC < TCercle.size()){
				TCercle.get(nbC).dessiner(batch, Color.RED, ""+nbC);
				nbC++;
			}
			nbC=0;
			
			joueur.setText("joueur");
			joueur.setPosition(AdaptEcran.setEcranLargeur(10),AdaptEcran.setEcranLargeur(10));
			
			statue.setText("statue du  la partie");
			statue.setPosition(AdaptEcran.setEcranLargeur(60),AdaptEcran.setEcranLargeur(10));

			stage.addActor(joueur);
			stage.addActor(statue);
			stage.addActor(bouton1);
			stage.addActor(bouton3);
			stage.addActor(bouton10);
			
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


			}

			else if(dep){
				x1 = Gdx.input.getX();
				y1 = (Gdx.graphics.getHeight()-Gdx.input.getY());

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
	
	
	
	
	private void createBasicSkin(){
		  //Create a font
		  BitmapFont font = new BitmapFont();
		  font.scale(1f);
		  skin = new Skin();
		  skin.add("default", font);

		  //Create a texture
		  Pixmap pixmap = new Pixmap((int)Gdx.graphics.getWidth()/10,(int)Gdx.graphics.getHeight()/20, Pixmap.Format.RGB888);
		  pixmap.setColor(Color.RED);
		  pixmap.fill();
		  skin.add("background",new Texture(pixmap));

		  //Create a button style
		  TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		  textButtonStyle.up = skin.newDrawable("background", Color.PINK);
		  textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
		  textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
		  textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
		  textButtonStyle.font = skin.getFont("default");
		  skin.add("default", textButtonStyle);

		}

}
