package Models.Weapons.Projectiles;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class eBomb2 extends EnemyBullet {
	private boolean fire = true;

	public eBomb2(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		velocity = new Vector2(0,200);
		texture = "enemyLaser";
		//animate = false;
	}
	
	public void update(World world)
	{
		
		if(fire)
        {
			world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(300,0)));
        	world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-300,0)));
            world.timer.scheduleTask(new Task(){

				@Override
				public void run() {
					fire = true;
				}
            	
            }, 0.86f);
            fire = false;
        }
		super.update(world);
	}
	
}


