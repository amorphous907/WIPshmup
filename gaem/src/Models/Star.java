package Models;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Star extends MoveableEntity{
	
	int ranstar = com.badlogic.gdx.math.MathUtils.random(1, 10);
	
	public Star(Vector2 position, float width, float height, Vector2 speed) {
		super(position, width, height, 0, 0);
		velocity = speed;
		actorID = 14;
		if(ranstar == 1)
		{
			texture = "star1";
			width = 20*2;
			height = 20*2;
		}
		if(ranstar == 2)
		{
			texture = "star2";
			width = 20*2;
			height = 20*2;
		}
		if(ranstar == 3)
		{
			texture = "star3";
			width = 5*2;
			height = 5*2;
		}
		if(ranstar == 4)
		{
			texture = "star4";
			width = 50*2;
			height = 75*2;
		}
		if(ranstar == 5)
		{
			texture = "star5";
			width = 5*2;
			height = 5*2;
		}
		if(ranstar == 6)
		{
			texture = "star6";
			width = 25*2;
			height = 25*2;
		}
		if(ranstar == 7)
		{
			texture = "star7";
			width = 5*2;
			height = 5*2;
		}
		if(ranstar == 8)
		{
			texture = "star8";
			width = 40*2;
			height = 35*2;
		}
		if(ranstar == 9)
		{
			texture = "star9";
			width = 40*2;
			height = 50*2;
		}
		if(ranstar == 10)
		{
			texture = "star10";
			width = 5*2;
			height = 5*2;
		}
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
