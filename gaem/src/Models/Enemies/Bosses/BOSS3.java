package Models.Enemies.Bosses;

import Models.Enemies.Enemy;
import Models.Enemies.EnemyMines;
import Models.Weapons.Projectiles.EnemyBullet;
import View.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BOSS3 extends Enemy
{
	boolean danger = false;
	int move=1;
	int tic = 0;
    int shoot_tic=0;
    int firerate = 50;
    int fired = 0;
    int pingA = 0;
    int pingB = 0;
    int x = 0;
    int phase = 0;
    int ready_4_battle = 0;
	
	public BOSS3(Vector2 position, float width, float height, float hitX, float hitY) 
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
		
	
	
	if(move == 1)
	{
		if(position.y >= 400-width)
		{
			velocity.y = 0;
			velocity.x = 150;
			move = 0;
			ready_4_battle = 1;
		}
	}
	if(phase == 2)
	{
		firerate = 25;
	}
	
	if(position.x >= 699-width)
    {
        velocity.x = -150;
    }
    if(position.x <= 0)
    {
        velocity.x = 150;
    }
    if(ready_4_battle == 1)
    {
    	
    if(pingA == 2 || pingB > 4)
    {
    	x = com.badlogic.gdx.math.MathUtils.random(0, 4);
        pingA = 0;
        pingB = 0;
    }
    if(x == 1)
    {
        shoot_tic++;
        if(shoot_tic == 10)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+50,position.y+height/2+50),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-50,position.y+height/2+50),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic == 20)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+40,position.y+height/2+50),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-40,position.y+height/2+50),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic == 30)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+30,position.y+height/2+50),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-30,position.y+height/2+50),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic == 40)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+20,position.y+height/2+50),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-20,position.y+height/2+50),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav"); 
        }
        if(shoot_tic == 50)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+10,position.y+height/2+50),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+10,position.y+height/2+50),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
            pingB++;
            pingB++;
        }
        if(shoot_tic > 50)
        {
            pingB++;
        }
    }
    if(x == 0)
    {
        if(fired>firerate)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+140,position.y+height),25,25,25,25, new Vector2(100,600)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+140,position.y+height),25,25,25,25));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+140,position.y+height),25,25,25,25, new Vector2(-100,600)));
            //Greenfoot.playSound("auto.wav");
            world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-140,position.y+height),25,25,25,25, new Vector2(100,600)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-140,position.y+height),25,25,25,25));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-140,position.y+height),25,25,25,25, new Vector2(-100,600)));
            fired=0;
            pingB++;
        }
        else
        {
            fired++;
        }
    }
    if(x == 2)
    {
        shoot_tic++;
        if(shoot_tic == 10)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+60,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-60,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic == 20)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+70,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-70,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic == 30)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+80,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-80,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic == 40)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+90,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-90,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav"); 
        }
        if(shoot_tic == 50)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+100,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-100,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic > 50)
        {
            pingB++;
        }
    }
    if(x == 3)
    {
        shoot_tic++;
        if(shoot_tic == 10)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+150,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-150,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic == 20)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+140,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-140,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic == 30)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+130,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-130,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic == 40)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+120,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-120,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav"); 
        }
        if(shoot_tic == 50)
        {
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2+110,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
        	world.actors.get(0).add(new EnemyBullet(new Vector2(position.x+width/2-110,position.y+height/2-10),25,50,25,50, new Vector2(0,1200)));
            //Greenfoot.playSound("auto.wav");
        }
        if(shoot_tic > 50)
        {
            pingB++;
        }
    }
    if(x == 4)
    {
    	world.actors.get(0).add(new EnemyMines(new Vector2(position.x+com.badlogic.gdx.math.MathUtils.random(0, 400)-200,200), 60,60,50,50));  
        pingB++;
    }
    }
}
}