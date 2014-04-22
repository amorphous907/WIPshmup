package View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class animation {
	public Array<Texture> frames;
	public int numFrames;
	public String path;
	
	public animation(String path, int numFrames){
		this.numFrames = numFrames;
		this.path = path;
		
		frames = new Array<Texture>(numFrames);
		loadTextures(path);
	}

	private void loadTextures(String path2) {
		Texture temp;
		for(int c = 0; c < numFrames ; c++){
			temp = new Texture(Gdx.files.internal("data/animation/"+path+"/"+c+".png"));
			frames.add(temp);
		}
	}
	
	public Texture getFrame(int frame){
		return frames.get(frame);
	}
	
}
