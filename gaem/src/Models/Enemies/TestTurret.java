package Models.Enemies;

import Models.MoveableEntity;
import Models.subObject;
import Models.Players.Player;
import Models.Weapons.Gun;
import View.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class TestTurret extends subObject{
	public Gun gun;
	public boolean fire;
	public Player player;
	
	public TestTurret(Vector2 offset, float width, float height, float hitX,
			float hitY, MoveableEntity Parent) {
		super(offset, width, height, hitX, hitY, Parent);
		actorID = 0;
		texture = "player1";
		this.player = (Player) Parent;
		gun = new Gun();
	}
	
	@Override
	public void update(World world, MoveableEntity Parent){
		super.update(world, Parent);
			player = (Player) Parent;
			gun.fire = player.gun.fire;
			gun.update(world, this);
	}

}
