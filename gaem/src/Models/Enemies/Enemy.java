package Models.Enemies;

import Models.MoveableEntity;
import Models.Players.Player;
import Models.Players.Powerups.PowerupSPD;
import Models.Players.Powerups.PowerupSTR;
import Models.Enemies.debuffCrack1;
import Models.Weapons.Projectiles.armorPierce;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends MoveableEntity{
	int PUchance = 0;
	boolean cracked = false;
	protected int tick;
	protected boolean loaded;
	//constructor, includes initial position as a new Vector2(x,y),width of texture, height of texture
	//width of hitbox, and height of hitbox
	public Enemy(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		velocity = new Vector2(0,200);
		tick = 0;
		//initial health, insert this after every super() in constructors for custom health
		health = 1000;//if you dont health will default to this
		actorID = 999; //sundowner
	}
	
	public Enemy(Vector2 position, int aI) {
		super(position, aI);
		
	}

	@Override //this is important to add before update and collidesWith
	public void update(World world)
	{
		super.update(world);
		if(health <= 0){
			remove = true;
			dead = true;
			PUchance = com.badlogic.gdx.math.MathUtils.random(1, 20);
			if(PUchance == 19)
			{
				world.actors.add(new PowerupSTR(centerLocation,20,20,20,20));
			}
			if(PUchance == 20)
			{
				world.actors.add(new PowerupSPD(centerLocation,20,20,20,20));
			}
			
		}
		if(position.y >=1000)
			remove = true;
		//if(remove)
			//world.entities.add(new Explosion(this.getPosition(), 100, 100, 0, 0));
		
	}
	
	//collision code
	@Override
	public void collidesWith(MoveableEntity e, World world) 
	{
		if(e instanceof Player)
		{
			//((Player) e).damage(1);
		}
		
		if(e instanceof armorPierce)
		{
			if(!cracked)
			{
				subObjects.add(new debuffCrack1(new Vector2(0,0), width-10, height-10, 0, 0, this));
			}
			cracked = true;
		}
	}

	//health
	public void damage(int i) 
	{
		if(cracked)
		{
			super.damage((int) (i * 1.5));
		}
		else
		super.damage(i);
		world.game.audio.playSound("EnemyHurt"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.2f);
	}
}
