package Models.Weapons.Projectiles;

import java.io.IOException;

import Models.MoveableEntity;
import Models.subObjectEnemy;
import Models.Enemies.Enemy;
import Models.Enemies.LightBasic;
import Models.Enemies.LightTiny;
import View.World;
import View.WorldRender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class Missile extends MoveableEntity
{
	int vel = -0;
	private ParticleEmitter fumes;
	public boolean explode = false;

	public Missile(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		velocity = new Vector2(0,200);//how to change its velocity(pixels per second), add this for every bullet for specific velocities
		rotation = 180;//you dont need to add this every new bullet, leave it at 180 for proper rendering
		texture = "missile";
		fumes = new ParticleEmitter();
		circle = false;
		bounds2 = new Circle(position, bounds.width/2);

		fumes = new ParticleEmitter();
		try {
            fumes.load(Gdx.files.internal("data/particle/Player1Fumes").reader(2024));
		} catch (IOException e) {
            e.printStackTrace();
		}
		
		fumes.setPosition(position.x, position.y);
		Texture particle = new Texture("data/particle/particle.png");
		Sprite particleSprite = new Sprite(particle);
		fumes.setSprite(particleSprite);
		fumes.getScale().setHigh(8f);
		fumes.start();
	}
	
	public Missile(Vector2 position, float width, float height, float hitX,
			float hitY, Vector2 velocity) {
		super(position, width, height, hitX, hitY);
		this.velocity = velocity;//how to change its velocity(pixels per second), add this for every bullet for specific velocities
		rotation = 180;//you dont need to add this every new bullet, leave it at 180 for proper rendering
		actorID = 42;
		texture = "missile";
		fumes = new ParticleEmitter();
		try {
            fumes.load(Gdx.files.internal("data/particle/Player1Fumes").reader(2024));
		} catch (IOException e) {
            e.printStackTrace();
		}
		
		fumes.setPosition(position.x, position.y);
		Texture particle = new Texture("data/particle/particle.png");
		Sprite particleSprite = new Sprite(particle);
		fumes.setSprite(particleSprite);
		fumes.getScale().setHigh(8f);
		fumes.start();
	}
	
	public Missile(Vector2 position, Vector2 velocity){
		super(position, 10, 10, 5, 5);
		this.velocity = velocity;
		actorID = 28;
		rotation = velocity.angle()-90;
	}
	
	@Override
	public void update(World world){
		super.update(world);
		world.timer.scheduleTask(new Task() 
		{
			@Override
			public void run()
			{
				velocity.y -= 1;
			}
		} , 0.1f);
		 if(velocity.x > 0) velocity.x -= 1;
		 if(velocity.x < 0) velocity.x += 1;
		rotation = velocity.angle()-90;
		if(position.y <= 0)
			remove = true;
		fumes.setPosition(centerLocation.x, centerLocation.y);
		

		
		//if(remove)
			//world.entities.add(new Explosion(this.getPosition(), 300, 300, 0, 0));
		
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world)
	{
		//damage enemy
		if(e instanceof Enemy)
		{
			world.actors.add(new BLAST(centerLocation, 0,0,100,100));
			explode = true;
			world.game.audio.playSound("Player1Explosion", 1);
			//kill itself
			remove = true;
		}
		if(e instanceof subObjectEnemy)
		{
			world.actors.add(new BLAST(centerLocation, 0,0,100,100));
			explode = true;
			world.game.audio.playSound("Player1Explosion", 1);
			//kill itself
			remove = true;
		}
	}
	
	@Override
	public void render(WorldRender render)
	{
			//render.BulletImpact(new Vector2((this.getPosition().x+this.getWidth()/2), (this.getPosition().y+this.getHeight()/2)));
		//render.addParticles(2, 0, -3f, new Vector2(centerLocation.x, centerLocation.y+15));
		fumes.draw(render.batch, Gdx.graphics.getDeltaTime());
		super.render(render);
	}
}

