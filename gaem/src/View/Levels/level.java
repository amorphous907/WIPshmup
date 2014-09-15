package View.Levels;

import View.World;

public abstract class level {
	protected float currentTime = 0;
	protected float timeLimit = 0;
	public boolean bossDead;
	protected boolean waveDone;
	protected final World world;
	protected boolean star = true;
	
	public level(World world) {
		this.world = world;
		bossDead = false;
		waveDone = true;
	}
	
	public abstract void start();
	
	public abstract void update();
	
	protected abstract void HandleWaves(int wave);
	
	public float getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(float currentTime) {
		this.currentTime = currentTime;
	}

	public float getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(float timeLimit) {
		this.timeLimit = timeLimit;
	}
	
}
