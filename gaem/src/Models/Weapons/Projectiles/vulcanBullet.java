package Models.Weapons.Projectiles;

import Models.MoveableEntity;
import Models.subObjectEnemy;
import Models.Enemies.Enemy;
import View.World;
import View.WorldRender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class vulcanBullet extends MoveableEntity
{
	public boolean explode = false;

	public vulcanBullet(Vector2 position, Vector2 velocity){
		super(position, 10, 10, 5, 5);
		this.velocity = velocity;
		actorID = 28;
		texture = "vulcanBullet";
		rotation = velocity.angle()-90;
		color = color.BLUE;
	}
	
	@Override
	public void update(World world){
		super.update(world);
		if(position.y <= 0)
			remove = true;
		rotation++;
		rotation++;
		rotation++;//HURR HURR I CODE ROTATION
		rotation++;
		rotation++;
		
		//if(remove)
			//world.entities.add(new Explosion(this.getPosition(), 300, 300, 0, 0));
		
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world)
	{
		//damage enemy
		if(e instanceof Enemy || e instanceof subObjectEnemy)
		{
			e.damage(8);
			explode = true;
			//kill itself
			remove = true;
		}
		if(e instanceof subObjectEnemy){
			((Models.subObject) e).subDamage(8);
			explode = true;
			//kill itself
			remove = true;
		}
	}
	
	@Override
	public void render(WorldRender render){
		if(explode){
			//render.BulletImpact(new Vector2((this.getPosition().x+this.getWidth()/2), (this.getPosition().y+this.getHeight()/2)));
			render.addParticles(2, 0, -3f, new Vector2(centerLocation.x, centerLocation.y+15));
		}
		super.render(render);
	}

}
