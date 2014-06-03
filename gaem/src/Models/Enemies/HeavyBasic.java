package Models.Enemies;

import Models.Weapons.Projectiles.EnemyBullet;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class HeavyBasic extends Enemy
{
	
	Vector2 aim;
	private boolean wait;
	
	public HeavyBasic(Vector2 position, int AI)
	{
		super(position, 60, 60, 50, 50);
		actorID = 5;
		texture = "heavyBasic";
		health = 500;
		score = 500;
		this.AI = AI;
		wait = true;
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		
		if(loaded)
		{
			world.actors.add(new EnemyBullet(new Vector2(centerLocation.x-20,centerLocation.y+25),25,25,25,25));
			world.actors.add(new EnemyBullet(new Vector2(centerLocation.x+20,centerLocation.y+25),25,25,25,25));
			world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
			world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
			world.getRender().addParticles(3, 2, 2, new Vector2(centerLocation.x-20,centerLocation.y-10));
			world.getRender().addParticles(3, 2, 2, new Vector2(centerLocation.x+20,centerLocation.y-10));
			
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
