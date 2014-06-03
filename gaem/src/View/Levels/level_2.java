package View.Levels;

import java.util.Random;

import Models.yellow;
import Models.Enemies.LightBasic;
import Models.Enemies.enemyAL;
import Models.Enemies.enemyAR;
import Models.Enemies.HeavyBasic;
import Models.Enemies.HeavySpread;
import Models.Enemies.LightLaser;
import Models.Enemies.HeavyLaser;
import Models.Enemies.GunshipBasic;
import Models.Enemies.Bosses.BOSS2;
import View.World;

import com.badlogic.gdx.math.Vector2;

public class level_2 extends level_1
{
	public boolean bossDead = false;
	Random rnd = new Random();
	int time = 0;
	int currentTime = 0;
	boolean done = true;
	boolean PREPARE_TO_DIE = false;
	boolean musicstart = true;
	int tic = 0;
	int tic2 = 0;
	int x = 0;
	int count = 0;
	int HUE1 = 0;
	int HUE2 = 0;
	int HUE3 = 0;
	int HUE4 = 0;
	int HUE5 = 0;
	public int timeLimit = 7200;
	@Override
	public void update(World world)
	{
		float size = rnd.nextFloat()*50; 
		if(rnd.nextInt(50)<10 && size > 12.5f && size <= 25)//10
			world.actors.add(new yellow(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		if(rnd.nextInt(75)<5 && size > 25) //5
			world.actors.add(new yellow(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		if(rnd.nextInt(25)<25 && size <= 12.5) //25
			world.actors.add(new yellow(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		
		if(musicstart)
		{
			world.game.audio.loopMusic("level_2");
			musicstart = false;
		}
		if(done && time < timeLimit)
		{
			tic = 0;
			x = com.badlogic.gdx.math.MathUtils.random(1, 41);
			System.out.println("time"+time);
			System.out.println("wave"+x);
			done = false;
		}
		if(time >= timeLimit)
		{
			world.game.audio.stopMusic("level_2 boss");
			tic2++;
			if(tic2 == 200)
			{
				PREPARE_TO_DIE = true;
			}
		}
		if(PREPARE_TO_DIE)
		{
			world.game.audio.loopMusic("level_2 boss");
			world.actors.add(new BOSS2(new Vector2(350,-200), 300,300,240,240));
			PREPARE_TO_DIE = false;
		}
		
		if(x == 1)
		{
			if(tic == 0)
			{
				world.actors.add(new LightBasic(new Vector2(150,-100), 60,60,50,50));
				world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
				world.actors.add(new LightBasic(new Vector2(550,-100), 60,60,50,50));
			}
			if(tic == 50)
			{
				world.actors.add(new LightLaser(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new LightLaser(new Vector2(500,-100), 60,60,50,50));
			}
			if(tic == 100)
			{
				world.actors.add(new HeavyLaser(new Vector2(350,-100), 90,60,80,50));
			}   
			tic++;
			currentTime++;
			if(tic == 200)
			{
				time = time + 200;
				done = true;
			}
		}
		
		if(x == 2)
		{
			if(tic == 0)
			{
				world.actors.add(new HeavyLaser(new Vector2(500,-100), 90,60,80,50));
            	world.actors.add(new HeavyLaser(new Vector2(200,-100), 90,60,80,50));
			}
			if(tic == 100)
			{
				world.actors.add(new LightLaser(new Vector2(150,-100), 60,60,50,50));
                world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(550,-100), 60,60,50,50));
			}
			if(tic == 150)
			{
				world.actors.add(new HeavyLaser(new Vector2(350,-100), 90,60,80,50));
			}   
			tic++;
			currentTime++;
			if(tic == 200)
			{
				time = time + 200;
				done = true;
			}
		}
		if(x == 3)
		{
			if(tic == 0)
			{
				world.actors.add(new LightLaser(new Vector2(250,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(450,-100), 60,60,50,50));
			}
			if(tic == 100)
            {
            	world.actors.add(new LightBasic(new Vector2(300,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(400,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new HeavyLaser(new Vector2(200,-100), 90,60,80,50));
            	world.actors.add(new HeavyLaser(new Vector2(500,-100), 90,60,80,50));
            }
			tic++;
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 4)
		{
			if(tic == 0)
			{
				world.actors.add(new HeavyBasic(new Vector2(500,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(200,-100), 90,60,80,50));
			}
			if(tic == 75)
			{
				world.actors.add(new HeavyBasic(new Vector2(350,-100), 90,60,80,50));
			}
			if(tic == 125)
			{
				world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
                world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
                world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
			}
			tic++;
			currentTime++;
			if(tic == 200)
			{
				time = time + 200;
				done = true;
			}
		}
		if(x == 5)
		{
			if(tic == 0)
			{
				world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
			}
			if(tic == 100)
			{
				world.actors.add(new HeavyBasic(new Vector2(100,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(600,-100), 90,60,80,50));
			}
			if(tic == 200)
			{
				world.actors.add(new enemyAR(new Vector2(100,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
                world.actors.add(new enemyAL(new Vector2(600,-100), 60,60,50,50));
			}
			tic++;
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 6)
		{
			if(tic == 0)
			{
				world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
			}
			if(tic == 50)
			{
				world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
				world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
			}
			if(tic == 100)
			{
				world.actors.add(new LightBasic(new Vector2(150,-100), 60,60,50,50));
				world.actors.add(new LightBasic(new Vector2(550,-100), 60,60,50,50));
			}
			tic++;
			currentTime++;
			if(tic == 150)
			{
				time = time + 150;
				done = true;
			}
		}
		if(x == 7)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new LightLaser(new Vector2(100,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(300,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightLaser(new Vector2(200,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(400,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(600,-100), 60,60,50,50));
            }
			tic++;
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 8)
		{
			if(tic == 0)
            {
            	world.actors.add(new enemyAR(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new enemyAR(new Vector2(350,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(350,-100), 60,60,50,50));
            }
			tic++;
			currentTime++;
			if(tic == 250)
			{
				time = time + 250;
				done = true;
			}
		}
		if(x == 9)
		{
			if(tic == 0)
            {
            	world.actors.add(new enemyAR(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new HeavyBasic(new Vector2(200,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(500,-100), 90,60,80,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new enemyAR(new Vector2(350,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(350,-100), 60,60,50,50));
            }
			tic++;
			currentTime++;
			if(tic == 250)
			{
				time = time + 250;
				done = true;
			}
		}
		if(x == 10)
		{
			if(tic == 0)
            {
            	world.actors.add(new enemyAR(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new HeavyBasic(new Vector2(200,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(500,-100), 90,60,80,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new enemyAR(new Vector2(350,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(350,-100), 60,60,50,50));
            }
			tic++;
			currentTime++;
			if(tic == 250)
			{
				time = time + 250;
				done = true;
			}
		}
		if(x == 11)
		{
			if(tic == 0)
            {
            	world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new LightBasic(new Vector2(150,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(550,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 250)
			{
				time = time + 250;
				done = true;
			}
		}
		if(x == 12)
		{
			if(tic == 0)
            {
            	world.actors.add(new LightLaser(new Vector2(100,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(600,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new HeavyLaser(new Vector2(400,-100), 90,60,80,50));
            	world.actors.add(new HeavyLaser(new Vector2(300,-100), 90,60,80,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new HeavyLaser(new Vector2(100,-100), 90,60,80,50));
                world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
                world.actors.add(new HeavyLaser(new Vector2(600,-100), 90,60,80,50));
            }
			tic++;  
			currentTime++;
			if(tic == 250)
			{
				time = time + 250;
				done = true;
			}
		}
		if(x == 13)
		{
			if(tic == 0)
            {
            	world.actors.add(new LightLaser(new Vector2(200,-100), 60,60,50,50));
                world.actors.add(new enemyAL(new Vector2(300,-100), 60,60,50,50));
                world.actors.add(new enemyAR(new Vector2(400,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(500,-100), 60,60,50,50));
            }
			if(tic == 100)
            {
            	world.actors.add(new LightLaser(new Vector2(100,-100), 60,60,50,50));
                world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
                world.actors.add(new LightLaser(new Vector2(600,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 200)
			{
				time = time + 200;
				done = true;
			}
		}
		if(x == 14)
		{
			if(tic == 0)
            {
            	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 200)
			{
				time = time + 200;
				done = true;
			}
		}
		if(x == 15)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavySpread(new Vector2(250,-100), 90,60,80,50));
                world.actors.add(new HeavyBasic(new Vector2(350,-100), 90,60,80,50));
                world.actors.add(new HeavySpread(new Vector2(450,-100), 90,60,80,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new LightLaser(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new HeavyLaser(new Vector2(350,-100), 90,60,80,50));
                world.actors.add(new LightLaser(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightBasic(new Vector2(300,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(400,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 200)
			{
				time = time + 200;
				done = true;
			}
		}
		if(x == 16)
		{
			if(tic == 0)
            {
            	world.actors.add(new LightBasic(new Vector2(100,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(600,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 250)
            {
            	world.actors.add(new LightLaser(new Vector2(550,-100), 60,60,50,50));
            	world.actors.add(new LightLaser(new Vector2(150,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 200)
			{
				time = time + 200;
				done = true;
			}
		}
		if(x == 17)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavyBasic(new Vector2(50,-100), 90,60,80,50));
            }
            if(tic == 25)
            {
            	world.actors.add(new HeavyBasic(new Vector2(150,-100), 90,60,80,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new HeavyBasic(new Vector2(250,-100), 90,60,80,50));
            }
            if(tic == 75)
            {
            	world.actors.add(new HeavyBasic(new Vector2(350,-100), 90,60,80,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new HeavyBasic(new Vector2(650,-100), 90,60,80,50));
            }
            if(tic == 125)
            {
            	world.actors.add(new HeavyBasic(new Vector2(550,-100), 90,60,80,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new HeavyBasic(new Vector2(450,-100), 90,60,80,50));
            }
            if(tic == 175)
            {
            	world.actors.add(new HeavyBasic(new Vector2(350,-100), 90,60,80,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new HeavyBasic(new Vector2(50,-100), 90,60,80,50));
            }
            if(tic == 225)
            {
            	world.actors.add(new HeavyBasic(new Vector2(150,-100), 90,60,80,50));
            }
            if(tic == 250)
            {
            	world.actors.add(new HeavyBasic(new Vector2(250,-100), 90,60,80,50));
            }
            if(tic == 275)
            {
            	world.actors.add(new HeavyBasic(new Vector2(350,-100), 90,60,80,50));
            }
			tic++;  
			currentTime++;
			if(tic == 350)
			{
				time = time + 350;
				done = true;
			}
		}
		if(x == 17)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavySpread(new Vector2(650,-100), 90,60,80,50));
            	world.actors.add(new HeavySpread(new Vector2(550,-100), 90,60,80,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new enemyAR(new Vector2(350,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(350,-100), 60,60,50,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new enemyAR(new Vector2(450,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(250,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new HeavyBasic(new Vector2(450,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(250,-100), 90,60,80,50));
            }
            if(tic == 250)
            {
            	world.actors.add(new HeavyLaser(new Vector2(550,-100), 90,60,80,50));
            	world.actors.add(new HeavyLaser(new Vector2(150,-100), 90,60,80,50));
            }
            if(tic == 300)
            {
            	world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 18)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavySpread(new Vector2(650,-100), 90,60,80,50));
            	world.actors.add(new HeavySpread(new Vector2(550,-100), 90,60,80,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new enemyAR(new Vector2(350,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(350,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new enemyAR(new Vector2(450,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(250,-100), 60,60,50,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new HeavyBasic(new Vector2(450,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(250,-100), 90,60,80,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new HeavyLaser(new Vector2(550,-100), 90,60,80,50));
            	world.actors.add(new HeavyLaser(new Vector2(150,-100), 90,60,80,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 19)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavySpread(new Vector2(650,-100), 90,60,80,50));
            	world.actors.add(new HeavySpread(new Vector2(550,-100), 90,60,80,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new enemyAR(new Vector2(350,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(350,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new enemyAR(new Vector2(450,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(250,-100), 60,60,50,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new HeavyBasic(new Vector2(450,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(250,-100), 90,60,80,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new HeavyLaser(new Vector2(550,-100), 90,60,80,50));
            	world.actors.add(new HeavyLaser(new Vector2(150,-100), 90,60,80,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 20)
		{
			if(tic == 0)
            {
            	world.actors.add(new GunshipBasic(new Vector2(350,-100), 90,60,80,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 21)
		{
			if(tic == 0)
            {
            	world.actors.add(new GunshipBasic(new Vector2(350,-100), 90,60,80,50));
            }
			tic++;  
			currentTime++;
			if(tic == 100)
			{
				time = time + 100;
				done = true;
			}
		}
		if(x == 22)
		{
			if(tic == 0)
            {
            	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new HeavyBasic(new Vector2(150,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(550,-100), 90,60,80,50));
            }
			tic++;
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 23)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavyBasic(new Vector2(50,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(650,-100), 90,60,80,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
                world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
                world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
            	world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
                world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 250)
			{
				time = time + 250;
				done = true;
			}
		}
		if(x == 24)
		{
			if(tic == 0)
            {
            	world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new HeavyLaser(new Vector2(250,-100), 90,60,80,50));
            	world.actors.add(new HeavyLaser(new Vector2(450,-100), 90,60,80,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 25)
		{
			 if(tic == 0)
	            {
	            	world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
	            	world.actors.add(new enemyAR(new Vector2(350,-100), 60,60,50,50));
	            	world.actors.add(new enemyAL(new Vector2(350,-100), 60,60,50,50));
	            	world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
	            }
	            if(tic == 100)
	            {
	            	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
	            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 26)
		{
			 if(tic == 0)
	            {
	            	world.actors.add(new HeavyLaser(new Vector2(450,-100), 90,60,80,50));
	            	world.actors.add(new HeavyLaser(new Vector2(250,-100), 90,60,80,50));
	            }
	            if(tic == 100)
	            {
	            	world.actors.add(new LightLaser(new Vector2(450,-100), 60,60,50,50));
	                world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
	                world.actors.add(new LightLaser(new Vector2(250,-100), 60,60,50,50));
	            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 27)
		{
			 if(tic == 0)
	            {
	            	world.actors.add(new HeavyLaser(new Vector2(450,-100), 90,60,80,50));
	            	world.actors.add(new HeavyLaser(new Vector2(250,-100), 90,60,80,50));
	            }
	            if(tic == 100)
	            {
	            	world.actors.add(new LightLaser(new Vector2(450,-100), 60,60,50,50));
	                world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
	                world.actors.add(new LightLaser(new Vector2(250,-100), 60,60,50,50));
	            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 28)
		{
			if(tic == 0)
            {
            	world.actors.add(new enemyAR(new Vector2(600,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(100,-100), 60,60,50,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new HeavySpread(new Vector2(400,-100), 90,60,80,50));
            	world.actors.add(new HeavySpread(new Vector2(300,-100), 90,60,80,50));
            }
			tic++; 
			currentTime++;
			if(tic == 200)
			{
				time = time + 200;
				done = true;
			}
		}
		if(x == 29)
		{
			if(tic == 0)
            {
            	world.actors.add(new enemyAR(new Vector2(600,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(100,-100), 60,60,50,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new HeavySpread(new Vector2(400,-100), 90,60,80,50));
            	world.actors.add(new HeavySpread(new Vector2(300,-100), 90,60,80,50));
            }
			tic++; 
			currentTime++;
			if(tic == 200)
			{
				time = time + 200;
				done = true;
			}
		}
		if(x == 30)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new HeavyLaser(new Vector2(250,-100), 90,60,80,50));
                world.actors.add(new LightLaser(new Vector2(300,-100), 60,60,50,50));
                world.actors.add(new LightLaser(new Vector2(400,-100), 60,60,50,50));
                world.actors.add(new HeavyLaser(new Vector2(450,-100), 90,60,80,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightLaser(new Vector2(500,-100), 60,60,50,50));
            	world.actors.add(new LightLaser(new Vector2(200,-100), 60,60,50,50));
            }
			tic++; 
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 31)
		{
			if(tic == 0)
            {
            	world.actors.add(new enemyAR(new Vector2(500,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(200,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new HeavySpread(new Vector2(150,-100), 90,60,80,50));
                world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
                world.actors.add(new HeavySpread(new Vector2(550,-100), 90,60,80,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightBasic(new Vector2(100,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(600,-100), 60,60,50,50));
            }
			tic++; 
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 32)
		{
			if(tic == 0)
            {
            	world.actors.add(new enemyAR(new Vector2(500,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(200,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new HeavySpread(new Vector2(150,-100), 90,60,80,50));
                world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
                world.actors.add(new HeavySpread(new Vector2(550,-100), 90,60,80,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightBasic(new Vector2(100,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(600,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 33)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavyLaser(new Vector2(100,-100), 90,60,80,50));
            	world.actors.add(new HeavyLaser(new Vector2(600,-100), 90,60,80,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new LightBasic(new Vector2(100,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(600,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
                world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 34)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavyLaser(new Vector2(100,-100), 90,60,80,50));
            	world.actors.add(new HeavyLaser(new Vector2(600,-100), 90,60,80,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new LightBasic(new Vector2(100,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
            	world.actors.add(new LightBasic(new Vector2(600,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
                world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 35)
		{
			if(tic == 0)
            {
            	world.actors.add(new enemyAR(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new enemyAR(new Vector2(400,-100), 60,60,50,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new enemyAR(new Vector2(350,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(350,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new enemyAR(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
                world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 36)
		{
			if(tic == 0)
            {
            	world.actors.add(new enemyAR(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new enemyAR(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new enemyAR(new Vector2(350,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(350,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new enemyAR(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new enemyAL(new Vector2(500,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
                world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 37)
		{
			if(tic == 0)
            {
            	world.actors.add(new HeavyLaser(new Vector2(350,-100), 90,60,80,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new HeavyBasic(new Vector2(300,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(400,-100), 90,60,80,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new HeavyBasic(new Vector2(200,-100), 90,60,80,50));
            	world.actors.add(new HeavyBasic(new Vector2(500,-100), 90,60,80,50));
            }
            if(tic == 300)
            {
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
            	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
                world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 400)
			{
				time = time + 400;
				done = true;
			}
		}
		if(x == 38)
		{
			if(tic == 0)
            {
            	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
            }
            if(tic == 50)
            {
            	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new LightBasic(new Vector2(300,-100), 60,60,50,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
            }
            if(tic == 200)
            {
            	world.actors.add(new LightBasic(new Vector2(400,-100), 60,60,50,50));
            }
			tic++;  
			currentTime++;
			if(tic == 300)
			{
				time = time + 300;
				done = true;
			}
		}
		if(x == 39)
		{
			if(tic == 0)
            {
            	world.actors.add(new enemyAR(new Vector2(400,-100), 60,60,50,50));
            	world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
                world.actors.add(new enemyAL(new Vector2(300,-100), 60,60,50,50));
            }
            if(tic == 100)
            {
            	world.actors.add(new HeavySpread(new Vector2(200,-100), 90,60,80,50));
            	world.actors.add(new HeavySpread(new Vector2(500,-100), 90,60,80,50));
            }
            if(tic == 150)
            {
            	world.actors.add(new HeavyLaser(new Vector2(350,-100), 90,60,80,50));
            }
			tic++;  
			currentTime++;
			if(tic == 250)
			{
				time = time + 250;
				done = true;
			}
		}
		if(x == 40)
		{
			if(tic == 0)
			{
				HUE1 = com.badlogic.gdx.math.MathUtils.random(0, 200);
				HUE2 = com.badlogic.gdx.math.MathUtils.random(250, 450);
				HUE3 = com.badlogic.gdx.math.MathUtils.random(500, 700);
				world.actors.add(new HeavyLaser(new Vector2(HUE1,-100), 90,60,80,50));
				world.actors.add(new HeavyLaser(new Vector2(HUE2,-100), 90,60,80,50));
				world.actors.add(new HeavyLaser(new Vector2(HUE3,-100), 90,60,80,50));
			}
			tic++;
			if(tic == 125)
			{
				time = time + 125;
				done = true;
			}
		}
		tic++;  
		if(tic == 250)
		{
			time = time + 250;
			done = true;
		}
		if(x == 41)
		{
			if(tic == 0)
			{
				HUE1 = com.badlogic.gdx.math.MathUtils.random(0, 140);
				HUE2 = com.badlogic.gdx.math.MathUtils.random(140, 280);
				HUE3 = com.badlogic.gdx.math.MathUtils.random(280, 420);
				HUE4 = com.badlogic.gdx.math.MathUtils.random(420, 560);
				HUE5 = com.badlogic.gdx.math.MathUtils.random(560, 700);
				world.actors.add(new LightLaser(new Vector2(HUE1,-100), 60,60,50,50));
				world.actors.add(new LightLaser(new Vector2(HUE2,-100), 60,60,50,50));
				world.actors.add(new LightLaser(new Vector2(HUE3,-100), 60,60,50,50));
				world.actors.add(new LightLaser(new Vector2(HUE4,-100), 60,60,50,50));
				world.actors.add(new LightLaser(new Vector2(HUE5,-100), 60,60,50,50));
			}
			tic++;
			currentTime++;
			if(tic == 100)
			{
				time = time + 100;
				done = true;
			}
		}
	}
}
