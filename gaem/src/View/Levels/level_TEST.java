package View.Levels;

import java.util.Random;

//import Models.BOSS4;
import Models.Star;
import Models.yellow;
import Models.Enemies.LightBasic;
import Models.Enemies.HeavyBasic;
import Models.Enemies.HeavySpread;
import Models.Enemies.LightLaser;
import Models.Enemies.HeavyLaser;
import Models.Enemies.GunshipBasic;
import Models.Enemies.EnemyMines;
import Models.Enemies.Bosses.BOSS4;
import Models.Enemies.Bosses.BOSS2;
import Models.Enemies.Bosses.BOSS3;
import Models.Enemies.Bosses.BOSS5;
import Models.Players.Powerups.PowerupSPD;
import Models.Players.Powerups.PowerupSTR;
import Models.Players.Powerups.Powerups;
import View.World;

import com.badlogic.gdx.math.Vector2;

public class level_TEST extends level_1
{
	public level_TEST(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}
	int tic = 0;
	public void update(World world)
	{
		
		tic++;
		
		if(tic == 100)
		{
			world.actors.get(0).add(new PowerupSPD(new Vector2(350,50), 30,30,30,30));
			world.actors.get(0).add(new PowerupSTR(new Vector2(350,200), 30,30,30,30));
		}
	}
}

