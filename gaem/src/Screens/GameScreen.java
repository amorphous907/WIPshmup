package Screens;

import Models.Players.SelectShip;
import View.World;
import View.WorldRender;

import com.amorphous.gaem.gaemMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen{
	gaemMain game;
	World world;
	WorldRender render;
	
	public GameScreen(gaemMain game, int level, Array<SelectShip> selectedShips){
		this.game = game;
		world = new World(game, level, selectedShips);
		render = new WorldRender(world, game);
		
	}
	
	
	@Override
	public void render(float delta) {
		world.update();
		
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
		dispose();
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
		world.dispose();
		
	}
	
}
