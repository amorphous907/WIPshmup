package Models.Players.Powerups;

import Models.MoveableEntity;
import Models.Players.Player;
import View.World;
import View.WorldRender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class medi_pellet extends Powerups {
	
	public medi_pellet(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		velocity = new Vector2(0,300);
		actorID = 36;
		texture = "medi pellet";
	}
	
	@Override
	public void collidesWith(MoveableEntity e, World world){
		if(e instanceof Player)
		{
			//world.getRender().addParticles(6, 4, 15, new Vector2(centerLocation.x,centerLocation.y));
			remove = true;
			
		}
		
	}

}