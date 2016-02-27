package View.Levels;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

import Models.Explosion;
import Models.MoveableEntity;
import Models.level1hanger;
import Models.Enemies.EnemyMine;
import Models.Enemies.GunshipBasic;
import Models.Enemies.HeavyBasic;
import Models.Enemies.HeavyLaser;
import Models.Enemies.HeavySpread;
import Models.Enemies.LightBasic;
import Models.Enemies.LightLaser;
import Models.Enemies.LightSpread;
import Models.Enemies.LightTiny;
import Models.Enemies.eTurret1;
import View.World;

public class levelEditor extends level{
	private float waveLength;
	private String waveVariable;
	private boolean start = true;
	private int waveNumber = 0;
	private Iterator<MoveableEntity> eIter;
	private boolean making;
	private boolean[] wave = new boolean[1500];
	private boolean testing = false;
	private String load;
	private String file;
	
		
	public levelEditor(World world) {
		super(world);
		making = false;
		for(int i = 0 ; i < wave.length ; i++){
			wave[i] = false;
		}
	}

	@Override
	public void start() {
		Gdx.input.getTextInput(new TextInputListener(){

			@Override
			public void input(String text) {
				load = text;
				start2();
			}
			@Override
			public void canceled() {
				load = "";
			}
			
		}, "Load a wave (y/n)?", "n");
	}
	
	private void start2(){
		if(load.matches("y") || load.matches("yes")){
			Gdx.input.getTextInput(new TextInputListener(){

				@Override
				public void input(String text) {
					file = text;
					load(loadWave(file));
				}

				@Override
				public void canceled() {
					initialize();
				}
				
			}, "Filename: ", "WaveSave_1.w");
		} else{
			initialize();
		}
	}
	
	private void load(List<String> loadWave) {
			waveLength = Float.parseFloat(loadWave.get(0));
			waveVariable = loadWave.get(1);
			waveNumber = Integer.parseInt(loadWave.get(2));
			int line = 3;
			while(!loadWave.get(line).matches("ENDSAVE")){
				float posX;
				float posY;
				float offset;
				String classname;
				int ai;
				posX = Float.parseFloat(loadWave.get(line));
				posY = Float.parseFloat(loadWave.get(line+1));
				offset = Float.parseFloat(loadWave.get(line+2));
				classname = loadWave.get(line+3);
				ai = Integer.parseInt(loadWave.get(line+4));
				editorGrid bob = new editorGrid(new Vector2(posX+25, posY+25), ai, waveLength, classname, offset);
				world.actors.get(0).add(bob);
				line += 5;
				
			}
	}

