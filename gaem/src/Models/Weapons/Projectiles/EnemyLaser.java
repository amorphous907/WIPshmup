package Models.Weapons.Projectiles;

import Models.MoveableEntity;
import Models.Players.Player;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class EnemyLaser extends EnemyBullet {

	public EnemyLaser(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		texture = "enemyLaser";
		animate = false;
		// TODO Auto-generated constructor stub
	}
	
	public EnemyLaser(Vector2 position, float width, float height, float hitX,
			float hitY, Vector2 velocity) {
		super(position, width, height, hitX, hitY, velocity);
		animate = false;
		// TODO Auto-generated constructor stub
	}
	public void update(World world)
	{
		
		super.update(world);
	}
	
	public void collidesWith(MoveableEntity e, World world)
	{
		if(e instanceof Player){
			((Player) e).damage(75);
			remove = true;
		}
	}

}
