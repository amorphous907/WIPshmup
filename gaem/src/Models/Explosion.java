package Models;

import View.WorldRender;

import com.badlogic.gdx.math.Vector2;

public class Explosion extends MoveableEntity{

	public Explosion(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		animate = true;
		animationNum = 0;
		currentFrame = 0;
	}
	
	@Override
	public void animate(WorldRender world){
		world.animate(animationNum, currentFrame, this);
		currentFrame++;
		if(currentFrame == world.getAnimation(animationNum).numFrames){
			currentFrame = 0;
			remove = true;
		}
	}

}
