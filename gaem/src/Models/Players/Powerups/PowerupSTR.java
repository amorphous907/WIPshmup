package Models.Players.Powerups;

import Models.MoveableEntity;
import Models.Players.Player;
import View.World;
import View.WorldRender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class PowerupSTR extends Powerups {
	
	public PowerupSTR(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		velocity = new Vector2(0,200);
		actorID = 35;
		texture = "powerupSTR";
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world){
		if(e instanceof Player)
		{
			world.getRender().addParticles(5, 3, 30, new Vector2(centerLocation.x,centerLocation.y));
			remove = true;
			
		}
		
	}

}
