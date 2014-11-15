package Models.Players;

import Models.MoveableEntity;
import Models.Enemies.TestTurret;
import Models.Players.Powerups.PowerupSPD;
import Models.Players.Powerups.PowerupSTR;
import Models.Weapons.Gun;
import Models.Weapons.LaserDEF;
import Models.Weapons.SpreadDEF;
import Models.Weapons.VanillaDEF;
import Models.Weapons.VanillaSPD;
import Models.Weapons.VanillaSTR;
import View.World;

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
			subObjects.add(new VanillaDECAL(new Vector2(), 1, this));
			texture = "vanilla";
			setHeight(60);// = 60;
			setWidth(60);// = 60;
			bounds.width = 45;
			bounds.height = 45;
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
			subObjects.add(new VanillaDECAL(new Vector2(), 1, this));
			texture = "vanilla";
			maxHealth = 500;
			setHeight(60);// = 60;
			setWidth(60);// = 60;
			bounds.width = 45;
			bounds.height = 45;
			gun = new VanillaDEF();
		}
		if(ship.AI  == 1)
		{
			subObjects.add(new laserDECAL(new Vector2(), 1, this));
			texture = "laser";
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
			maxHealth = 300;
			setHeight(70);// = 60;
			setWidth(40);// = 60;
			bounds.width = 30;
			bounds.height = 50;
			gun = new SpreadDEF();
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
			
			if(health <= 0)
			{
				isPlaying = false;
				spawnTic = 0;
				render = false;
				powerupID = 0;
				hasPowerup = true;
			}

			if(hasPowerup)
				applyPowerup();
			
			if(!isPlaying){
				setPosition(new Vector2(9999, 9999));
			}
			super.update(world);
			fixPosition();
	}
	
	protected void handleGamepad(World world) {
		
	}
	protected void applyPowerup() {
		hasPowerup = false;
		powerupID = 0;
		

	}
	protected void HandleInput(World world) {
		
	}
	private void fixPosition() {
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
		
	}

}
