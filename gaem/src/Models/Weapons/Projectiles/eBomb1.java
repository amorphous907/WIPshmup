package Models.Weapons.Projectiles;

import View.World;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class eBomb1 extends EnemyBullet {
	int tic = 0;
	private boolean explode;
	public eBomb1(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		// TODO Auto-generated constructor stub
		velocity = new Vector2(0,200);
	}
	
	public void update(World world)
	{
		if(tic == 0)
		{
			world.timer.scheduleTask(new Task(){

				@Override
				public void run() {
					explode = true;
				}
				
			}, 1.5f);
			tic = 1;
		}
		if(explode){
			world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(300,300)));
			world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(0,400)));
			world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-300,300)));
			world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-400,0)));
			world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(400,0)));
			world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(300,-300)));
			world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(0,-400)));
			world.actors.add(new EnemyBullet(new Vector2(position.x+width/2,position.y+height),25,25,25,25, new Vector2(-300,-300)));
			remove = true;
		}
		super.update(world);
	} 
	
}


