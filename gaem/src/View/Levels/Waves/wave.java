package View.Levels.Waves;

import View.World;

public abstract class wave {
	protected World world;
	
	public wave(World world) {
		this.world = world;
	}
	
	public abstract void GenerateWave(int wave, String waveVar);

}
