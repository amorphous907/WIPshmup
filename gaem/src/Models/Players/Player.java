package Models.Players;

import Models.MoveableEntity;
import Models.Enemies.TestTurret;
import Models.Players.Powerups.PowerupSPD;
import Models.Players.Powerups.PowerupSTR;
import Models.Players.Powerups.medi_pellet;
import Models.Weapons.DroneDEF;
import Models.Weapons.Gun;
import Models.Weapons.LaserDEF;
import Models.Weapons.MedicDEF;
import Models.Weapons.SpreadDEF;
import Models.Weapons.VanillaDEF;
import Models.Weapons.VanillaSPD;
import Models.Weapons.VanillaSTR;
import Models.Weapons.Projectiles.EnemyBullet;
import View.World;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Player extends MoveableEntity{
	public boolean isPlaying;
	public boolean hasPowerup;
	public int powerupID;
	public Gun gun;
	public VanillaDEF vanilladef;
	public VanillaSTR vanillastr;
	public VanillaSPD vanillaspd;
	public static int SPEED = 240;
	int corpseType;
	public float spawnTime = 5; //in seconds
	public float spawnTic = 5;
	private boolean test = false;
	protected World world;
	public boolean gamepad;
	
	public Player(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		health = 500;
		isPlaying = false;
		maxHealth = 500;
		gun = new Gun();
		vanilladef = new VanillaDEF();
		vanillastr = new VanillaSTR();
		vanillaspd = new VanillaSPD();
		render = false;
		
		int ship = com.badlogic.gdx.math.MathUtils.random(1, 3);
		
		if(ship  == 1)
		{
			subObjects.add(new vanillaDECAL(new Vector2(), 1, this));
			texture = "vanilla";
			setHeight(60 * getScale());// = 60;
			setWidth(60 * getScale());// = 60;
			bounds.width = 45 * getScale();
			bounds.height = 45 * getScale();
			gun = new VanillaDEF();
		}
		if(ship  == 2)
		{
			subObjects.add(new laserDECAL(new Vector2(), 1, this));
			texture = "laser";
			setHeight(60);// = 60;
			setWidth(90);// = 60;
			bounds.width = 60;
			bounds.height = 45;
			gun = new LaserDEF();
		}
		if(ship  == 3)
		{
			subObjects.add(new spreadDECAL(new Vector2(), 1, this));
			texture = "spread";
			setHeight(70);// = 60;
			setWidth(40);// = 60;
			bounds.width = 30;
			bounds.height = 50;
			gun = new SpreadDEF();
		}
		if(ship  == 4)
		{
			subObjects.add(new medicDECAL(new Vector2(), 1, this));
			texture = "medic";
			setHeight(70);// = 60;
			setWidth(60);// = 60;
			bounds.width = 60;
			bounds.height = 50;
			gun = new MedicDEF();
		}
		if(ship  == 5)
		{
			subObjects.add(new DroneBodyDECAL(new Vector2(), 1, this));
			texture = "DroneBody";
			setHeight(70);// = 60;
			setWidth(60);// = 60;
			bounds.width = 60;
			bounds.height = 50;
			gun = new DroneDEF();
		}
	}
	
	public Player(Vector2 position, float width, float height, float hitX,
			float hitY, SelectShip ship) {
		super(position, width, height, hitX, hitY);
		health = 500;
		isPlaying = false;
		maxHealth = 500;
		gun = new Gun();
		vanilladef = new VanillaDEF();
		vanillastr = new VanillaSTR();
		vanillaspd = new VanillaSPD();
		render = false;
		System.out.println(ship.AI);
		if(ship.AI  == 0)
		{
			subObjects.add(new vanillaDECAL(new Vector2(), 1, this));
			texture = "vanilla";
			corpseType = 1;
			maxHealth = 500;
			setHeight(60 * getScale());// = 60;
			setWidth(60 * getScale());// = 60;
			bounds.width = 45 * getScale();
			bounds.height = 45 * getScale();
			gun = new VanillaDEF();
		}
		if(ship.AI  == 1)
		{
			subObjects.add(new laserDECAL(new Vector2(), 1, this));
			texture = "laser";
			corpseType = 2;
			maxHealth = 800;
			setHeight(60);// = 60;
			setWidth(90);// = 60;
			bounds.width = 60;
			bounds.height = 45;
			gun = new LaserDEF();
		}
		if(ship.AI  == 2)
		{
			subObjects.add(new spreadDECAL(new Vector2(), 1, this));
			texture = "spread";
			corpseType = 3;
			maxHealth = 300;
			setHeight(70);// = 60;
			setWidth(40);// = 60;
			bounds.width = 30;
			bounds.height = 50;
			gun = new SpreadDEF();
		}
		if(ship.AI  == 3)
		{
			subObjects.add(new medicDECAL(new Vector2(), 1, this));
			texture = "medic";
			corpseType = 4;
			maxHealth = 500;
			setHeight(70);// = 60;
			setWidth(60);// = 60;
			bounds.width = 60;
			bounds.height = 50;
			gun = new MedicDEF();
		}
		if(ship.AI  == 4)
		{
			subObjects.add(new DroneBodyDECAL(new Vector2(), 1, this));
			subObjects.add(new DroneArm(new Vector2(25,-25), 1, 0, 0, 0, 1, this));
			subObjects.add(new DroneArm(new Vector2(-25,-25), 1, 0, 0, 0, 2, this));
			subObjects.add(new DroneArm(new Vector2(25,25), 1, 0, 0, 0, 3, this));
			subObjects.add(new DroneArm(new Vector2(-25,25), 1, 0, 0, 0, 4, this));
			texture = "DroneBody";
			corpseType = 5;
			maxHealth = 500;
			setHeight(30);// = 60;
			setWidth(45);// = 60;
			bounds.width = 50;
			bounds.height = 35;
			gun = new DroneDEF();
		}
	}
	public Player(Vector2 position, float width, float height,
			float hitX, float hitY, Vector2 velocity, float rotation){
		super(position, width, height, hitX, hitY, velocity, rotation);
		health = 500;
		maxHealth = 500;
		isPlaying = false;
		gun = new Gun();
		vanilladef = new VanillaDEF();
		vanillastr = new VanillaSTR();
		vanillaspd = new VanillaSPD();
		render = false;
	}
	public Player(Vector2 position, float width, float height,
			float hitX, float hitY, Vector2 velocity, float rotation, int health){
		super(position, width, height, hitX, hitY, velocity, rotation);
		this.health = health;
		maxHealth = health;
		isPlaying = false;
		gun = new Gun();
		vanilladef = new VanillaDEF();
		vanillastr = new VanillaSTR();
		vanillaspd = new VanillaSPD();
		render = false;
	}
	
	@Override
	public void update(World world){
			this.world = world;
			if(!gamepad)
				HandleInput(world);
			else
				handleGamepad(world);
			super.update(world);
			gun.update(world, this);
			
			if(health >= maxHealth)
			{
				health = maxHealth;
			}
			if(health <= 0)
			{
				isPlaying = false;
				spawnTic = 0;
				render = false;
				powerupID = 0;
				hasPowerup = true;
				world.ShakeAmmount += 5;
				world.actors.get(0).add(new corpse(new Vector2(centerLocation.x,centerLocation.y),width,height,corpseType));
			}

			if(hasPowerup)
				applyPowerup();
			
			if(!isPlaying){
				setPosition(new Vector2(9999, 9999));
			}
			super.update(world);
			fixPosition();
			hasLight = true;
			lightMap = "vanilla_L";
			lightColor = new Color(0,0,1,1);
	}
	
	protected void handleGamepad(World world) {
		
	}
	protected void applyPowerup() {
		hasPowerup = false;
		powerupID = 0;
		

	}
	protected void HandleInput(World world) {
		
	}
	private void fixPosition() 
	{
		if(position.x < 0)
			position.x = 0;
		if(position.x > 700-width)
			position.x = 700-width;
		if(position.y < 150)
			position.y = 150;
		if(position.y > 900-height)
			position.y = 900-height;
	}
	public void fire(boolean b){
		gun.fire = b;
	}
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public int getHealth(){
		return health;
	}
	
	public boolean setPlaying(){
		if(spawnTic >= spawnTime){
			this.isPlaying = true;
			spawnTic = 0;
			health = maxHealth;
			render = true;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isPlaying()
	{
		return isPlaying;
	}
	
	@Override
	public void damage(int i) 
	{
		super.damage(i);
		world.game.audio.playSound("Player1Hurt"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
		world.ShakeAmmount += 2;
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world)
	{
		if(e instanceof PowerupSTR)
		{
			powerupID = 1;
			hasPowerup = true;
		}
		if(e instanceof PowerupSPD)
		{
			powerupID = 2;
			hasPowerup = true;
		}
		if(e instanceof medi_pellet)
		{
			if(health < maxHealth)
			{
				health = health + 5;
			}
			
		}
		
	}

}
