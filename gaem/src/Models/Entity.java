package Models;

import View.World;
import View.WorldRender;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class Entity {
	public Vector2 position;
	public float width;
	public float height;
	protected Rectangle bounds;
	protected Circle bounds2;
	protected String texture;
	public boolean render;
	public int health;
	public int maxHealth;
	protected float rotation;
	protected int AI;
	public int actorID;
	public Vector2 centerLocation;
	public int score = 0;
	protected float frameDelay;
	protected World world;
	public Color color;
	public Color damageColor;
	public boolean fadeToWhite = false;
	
	public boolean animate = false;
	public int animationNum;
	public int currentFrame;
	public boolean circle;
	
	public Entity(Vector2 position, float width, float height, float hitX, float hitY){
		this.position = new Vector2(position.x-width/2, position.y-height/2);
		this.width = width;
		this.height = height;
		this.bounds = new Rectangle(position.x, position.y, hitX, hitY);
		this.render = true;
		this.texture = null;
		this.centerLocation = new Vector2((this.getPosition().x+this.getWidth()/2), (this.getPosition().y+this.getHeight()/2));
		actorID = -1;
		texture = "NONE";
		color = new Color(1,1,1,1);
		damageColor = new Color(1,0,0,1);
	}
	
	public Entity(Vector2 position, int AI){
		this.position = new Vector2(position.x-width/2, position.y-height/2);
		this.AI = AI;
		actorID = -1;
		color = new Color(1,1,1,1);
		damageColor = new Color(1,0,0,1);
	}
	public Entity(Vector2 position, float width, float height, int AI){
		this.position = new Vector2(position.x-width/2, position.y-height/2);
		this.width = width;
		this.height = height;
		this.AI = AI;
		actorID = -1;
		color = new Color(1,1,1,1);
		damageColor = new Color(1,0,0,1);
	}
	
	public Entity(Vector2 position, float width, float height) {
		this.position = position;
		this.width = width;
		this.height = height;
		color = new Color(1,1,1,1);
		damageColor = new Color(1,0,0,1);
	}

	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public Rectangle getBounds() {
		return bounds;
	}
	
	public Circle getCircle() {
		return bounds2;
	}
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getMaxHealth(){
		return maxHealth;
	}
	
	public void render(WorldRender world){
		world.draw(this, texture, color);
	}

	public void animate(final WorldRender world) {
		world.animate(animationNum, currentFrame, this);
		this.world.timer.scheduleTask(new Task(){

			@Override
			public void run() {
				currentFrame++;
				if(currentFrame == world.getAnimation(animationNum).numFrames){
					currentFrame = 0;
				}
			}
			
		}, frameDelay);
	}

	public float getRotation() {
		return rotation;
	}
}
