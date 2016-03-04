package Models;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class genericBG extends MoveableEntity
{
	int basetext;
	public genericBG(Vector2 position, float width, float height, Vector2 speed, int image) 
	{
		super(position, width, height, 0, 0);
		//velocity = speed;
		actorID = 14;
		render=false;
		basetext = image;
	}
	

	public void update(World world){
		super.update(world);
		if(basetext == 1)
		{
			texture = "level1hanger";
		}
		//REMOVE CODE, VERY IMPORTANT
		if(position.y >= 1000)
		{
			//world.aIter.remove();
		}
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world){
	}

}
