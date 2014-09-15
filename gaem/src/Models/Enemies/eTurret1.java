package Models.Enemies;

import Models.MoveableEntity;
import Models.subObject;
import Models.Weapons.Projectiles.EnemyBullet;
import Models.Weapons.Projectiles.EnemyLaser;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class eTurret1 extends subObject{
	public Vector2 aim;
	private boolean loaded = false;
	
	public eTurret1(Vector2 offset, float width, float height,
			float hitX, float hitY, MoveableEntity Parent) {
		super(offset, width, height, hitX, hitY, Parent);
		actorID = 12;
		texture = "eTurret1";
	}

	@Override
	public void update(World world, MoveableEntity Parent){
		super.update(world, Parent);
		
		updateAim(world);
		if(loaded)
		{
			if(aim != null){
				EnemyBullet temp = new EnemyBullet(new Vector2(position.x+width/2-10,position.y+height/2-10),25,25,25,25);
				temp.setVelocity(new Vector2(aim.cpy().sub(this.getPosition()).nor().scl(400)));
				world.actors.get(0).add(temp);
				world.game.audio.playSound("EnemyLaser"+com.badlogic.gdx.math.MathUtils.random(1, 4), 0.8f);
			}
			
			world.timer.scheduleTask(new Task(){

				@Override
				public void run() {
					loaded = true;
				}
				
			}, 1.25f);
			loaded = false;	
		}
		if(aim!=null)
			rotation = aim.cpy().sub(this.getPosition()).nor().angle() - 270;
	}
	
	
	private void updateAim(World world)
    {
    	aim = null;
    	if(world.player1.isPlaying)
   			aim = world.player1.getPosition();
   		if(world.player2.isPlaying)
   			if(aim == null)
   				aim = world.player2.getPosition();
   		else if(this.getPosition().dst(aim)>this.getPosition().dst(world.player2.getPosition()))
    			aim = world.player2.getPosition();
   		if(world.player4.isPlaying)
    		if(aim == null)
   				aim = world.player4.getPosition();
   			else if(this.getPosition().dst(aim)>this.getPosition().dst(world.player4.getPosition()))
    			aim = world.player4.getPosition();
    	if(world.player3.isPlaying)
   			if(aim == null)
    			aim = world.player3.getPosition();
    		else if(this.getPosition().dst(aim)>this.getPosition().dst(world.player3.getPosition()))
   				aim = world.player3.getPosition();
    }
	
	@Override
	protected void spawn(World world){
		world.timer.scheduleTask(new Task(){

			@Override
			public void run() {
				loaded = true;
			}
			
		}, com.badlogic.gdx.math.MathUtils.random(0, 1.25f));
		super.spawn(world);
	}

}
