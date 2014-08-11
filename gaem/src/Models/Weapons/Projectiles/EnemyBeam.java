package Models.Weapons.Projectiles;

import Models.MoveableEntity;
import Models.Players.Player;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class EnemyBeam extends EnemyBullet {

	public EnemyBeam(Vector2 position, float width, float height, float hitX, float hitY) {
		super(position, width, height, hitX, hitY);
		texture = "enemyBeam";
		actorID = 42;
		animate = false;
		velocity.y = 0;
		// TODO Auto-generated constructor stub
	}
	
	public void update(World world)
	{
		super.update(world);
		height++;
	}
	
	public void collidesWith(MoveableEntity e, World world)
	{
		if(e instanceof Player)
		{
			((Player) e).damage(20);
		}
	}
}
