package Screens;

import View.ShipSelectionWorld;
import View.WorldRender;

import com.amorphous.gaem.gaemMain;
import com.badlogic.gdx.Screen;

public class ShipSelection implements Screen{
	gaemMain game;
	int level;
	private ShipSelectionWorld ship;
	private WorldRender render;
	
	public ShipSelection(int level, gaemMain game){
		this.game = game;
		this.level = level;
		ship = new ShipSelectionWorld(game, level);
		render = new WorldRender(ship, game);
	}

	@Override
	public void render(float delta) {
		ship.update();
		render.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
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
		ship.dispose();
		
	}
	
	

}
