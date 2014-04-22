package Screens;

import View.World;
import View.WorldRender;

import com.amorphous.gaem.gaemMain;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen{
	gaemMain game;
	World world;
	WorldRender render;
	
	public GameScreen(gaemMain game, int level){
		this.game = game;
		world = new World(game, level);
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
