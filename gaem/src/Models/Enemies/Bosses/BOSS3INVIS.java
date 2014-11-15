package Models.Enemies.Bosses;


import Models.MoveableEntity;
import Models.Enemies.Enemy;
import Models.Enemies.EnemyHurtmark;
import Models.Enemies.EnemyMine;
import Models.Enemies.LightTiny;
import Models.Weapons.Projectiles.EnemyBullet;
import Models.Weapons.Projectiles.EnemyWide;
import Models.Enemies.EnemyMissile;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class BOSS3INVIS extends Enemy
{
	Vector2 aim;
	boolean vertmove = false;
	boolean stopper = true;
	boolean fireside  = true;
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
	
	public BOSS3INVIS(Vector2 position) 
	{
		super(position, 360, 169, 350, 159);
		health = 35000;
		score = 35000;
		tick = 0;
		velocity = new Vector2(0,150);
		texture = "boss3INVIS";
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
	            if(fired>firerateA)
	            {
	            	if(fireside)
	            	{
	            		world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-50,position.y+height),25,25,25,25, new Vector2(125,600)));
	            		world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-50,position.y+height),25,25,25,25));
	            		world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-50,position.y+height),25,25,25,25, new Vector2(-125,600)));
	            		fireside = false;
	            	}
	            	else
	            	{
	            		world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+50,position.y+height),25,25,25,25, new Vector2(125,600)));
		            	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+50,position.y+height),25,25,25,25));
		            	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+50,position.y+height),25,25,25,25, new Vector2(-125,600)));
		            	fireside = true;
	            	}
	            	world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
	                fired=0;
	                pingA++;
	            }
	            else
	            {
	                fired++;
	            }
	        }
	        if(x == 2)
	        {
	        	if(fired>firerateB)
	            {
	        		world.actors.get(0).add(new EnemyMine(new Vector2(0,-100), 1));
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

