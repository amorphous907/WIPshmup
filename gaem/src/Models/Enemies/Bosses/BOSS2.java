package Models.Enemies.Bosses;


import Models.Enemies.Enemy;
import Models.Enemies.LightTiny;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class BOSS2 extends Enemy
{
	boolean danger = false;
	boolean safe = true;
	boolean die = false;
	boolean drone_buddy = true;
	boolean assault_drone = true;
	int happy = 0;
	int sad = 0;
	int move=1;
	int tic = 0;
    int firerate = 100;
    int fired = 0;
    int pingA = 0;
    int pingB = 0;
    int x = 1;
    int y = 0;
    int ready_4_battle = 0;
    int cooldown = 0;
	
	public BOSS2(Vector2 position) 
	{
		super(position, 300, 300, 240, 240);
		health = 20000;
		tick = 0;
		velocity = new Vector2(0,100);
		actorID = 30;
		texture = "boss2";
		circle = true;
		bounds2 = new Circle(position, 130);
		score = 20000;
		
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		if(danger)
        {
            drone_buddy = true;
            assault_drone = true;
            danger = false;
            happy = 0;
            sad = 0;
        }
		
		
		if(assault_drone)
		{
			subObjects.add(new BOSS2attack_drone1(new Vector2(150,0), 75, 75, 65, 65, this));
			subObjects.add(new BOSS2attack_drone2(new Vector2(0,150), 75, 75, 65, 65, this));
			subObjects.add(new BOSS2attack_drone3(new Vector2(-150,0), 75, 75, 65, 65, this));
			subObjects.add(new BOSS2attack_drone4(new Vector2(0,-150), 75, 75, 65, 65, this));
			assault_drone = false;
		}
		
		if(drone_buddy)
		{
			happy++;
			if(happy == 5)
			{
				
				subObjects.add(new BOSS2drone_buddy(new Vector2(0,0), 25, 25, 20, 20, this));

				sad++;
				happy = 0;
			}
			if(sad == 100)
			{
				drone_buddy = false;
			}
		}
		
		//ally summoning
		if(ready_4_battle == 1)
		{
			y = com.badlogic.gdx.math.MathUtils.random(0, 700);
			if(pingA == 5 || pingB == 2)
            {
				x = com.badlogic.gdx.math.MathUtils.random(0, 0);
                pingA = 0;
                pingB = 0;
            }
            if(x == 0)
            {
            	if(fired>firerate)
                {
            		world.actors.add(new LightTiny(new Vector2(y,-100), 1));
                    fired=0;
                    pingB++;
                }
                else
                {
                    fired++;
                }
            }
            else
			{
				tick++;
			}
	}
		if(move == 1)
		{
			if(position.y >= 200-width/2)
			{
				velocity.y = 0;
				velocity.x = 100;
				move = 0;
				ready_4_battle = 1;
			}
		}
		
		if(position.x >= 699-width)
        {
            velocity.x = -100;
        }
        if(position.x <= 0)
        {
            velocity.x = 100;
        }
        
        //random stuff
        if(safe)
        {
        	if(health <= 10000)
            {
        		firerate = 50;
            	danger = true;
            	safe = false;
            }
        }
	}
}
