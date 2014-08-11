package Models.Enemies;

import Models.MoveableEntity;
import Models.subObject;
import Models.Weapons.Projectiles.EnemyBulletTiny;
import Models.Weapons.Projectiles.EnemyLaser;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class debuffCrack1 extends subObject{
	
	public debuffCrack1(Vector2 offset, float width, float height,
			float hitX, float hitY, MoveableEntity Parent) {
		super(offset, width, height, hitX, hitY, Parent);
		texture = "debuffCrack1";
		actorID = 42;
	}

	@Override
	public void update(World world, MoveableEntity Parent){
		super.update(world, Parent);
	}
}
