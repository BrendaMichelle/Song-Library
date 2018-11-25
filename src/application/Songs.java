//Coders: Brenda M. Rios (NetID: bmr111) & Roy Jacome (NetID: roj5)

package application;

import java.util.Comparator;

public class Songs {
	
	public static class Song {
		public String name;
		public String artist;
		public String album;
		public int year;

		Song (String name, String artist, String album, int year){
			this.name = name;
			this.artist = artist;
			this.album = album;
			this.year = year;
		}
		Song (String name, String artist){
			this.name = name;
			this.artist = artist;
			this.album = null;
			this.year = 0;	
		}
		
		//methods to update attributes of a song 
		public void editName(String new_name){
			name = new_name;
		}
		public void editArtist(String new_artist){
			artist = new_artist;
		}
		public void editAlbum(String new_album){
			album = new_album;
		}
		public void editYear(int new_year){
			year = new_year;
		}
		public String getSongname() {
			return name;
		}
		
		public int compareArtists(Song s) {
			if(artist.compareToIgnoreCase(s.artist) == 0) {
				return 0;
			}
			else {
				return (artist.compareToIgnoreCase(s.artist) < 0) ? -1 : 1;
			}
		}
		public int compareNames(Song s) { 
			if(name.compareToIgnoreCase(s.name) == 0) {
				return 0;
			}
			else {
				return (name.compareToIgnoreCase(s.name) < 0) ? -1 : 1;
			}
		}
		/*public static class Comparators{
			public static final Comparator<Song> NAME = (Song s1, Song s2) -> s1.name.compareToIgnoreCase(s2.name);
			public static final Comparator<Song> ARTIST = (Song s1, Song s2) -> s1.artist.compareToIgnoreCase(s2.artist);
			public static final Comparator<Song> NAMEANDARTIST = (Song s1, Song s2) -> NAME.thenComparing(ARTIST).compare(s1, s2);
		}*/
		
	} 
}