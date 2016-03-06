package Models.Players;

import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

import Models.MoveableEntity;

public class corpse extends MoveableEntity{
	
	int spin = com.badlogic.gdx.math.MathUtils.random(-5, 5);
	int spinMega = 0;
	
	public corpse(Vector2 position, float width, float height) 
	{
		super(position, width, height, 0, 0);
		actorID = 14;
		texture = "vanilla";
		boolean timeCheck = true;
		velocity.x = com.badlogic.gdx.math.MathUtils.random(-300, 300);
		velocity.y = com.badlogic.gdx.math.MathUtils.random(-300, 300);
		
	}
	

	public void update(World world)
	{
		super.update(world);
		spinMega = spinMega + spin;
		rotation = 180 + spinMega;
		velocity.y = velocity.y + 10;
		if(velocity.y < 0)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					velocity.y = velocity.y + 5;
				}	
			} , 0.25f);
		}
		if(velocity.y > 0)
		{
			world.timer.scheduleTask(new Task() 
			{
				@Override
				public void run()
				{
					velocity.y = velocity.y - 5;
				}	
			} , 0.25f);
		}
		//REMOVE CODE, VERY IMPORTANT
		if(position.y >= 1000)
			world.aIter.remove();
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world){
	}

}
