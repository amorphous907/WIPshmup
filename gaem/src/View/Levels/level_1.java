package View.Levels;

import java.util.Random;

import Models.Star;
import Models.level1hanger;
import Models.Enemies.GunshipBasic;
import Models.Enemies.LightBasic;
import Models.Enemies.LightSpread;
import Models.Enemies.LightTiny;
import Models.Enemies.Bosses.BOSS1;
import View.World;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class level_1 extends level
{
	Random rnd = new Random();
	boolean minibossded = false;
	boolean minibosssummon = false;
	boolean PREPARE_TO_DIE = false;
	boolean musicstart = true;
	int boss_here = 0;
	int x;
	int y;
	int z;
	float time = 0;
	boolean NOVA = true;
	
	public level_1(World world) {
		super(world);
		timeLimit = 60*2;
	}
	
	@Override
	public void update() {
		if(star){
			world.timer.scheduleTask(new Task(){
				@Override
				public void run()
				{
					float size = rnd.nextFloat()*20; 
					if(size <= 12.5) //25
						world.background.get(10).insert(0, new Star(new Vector2(rnd.nextInt(700),0), size,size, new Vector2(0,size*4)));
					star = true;
				}
			} , 0.016f);
			star = false;
		}
		
		if(NOVA){ //THIS IS YOUR STAR
			world.timer.scheduleTask(new Task(){
				@Override
				public void run()
				{
					//if(rnd.nextInt(2) == 1)//randomly pick between foreground and background
					//{ 
						world.background.get(0).insert(0, new level1hanger(new Vector2(350,0), 700,2000, new Vector2(0,100)));
					//} 
					//else
					//{
						//world.foreground.insert(0, new level1hanger(new Vector2(350,0), 700,2000, new Vector2(0,100)));
					//}
					NOVA = true;
				}
			} , 8f);
			
			NOVA = false;
		}
		
		if(musicstart)
		{
			world.background.insert(0, new level1hanger(new Vector2(350,0), 700,2000, new Vector2(0,100)));
			world.game.audio.loopMusic("level_1", 0.45f);
			musicstart = false;
		}
		
		if(waveDone && time < timeLimit)
		{
			if(time < 30)
			{
				System.out.println("tier 1");
				x = com.badlogic.gdx.math.MathUtils.random(1, 10);
			}
			if(time >= 30 && time < 60)
			{
				System.out.println("tier 2");
				y = com.badlogic.gdx.math.MathUtils.random(1, 5);
			}
			if(time >= 60 && !minibosssummon)
			{
				world.actors.get(0).add(new GunshipBasic(new Vector2(350,-200)));
			}
			
			if(time >= 60 && minibossded)
			{
				System.out.println("tier 3");
				z = com.badlogic.gdx.math.MathUtils.random(1, 20);
			}
				
			waveDone = false;
			HandleWaves(x);
		}
		
		if(time >= timeLimit && boss_here == 0)
		{
			world.game.audio.stopMusic("level_1");
			boss_here = 1;
		}
		if(boss_here == 1)
		{
			boss_here = 2;
			world.game.audio.loopMusic("level_1 boss", 0.45f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new BOSS1(new Vector2(350,200)));
				}
			} , 3.0f);
		}
		
	}
	@Override
	protected void HandleWaves(int wave) 
	{
		if(x == 1)//x wave is the last 60 seconds
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 0));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(325,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(375,-100), 0));
				}
			} , 0.1f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(300,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(400,-100), 0));
				}
			} , 0.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(200,-100), 0));
					world.actors.get(0).add(new LightBasic(new Vector2(500,-100), 0));
					
				}
			} , 1.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(50,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(125,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(600,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(675,-100), 0));
				}
			} , 2.2f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(75,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(100,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(625,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(650,-100), 0));
				}
			} , 2.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 5.2f;
					waveDone = true;
				}
			} , 5.2f);
			x = 0;
		}
		
		if(x == 2)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(0,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 9));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-50,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(750,-100), 9));
				}
			} , 0.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-100,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(800,-100), 9));
				}
			} , 0.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-150,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(850,-100), 9));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-200,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(900,-100), 9));
				}
			} , 0.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-250,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(950,-100), 9));
				}
			} , 1.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 1));
					world.actors.get(0).add(new LightSpread(new Vector2(350,-100), 0));
					world.actors.get(0).add(new LightBasic(new Vector2(700,-100), 1));
				}
			} , 2.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.6f;
					waveDone = true;
				}
			} , 3.6f);
			x = 0;
		}
		
		if(x == 3)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(10,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(690,-100), 1));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(10,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(690,-100), 1));
				}
			} , 0.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(350,-100), 0));
				}
			} , 0.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(10,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(690,-100), 1));
				}
			} , 0.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 6));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 7));
				}
			} , 1.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(10,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(690,-100), 1));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(10,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(690,-100), 1));
				}
			} , 1.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(10,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(690,-100), 1));
				}
			} , 1.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 5.0f;
					waveDone = true;
				}
			} , 5.0f);
			x = 0;
		}
		
		if(x == 4)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 10));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(150,-100), 4));
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 4));
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 5));
					world.actors.get(0).add(new LightTiny(new Vector2(550,-100), 5));
				}
			} , 0.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 11));
				}
			} , 0.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(500,-100), 11));
					world.actors.get(0).add(new LightBasic(new Vector2(200,-100), 10));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(500,-100), 2));
					world.actors.get(0).add(new LightTiny(new Vector2(200,-100), 3));
				}
			} , 1.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(500,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(200,-100), 10));
				}
			} , 1.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.4f;
					waveDone = true;
				}
			} , 3.4f);
			x = 0;
		}
		
		if(x == 5)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 10));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(300,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(400,-100), 10));
				}
			} , 0.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(250,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(450,-100), 10));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 10));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(300,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(400,-100), 11));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(250,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(450,-100), 11));
				}
			} , 1.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 4.7f;
					waveDone = true;
				}
			} , 4.7f);
			x = 0;
		}
		
		if(x == 6)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(250,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(450,-100), 11));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(250,-100), 2));
					world.actors.get(0).add(new LightSpread(new Vector2(450,-100), 3));
				}
			} , 0.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(50,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(150,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(250,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(450,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(550,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(650,-100), 11));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(50,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(150,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(250,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(450,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(550,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(650,-100), 10));
				}
			} , 1.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(50,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(150,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(250,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(450,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(550,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(650,-100), 9));
				}
			} , 2.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.9f;
					waveDone = true;
				}
			} , 3.9f);
			x = 0;
		}
		
		if(x == 7)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(50,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(650,-100), 1));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(50,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(150,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(550,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(650,-100), 1));
				}
			} , 0.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(20,-100), 2));
					world.actors.get(0).add(new LightTiny(new Vector2(120,-100), 2));
					world.actors.get(0).add(new LightTiny(new Vector2(320,-100), 2));
					world.actors.get(0).add(new LightTiny(new Vector2(380,-100), 3));
					world.actors.get(0).add(new LightTiny(new Vector2(580,-100), 3));
					world.actors.get(0).add(new LightTiny(new Vector2(680,-100), 3));
				}
			} , 1.1f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(20,-100), 4));
					world.actors.get(0).add(new LightTiny(new Vector2(320,-100), 4));
					world.actors.get(0).add(new LightTiny(new Vector2(380,-100), 5));
					world.actors.get(0).add(new LightTiny(new Vector2(680,-100), 5));
				}
			} , 1.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(30,-100), 6));
					world.actors.get(0).add(new LightTiny(new Vector2(130,-100), 6));
					world.actors.get(0).add(new LightTiny(new Vector2(570,-100), 7));
					world.actors.get(0).add(new LightTiny(new Vector2(670,-100), 7));
				}
			} , 1.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 2.8f;
					waveDone = true;
				}
			} , 2.8f);
			x = 0;
		}
		
		if(x == 8)
		{	
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(50,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(150,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(550,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(650,-100), 11));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(20,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(120,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(320,-100), 10));
					world.actors.get(0).add(new LightTiny(new Vector2(380,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(580,-100), 11));
					world.actors.get(0).add(new LightTiny(new Vector2(680,-100), 11));
				}
			} , 0.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(325,-100), 2));
					world.actors.get(0).add(new LightTiny(new Vector2(325,-100), 6));
					world.actors.get(0).add(new LightTiny(new Vector2(325,-100), 2));
					world.actors.get(0).add(new LightTiny(new Vector2(375,-100), 3));
					world.actors.get(0).add(new LightTiny(new Vector2(375,-100), 7));
					world.actors.get(0).add(new LightTiny(new Vector2(375,-100), 3));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 1.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.6f;
					waveDone = true;
				}
			} , 3.6f);
			x = 0;
		}
		
		if(x == 9)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-75,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(0,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(75,-100), 8));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-75,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(0,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(75,-100), 8));
				}
			} , 0.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-75,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(0,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(75,-100), 8));
				}
			} , 0.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-75,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(0,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(75,-100), 8));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-75,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(0,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(75,-100), 8));
				}
			} , 1.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(-75,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(0,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(75,-100), 8));
				}
			} , 2.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(-50,-100), 8));
				}
			} , 2.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 4.8f;
					waveDone = true;
				}
			} , 4.8f);
			x = 0;
		}
		
		if(x == 10)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(775,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(625,-100), 9));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(775,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(625,-100), 9));
				}
			} , 0.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(775,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(625,-100), 9));
				}
			} , 0.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(775,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(625,-100), 9));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(775,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(625,-100), 9));
				}
			} , 1.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(775,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 9));
					world.actors.get(0).add(new LightTiny(new Vector2(625,-100), 9));
				}
			} , 2.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(50,-100), 0));
					world.actors.get(0).add(new LightBasic(new Vector2(650,-100), 0));
				}
			} , 3.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(200,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(500,-100), 9));
				}
			} , 4.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(150,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(550,-100), 9));
				}
			} , 4.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(100,-100), 8));
					world.actors.get(0).add(new LightTiny(new Vector2(600,-100), 9));
				}
			} , 4.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 7.5f;
					waveDone = true;
				}
			} , 7.5f);
			x = 0;
		}
		
		if(y == 1)//y wave is 30 seconds in, but ends at 60
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(300,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(400,-100), 0));
				}
			} , 0.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(250,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(450,-100), 0));
				}
			} , 0.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(200,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(500,-100), 0));
				}
			} , 0.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(-100,-100), 10));
					world.actors.get(0).add(new LightSpread(new Vector2(800,-100), 11));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(200,-100), 7));
					world.actors.get(0).add(new LightBasic(new Vector2(500,-100), 6));
				}
			} , 2.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 2.0f;
					waveDone = true;
				}
			} , 5.0f);
			y = 0;
		}
		
		if(y == 2)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(200,-100), 7));
					world.actors.get(0).add(new LightBasic(new Vector2(500,-100), 6));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(300,-100), 7));
					world.actors.get(0).add(new LightBasic(new Vector2(400,-100), 6));
				}
			} , 0.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(250,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(450,-100), 0));
				}
			} , 1.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(300,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(400,-100), 0));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(350,-100), 0));
				}
			} , 1.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(250,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(450,-100), 0));
				}
			} , 1.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 2));
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 3));
				}
			} , 2.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(150,-100), 1));
					world.actors.get(0).add(new LightSpread(new Vector2(550,-100), 1));
				}
			} , 3.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 6.5f;
					waveDone = true;
				}
			} , 6.5f);
			y = 0;
		}
		
		if(y == 3)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(150,-100), 1));
					world.actors.get(0).add(new LightSpread(new Vector2(550,-100), 1));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(700,-100), 5));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(250,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(450,-100), 0));
				}
			} , 2.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(225,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(275,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(425,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(475,-100), 0));
				}
			} , 2.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(200,-100), 0));
					world.actors.get(0).add(new LightTiny(new Vector2(500,-100), 0));
				}
			} , 3.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 5.5f;
					waveDone = true;
				}
			} , 5.5f);
			y = 0;
		}
		
		if(y == 4)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(00,-100), 1));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(00,-100), 1));
				}
			} , 0.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(00,-100), 1));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(00,-100), 1));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(00,-100), 1));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(00,-100), 1));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 1));
				}
			} , 2.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 1));
				}
			} , 2.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 1));
				}
			} , 2.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 1));
				}
			} , 2.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 1));
				}
			} , 3.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 1));
				}
			} , 3.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 4.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(100,-100), 1));
					world.actors.get(0).add(new LightBasic(new Vector2(600,-100), 1));
				}
			} , 5.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(275,-100), 7));
					world.actors.get(0).add(new LightBasic(new Vector2(425,-100), 6));
				}
			} , 6.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 9.0f;
					waveDone = true;
				}
			} , 9.0f);
			y = 0;
		}
		
		if(y == 5)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(275,-100), 7));
					world.actors.get(0).add(new LightBasic(new Vector2(425,-100), 6));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(350,-100), 1));
				}
			} , 0.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(100,-100), 2));
					world.actors.get(0).add(new LightBasic(new Vector2(600,-100), 3));
				}
			} , 1.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(0,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(700,-100), 1));
				}
			} , 2.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(25,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(675,-100), 1));
				}
			} , 2.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightTiny(new Vector2(50,-100), 1));
					world.actors.get(0).add(new LightTiny(new Vector2(650,-100), 1));
				}
			} , 2.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 6.0f;
					waveDone = true;
				}
			} , 6.0f);
			y = 0;
		}
		
		/*if(y == #)
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
					time = time + #.#f;
					waveDone = true;
				}
			} , #.#f);
			y = 0;
		}*/
		
		if(z == 1)//z wave is the last 60 seconds
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 0));
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 0));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 1));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 1));
				}
			} , 1.0f);
			
			world.timer.scheduleTask(new Task()
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 0));
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 0));
				}
			} , 2.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.5f;
					waveDone = true;
				}
			} , 3.5f);
			z = 0;
		}
		
		if(z == 2)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 1));
					world.actors.get(0).add(new LightBasic(new Vector2(700,-100), 1));
				}
			} , 0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 2));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 3));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.get(0).add(new LightSpread(new Vector2(0,-100), 6));
					world.actors.get(0).add(new LightSpread(new Vector2(700,-100), 7));
				}
			} , 1.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.2f;
					waveDone = true;
				}
			} , 3.2f);
			z = 0;
		}
		
		if(z == 3)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 8));
				}
			} , 0f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.get(0).add(new LightBasic(new Vector2(700,-100), 9));
				}
			} , 0.2f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 8));
				}
			} , 0.4f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.get(0).add(new LightBasic(new Vector2(700,-100), 9));
				}
			} , 0.6f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 8));
				}
			} , 0.8f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.get(0).add(new LightBasic(new Vector2(700,-100), 9));
				}
			} , 1.0f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run(){
					
					world.actors.get(0).add(new LightSpread(new Vector2(200,-100), 6));
					world.actors.get(0).add(new LightSpread(new Vector2(500,-100), 7));
				}
			} , 1.0f);
			
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.0f;
					waveDone = true;
				}
			} , 3.0f);
			z = 0;
		}
		
		if(z == 4)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(100,-100), 1));
					world.actors.get(0).add(new LightSpread(new Vector2(600,-100), 1));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 3));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 2));
				}
			} , .7f);
			
			world.timer.scheduleTask(new Task()
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 1));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 1));
				}
			} , 1.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 2.2f;
					waveDone = true;
				}
			} , 2.2f);
			z = 0;
		}
		
		if(z == 5)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(350,-100), 4));
					world.actors.get(0).add(new LightSpread(new Vector2(350,-100), 5));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(125,-100), 5));
					world.actors.get(0).add(new LightSpread(new Vector2(575,-100), 4));
				}
			} , 0.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 3));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 2));
				}
			} , 1.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(50,-100), 3));
					world.actors.get(0).add(new LightBasic(new Vector2(650,-100), 2));
				}
			} , 2.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.9f;
					waveDone = true;
				}
			} , 3.9f);
			z = 0;
		}
		
		if(z == 6)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(-200,-100), 8));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(-200,-100), 8));
				}
			} , 0.3f);
			
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(-200,-100), 8));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(-200,-100), 8));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(-200,-100), 8));
					world.actors.get(0).add(new LightSpread(new Vector2(0,-100), 8));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(-200,-100), 8));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.0f;
					waveDone = true;
				}
			} , 3.0f);
			z = 0;
		}
		
		if(z == 7)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(350,-100), 0));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 1));
					world.actors.get(0).add(new LightBasic(new Vector2(700,-100), 1));
				}
			} , 0.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(0,-100), 4));
					world.actors.get(0).add(new LightSpread(new Vector2(700,-100), 5));
				}
			} , 1.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(50,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(650,-100), 5));
				}
			} , 2.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(100,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(600,-100), 5));
				}
			} , 3.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(350,-100), 0));
				}
			} , 3.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 5.0f;
					waveDone = true;
				}
			} , 5.0f);
			z = 0;
		}
		
		if(z == 8)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 5));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 4));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 5));
				}
			} , 3.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 5.0f;
					waveDone = true;
				}
			} , 5.0f);
			z = 0;
		}
		
		if(z == 9)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 5));
					
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 5));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 4));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 3.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 5.0f;
					waveDone = true;
				}
			} , 5.0f);
			z = 0;
		}
		
		if(z == 10)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(50,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(650,-100), 5));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 5));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(225,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(475,-100), 5));
				}
			} , 1.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 5));
				}
			} , 2.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(50,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(650,-100), 5));
				}
			} , 3.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 8.0f;
					waveDone = true;
				}
			} , 5.0f);
			z = 0;
		}
		
		if(z == 11)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(50,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 4));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(650,-100), 5));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 5));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 5));
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 5));
				}
			} , 1.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 2.6f;
					waveDone = true;
				}
			} , 2.8f);
			z = 0;
		}
		
		if(z == 12)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 5));
				}
			} , 1.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 4));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 5));
				}
			} , 2.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.8f;
					waveDone = true;
				}
			} , 3.8f);
			z = 0;
		}
		
		if(z == 13)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(900,-100), 9));
				}
			} , 0);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(900,-100), 9));
				}
			} , 0.3f);
			
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(900,-100), 9));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(900,-100), 9));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(900,-100), 9));
					world.actors.get(0).add(new LightSpread(new Vector2(700,-100), 9));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(900,-100), 9));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.0f;
					waveDone = true;
				}
			} , 3.0f);
			z = 0;
		}
		
		if(z == 14)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(0,-100), 8));
					world.actors.get(0).add(new LightSpread(new Vector2(700,-100), 9));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 8));
					world.actors.get(0).add(new LightBasic(new Vector2(700,-100), 9));
				}
			} , 0.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 2));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 3));
				}
			} , 1.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 6));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 7));
				}
			} , 2.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 4.0f;
					waveDone = true;
				}
			} , 4.0f);
			z = 0;
		}
		
		if(z == 15)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 8));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 9));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(250,-100), 8));
					world.actors.get(0).add(new LightSpread(new Vector2(450,-100), 9));
				}
			} , 0.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 8));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 9));
				}
			} , 1.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 2.7f;
					waveDone = true;
				}
			} , 2.7f);
			z = 0;
		}
		
		if(z == 16)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(325,-100), 0));
					world.actors.get(0).add(new LightBasic(new Vector2(375,-100), 0));
				}
			} , 0.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(300,-100), 0));
					world.actors.get(0).add(new LightBasic(new Vector2(400,-100), 0));
				}
			} , 0.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(275,-100), 0));
					world.actors.get(0).add(new LightBasic(new Vector2(425,-100), 0));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(100,-100), 0));
					world.actors.get(0).add(new LightSpread(new Vector2(600,-100), 0));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 2.6f;
					waveDone = true;
				}
			} , 2.6f);
			z = 0;
		}
		
		if(z == 17)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 1));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 1));
				}
			} , 0.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 1));
				}
			} , 0.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 1));
				}
			} , 0.9f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 1));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 2.0f;
					waveDone = true;
				}
			} , 2.0f);
			z = 0;
		}
		
		if(z == 18)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(350,-100), 0));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 2));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 3));
				}
			} , 0.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(350,-100), 0));
				}
			} , 1.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(250,-100), 10));
					world.actors.get(0).add(new LightBasic(new Vector2(450,-100), 11));
				}
			} , 2.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 8));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 9));
				}
			} , 3.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 5.0f;
					waveDone = true;
				}
			} , 5.0f);
			z = 0;
		}
		
		if(z == 19)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 2));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 3));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(150,-100), 3));
					world.actors.get(0).add(new LightBasic(new Vector2(550,-100), 2));
				}
			} , 0.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightSpread(new Vector2(150,-100), 0));
					world.actors.get(0).add(new LightSpread(new Vector2(550,-100), 0));
				}
			} , 1.7f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 3.8f;
					waveDone = true;
				}
			} , 3.8f);
			z = 0;
		}
		
		if(z == 20)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(0,-100), 6));
					world.actors.get(0).add(new LightBasic(new Vector2(100,-100), 6));
					world.actors.get(0).add(new LightBasic(new Vector2(200,-100), 6));
					world.actors.get(0).add(new LightBasic(new Vector2(300,-100), 6));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.get(0).add(new LightBasic(new Vector2(700,-100), 7));
					world.actors.get(0).add(new LightBasic(new Vector2(600,-100), 7));
					world.actors.get(0).add(new LightBasic(new Vector2(500,-100), 7));
					world.actors.get(0).add(new LightBasic(new Vector2(400,-100), 7));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 2.5f;
					waveDone = true;
				}
			} , 2.5f);
			z = 0;
		}
		
		if(z == 21)
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
					time = time + 0.0f;
					waveDone = true;
				}
			} , 3.0f);
			z = 0;
		}
		
	}
	@Override
	public void start() {
		
	}
}
