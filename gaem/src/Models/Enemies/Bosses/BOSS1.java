package Models.Enemies.Bosses;


import Models.MoveableEntity;
import Models.Enemies.Enemy;
import Models.Weapons.Projectiles.EnemyBeam;
import Models.Weapons.Projectiles.EnemyBullet;
import Models.Enemies.EnemyMissile;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class BOSS1 extends Enemy
{
	Vector2 aim;
	int Xvel = 100;
	int move=1;
	int tic = 0;
    int firerateA = 0;
    int firerateB = 15;
    int fired = 0;
    int pingA = 101;
    int pingB = 3;
    int x = 0;
    int y = 0;
    int z = 0;
    int ready_4_battle = 0;
    private boolean wait = true;
	
	public BOSS1(Vector2 position) 
	{
		super(position, 300, 180, 290, 170);
		health = 10000;
		score = 10000;
		tick = 0;
		velocity = new Vector2(0,150);
		texture = "boss1";
		subObjects.add(new BOSS1turret(new Vector2(100,-10), 75, 75, 0, 0, this));
		subObjects.add(new BOSS1turret(new Vector2(-100,-10), 75, 75, 0, 0, this));
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		if(wait){
			if(ready_4_battle == 1)
			{
			if(pingA > 100 || pingB > 20)
	        {
	            x = com.badlogic.gdx.math.MathUtils.random(2, 2);
	            pingA = 0;
	        }
	        if(x == 1)
	        {
	        	Xvel = 33;
	            if(fired>firerateA)
	            {
	            	world.actors.add(new EnemyBeam(new Vector2(position.x+width/2+100,position.y+height),50,25,45,20));
	            	world.actors.add(new EnemyBeam(new Vector2(position.x+width/2-100,position.y+height),50,25,45,20));
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
	        }
	        if(x == 2)
	        {
	            if(fired>firerateB)
	            {
	            	world.actors.add(new EnemyMissile(new Vector2(position.x+width/2+100,position.y+height)));
	            	world.actors.add(new EnemyMissile(new Vector2(position.x+width/2-100,position.y+height)));
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
	            if(fired>firerateA)
	            {
	            	
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
			
				
	        if(move == 1)
			{
				if(position.y >= 200-width/2)
				{
					velocity.y = 0;
					velocity.x = Xvel;
					move = 0;
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
	        
	        if(health <= 0)
	        	world.level.bossDead = true;
	        
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
	public void collidesWith(MoveableEntity e, World world)
	{
		if(e instanceof BOSS4shield)
		{
			ready_4_battle = 0;
		}
		else
		{
			ready_4_battle = 1;
		}
	}
}
