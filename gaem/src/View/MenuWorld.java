package View;

import java.util.Random;

import com.amorphous.gaem.gaemMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import Models.Enemies.MenuDummyE;
import Models.Enemies.MenuDummyP;

public class MenuWorld extends World{
	public Random rnd = new Random();
	private float time = 0;

	public MenuWorld(gaemMain game, int level) {
		super(game, level);
		renderHud = false;
	}
	
	public void update(){
		time += Gdx.graphics.getDeltaTime();
		if(time >= 0.5){
			this.actors.get(0).add(new MenuDummyE(new Vector2(rnd.nextFloat()*1000, 0), 0));
			this.actors.get(0).add(new MenuDummyP(new Vector2(rnd.nextFloat()*1000, 900), 0));
			time = 0;
		}
		updateActors();
	}

}
