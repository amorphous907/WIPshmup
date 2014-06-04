package View.Levels;

import java.util.Random;

import Models.Star;
import Models.Enemies.LightBasic;
import Models.Enemies.LightSpread;
import Models.Enemies.HeavyBasic;
import Models.Enemies.HeavySpread;
import Models.Enemies.LightLaser;
import Models.Enemies.HeavyLaser;
import Models.Enemies.LightTiny;
import Models.Enemies.Bosses.BOSS1;
import Models.Weapons.Projectiles.EnemyLaser;
import View.World;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class level_1 extends level
{
	Random rnd = new Random();
	boolean PREPARE_TO_DIE = false;
	boolean musicstart = true;
	int x;
	
	public level_1(World world) {
		super(world);
		timeLimit = 60*2;
	}
	
	@Override
	public void update() {
		float size = rnd.nextFloat()*50; 
		if(rnd.nextInt(500)<10 && size > 12.5f && size <= 40)//10
			world.background.insert(0, new Star(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		if(rnd.nextInt(750)<5 && size > 25) //5
			world.background.insert(0, new Star(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		if(rnd.nextInt(250)<25 && size <= 12.5) //25
			world.background.insert(0, new Star(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		
		if(musicstart)
		{
			world.game.audio.loopMusic("level_1", 0.45f);
			musicstart = false;
		}
		
		if(waveDone) //&& time < timeLimit)
		{
			x = com.badlogic.gdx.math.MathUtils.random(21, 21);
			waveDone = false;
			HandleWaves(x);
		}
	}
	@Override
	protected void HandleWaves(int wave) {
		if(x == 1)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 0));
					world.actors.add(new LightBasic(new Vector2(350,-100), 0));
					world.actors.add(new LightBasic(new Vector2(550,-100), 0));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(250,-100), 1));
					world.actors.add(new LightBasic(new Vector2(450,-100), 1));
				}
			} , 1.0f);
			
			world.timer.scheduleTask(new Task()
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 0));
					world.actors.add(new LightBasic(new Vector2(350,-100), 0));
					world.actors.add(new LightBasic(new Vector2(550,-100), 0));
				}
			} , 2.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 3.5f;
					waveDone = true;
				}
			} , 3.5f);
			x = 0;
		}
		
		if(x == 2)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 1));
					world.actors.add(new LightBasic(new Vector2(700,-100), 1));
				}
			} , 0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightBasic(new Vector2(250,-100), 2));
					world.actors.add(new LightBasic(new Vector2(450,-100), 3));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightSpread(new Vector2(0,-100), 6));
					world.actors.add(new LightSpread(new Vector2(700,-100), 7));
				}
			} , 1.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 3.2f;
					waveDone = true;
				}
			} , 3.2f);
			x = 0;
		}
		
		if(x == 3)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightBasic(new Vector2(0,-100), 8));
				}
			} , 0f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightBasic(new Vector2(700,-100), 9));
				}
			} , 0.2f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightBasic(new Vector2(0,-100), 8));
				}
			} , 0.4f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightBasic(new Vector2(700,-100), 9));
				}
			} , 0.6f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightBasic(new Vector2(0,-100), 8));
				}
			} , 0.8f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightBasic(new Vector2(700,-100), 9));
				}
			} , 1.0f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightSpread(new Vector2(200,-100), 6));
					world.actors.add(new LightSpread(new Vector2(500,-100), 7));
				}
			} , 1.0f);
			
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 3.0f;
					waveDone = true;
				}
			} , 3.0f);
			x = 0;
		}
		
		if(x == 4)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(100,-100), 1));
					world.actors.add(new LightSpread(new Vector2(600,-100), 1));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 3));
					world.actors.add(new LightBasic(new Vector2(550,-100), 2));
				}
			} , .7f);
			
			world.timer.scheduleTask(new Task()
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 1));
					world.actors.add(new LightBasic(new Vector2(550,-100), 1));
				}
			} , 1.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 2.2f;
					waveDone = true;
				}
			} , 2.2f);
			x = 0;
		}
		
		if(x == 5)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(350,-100), 4));
					world.actors.add(new LightSpread(new Vector2(350,-100), 5));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(125,-100), 5));
					world.actors.add(new LightSpread(new Vector2(575,-100), 4));
				}
			} , 0.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(250,-100), 3));
					world.actors.add(new LightBasic(new Vector2(450,-100), 2));
				}
			} , 1.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(50,-100), 3));
					world.actors.add(new LightBasic(new Vector2(650,-100), 2));
				}
			} , 2.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 3.9f;
					waveDone = true;
				}
			} , 3.9f);
			x = 0;
		}
		
		if(x == 6)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(-200,-100), 8));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(-200,-100), 8));
				}
			} , 0.3f);
			
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(-200,-100), 8));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(-200,-100), 8));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(-200,-100), 8));
					world.actors.add(new LightSpread(new Vector2(0,-100), 8));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(-200,-100), 8));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 3.0f;
					waveDone = true;
				}
			} , 3.0f);
			x = 0;
		}
		
		if(x == 7)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(350,-100), 0));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 1));
					world.actors.add(new LightBasic(new Vector2(700,-100), 1));
				}
			} , 0.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(0,-100), 4));
					world.actors.add(new LightSpread(new Vector2(700,-100), 5));
				}
			} , 1.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(50,-100), 4));
					world.actors.add(new LightBasic(new Vector2(650,-100), 5));
				}
			} , 2.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(100,-100), 4));
					world.actors.add(new LightBasic(new Vector2(600,-100), 5));
				}
			} , 3.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(350,-100), 0));
				}
			} , 3.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 5.0f;
					waveDone = true;
				}
			} , 5.0f);
			x = 0;
		}
		
		if(x == 8)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(250,-100), 5));
					world.actors.add(new LightBasic(new Vector2(450,-100), 4));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 4));
					world.actors.add(new LightBasic(new Vector2(550,-100), 5));
				}
			} , 3.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 5.0f;
					waveDone = true;
				}
			} , 5.0f);
			x = 0;
		}
		
		if(x == 9)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 4));
					world.actors.add(new LightBasic(new Vector2(550,-100), 5));
					
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(250,-100), 5));
					world.actors.add(new LightBasic(new Vector2(450,-100), 4));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 3.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 5.0f;
					waveDone = true;
				}
			} , 5.0f);
			x = 0;
		}
		
		if(x == 10)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(50,-100), 4));
					world.actors.add(new LightBasic(new Vector2(650,-100), 5));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 4));
					world.actors.add(new LightBasic(new Vector2(550,-100), 5));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(225,-100), 4));
					world.actors.add(new LightBasic(new Vector2(475,-100), 5));
				}
			} , 1.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 4));
					world.actors.add(new LightBasic(new Vector2(550,-100), 5));
				}
			} , 2.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(50,-100), 4));
					world.actors.add(new LightBasic(new Vector2(650,-100), 5));
				}
			} , 3.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 8.0f;
					waveDone = true;
				}
			} , 5.0f);
			x = 0;
		}
		
		if(x == 11)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(50,-100), 4));
					world.actors.add(new LightBasic(new Vector2(150,-100), 4));
					world.actors.add(new LightBasic(new Vector2(250,-100), 4));
					world.actors.add(new LightBasic(new Vector2(350,-100), 4));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(650,-100), 5));
					world.actors.add(new LightBasic(new Vector2(550,-100), 5));
					world.actors.add(new LightBasic(new Vector2(450,-100), 5));
					world.actors.add(new LightBasic(new Vector2(350,-100), 5));
				}
			} , 1.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 2.6f;
					waveDone = true;
				}
			} , 2.8f);
			x = 0;
		}
		
		if(x == 12)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(350,-100), 4));
					world.actors.add(new LightBasic(new Vector2(350,-100), 5));
				}
			} , 1.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(250,-100), 4));
					world.actors.add(new LightBasic(new Vector2(450,-100), 5));
				}
			} , 2.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 3.8f;
					waveDone = true;
				}
			} , 3.8f);
			x = 0;
		}
		
		if(x == 13)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(900,-100), 9));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(900,-100), 9));
				}
			} , 0.3f);
			
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(900,-100), 9));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(900,-100), 9));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(900,-100), 9));
					world.actors.add(new LightSpread(new Vector2(700,-100), 9));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(900,-100), 9));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 3.0f;
					waveDone = true;
				}
			} , 3.0f);
			x = 0;
		}
		
		if(x == 14)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(0,-100), 8));
					world.actors.add(new LightSpread(new Vector2(700,-100), 9));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 8));
					world.actors.add(new LightBasic(new Vector2(700,-100), 9));
				}
			} , 0.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(250,-100), 2));
					world.actors.add(new LightBasic(new Vector2(450,-100), 3));
				}
			} , 1.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 6));
					world.actors.add(new LightBasic(new Vector2(550,-100), 7));
				}
			} , 2.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 4.0f;
					waveDone = true;
				}
			} , 4.0f);
			x = 0;
		}
		
		if(x == 15)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(250,-100), 8));
					world.actors.add(new LightBasic(new Vector2(450,-100), 9));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(250,-100), 8));
					world.actors.add(new LightSpread(new Vector2(450,-100), 9));
				}
			} , 0.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(250,-100), 8));
					world.actors.add(new LightBasic(new Vector2(450,-100), 9));
				}
			} , 1.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 2.7f;
					waveDone = true;
				}
			} , 2.7f);
			x = 0;
		}
		
		if(x == 16)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(325,-100), 0));
					world.actors.add(new LightBasic(new Vector2(375,-100), 0));
				}
			} , 0.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(300,-100), 0));
					world.actors.add(new LightBasic(new Vector2(400,-100), 0));
				}
			} , 0.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(275,-100), 0));
					world.actors.add(new LightBasic(new Vector2(425,-100), 0));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(100,-100), 0));
					world.actors.add(new LightSpread(new Vector2(600,-100), 0));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 2.6f;
					waveDone = true;
				}
			} , 2.6f);
			x = 0;
		}
		
		if(x == 17)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 1));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 1));
				}
			} , 0.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 1));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 1));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 1));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 2.0f;
					waveDone = true;
				}
			} , 2.0f);
			x = 0;
		}
		
		if(x == 18)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new HeavyBasic(new Vector2(350,-100), 0));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 2));
					world.actors.add(new LightBasic(new Vector2(550,-100), 3));
				}
			} , 0.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 2.0f;
					waveDone = true;
				}
			} , 2.0f);
			x = 0;
		}
		
		if(x == 19)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 2));
					world.actors.add(new LightBasic(new Vector2(550,-100), 3));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(150,-100), 3));
					world.actors.add(new LightBasic(new Vector2(550,-100), 2));
				}
			} , 0.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(150,-100), 0));
					world.actors.add(new LightSpread(new Vector2(550,-100), 0));
				}
			} , 1.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 2.6f;
					waveDone = true;
				}
			} , 2.6f);
			x = 0;
		}
		
		if(x == 20)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 6));
					world.actors.add(new LightBasic(new Vector2(100,-100), 6));
					world.actors.add(new LightBasic(new Vector2(200,-100), 6));
					world.actors.add(new LightBasic(new Vector2(300,-100), 6));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(700,-100), 7));
					world.actors.add(new LightBasic(new Vector2(600,-100), 7));
					world.actors.add(new LightBasic(new Vector2(500,-100), 7));
					world.actors.add(new LightBasic(new Vector2(400,-100), 7));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 2.5f;
					waveDone = true;
				}
			} , 2.5f);
			x = 0;
		}
		
		if(x == 21)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightTiny(new Vector2(20,-100), 0));
					world.actors.add(new LightTiny(new Vector2(40,-100), 0));
					world.actors.add(new LightTiny(new Vector2(60,-100), 0));
					world.actors.add(new LightTiny(new Vector2(80,-100), 0));
					world.actors.add(new LightTiny(new Vector2(100,-100), 0));
					world.actors.add(new LightTiny(new Vector2(120,-100), 0));
					world.actors.add(new LightTiny(new Vector2(140,-100), 0));
					world.actors.add(new LightTiny(new Vector2(160,-100), 0));
					world.actors.add(new LightTiny(new Vector2(180,-100), 0));
					world.actors.add(new LightTiny(new Vector2(200,-100), 0));
					world.actors.add(new LightTiny(new Vector2(220,-100), 0));
					world.actors.add(new LightTiny(new Vector2(240,-100), 0));
					world.actors.add(new LightTiny(new Vector2(260,-100), 0));
					world.actors.add(new LightTiny(new Vector2(280,-100), 0));
					world.actors.add(new LightTiny(new Vector2(300,-100), 0));
					world.actors.add(new LightTiny(new Vector2(320,-100), 0));
					world.actors.add(new LightTiny(new Vector2(340,-100), 0));
					world.actors.add(new LightTiny(new Vector2(360,-100), 0));
					world.actors.add(new LightTiny(new Vector2(380,-100), 0));
					world.actors.add(new LightTiny(new Vector2(400,-100), 0));
					world.actors.add(new LightTiny(new Vector2(420,-100), 0));
					world.actors.add(new LightTiny(new Vector2(440,-100), 0));
					world.actors.add(new LightTiny(new Vector2(460,-100), 0));
					world.actors.add(new LightTiny(new Vector2(480,-100), 0));
					world.actors.add(new LightTiny(new Vector2(500,-100), 0));
					world.actors.add(new LightTiny(new Vector2(520,-100), 0));
					world.actors.add(new LightTiny(new Vector2(540,-100), 0));
					world.actors.add(new LightTiny(new Vector2(560,-100), 0));
					world.actors.add(new LightTiny(new Vector2(580,-100), 0));
					world.actors.add(new LightTiny(new Vector2(600,-100), 0));
					world.actors.add(new LightTiny(new Vector2(620,-100), 0));
					world.actors.add(new LightTiny(new Vector2(640,-100), 0));
					world.actors.add(new LightTiny(new Vector2(660,-100), 0));
					world.actors.add(new LightTiny(new Vector2(680,-100), 0));
					world.actors.add(new LightTiny(new Vector2(700,-100), 0));
					
				}
			} , 0.0f);
			
			
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + 0.0f;
					waveDone = true;
				}
			} , 3.0f);
			x = 0;
		}
		/*if(x == #)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					
				}
			} , 0.0f);
			
			
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					timeLimit = timeLimit + #.#f;
					waveDone = true;
				}
			} , #.#f);
			x = 0;
		}*/
	}
	@Override
	public void start() {
		
	}
}