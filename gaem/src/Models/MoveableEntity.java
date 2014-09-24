package Models;

import java.util.Iterator;

import View.World;
import View.WorldRender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer.Task;

public class MoveableEntity extends Entity{
	protected Vector2 velocity;
	public boolean remove = false;
	public Array<subObject> subObjects = new Array<subObject>();
	public Iterator<subObject> subIter;
	protected subObject subObject;
	protected int tick;
	protected World world;
	public boolean dead = false;
	protected boolean spawned = false;
	
	public MoveableEntity(Vector2 position, float width, float height,
			float hitX, float hitY) {
		super(position, width, height, hitX, hitY);
		velocity = new Vector2(0,0);
		rotation = 180;
	}
	
	public MoveableEntity(Vector2 position, float width, float height,
			float hitX, float hitY, Vector2 velocity, float rotation) {
		super(position, width, height, hitX, hitY);
		this.velocity = velocity;
		this.rotation = rotation;
	}
	
	public MoveableEntity(Vector2 position, int aI) {
		super(position, aI);
		new Vector2(0,0);
	}

	public Vector2 getVelocity(){
        return velocity;
	}

	public void setVelocity(Vector2 velocity){
        this.velocity = velocity;
	}

	public float getRotation(){
        return rotation;
	}

	public void setRotation(float rotation){
        this.rotation = rotation;
	}

	public void update(World world) {
		if(!spawned)
			spawn(world);
		if(AI > -1)
			handleAI(world);
		position.add(velocity.cpy().scl(Gdx.graphics.getDeltaTime()));
		centerLocation = new Vector2((this.getPosition().x+this.getWidth()/2), (this.getPosition().y+this.getHeight()/2));
		bounds.x = position.x+width/2-bounds.getWidth()/2;
		bounds.y = position.y+height/2-bounds.getHeight()/2;
		if(circle){
			bounds2.x = centerLocation.x;
			bounds2.y = centerLocation.y;
		}
		subIter = subObjects.iterator();
		while(subIter.hasNext()){
			subObject = subIter.next();
			subObject.update(world, this);
			if(subObject.remove)
				subIter.remove();
		}
		
		if(fadeToBase){
			color.lerp(baseColor, Gdx.graphics.getDeltaTime()*fadeRate);
			if(color.r >= 0.95f && color.g >= 0.95f && color.b >= 0.95f)
				fadeToBase = false;
		}
		
		/*if(subObjects.size != 0){
			for(int c = 0; c < subObjects.size; c++){
				subObjects.get(c).update(world, this);
			}
		}*/
	}
	
	protected void handleAI(World world) {
		
	}

	@Override
	public void render(WorldRender render){
		super.render(render);
		if(subObjects.size != 0){
			for(int c = 0; c < subObjects.size; c++){
				subObjects.get(c).render(render);
			}
		}
	}
	
	protected void spawn(World world){
		this.world = world;
		spawned = true;
	}

	public void collidesWith(MoveableEntity e, World world) {
		
	}
	
	public void animate(WorldRender render, World world){
		render.animate(animationID, currentFrame, this);
		if(animationAdvance){
			currentFrame++;
			
			world.timer.scheduleTask(new Task(){

				@Override
				public void run() {
					animationAdvance = true;
				}
				
			}, animationDelay);
			animationAdvance = false;
		}
		if(currentFrame == render.getAnimation(animationID).numFrames){
			currentFrame = 0;
		}
	}

	public void damage(int i) 
	{
		health -= i;
		if(damageFlash) color = new Color(damageColor);
		
		fadeToBase = true;
		
		subIter = subObjects.iterator();
		while(subIter.hasNext()){
			subObject = subIter.next();
			subObject.subHit();
		}
		
	}
}
