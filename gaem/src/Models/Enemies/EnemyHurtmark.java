package Models.Enemies;

import Models.MoveableEntity;
import Models.subObject;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class EnemyHurtmark extends subObject{
	public Vector2 aim;
	int x = 0;
	
	public EnemyHurtmark(Vector2 offset, float width, float height,
			float hitX, float hitY, MoveableEntity Parent) {
		super(offset, width, height, hitX, hitY, Parent);
		actorID = 12;
		texture = "Hurtmark1";
		x = com.badlogic.gdx.math.MathUtils.random(0, 359);
		rotation = x;
	}
}