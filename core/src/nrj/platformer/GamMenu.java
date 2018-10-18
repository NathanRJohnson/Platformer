package nrj.platformer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import nrj.platformer.Objects.Background;
import nrj.platformer.Objects.Ground;
import nrj.platformer.Objects.Jumper;
import nrj.platformer.Objects.Platform;

public class GamMenu extends ApplicationAdapter {
	//Extras
	SpriteBatch batch;
	//Textures
	Texture txCity;
	Texture txJumper;
	Texture txFloor;
	//Backgrounds
	Background bgCity;
	//Jumper
	Jumper jmpHero;
	//Orthographic Camera
	OrthographicCamera oc = new OrthographicCamera();
	//Floor
	Ground grndFloor;
	Platform ptPlatform, ptPlatform2;
	//Vectors
	Vector2 v2Gravity, v2Normal;

	
	@Override
	public void create () {
		oc.setToOrtho(false,800,400);
		batch = new SpriteBatch();
		//Textures
		txCity = new Texture("bg_city.png");
		txJumper = new Texture("jumper.png");
		txFloor = new Texture("city_ground.png");
		//Backgrounds
		bgCity = new Background(txCity);
		//Jumper
		jmpHero = new Jumper(txJumper, 200,100);
		//Floor
		grndFloor = new Ground(txFloor);
		ptPlatform = new Platform(txFloor, 100,150,100,30);
		ptPlatform2 = new Platform(txFloor, 300,250,100,30);
		//Vector
		v2Gravity = new Vector2(0,-1);
		v2Normal = new Vector2(0,1);
	}

	@Override
	public void render () {
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bgCity.draw(batch);
		grndFloor.draw(batch);
		jmpHero.draw(batch);
		ptPlatform.draw(batch);
		ptPlatform2.draw(batch);
		batch.end();
		grndFloor.floor(jmpHero);
		jmpHero.Update();
		ptPlatform.hold(jmpHero);
		ptPlatform2.hold(jmpHero);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bgCity.getTexture().dispose();
		jmpHero.getTexture().dispose();
	}
}
