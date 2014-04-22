package Models.Players.Powerups;

import Models.MoveableEntity;
import Models.Players.Player;
import View.World;
import View.WorldRender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Powerups extends MoveableEntity{
	int ID = 0;
	public Powerups(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		velocity = new Vector2(0,200);
		//actorID = 0;
	}

	@Override
	public void update(World world){
		super.update(world);
		//if(position.y > 900 || position.y < 0 || position.x < 0 || position.x > 700)
			//remove = true;
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world){
		if(e instanceof Player)
		{
			((Player) e).hasPowerup = true;
			((Player) e).powerupID = ID;
		}
		
	}

}
