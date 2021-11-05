package rishi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Music {
	private static ArrayList<Album> albums=new ArrayList<>();

	public static void main(String[] args) {
		
		
		Album album=new Album("lost","justin bieber");
album.addsong("love yourself", 4.0);
album.addsong("sorry", 3.0);
album.addsong("peaches",5.0);
albums.add(album);


 album=new Album("found"," ed sheeran");
 album.addsong("perfect", 4.0);
 album.addsong("shape of you", 3.5);
 album.addsong("i dont know", 5.0);
 albums.add(album);
 
 LinkedList<Song> playlist=new LinkedList<>();
 albums.get(0).addplaylist("love yourself", playlist);
 albums.get(0).addplaylist("sorry", playlist);
 albums.get(1).addplaylist("perfect", playlist);
 albums.get(1).addplaylist("peaches", playlist);
 play(playlist);
	}
	public static void play(LinkedList<Song> playlist) {
		Scanner sc=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		
		ListIterator<Song> iterator=playlist.listIterator();
		if(playlist.size()==0) {
			System.out.println(" The List has no song");
		}
		else {
			System.out.println(" Now Playing "+iterator.next().toString());
			printmenu();
		}
		while(!quit) {
		
		int action=sc.nextInt();
		sc.nextLine();
		switch(action) {
		case 0:
			System.out.println(" playlist complete");
			quit=true;
			break;
			
		case 1:
			if(!forward) {
				if(iterator.hasNext()) {
					iterator.next();
				}
				forward=true;
				
			}
			if(iterator.hasNext()) {
				System.out.println("Now playing "+iterator.next().toString());
			}
			else {
				System.out.println(" the list has no more song");
				forward=false;
			}
			break;
			
		case 2:
			if(forward) {
				if(iterator.hasPrevious()) {
					iterator.previous();
				}
				forward=false;
			}
			if(iterator.hasPrevious()) {
				System.out.println(" Now Playing"+iterator.previous().toString());
			}
			else {
				System.out.println(" we are at first song");
				forward=false;
			}
			break;
			
		case 3:
			if(forward) {
				if(iterator.hasPrevious()) {
					System.out.println("Now playing"+iterator.previous());
					forward=false;
				}
				else {
					System.out.println("we are at the start of the list");
					forward=true;
				}
			}
			else {
				if(iterator.hasNext()) {
					System.out.println("Now playing"+iterator.next().toString());
					forward=true;
				}
				else {
					System.out.println("we are at the end of the list");
				}
			}
			break;
		case 4:
			printlist(playlist);
			break;
		case 5:
			printmenu();
			break;
		case 6:
			if(playlist.size()>0) {
				iterator.remove();
				if(iterator.hasNext()) {
					System.out.println("Now playing"+iterator.next().toString());
				}
				else {
					if(iterator.hasPrevious()) {
						System.out.println("Now Playing"+iterator.previous().toString());
					}
				}
			}
		}
		}
		
	}
	public static void printmenu() {
		System.out.println(" Available option\n press");
		System.out.println(" 0-to quit \n"+
		"1-to play next song \n"+
				"2-to previous song \n"+
		"3-to replay the current song"+
			"4-list of all songs"+
		"5-print all available option"+
			"6-delete current song");
	}
	public static void printlist(LinkedList<Song> playlist) {
		Iterator<Song> iterator=playlist.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
