package View.Levels;

import java.util.Random;

import Models.Star;
import Models.Enemies.LightBasic;
import Models.Enemies.LightSpread;
import Models.Enemies.LightTiny;
import Models.Enemies.Bosses.BOSS2;
import View.World;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class level_2 extends level
{
	Random rnd = new Random();
	boolean PREPARE_TO_DIE = false;
	boolean musicstart = true;
	int boss_here = 0;
	int x;
	int y;
	int z;
	float time = 0;
	
	public level_2(World world) {
		super(world);
		timeLimit = 60*2;
	}
	
	@Override
	public void update() {
		float size = rnd.nextFloat()*50; 
		if(rnd.nextInt(500)<25 && size <= 12.5) //25
			world.background.insert(0, new Star(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		
		if(musicstart)
		{
			world.game.audio.loopMusic("level_2", 0.45f);
			musicstart = false;
		}
		
		if(waveDone && time < timeLimit)
		{
			if(time < 30)
			{
				System.out.println("tier 1");
				y = com.badlogic.gdx.math.MathUtils.random(1, 10);
			}
			
			if(time >= 30)
			{
				System.out.println("tier 2");
				z = com.badlogic.gdx.math.MathUtils.random(1, 30);
			}
				
			waveDone = false;
			HandleWaves(x);
		}
		
		if(time >= timeLimit && boss_here == 0)
		{
			world.game.audio.stopMusic("level_2");
			boss_here = 1;
		}
		if(boss_here == 1)
		{
			boss_here = 2;
			world.game.audio.loopMusic("level_2 boss", 0.45f);
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new BOSS2(new Vector2(350,-200)));
				}
			} , 1.0f);
		}
		
	}
	@Override
	protected void HandleWaves(int wave) 
	{
		if(y == 1)
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
					world.actors.add(new LightBasic(new Vector2(350,-100), 2));
					world.actors.add(new LightBasic(new Vector2(350,-100), 3));
				}
			} , 2.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(250,-100), 10));
					world.actors.add(new LightBasic(new Vector2(450,-100), 11));
				}
			} , 3.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(350,-100), 1));
				}
			} , 5.1f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 8.1f;
					waveDone = true;
				}
			} , 8.1f);
			y = 0;
		}
		
		if(y == 2)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(350,-100), 1));
					world.actors.add(new LightSpread(new Vector2(350,-100), 1));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(300,-100), 2));
					world.actors.add(new LightBasic(new Vector2(400,-100), 3));
				}
			} , 1.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(100,-100), 4));
					world.actors.add(new LightSpread(new Vector2(600,-100), 5));
				}
			} , 4.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(300,-100), 5));
					world.actors.add(new LightBasic(new Vector2(400,-100), 4));
				}
			} , 6.3f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 9.3f;
					waveDone = true;
				}
			} , 9.3f);
			y = 0;
		}
		
		if(y == 3)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(-150,-100), 1));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(-150,-100), 1));
				}
			} , 1.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(-150,-100), 1));
				}
			} , 2.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(-150,-100), 1));
				}
			} , 3.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(-150,-100), 1));
				}
			} , 4.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(850,-100), 1));
				}
			} , 6.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(850,-100), 1));
				}
			} , 7.2f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(850,-100), 1));
				}
			} , 8.4f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(850,-100), 1));
				}
			} , 9.6f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(850,-100), 1));
				}
			} , 10.8f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 13.8f;
					waveDone = true;
				}
			} , 13.8f);
			y = 0;
		}
		
		if(y == 4)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 0));
					world.actors.add(new LightBasic(new Vector2(700,-100), 0));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(50,-100), 0));
					world.actors.add(new LightBasic(new Vector2(650,-100), 0));
				}
			} , 1.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(100,-100), 0));
					world.actors.add(new LightBasic(new Vector2(600,-100), 0));
				}
			} , 2.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(200,-100), 4));
					world.actors.add(new LightSpread(new Vector2(500,-100), 5));
				}
			} , 4.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 7.0f;
					waveDone = true;
				}
			} , 7.0f);
			y = 0;
		}
		
		if(y == 5)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightSpread(new Vector2(200,-100), 2));
					world.actors.add(new LightSpread(new Vector2(500,-100), 3));
				}
			} , 0.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(100,-100), 0));
					world.actors.add(new LightBasic(new Vector2(600,-100), 0));
				}
			} , 2.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(50,-100), 0));
					world.actors.add(new LightBasic(new Vector2(650,-100), 0));
				}
			} , 2.5f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(100,-100), 0));
					world.actors.add(new LightBasic(new Vector2(600,-100), 0));
				}
			} , 3.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(350,-100), 10));
					world.actors.add(new LightBasic(new Vector2(350,-100), 0));
					world.actors.add(new LightBasic(new Vector2(350,-100), 11));
				}
			} , 5.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					world.actors.add(new LightBasic(new Vector2(0,-100), 8));
					world.actors.add(new LightBasic(new Vector2(700,-100), 9));
				}
			} , 7.0f);
			
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					time = time + 10.0f;
					waveDone = true;
				}
			} , 10.0f);
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
		
		/*if(z == #)
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
			z = 0;
		}*/
	}
	@Override
	public void start() {
		
	}
}