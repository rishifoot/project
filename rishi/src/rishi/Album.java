package rishi;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String title;
	private String artistname;
	private ArrayList<Song> songs;
	
	public Album(String title, String artistname) {
		
		this.title = title;
		this.artistname = artistname;
		this.songs = new ArrayList<Song>();
	}
	public Song findsong(String name) {
		for(Song checksong:songs) {
			if(checksong.getName().equals(name)) {
				return checksong;
			}
		}
		return null;
	}
	
	public boolean addsong(String name,double duration) {
		if(findsong(name)==null) {
			songs.add(new Song(name,duration));
			return true;
		}
		else {
			return false;
		}
	}
	public boolean addplaylist(int trackno,LinkedList<Song> playList) {
		int index=trackno-1;
		if(index>0 && index<=songs.size()) {
			playList.add(this.songs.get(index));
			return true;
		}
		else {
			return false;
		}
	}
	public boolean addplaylist(String title,LinkedList<Song> playList) {
		for(Song checksong:songs) {
			if(checksong.getName().equals(title)) {
				playList.add(checksong);
				return true;
			}
			
		}
		return false;
	}
	
	
	

}
