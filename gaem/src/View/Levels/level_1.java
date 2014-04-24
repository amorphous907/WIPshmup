package View.Levels;

import java.util.Random;

import Models.Star;
import Models.Enemies.LightBasic;
import Models.Enemies.LightSpread;
import Models.Enemies.enemyAL;
import Models.Enemies.enemyAR;
import Models.Enemies.HeavyBasic;
import Models.Enemies.HeavySpread;
import Models.Enemies.LightLaser;
import Models.Enemies.HeavyLaser;
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
		if(rnd.nextInt(50)<10 && size > 12.5f && size <= 40)//10
			world.background.insert(0, new Star(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		if(rnd.nextInt(75)<5 && size > 25) //5
			world.background.insert(0, new Star(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		if(rnd.nextInt(25)<25 && size <= 12.5) //25
			world.background.insert(0, new Star(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		
		if(musicstart)
		{
			world.game.audio.loopMusic("level_1", 0.45f);
			musicstart = false;
		}
		
		if(waveDone) //&& time < timeLimit)
		{
			x = com.badlogic.gdx.math.MathUtils.random(1, 2);
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
					currentTime = currentTime + 3.5f;
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
				public void run(){
					
					world.actors.add(new LightBasic(new Vector2(0,-100), 1));
					world.actors.add(new LightBasic(new Vector2(700,-100), 1));
				}
			} , 0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightBasic(new Vector2(0,-100), 2));
					world.actors.add(new LightBasic(new Vector2(700,-100), 3));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.add(new LightSpread(new Vector2(0,-100), 7));
					world.actors.add(new LightSpread(new Vector2(700,-100), 8));
				}
			} , 1.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					currentTime += 3.2f;
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
					world.actors.add(new LightSpread(new Vector2(500,-100), 5));
				}
			} , 1.0f);
			
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					currentTime = currentTime + 2.0f;
					waveDone = true;
				}
			} , 1.5f);
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
					currentTime = currentTime + 2.2f;
					waveDone = true;
				}
			} , 2.2f);
		}
		
		if(x == 5)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(350,-100), 5));
					world.actors.add(new LightSpread(new Vector2(350,-100), 6));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(125,-100), 5));
					world.actors.add(new LightSpread(new Vector2(575,-100), 6));
				}
			} , 0.7f);
			
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
			} , 2.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					currentTime = currentTime + 3.6f;
					waveDone = true;
				}
			} , 3.6f);
		}
	}
	@Override
	public void start() {
		
	}
}