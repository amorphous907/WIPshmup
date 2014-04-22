package Models;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Star extends MoveableEntity{
	
	public Star(Vector2 position, float width, float height, float hitX,
			float hitY, Vector2 speed) {
		super(position, width, height, hitX, hitY);
		velocity = speed;
		actorID = 14;
		texture = "star";
	}
	

	public void update(World world){
		super.update(world);
		//REMOVE CODE, VERY IMPORTANT
		if(position.y >= 1000)
			world.aIter.remove();
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world){
	}

}
