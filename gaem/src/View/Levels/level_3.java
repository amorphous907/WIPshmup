package View.Levels;

import com.badlogic.gdx.math.Vector2;

import Models.Enemies.Bosses.BOSS2;
import Models.Enemies.Bosses.BOSS3INVIS;
import View.World;

public class level_3 extends level {
	boolean aspie = true;

	public level_3(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(aspie)
		{
			world.game.audio.loopMusic("level_3 boss", 0.45f);
			world.actors.get(0).add(new BOSS3INVIS(new Vector2(350,-200)));
			aspie = false;
		}
	}

	@Override
	protected void HandleWaves(int wave) {
		// TODO Auto-generated method stub

	}

}
