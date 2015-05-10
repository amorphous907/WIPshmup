package Models.Enemies.Bosses;

import Models.MoveableEntity;
import Models.subObjectEnemy;
import Models.Enemies.eTurret1;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class BOSS2attack_drone4 extends subObjectEnemy {
	public float angle;
	private float radian;
	private int distance;
	private float speed;
	int woosh = 0;
	boolean go = true;

	public BOSS2attack_drone4(Vector2 offset, float width, float height, float hitX,
			float hitY, MoveableEntity Parent) {
		super(offset, width, height, hitX, hitY, Parent);
		speed = 30;
		health = 3000;
		actorID = 30;
		texture = "boss2";
		hasLight = true;
		lightMap = "boss2_L";
		
		angle = 270;
		radian = angle*(com.badlogic.gdx.math.MathUtils.PI/180);
		offset.x = com.badlogic.gdx.math.MathUtils.cos(radian)*distance;
		offset.y = com.badlogic.gdx.math.MathUtils.sin(radian)*distance;
		subObjects.add(new eTurret1(new Vector2(0,0), 60, 80, 0, 0, this));
		circle = true;
		bounds2 = new Circle(position, bounds.width/2);
		score = 3000;
	}
	
	@Override
	public void update(World world, MoveableEntity parent)
	{
		distance = woosh;
		if(go)
		{
			woosh++;
			if(woosh == 220)
			{
				go = false;
			}
		}
		radian = angle*(com.badlogic.gdx.math.MathUtils.PI/180);
		offset.x = com.badlogic.gdx.math.MathUtils.cos(radian)*distance;
		offset.y = com.badlogic.gdx.math.MathUtils.sin(radian)*distance;
		angle += speed*Gdx.graphics.getDeltaTime();
		if(angle >=360)
			angle=0;
		super.update(world, parent);
	}
}
