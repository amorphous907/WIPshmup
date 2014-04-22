package Models;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class yellow extends MoveableEntity{
	
	public yellow(Vector2 position, float width, float height, float hitX,
			float hitY, Vector2 speed) {
		super(position, width, height, hitX, hitY);
		velocity = speed;
		actorID = 14;
		texture = "yellow";
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
