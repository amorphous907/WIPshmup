package Models.Enemies;


import Models.Weapons.Projectiles.EnemyLaser;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class HeavyLaser extends Enemy
{
	
	public HeavyLaser(Vector2 position, float width, float height, float hitX, float hitY) 
	{
		super(position, width, height, hitX, hitY);
		health = 400;
		texture = "heavyLaser";
		tick = com.badlogic.gdx.math.MathUtils.random(0, 99);
		score = 500;
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		if(loaded)
		{
			world.actors.add(new EnemyLaser(new Vector2(position.x+width/2+12,position.y+height/2),25,75,25,75, new Vector2(0,1200)));
			world.actors.add(new EnemyLaser(new Vector2(position.x+width/2-12,position.y+height/2),25,75,25,75, new Vector2(0,1200)));
			world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
			world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
			world.getRender().addParticles(3, 2, 2, new Vector2(position.x+width/2+12,position.y+25+height/2));
			world.getRender().addParticles(3, 2, 2, new Vector2(position.x+width/2-12,position.y+25+height/2));
			
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