	public void initialize(){
		Gdx.input.getTextInput(new TextInputListener(){

			@Override
			public void input(String text) {
				waveLength = Float.parseFloat(text);
			}

			@Override
			public void canceled() {
				waveLength = 3;
			}
			
		}, "Wave Time(Seconds):", "3");
		
		Gdx.input.getTextInput(new TextInputListener(){

			@Override
			public void input(String text) {
				waveNumber = Integer.parseInt(text);
			}

			@Override
			public void canceled() {
				waveNumber = 1;
			}
			
		}, "Wave Number:", "1");
		
		Gdx.input.getTextInput(new TextInputListener(){

			@Override
			public void input(String text) {
				waveVariable = text;
			}

			@Override
			public void canceled() {
				waveVariable = "x";
			}
			
		}, "Wave Variable:", "x");
		
		
		for(int x = 25; x < 700 ; x += 50){
			for(int y = 25 ; y < 900 ; y += 50){
				world.actors.get(0).add(new editorGrid(new Vector2(x, y), 0, waveLength));
			}
		}
		System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation());
	}

	@Override
	public void update() {
		if(start){
			start();
			start = false;
		}
		if(world.keys[Keys.R]){
			eIter = world.getActors().iterator();
			while(eIter.hasNext()){
				MoveableEntity e = eIter.next();
				if(e instanceof editorGrid){
					((editorGrid) e).reset();
				}
			}
		}
		
		if(world.keys[Keys.PLUS] && !testing){
			testing = true;
			spawnWave();
		}
		
		if(world.keys[Keys.BACKSLASH]){
			saveWave();
		}
		
		if(world.keys[Keys.BACKSPACE] && !making){
			making = true;
			try {
				PrintWriter writer = new PrintWriter("Wave_"+waveNumber+".txt", "UTF-8");
				writer.println("		if(x == " + waveNumber + ")");
				writer.println("		{");
				for(float y = 0 ; y < 900 ; y += 50){
					eIter = world.getActors().iterator();
					while(eIter.hasNext()){
						MoveableEntity e = eIter.next();
						if(e instanceof editorGrid){
							if(e.position.y == y){
								editorGrid temp = (editorGrid) e;
								if(temp.isFinished){
									wave[(int) y] = true;
								}
							}
						}
					}
				}
				for(float y = 900 ; y >= 0 ; y -= 50){
					System.out.println(y);
					if(wave[(int) y]){
						writer.println("			world.timer.scheduleTask(new Task()");
						writer.println("			{");
						writer.println("				@Override");
						writer.println("				public void run()");
						writer.println("				{");
						eIter = world.getActors().iterator();
						while(eIter.hasNext()){
							MoveableEntity e = eIter.next();
							if(e instanceof editorGrid){
								if(e.position.y == y){
									editorGrid temp = (editorGrid) e;
									if(temp.isFinished){
										writer.println("					world.actors.get(0).add(new "+temp.getClassName()+"(new Vector2("+temp.getSpawnPosition().x+"f,-100f), "+temp.getAI()+"));");
									}
								}
							}
						}
						writer.println("				}");
						writer.println("			} , "+(((900f-y)/900f)*waveLength)+"f);");
						writer.println("");
						System.out.println(y);
					}
				}
				writer.println("");
				writer.println("			world.timer.scheduleTask(new Task()");
				writer.println("			{");
				writer.println("				@Override");
				writer.println("				public void run()");
				writer.println("				{");
				writer.println("					time = time + "+(waveLength+5f)+";");
				writer.println("					waveDone = true;");
				writer.println("				}");
				writer.println("			} , "+(waveLength+5f)+");");
				writer.println("			"+waveVariable+" = 0;");
				writer.println("		}");
				
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
			making = false;
		}
	}

	@Override
	protected void HandleWaves(int wave) {
		// TODO Auto-generated method stub
		
	}
	
	private void spawnWave(){
		for(float y = 0 ; y < 900 ; y += 50){
			addSpawn((int) y);
			System.out.println(y+ "THIS IS BIG THINGY");
		}
		
		eIter = world.getActors().iterator();
		while(eIter.hasNext()){
			MoveableEntity e = eIter.next();
			if(e instanceof editorGrid){
				((editorGrid) e).testing = true;
				e.position = new Vector2(999,999);
			}
		}
		world.timer.scheduleTask(new Task(){
			@Override
			public void run()
			{
				eIter = world.getActors().iterator();
				while(eIter.hasNext()){
					MoveableEntity e = eIter.next();
					if(e instanceof editorGrid){
						((editorGrid) e).testing = false;
					}
					testing = false;
				}
			}
		}, waveLength+5);
	}
	
	private void addSpawn(final int y) {
		world.timer.scheduleTask(new Task(){
			@Override
			public void run()
			{
				findSpawns(y);
			}
		}, waveLength*((900-y)/900f) );
		
	}

	private void findSpawns(int y) {
		eIter = world.getActors().iterator();
		while(eIter.hasNext()){
			MoveableEntity e = eIter.next();
			if(e instanceof editorGrid){
				if(((editorGrid) e).getOriginalPosition().y == y){
					editorGrid temp = (editorGrid) e;
					if(temp.isFinished){
						spawnTest(temp);
					}
				}
			}
		}
	}

	private void spawnTest(editorGrid e){
		System.out.println(e.getClassName());
		switch(e.getClassName()){
		case "Explosion":
			break;
		case "level1hanger":
			break;
		case "Star":
			break;
		case "EnemyMines":
			break;
		case "eTurret1":
			break;
		case "GunshipBasic":
			world.actors.get(0).add(new GunshipBasic(new Vector2(e.getSpawnPosition().x, -100)));
			break;
		case "HeavyBasic":
			world.actors.get(0).add(new HeavyBasic(new Vector2(e.getSpawnPosition().x, -100), e.getAI()));
			break;
		case "HeavyLaser":
			world.actors.get(0).add(new HeavyLaser(new Vector2(e.getSpawnPosition().x, -100), e.getAI()));
			break;
		case "HeavySpread":
			world.actors.get(0).add(new HeavySpread(new Vector2(e.getSpawnPosition().x, -100), e.getAI()));
			break;
		case "LightBasic":
			world.actors.get(0).add(new LightBasic(new Vector2(e.getSpawnPosition().x, -100), e.getAI()));
			break;
		case "LightLaser":
			world.actors.get(0).add(new LightLaser(new Vector2(e.getSpawnPosition().x, -100), e.getAI()));
			break;
		case "LightSpread":
			world.actors.get(0).add(new LightSpread(new Vector2(e.getSpawnPosition().x, -100), e.getAI()));
			break;
		case "LightTiny":
			world.actors.get(0).add(new LightTiny(new Vector2(e.getSpawnPosition().x, -100), e.getAI()));
			break;
		case "BOSS1":
			break;
		case "BOSS2":
			break;
		case "BOSS3":
			break;
		case "BOSS4":
			break;
		default:
			world.actors.get(0).add(new LightBasic(new Vector2(e.getSpawnPosition().x-e.getxOffset(), -100), e.getAI()));
			break;
		}
	}
	
	public void saveWave(){
		try {
			PrintWriter writer = new PrintWriter("WaveSave_"+waveNumber+".w", "UTF-8");
			writer.println(waveLength);
			writer.println(waveVariable);
			writer.println(waveNumber);
			for(float y = 900 ; y >= 0 ; y -= 50){
				System.out.println(y);
					eIter = world.getActors().iterator();
					while(eIter.hasNext()){
						MoveableEntity e = eIter.next();
						if(e instanceof editorGrid){
							if(e.position.y == y){
								editorGrid temp = (editorGrid) e;
								writer.println(temp.getOriginalPosition().x);
								writer.println(temp.getOriginalPosition().y);
								writer.println(temp.getxOffset());
								writer.println(temp.getClassName());
								writer.println(temp.getAI());
							}
						}
					}
				}
			writer.println("ENDSAVE");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private List<String> loadWave(String fileName)
	{
		try{
			Path path = Paths.get(fileName);
			return Files.readAllLines(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
