package Models.Weapons.Projectiles;

import Models.Explosion;
import Models.MoveableEntity;
import Models.subObjectEnemy;
import Models.Enemies.Enemy;
import View.World;
import View.WorldRender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class BLAST extends MoveableEntity
{
	public boolean explode = false;

	public BLAST(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		rotation = 180;//you dont need to add this every new bullet, leave it at 180 for proper rendering
		actorID = 28;
		texture = "vanillaBullet";
		circle = false;
		bounds2 = new Circle(position, bounds.width/2);
	}
	
	public BLAST(Vector2 position, float width, float height, float hitX,
			float hitY, Vector2 velocity) {
		super(position, width, height, hitX, hitY);
		this.velocity = velocity;//how to change its velocity(pixels per second), add this for every bullet for specific velocities
		rotation = 180;//you dont need to add this every new bullet, leave it at 180 for proper rendering
		actorID = 28;
	}
	
	public BLAST(Vector2 position, Vector2 velocity){
		super(position, 10, 10, 5, 5);
		this.velocity = velocity;
		actorID = 28;
		rotation = velocity.angle()-90;
	}
	
	@Override
	public void update(World world){
		super.update(world);
		if(position.y <= 0)
			remove = true;
		
		//if(remove)
			//world.entities.add(new Explosion(this.getPosition(), 300, 300, 0, 0));
		
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world)
	{
		//damage enemy
		if(e instanceof Enemy)
		{
			e.damage(100);
			explode = true;
			world.actors.add(new Explosion(new Vector2(centerLocation),100,100,0,0));
			//kill itself
			remove = true;
		}
		if(e instanceof subObjectEnemy)
		{
			e.damage(100);
			explode = true;
			world.actors.add(new Explosion(new Vector2(centerLocation),100,100,0,0));
			//kill itself
			remove = true;
		}
	}
	
	@Override
	public void render(WorldRender render)
	{
		if(explode)
		{
			//render.BulletImpact(new Vector2((this.getPosition().x+this.getWidth()/2), (this.getPosition().y+this.getHeight()/2)));
			render.addParticles(2, 0, -3f, new Vector2(centerLocation.x, centerLocation.y+15));
		}
		super.render(render);
	}

}
