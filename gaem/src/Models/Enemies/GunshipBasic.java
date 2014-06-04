package Models.Enemies;


import Models.Weapons.Projectiles.EnemyBullet;
import Models.Weapons.Projectiles.EnemyLaser;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class GunshipBasic extends Enemy
{
	int turn=0;
	int move=1;
	
	public GunshipBasic(Vector2 position, float width, float height, float hitX, float hitY) 
	{
		super(position, width, height, hitX, hitY);
		health = 800;
		tick = com.badlogic.gdx.math.MathUtils.random(0, 99);
		velocity = new Vector2(0,150);
		actorID = 9;
		texture = "gunshipBasic";
		score = 800;
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		if(loaded)
		{
			world.actors.add(new EnemyBullet(new Vector2(position.x+width/2-10,position.y+height/2-10),25,25,25,25));
			world.getRender().addParticles(3, 2, 2, new Vector2(position.x+width/2-10,position.y+height/2-10));
			world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
			
			world.timer.scheduleTask(new Task(){

				@Override
				public void run() {
					loaded = true;
				}
				
			}, 1.66f);
			loaded = false;	
		}
		
		if(move == 1)
		{
			if(position.y >= 200-width)
			{
				velocity.y = 0;
				velocity.x = 275;
				move = 0;
			}
		}
		
		if(position.x >= 699-width)
        {
            velocity.x = -275;
        }
        if(position.x <= 0)
        {
            velocity.x = 275;
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