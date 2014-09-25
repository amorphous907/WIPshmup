package Models.Enemies;


import Models.Weapons.Projectiles.EnemyLaser;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class LightLaser extends Enemy
{
	
	public LightLaser(Vector2 position, float width, float height, float hitX, float hitY) 
	{
		super(position, width, height, hitX, hitY);
		health = 200;
		tick = com.badlogic.gdx.math.MathUtils.random(0, 99);
		score = 250;
		texture = "lightLaser";
	}
	
	public LightLaser(Vector2 position, int ai) {
		super(position, 50, 50, 50, 50);
		health = 200;
		tick = com.badlogic.gdx.math.MathUtils.random(0, 99);
		score = 250;
		texture = "lightLaser";
	}

	@Override
	public void update(World world)
	{
		super.update(world);
		
		if(loaded)
		{
			world.actors.get(0).add(new EnemyLaser(new Vector2(centerLocation.x,centerLocation.y+25),25,50,25,50, new Vector2(0,1200)));
			world.getRender().addParticles(3, 2, 2, new Vector2(centerLocation.x,centerLocation.y+25));
			world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
			
			world.timer.scheduleTask(new Task(){

				@Override
				public void run() {
					loaded = true;
				}
				
			}, 1.66f);
			loaded = false;	
		}
		
	}
	
	@Override
	protected void spawn(World world){
		world.timer.scheduleTask(new Task(){

			@Override
			public void run() {
				loaded = true;
			}
			
		}, com.badlogic.gdx.math.MathUtils.random(0, 1.66f));
		super.spawn(world);
	}

}
