package Models.Enemies.Bosses;


import Models.MoveableEntity;
import Models.Enemies.Enemy;
import Models.Enemies.EnemyHurtmark;
import Models.Weapons.Projectiles.EnemyBullet;
import Models.Weapons.Projectiles.EnemyWide;
import Models.Enemies.EnemyMissile;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class BOSS1 extends Enemy
{
	Vector2 aim;
	boolean vertmove = false;
	boolean stopper = true;
	boolean hurt1 = true;
	boolean hurt2 = true;
	boolean hurt3 = true;
	int Xvel = 100;
	int move=1;
	int tic = 0;
    int firerateA = 0;
    int firerateB = 35;
    int fired = 0;
    int pingA = 201;
    int pingB = 0;
    int x = 0;
    int z = 0;
    int ready_4_battle = 1;
    private boolean wait = true;
	
	public BOSS1(Vector2 position) 
	{
		super(position, 300, 180, 290, 170);
		health = 1;//5000;
		score = 15000;
		tick = 0;
		velocity = new Vector2(0,150);
		texture = "boss1";
		subObjects.add(new BOSS1turret(new Vector2(100,-10), 75, 75, 0, 0, this));
		subObjects.add(new BOSS1turret(new Vector2(-100,-10), 75, 75, 0, 0, this));
	}
	
	@Override
	public void update(final World world)
	{
		super.update(world);
		if(health <= 0)
        	world.level.bossDead = true;
		if(wait)
		{
			if(ready_4_battle == 1)
			{
			if(pingA > 200 || pingB > 10)
	        {
				world.timer.scheduleTask(new Task() 
				{
					@Override
					public void run()
					{
						x = com.badlogic.gdx.math.MathUtils.random(1, 4);
					}
				} , 2.0f);
	            
	            pingA = 0;
	            pingB = 0;
	        }
	        if(x == 1)
	        {
	        	if(velocity.x < 0)
	        	{
		        	velocity.x = -33;
	        	}
	        	else
	        	{
		        	velocity.x = 33;
	        	}

	            if(fired>firerateA)
	            {
	            	world.actors.get(0).add(new EnemyWide(new Vector2(position.x+width/2+100,position.y+height),50,25,45,20));
	            	world.actors.get(0).add(new EnemyWide(new Vector2(position.x+width/2-100,position.y+height),50,25,45,20));
	            	world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
	                fired=0;
	                pingA++;
	            }
	            else
	            {
	                fired++;
	            }
	        }
	        else
	        {
	        	Xvel = 100;
	        	if(velocity.x < 0)
	        	{
		        	velocity.x = -100;
	        	}
	        	else
	        	{
		        	velocity.x = 100;
	        	}
	        }
	        if(x == 2)
	        {
	        	if(fired>firerateB)
	            {
	            	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(125,600)));
	            	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25));
	            	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-125,600)));
	            	world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
	                fired=0;
	                pingB++;
	            }
	            else
	            {
	                fired++;
	            }
	        }
	        if(x == 3)
	        {
	        	 if(fired>firerateB)
		            {
		            	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-200,600)));
		            	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-75,600)));
		            	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(200,600)));
		            	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(75,600)));
		            	world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
		                fired=0;
		                pingB++;
		            }
		            else
		            {
		                fired++;
		            }
	        }
			else
				tick++;
			}
			if(x == 4)
			{
				if(fired>firerateB)
	            {
	            	z = com.badlogic.gdx.math.MathUtils.random(0, 3);
	            	if(z == 0)
	            	{
	            		world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-360,350)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-340,360)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-320,370)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-300,380)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-280,390)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-260,400)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-240,410)));
	            	}
	            	if(z == 1)
	            	{
	            		world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-260,350)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-240,360)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-220,370)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-200,380)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-180,390)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-160,400)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-140,410)));
	            	}
	            	if(z == 2)
	            	{
	            		world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(260,350)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(240,360)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(220,370)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(200,380)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(180,390)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(160,400)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(140,410)));
	            	}
	            	if(z == 3)
	            	{
	            		world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(360,350)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(340,360)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(320,370)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(300,380)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(280,390)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(260,400)));
	                	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(240,410)));
	            	}
	            	world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
	                fired=0;
	                pingB++;
	                pingB++;
	            }
	            else
	            {
	                fired++;
	            }
			}
				
	        if(move == 1)
			{
				if(position.y >= 200-width/2)
				{
					velocity.y = 0;
					velocity.x = Xvel;
					move = 0;
					ready_4_battle = 1;
				}
			}		
	        if(position.x >= 620-width)
	        {
	            velocity.x = Xvel  - Xvel*2;
	        }
	        if(position.x <= 80)
	        {
	            velocity.x = Xvel;
	        }
	     
			world.timer.scheduleTask(new Task(){

				@Override
				public void run() {
					wait = true;
				}
				
			}, 0.0166f);
			wait = false;
		}
		
		if(health <= 11250)
		{
			if(hurt1)
			{
				subObjects.add(new EnemyHurtmark(new Vector2(-60,-20), 50, 50, 0, 0, this));
				hurt1 = false;
			}
		}
		
		if(health <= 7500)
		{
			if(hurt2)
			{
				subObjects.add(new EnemyHurtmark(new Vector2(40,-30), 50, 50, 0, 0, this));
				hurt2 = false;
			}
		}
		
		if(health <= 3750)
		{
			if(hurt3)
			{
				subObjects.add(new EnemyHurtmark(new Vector2(25,40), 50, 50, 0, 0, this));
				hurt3 = false;
			}
		}
	}
}
