package Models.Weapons.Projectiles;

import Models.MoveableEntity;
import Models.Players.Player;
import View.World;
import View.WorldRender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class EnemyBullet extends MoveableEntity{

	public EnemyBullet(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		animate = true;
		animationNum = 1;
		currentFrame = 0;
		velocity = new Vector2(0,600);
		actorID = 29;
		texture = "enemyBullet";
	}
	
	public EnemyBullet(Vector2 position, float width, float height, float hitX,
			float hitY, Vector2 velocity) {
			super(position, width, height, hitX, hitY);
			animate = true;
			animationNum = 1;
			currentFrame = 0;
			actorID = 29;
			this.velocity = velocity;
			}
	@Override
	public void animate(WorldRender world){
	    /*world.animate(animationNum, currentFrame, this);
		currentFrame++;
		if(currentFrame == world.getAnimation(animationNum).numFrames){
			currentFrame = 0;
		}*/
		if(rotation < 360)
			rotation+=18*Gdx.graphics.getDeltaTime()*60;
			else
				rotation = 0;
		render(world);
	}

	
	@Override
	public void update(World world){
		super.update(world);
		if(position.y >= 900 || position.y < 0 || position.x < 0 || position.x > 700)
			remove = true;
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world)
	{
		if(e instanceof Player){
			((Player) e).damage(100);
			remove = true;
		}
	}

}
