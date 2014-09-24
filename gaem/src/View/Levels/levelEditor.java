package View.Levels;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

import Models.MoveableEntity;
import View.World;

public class levelEditor extends level{
	private float waveLength;
	private boolean start = true;
	private int waveNumber = 0;
	private Iterator<MoveableEntity> eIter;
	private boolean making;
	private boolean[] wave = new boolean[1500];
	
		
	public levelEditor(World world) {
		super(world);
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
		making = false;
		for(int i = 0 ; i < wave.length ; i++){
			wave[i] = false;
		}
	}

	@Override
	public void start() {
		for(int x = 0; x < 700 ; x += 50){
			for(int y = 0 ; y < 900 ; y += 50){
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
		
		if(world.keys[Keys.BACKSPACE] && !making){
			making = true;
			try {
				PrintWriter writer = new PrintWriter("Level_"+waveNumber+".txt", "UTF-8");
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
				for(float y = 0 ; y < 900 ; y += 50){
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
										writer.println("					world.actors.get(0).add(new "+temp.getClassName()+"(new Vector2("+temp.getPosition().x+",-100), "+temp.getAI()+"));");
									}
								}
							}
						}
						writer.println("				}");
						writer.println("			} , "+(waveLength*(y/900f))+"f);");
						writer.println("");
					}
				}
				writer.println("			x = 0;");
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

}
