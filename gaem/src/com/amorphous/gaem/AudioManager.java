package com.amorphous.gaem;

import java.util.HashMap;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Array;

public class AudioManager {
	private HashMap<String, Music> musics = new HashMap<String, Music>();
	private HashMap<String, Sound> sounds = new HashMap<String, Sound>();
	
	public AudioManager(){
		
		musics.put("menu", Gdx.audio.newMusic(Gdx.files.local("data/sound/menu.mp3")));
		musics.put("level_1", Gdx.audio.newMusic(Gdx.files.local("data/sound/level_1.mp3")));
		musics.put("level_1 boss", Gdx.audio.newMusic(Gdx.files.local("data/sound/level_1 boss.mp3")));
		musics.put("level_2", Gdx.audio.newMusic(Gdx.files.local("data/sound/level_2.mp3")));
		musics.put("level_2 boss", Gdx.audio.newMusic(Gdx.files.local("data/sound/level_2 boss.mp3")));
		musics.put("level_3", Gdx.audio.newMusic(Gdx.files.local("data/sound/level_3.mp3")));
		musics.put("level_3 boss", Gdx.audio.newMusic(Gdx.files.local("data/sound/level_3 boss.mp3")));
		musics.put("ship_selection", Gdx.audio.newMusic(Gdx.files.local("data/sound/ship_selection.mp3")));
		
		sounds.put("PlayerLaser1", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/Player1Laser1.wav")));
		sounds.put("PlayerLaser2", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/Player1Laser2.wav")));
		sounds.put("PlayerLaser3", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/Player1Laser3.wav")));
		sounds.put("PlayerLaser4", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/Player1Laser4.wav")));
		sounds.put("EnemyLaser1", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/EnemyLaser1.wav")));
		sounds.put("EnemyLaser2", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/EnemyLaser2.wav")));
		sounds.put("EnemyLaser3", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/EnemyLaser3.wav")));
		sounds.put("EnemyLaser4", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/EnemyLaser4.wav")));
		sounds.put("Player1Hurt1", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/Player1Hurt1.wav")));
		sounds.put("Player1Hurt2", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/Player1Hurt2.wav")));
		sounds.put("Player1Hurt3", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/Player1Hurt3.wav")));
		sounds.put("Player1Hurt4", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/Player1Hurt4.wav")));
		sounds.put("EnemyHurt1", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/EnemyHurt1.wav")));
		sounds.put("EnemyHurt2", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/EnemyHurt2.wav")));
		sounds.put("EnemyHurt3", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/EnemyHurt3.wav")));
		sounds.put("EnemyHurt4", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/EnemyHurt4.wav")));
		sounds.put("Player1Explosion", Gdx.audio.newSound(Gdx.files.local("data/sound/effects/Player1Explosion.mp3")));
		
	}
	
	public void playSound(String x){
		sounds.get(x).play();
	}
	
	public void playSound(String x, float volume){
		sounds.get(x).play(volume);
	}
	
	public void loopSound(String x){
		sounds.get(x).loop();
	}
	public void loopSound(String x, float volume){
		sounds.get(x).loop(volume);
	}
	
	public void stopSound(String x){
		sounds.get(x).stop();
	}
	
	public void stopSound(){
		for(Sound s : sounds.values()){
			s.stop();
		}
	}
	
	public Sound getSound(String x){
		return sounds.get(x);
	}
	
	public void playMusic(String x){
		musics.get(x).setLooping(false);
		//music.get(x).setVolume();
		musics.get(x).play();
	}
	
	public void playMusic(String x, float volume){
		musics.get(x).setLooping(false);
		musics.get(x).setVolume(volume);
		musics.get(x).play();
	}
	
	public void loopMusic(String x){
		musics.get(x).setLooping(true);
		//music.get(x).setVolume();
		musics.get(x).play();
	}
	
	public void loopMusic(String x, float volume){
		musics.get(x).setLooping(true);
		musics.get(x).setVolume(volume);
		musics.get(x).play();
	}
	
	public void stopMusic(String x){
		musics.get(x).stop();
		musics.get(x).setLooping(false);
	}
	
	public void stopMusic(){
		for(Music m : musics.values()){
			m.stop();
			m.setLooping(false);
		}
	}
	
	public Music getMusic(String x){
		return musics.get(x);
	}
	
	public void dispose(){	
		for(Music m : musics.values()){
			m.dispose();
		}

		for(Sound s : sounds.values()){
			s.dispose();
		}
	}

}
