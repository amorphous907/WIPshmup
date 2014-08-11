package View.Levels;

import java.util.Random;

import Models.Star;
import Models.Enemies.LightBasic;
import Models.Enemies.LightSpread;
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
		if(rnd.nextInt(1000)<10 && size > 12.5f && size <= 40)//10
			world.background.insert(0, new Star(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		if(rnd.nextInt(1500)<5 && size > 25) //5
			world.background.insert(0, new Star(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
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
				y = com.badlogic.gdx.math.MathUtils.random(1, 5);
			}
			if(time >= 60)
			{
				System.out.println("tier 2");
				z = com.badlogic.gdx.math.MathUtils.random(1, 20);
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
			world.game.audio.loopMusic("level_1 boss", 0.45f);
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