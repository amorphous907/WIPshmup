package Models.Enemies.Bosses;

import Models.Enemies.Enemy;
import Models.Weapons.Projectiles.EnemyBullet;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BOSS5 extends Enemy
{
	boolean danger = false;
	int side = 0;
	int move=1;
	int tic = 0;
    int firerate = 15;
    int fired = 0;
    int pingA = 0;
    int pingB = 0;
    int pingC = 0;
    int x = 0;
    int ready_4_battle = 0;
	
	public BOSS5(Vector2 position, float width, float height, float hitX, float hitY) 
	{
		super(position, width, height, hitX, hitY);
		health = 30000;
		tick = 0;
		velocity = new Vector2(0,100);
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		if(ready_4_battle == 1)
		
		{
			if(pingA > 150 || pingB > 3 || pingC > 20)
            {
				//x = com.badlogic.gdx.math.MathUtils.random(0, 3);
                pingA = 0;
                pingB = 0;
                pingC = 0;
            }
            if(x == 0)
            {
            	if(side == 1)
            	{
            		world.actors.add(new EnemyBullet(new Vector2(position.x+width,position.y+height),25,25,25,25, new Vector2(100,600)));
            		world.actors.add(new EnemyBullet(new Vector2(position.x+width-10,position.y+height),25,25,25,25));
            		world.actors.add(new EnemyBullet(new Vector2(position.x+width,position.y+height),25,25,25,25, new Vector2(-100,600)));
            	side = 0;
            	}
            	else
            	{
            		world.actors.add(new EnemyBullet(new Vector2(position.x+width,position.y+height),25,25,25,25, new Vector2(100,600)));
                	world.actors.add(new EnemyBullet(new Vector2(position.x+width/2-10,position.y+height),25,25,25,25));
                	world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-100,600)));
            	}
            }
            if(x == 1)
            {
                
            }
            if(x == 2)
            {
                
            }
            if(x == 3)
            {
               
            }
        }
		else
		{
			tick++;
		}

		
		if(move == 1)
		{
			if(position.y >= 400-width/2)
			{
				velocity.y = 0;
				velocity.x = 150;
				move = 0;
				ready_4_battle = 1;
			}
		}
		
		if(position.x >= 699-width)
        {
            velocity.x = -150;
        }
        if(position.x <= 0)
        {
            velocity.x = 150;
        }
	}

}