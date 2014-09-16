package Models;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class level1hanger extends MoveableEntity{
	
	public level1hanger(Vector2 position, float width, float height, Vector2 speed) {
		super(position, width, height, 0, 0);
		velocity = speed;
		actorID = 14;
		texture = "level1hanger";
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
