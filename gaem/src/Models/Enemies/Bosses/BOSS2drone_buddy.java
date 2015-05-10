package Models.Enemies.Bosses;

import Models.MoveableEntity;
import Models.subObjectEnemy;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class BOSS2drone_buddy extends subObjectEnemy {
	public float angle;
	private float radian;
	private int distance;
	private float speed;
	int woosh = 0;
	boolean go = true;
	int stop = 0;

	public BOSS2drone_buddy(Vector2 offset, float width, float height, float hitX,
			float hitY, MoveableEntity Parent) {
		super(offset, width, height, hitX, hitY, Parent);
		stop = com.badlogic.gdx.math.MathUtils.random(150, 180);
		speed = com.badlogic.gdx.math.MathUtils.random(75, 100);
		health = 200;
		actorID = 30;
		texture = "boss2";
		hasLight = true;
		lightMap = "boss2_L";
		
		int BAM = com.badlogic.gdx.math.MathUtils.random(1, 4);
		if(BAM == 1)
			angle = 0;
		if(BAM == 2)
			angle = 90;
		if(BAM == 3)
			angle = 180;
		if(BAM == 4)
			angle = 270;
		radian = angle*(com.badlogic.gdx.math.MathUtils.PI/180);
		offset.x = com.badlogic.gdx.math.MathUtils.cos(radian)*distance;
		offset.y = com.badlogic.gdx.math.MathUtils.sin(radian)*distance;
		circle = true;
		bounds2 = new Circle(position, 10);
		score = 100;
	}
	
	@Override
	public void update(World world, MoveableEntity parent)
	{
		distance = woosh;
		if(go)
		{
			woosh++;
			if(woosh == stop)
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
