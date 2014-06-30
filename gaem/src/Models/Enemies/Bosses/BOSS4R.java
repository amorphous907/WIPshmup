package Models.Enemies.Bosses;

import Models.MoveableEntity;
import Models.subObjectEnemy;
import Models.Enemies.eTurret1;
import Models.Players.Player;
import Models.Weapons.Projectiles.eBomb1;
import Models.Weapons.Projectiles.eBomb2;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class BOSS4R extends subObjectEnemy{
	public Vector2 aim;
	int ready_4_battle = 0;
	int x = 1;
	int tic = 0;
    int firerate = 125;
    int fired = 0;
    int ping = 6;
    private boolean wait = true;

	public BOSS4R(Vector2 offset, float width, float height,
			float hitX, float hitY, MoveableEntity Parent) {
		super(offset, width, height, hitX, hitY, Parent);
		actorID = 24;
		texture = "boss4armR";
		subObjects.add(new eTurret1(new Vector2(-15,82), 60, 80, 0, 0, this));
		subObjects.add(new BOSS4shield(new Vector2(145,120), 210, 110, 200, 100, this));
		health = 10000;
		score = 10000;
		
	}
	
	public void collidesWith(MoveableEntity e, World world) 
	{	
		if(e instanceof Player)
		{
			((Player) e).damage(50);
		}
		super.collidesWith(e, world);
	}
	
	public void damage(int i) 
	{
		health -= i;
		
	}

	@Override
	public void update(World world, MoveableEntity Parent){
		super.update(world, Parent);
		if(health <= 0)
			remove = true;
		if(wait){
			if(ready_4_battle == 0)
			{
				if(ping > 1)
		        {
		            x = com.badlogic.gdx.math.MathUtils.random(1, 2);
		            ping = 0;
		        }
				if(x == 1)
		        {
		            if(fired>firerate)
		            {
		            	world.actors.add(new eBomb1(new Vector2(position.x+width/2,position.y+height),45,45,35,35));
		            	world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
		                fired=0;
		                ping++;
		            }
		            else
		            {
		                fired++;
		            }
		        }
				if(x == 2)
		        {
		            if(fired>firerate)
		            {
		            	world.actors.add(new eBomb2(new Vector2(position.x+width/2,position.y+height),45,45,35,35));
		            	world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
		                fired=0;
		                ping++;
		            }
		            else
		            {
		                fired++;
		            }
		        }
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
	
}