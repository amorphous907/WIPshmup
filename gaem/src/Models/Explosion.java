package Models;

import View.World;
import View.WorldRender;

import com.badlogic.gdx.math.Vector2;

public class Explosion extends MoveableEntity{


	public Explosion(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		animate = true;
		animationID = "boom";
		currentFrame = 0;
		animationDelay = 0.0133f;
	}
	
	public void animate(WorldRender render, World world){
		if(currentFrame == render.getAnimation(animationID).numFrames-1){
			remove = true;
		}
		super.animate(render, world);
	}

}
