package Models;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class ast extends MoveableEntity{
	
	public ast(Vector2 position, float width, float height, float hitX,
			float hitY, Vector2 speed) 
	{
		super(position, width, height, hitX, hitY);
		velocity = speed;
		int pick = com.badlogic.gdx.math.MathUtils.random(15, 21);
		//int pick =1;
		
		
		actorID = pick;
	}
	

	public void update(World world)
	{
		super.update(world);
		//REMOVE CODE, VERY IMPORTANT
		if(position.y >= 1000)
			world.aIter.remove();
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world){
	}

}