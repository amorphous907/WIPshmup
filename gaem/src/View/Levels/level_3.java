package View.Levels;

import java.util.Random;


import Models.ast;
import Models.yellow;
import Models.Enemies.LightBasic;
import Models.Enemies.enemyAL;
import Models.Enemies.enemyAR;
import Models.Enemies.HeavyBasic;
import Models.Enemies.HeavySpread;
import Models.Enemies.LightLaser;
import Models.Enemies.HeavyLaser;
import Models.Enemies.GunshipBasic;
import Models.Enemies.EnemyMines;
import Models.Enemies.Bosses.BOSS3;
import View.World;

import com.badlogic.gdx.math.Vector2;

public class level_3 extends level_1
{
	
	Random rnd = new Random();
	int tic = 0;
	public void update(World world)
	{
		float size = rnd.nextFloat()*50; 
		if(rnd.nextInt(50)<10 && size > 12.5f && size <= 25)//10
			world.actors.add(new yellow(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		if(rnd.nextInt(75)<5 && size > 25) //5
			world.actors.add(new yellow(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		if(rnd.nextInt(25)<25 && size <= 12.5) //25
			world.actors.add(new yellow(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		//asteroid
		if(rnd.nextInt(50)<10 && size > 12.5f && size <= 25)
			world.actors.add(new ast(new Vector2(rnd.nextInt(700),0), size,size,0,0, new Vector2(0,size*4)));
		
		tic++;
			if(tic == 1)
				world.game.audio.loopMusic("level_3");
	
	if(tic == 400) 
    {
		world.actors.add(new LightBasic(new Vector2(100,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 500)
    {
    	world.actors.add(new enemyAL(new Vector2(200,-100), 60,60,50,50));
    	world.actors.add(new enemyAR(new Vector2(500,-100), 60,60,50,50));
    }
    if(tic == 600)
    {
    	world.actors.add(new LightBasic(new Vector2(100,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 700)
    {
    	world.actors.add(new GunshipBasic(new Vector2(350,-100), 90,60,80,50));
    }
    if(tic == 800)
    {
    	world.actors.add(new HeavyBasic(new Vector2(200,-100), 90,60,80,50));
    	world.actors.add(new HeavyBasic(new Vector2(500,-100), 90,60,80,50));
    }
    if(tic == 900)
    {
    	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
    }
    if(tic == 1000)
    {
    	world.actors.add(new LightBasic(new Vector2(475,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(225,-100), 60,60,50,50));
    }
    if(tic == 1100)
    {
    	world.actors.add(new HeavyBasic(new Vector2(350,-100), 90,60,80,50));
    }
    if(tic == 1200)
    {
    	world.actors.add(new LightBasic(new Vector2(475,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(225,-100), 60,60,50,50));
    }
    if(tic == 1300)
    {
    	world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
    }
    if(tic == 1400)
    {
    	world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 1500)
    {
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 1600)
    {
    	world.actors.add(new LightLaser(new Vector2(475,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(225,-100), 60,60,50,50));
    }
    if(tic == 1700)
    {
    	world.actors.add(new HeavyBasic(new Vector2(400,-100), 90,60,80,50));
    	world.actors.add(new HeavyBasic(new Vector2(300,-100), 90,60,80,50));
    }
    if(tic == 1800)
    {
    	world.actors.add(new EnemyMines(new Vector2(50,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(650,-100), 60,60,50,50));
    }
    if(tic == 1850)
    {
    	world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 1950)
    {
    	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
    }
    if(tic == 2050)
    {
    	world.actors.add(new HeavyLaser(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new LightLaser(new Vector2(250,-100), 60,60,50,50));
        world.actors.add(new LightLaser(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 2150)
    {
    	world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 2250)
    {
    	world.actors.add(new HeavyBasic(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
        world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 2400)
    {
    	world.actors.add(new enemyAR(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 2500)
    {
    	world.actors.add(new enemyAR(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 2600)
    {
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 2700)
    {
    	world.actors.add(new EnemyMines(new Vector2(50,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(650,-100), 60,60,50,50));
    }
    if(tic == 2800)
    {
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 2900)
    {
    	world.actors.add(new enemyAR(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 3000)
    {
    	world.actors.add(new enemyAR(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 3000)
    {
    	world.actors.add(new LightBasic(new Vector2(150,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 3200)
    {
    	world.actors.add(new HeavySpread(new Vector2(200,-100), 90,60,80,50));
    	world.actors.add(new HeavyLaser(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new HeavySpread(new Vector2(500,-100), 90,60,80,50));
    }
    if(tic == 3200)
    {
    	world.actors.add(new HeavySpread(new Vector2(200,-100), 90,60,80,50));
    	world.actors.add(new HeavyLaser(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new HeavySpread(new Vector2(500,-100), 90,60,80,50));
    }
    if(tic == 3300)
    {
    	world.actors.add(new LightBasic(new Vector2(100,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(400,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(300,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 3400)
    {
    	world.actors.add(new enemyAR(new Vector2(0,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(700,-100), 60,60,50,50));
    }
    if(tic == 3500)
    {
    	world.actors.add(new enemyAR(new Vector2(0,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(700,-100), 60,60,50,50));
    }
    if(tic == 3600)
    {
    	world.actors.add(new enemyAR(new Vector2(0,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(700,-100), 60,60,50,50));
    }
    if(tic == 3700)
    {
    	world.actors.add(new EnemyMines(new Vector2(100,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(300,-100), 60,60,50,50));
        world.actors.add(new HeavyBasic(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new EnemyMines(new Vector2(400,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 3800)
    {
    	world.actors.add(new EnemyMines(new Vector2(200,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(500,-100), 60,60,50,50));
    }
    if(tic == 3900)
    {
    	world.actors.add(new EnemyMines(new Vector2(200,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(500,-100), 60,60,50,50));
    }
    if(tic == 4100)
    {
    	world.actors.add(new LightLaser(new Vector2(200,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(500,-100), 60,60,50,50));
    }
    if(tic == 4200)
    {
    	world.actors.add(new LightLaser(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(300,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(400,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 4300)
    {
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(225,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(475,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 4450)
    {
    	world.actors.add(new HeavySpread(new Vector2(150,-100), 90,60,80,50));
        world.actors.add(new GunshipBasic(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new HeavySpread(new Vector2(550,-100), 90,60,80,50));
    }
    if(tic == 4450)
    {
    	world.actors.add(new HeavyBasic(new Vector2(50,-100), 90,60,80,50));
    	world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new HeavyBasic(new Vector2(650,-100), 90,60,80,50));
    }
    if(tic == 4550)
    {
    	world.actors.add(new enemyAR(new Vector2(50,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new enemyAL(new Vector2(650,-100), 60,60,50,50));
    }
    if(tic == 4700)
    {
    	world.actors.add(new LightLaser(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new HeavyLaser(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new LightLaser(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 4800)
    {
    	world.actors.add(new HeavyLaser(new Vector2(150,-100), 90,60,80,50));
        world.actors.add(new HeavyBasic(new Vector2(250,-100), 90,60,80,50));
        world.actors.add(new HeavyBasic(new Vector2(450,-100), 90,60,80,50));
        world.actors.add(new HeavyLaser(new Vector2(550,-100), 90,60,80,50));
    }
    if(tic == 4900)
    {
    	world.actors.add(new enemyAL(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
        world.actors.add(new enemyAR(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 5050)
    {
    	world.actors.add(new LightBasic(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 5150)
    {
    	world.actors.add(new enemyAR(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new HeavyBasic(new Vector2(250,-100), 90,60,80,50));
    	world.actors.add(new HeavyBasic(new Vector2(450,-100), 90,60,80,50));
        world.actors.add(new enemyAL(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 5250)
    {
    	world.actors.add(new HeavySpread(new Vector2(250,-100), 90,60,80,50));
    	world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new HeavySpread(new Vector2(450,-100), 90,60,80,50));
    }
    if(tic == 5300)
    {
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 5400)
    {
    	world.actors.add(new HeavyLaser(new Vector2(150,-100), 90,60,80,50));
    	world.actors.add(new HeavyLaser(new Vector2(550,-100), 90,60,80,50));
    }
    if(tic == 5400)
    {
    	world.actors.add(new LightLaser(new Vector2(300,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(400,-100), 60,60,50,50));
    }
    if(tic == 5500)
    {
    	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
    }
    if(tic == 5650)
    {
    	world.actors.add(new enemyAR(new Vector2(400,-100), 60,60,50,50));
    }
    if(tic == 5700)
    {
    	world.actors.add(new enemyAR(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 5750)
    {
    	world.actors.add(new enemyAR(new Vector2(500,-100), 60,60,50,50));
    }
    if(tic == 5800)
    {
    	world.actors.add(new enemyAR(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 6000)
    {
    	world.actors.add(new HeavySpread(new Vector2(200,-100), 90,60,80,50));
    	world.actors.add(new HeavySpread(new Vector2(500,-100), 90,60,80,50));
    }
    if(tic == 6200)
    {
    	world.actors.add(new LightBasic(new Vector2(100,-100), 60,60,50,50));
    	world.actors.add(new HeavyBasic(new Vector2(200,-100), 90,60,80,50));
    	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new HeavyBasic(new Vector2(500,-100), 90,60,80,50));
        world.actors.add(new LightBasic(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 6300)
    {
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(300,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(400,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 6400)
    {
    	world.actors.add(new enemyAR(new Vector2(150,-100), 90,60,80,50));
    	world.actors.add(new enemyAL(new Vector2(550,-100), 90,60,80,50));
    }
    if(tic == 6500)
    {
    	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
    }
    if(tic == 6600)
    {
    	world.actors.add(new HeavyLaser(new Vector2(250,-100), 90,60,80,50));
    	world.actors.add(new HeavyLaser(new Vector2(450,-100), 90,60,80,50));
    }
    if(tic == 6650)
    {
    	world.actors.add(new LightLaser(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 6700)
    {
    	world.actors.add(new EnemyMines(new Vector2(300,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(400,-100), 60,60,50,50));
    }
    if(tic == 6800)
    {
    	world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(300,-100), 60,60,50,50));
        world.actors.add(new GunshipBasic(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new EnemyMines(new Vector2(400,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 6900)
    {
    	world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 7100)
    {
    	world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 7200)
    {
    	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 7300)
    {
    	world.actors.add(new LightLaser(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new LightLaser(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 7450)
    {
    	world.actors.add(new EnemyMines(new Vector2(200,-100), 60,60,50,50));
        world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new EnemyMines(new Vector2(500,-100), 60,60,50,50));
    }
    if(tic == 7550)
    {
    	world.actors.add(new HeavyBasic(new Vector2(250,-100), 90,60,80,50));
    	world.actors.add(new HeavyBasic(new Vector2(450,-100), 90,60,80,50));
    }
    if(tic == 7600)
    {
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));;
        world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 7700)
    {
    	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
    }
    if(tic == 7800)
    {
    	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
    }
    if(tic == 7900)
    {
    	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 8000)
    {
    	world.actors.add(new enemyAR(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 8100)
    {
    	world.actors.add(new HeavyBasic(new Vector2(150,-100), 90,60,80,50));
    	world.actors.add(new HeavyBasic(new Vector2(550,-100), 90,60,80,50));
    }
    if(tic == 8300)
    {
    	world.actors.add(new GunshipBasic(new Vector2(350,-100), 90,60,80,50));
    }
    if(tic == 8400)
    {
    	world.actors.add(new EnemyMines(new Vector2(300,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(325,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(375,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(400,-100), 60,60,50,50));
    }
    if(tic == 8500)
    {
    	world.actors.add(new LightBasic(new Vector2(350,-100), 60,60,50,50));
    }

    if(tic == 8700)
    {
    	world.actors.add(new HeavySpread(new Vector2(100,-100), 90,60,80,50));
        world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new HeavySpread(new Vector2(600,-100), 90,60,80,50));
    }
    if(tic == 8800)
    {
    	world.actors.add(new HeavyBasic(new Vector2(200,-100), 90,60,80,50));
    	world.actors.add(new HeavyBasic(new Vector2(500,-100), 90,60,80,50));
    }
    if(tic == 8900)
    {
    	world.actors.add(new HeavyLaser(new Vector2(50,-100), 90,60,80,50));
    	world.actors.add(new HeavyLaser(new Vector2(650,-100), 90,60,80,50));
    }
    if(tic == 9000)
    {
    	world.actors.add(new EnemyMines(new Vector2(100,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(125,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(175,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(200,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(500,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(525,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(575,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 9000)
    {
    	world.actors.add(new enemyAR(new Vector2(100,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 9100)
    {
    	world.actors.add(new LightLaser(new Vector2(100,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 9200)
    {
    	world.actors.add(new LightLaser(new Vector2(200,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(500,-100), 60,60,50,50));
    }
    if(tic == 9400)
    {
    	world.actors.add(new LightBasic(new Vector2(100,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(200,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(500,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 9500)
    {
    	world.actors.add(new enemyAR(new Vector2(100,-100), 60,60,50,50));
    	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new enemyAL(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 9600)
    {
    	world.actors.add(new HeavyLaser(new Vector2(150,-100), 90,60,80,50));
        world.actors.add(new HeavyBasic(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new HeavyLaser(new Vector2(550,-100), 90,60,80,50));
    }
    if(tic == 9600)
    {
    	world.actors.add(new EnemyMines(new Vector2(100,-100), 60,60,50,50));
        world.actors.add(new GunshipBasic(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new EnemyMines(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 9700)
    {
    	world.actors.add(new EnemyMines(new Vector2(100,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(200,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(500,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 9800)
    {
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 9800)
    {
    	world.actors.add(new LightBasic(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
    	world.actors.add(new LightBasic(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 9900)
    {
    	world.actors.add(new enemyAR(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 10100)
    {
    	world.actors.add(new enemyAR(new Vector2(350,-100), 60,60,50,50));
    	world.actors.add(new enemyAL(new Vector2(350,-100), 60,60,50,50));
    }
    if(tic == 10200)
    {
    	world.actors.add(new HeavyBasic(new Vector2(250,-100), 90,60,80,50));
    	world.actors.add(new HeavySpread(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new HeavyBasic(new Vector2(450,-100), 90,60,80,50));
    }
    if(tic == 10300)
    {
    	world.actors.add(new LightBasic(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new LightBasic(new Vector2(450,-100), 60,60,50,50));
    }
    if(tic == 10400)
    {
    	world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
    }
    if(tic == 10500)
    {
    	world.actors.add(new EnemyMines(new Vector2(100,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(200,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(500,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 10600)
    {
    	world.actors.add(new LightLaser(new Vector2(100,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(300,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(400,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 10700)
    {
    	world.actors.add(new enemyAR(new Vector2(100,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(300,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(400,-100), 60,60,50,50));
        world.actors.add(new enemyAR(new Vector2(600,-100), 60,60,50,50));
    }
    if(tic == 10800)
    {
    	world.actors.add(new HeavyBasic(new Vector2(300,-100), 90,60,80,50));
    	world.actors.add(new HeavyLaser(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new HeavyBasic(new Vector2(400,-100), 90,60,80,50));
    }
    if(tic == 10900)
    {
    	world.actors.add(new LightBasic(new Vector2(300,-100), 60,60,50,50));
    	world.actors.add(new LightLaser(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new LightBasic(new Vector2(400,-100), 60,60,50,50));
    }
    if(tic == 11000)
    {
    	world.actors.add(new enemyAR(new Vector2(300,-100), 60,60,50,50));
    	world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
        world.actors.add(new enemyAR(new Vector2(400,-100), 60,60,50,50));
    }
    if(tic == 11200)
    {
    	world.actors.add(new EnemyMines(new Vector2(300,-100), 60,60,50,50));
        world.actors.add(new GunshipBasic(new Vector2(350,-100), 90,60,80,50));
        world.actors.add(new EnemyMines(new Vector2(400,-100), 60,60,50,50));
    }
    if(tic == 11350)
    {
    	world.actors.add(new EnemyMines(new Vector2(100,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(150,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(200,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(250,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(300,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
    }
    if(tic == 11450)
    {
    	world.actors.add(new EnemyMines(new Vector2(600,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(550,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(500,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(450,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(400,-100), 60,60,50,50));
        world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
    }
    if(tic == 11600)
    {
    	world.actors.add(new EnemyMines(new Vector2(350,-100), 60,60,50,50));
    }
    if(tic == 12000)
    {
    	world.actors.add(new BOSS3(new Vector2(350,-100), 60,60,50,50));
    }
}
}
