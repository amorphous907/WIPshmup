package Models;

import com.badlogic.gdx.math.Vector2;

public class PointLight extends MoveableEntity {

	public PointLight(Vector2 position, float width, float height, float hitX,
			float hitY) {
		super(position, width, height, hitX, hitY);
		render = false;
		hasLight = true;
		lightMap = "pointLight_L";
	}

}
