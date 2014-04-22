package Models.Enemies;


import Models.Weapons.Projectiles.EnemyBullet;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class enemyAR extends Enemy
{
	private boolean wait;
	public enemyAR(Vector2 position, float width, float height, float hitX, float hitY) 
	{
		super(position, width, height, hitX, hitY);
		health = 300;
		tick = com.badlogic.gdx.math.MathUtils.random(0, 99);
		velocity = new Vector2(400, 0);
		actorID = 4;
		texture = "enemyA";
		score = 300;
		wait = true;
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		
		if(loaded)
		{
			world.actors.add(new EnemyBullet(centerLocation,25,25,25,25));
			world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
			world.getRender().addParticles(3, 2, 2, new Vector2(centerLocation.x,centerLocation.y+25));
			world.timer.scheduleTask(new Task(){

				@Override
				public void run() {
					loaded = true;
				}
				
			}, 1.66f);
			loaded = false;	
		}
		if(wait){
			
			if(position.x >= 540-width)
	        {
	            velocity.x = velocity.x - 10;
	        }
	        if(position.x <= 160)
	        {
	            velocity.x = velocity.x + 10;
	        }
	        
	        if(position.x >= 699-width)
	        {
	            velocity.x = -300;
	        }
	        if(position.x <= 0)
	        {
	            velocity.x = 300;
	        }
			
			world.timer.scheduleTask(new Task(){

				@Override
				public void run() {
					wait = true;
				}
				
			}, 0.0166f);
			wait = false;
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
