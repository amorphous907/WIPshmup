package Models.Enemies;


import Models.Weapons.Projectiles.EnemyBullet;
import Models.Weapons.Projectiles.EnemyLaser;
import Models.Weapons.Projectiles.EnemyWide;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class GunshipBasic extends Enemy
{
	int turn=0;
	int move=1;
	
	public GunshipBasic(Vector2 position) 
	{
		super(position, 120, 90, 110, 80);
		health = 2500;
		score = 2500;
		texture = "MINIBOSSL1";
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		if(health <= 1)
		{
	        world.level.minibossded = true;
	        world.level.setWaveDone(true);
		}

		
		if(loaded)
		{
			world.actors.get(0).add(new EnemyWide(new Vector2(position.x+width/2+25,position.y+height),50,25,45,20));
        	world.actors.get(0).add(new EnemyWide(new Vector2(position.x+width/2-25,position.y+height),50,25,45,20));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(200,600)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-200,600)));
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
				velocity.x = 125;
				move = 0;
			}
		}
		
		if(position.x >= 699-width)
        {
            velocity.x = -175;
        }
        if(position.x <= 0)
        {
            velocity.x = 175;
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
