package View.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import Models.MoveableEntity;
import Models.Text;
import View.World;
import View.WorldRender;

public class editorGrid extends MoveableEntity{
	private String className;
	private int AI;
	public boolean isFinished;
	private Vector2 originalPosition;
	private float xOffset;
	private boolean done;
	private float waveTime;
	private Vector2 spawnPosition;
	public boolean testing = false;

	public editorGrid(Vector2 position, int aI) {
		super(position, 50, 50, 50, 50);
		xOffset = 0;
		originalPosition = new Vector2(this.position);
		done = false;
		velocity = new Vector2(0,0);
		texture = "edit";
		className = "";
		System.out.println("EDITOR: " + position);
	}
	
	public editorGrid(Vector2 position, int aI, float waveLength) {
		super(position, 50, 50, 50, 50);
		xOffset = 0;
		originalPosition = new Vector2(this.position);
		done = false;
		waveTime = waveLength;
		texture = "edit";
		className = "";
		System.out.println("EDITOR: " + this.position);
	}
	
	public editorGrid(Vector2 position, int aI, float waveLength, String className, float xOffset) {
		super(position, 50, 50, 50, 50);
		this.xOffset = xOffset;
		originalPosition = new Vector2(this.position);
		done = false;
		waveTime = waveLength;
		texture = "edit";
		this.className = className;
		stepFour();
		System.out.println("EDITOR: " + this.position);
	}
	
	@Override
	public void update(World world){
		super.update(world);
		if(!testing){
			position = new Vector2(originalPosition.x+xOffset, originalPosition.y);
			spawnPosition = new Vector2(position.x+25, position.y+25);
		}
		if(world.mouseDown == 0 && bounds.contains(world.mousePos.x, world.mousePos.y) && !done){
			done = true;
			stepOne();
		}
		
		if(world.mouseDown == 1 && bounds.contains(world.mousePos.x, world.mousePos.y)){
			reset();
		}
		
		if(bounds.contains(world.mousePos.x, world.mousePos.y)){
			world.text.clear();
			world.text.add(new Text(centerLocation+" "+className+" "+AI, new Vector2(world.mousePos.x+10, world.mousePos.y-10), 1, 1, Color.GRAY));
		}
	}
	
	public void reset() {
		className = "";
		AI = 0;
		xOffset = 0;
		texture = "edit";
		isFinished = false;
	}

	private void stepOne(){
		Gdx.input.getTextInput(new TextInputListener(){

			@Override
			public void input(String text) {
				className = text;
				stepTwo();
			}

			@Override
			public void canceled() {
				className = "";
				done = false;
				isFinished = false;
			}
			
		}, "Object Class Name", "LightLaser");
	}
	
	private void stepTwo(){
		Gdx.input.getTextInput(new TextInputListener(){

			@Override
			public void input(String text) {
				AI = Integer.parseInt(text);
				stepThree();
			}

			@Override
			public void canceled() {
				AI = -1;
				done = false;
				isFinished = false;
			}
			
		}, "AI (int):", "1");
	}
	
	private void stepThree(){
		Gdx.input.getTextInput(new TextInputListener(){

			@Override
			public void input(String text) {
				xOffset = Integer.parseInt(text);
				stepFour();
			}

			@Override
			public void canceled() {
				xOffset = 0;
				done = false;
				isFinished = false;
			}
			
		}, "X offset from" + originalPosition.x + ":", "0");
	}
	
	private void stepFour(){
		switch(className){
		case "Explosion":
			animate = true;
			animationID = "boom";
			currentFrame = 0;
			animationDelay = 0.0133f;
			break;
		case "level1hanger":
			texture = "level1hanger";
			break;
		case "Star":
			texture = "star";
			break;
		case "EnemyMines":
			texture = "enemyG";
			break;
		case "eTurret1":
			texture = "eTurret1";
			break;
		case "GunshipBasic":
			texture = "MINIBOSSL1";
			break;
		case "HeavyBasic":
			texture = "heavyBasic";
			break;
		case "HeavyLaser":
			texture = "heavyLaser";
			break;
		case "HeavySpread":
			texture = "heavySpread";
			break;
		case "LightBasic":
			texture = "lightBasic";
			break;
		case "LightLaser":
			texture = "lightLaser";
			break;
		case "LightSpread":
			texture = "lightSpread";
			break;
		case "LightTiny":
			texture = "lightTiny";
			break;
		case "BOSS1":
			texture = "boss1";
			break;
		case "BOSS2":
			texture = "boss2";
			break;
		case "BOSS3":
			texture = "NONE";
			break;
		case "BOSS4":
			texture = "boss4";
			break;
		case "":
			texture = "edit";
			break;
		default:
			texture = "NONE";
			break;
		}
		isFinished = true;
		done = false;
	}
	
	@Override
	public void render(WorldRender render){
		super.render(render);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getAI() {
		return AI;
	}

	public void setAI(int aI) {
		AI = aI;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public Vector2 getOriginalPosition() {
		return originalPosition;
	}

	public void setOriginalPosition(Vector2 originalPosition) {
		this.originalPosition = originalPosition;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public Vector2 getSpawnPosition() {
		return spawnPosition;
	}

	public void setSpawnPosition(Vector2 spawnPosition) {
		this.spawnPosition = spawnPosition;
	}
	
	
}
