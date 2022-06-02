package music;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class MusicDTO {

	public class MusicT {

		ArrayList<MusicDAO> musicList = new ArrayList<MusicDAO>();

		MP3Player mp3 = new MP3Player();

		public void MusicADD() {

			String path = "C:/Users/smhrd/Desktop/MP3/musicList/music/";
			musicList.add(new MusicDAO(path + "New Day - Patrick Patrikios.mp3"));
			musicList.add(new MusicDAO(path + "Soggy Steps.mp3"));
			musicList.add(new MusicDAO(path + "Meet & Fun! - Ofshane.mp3"));

		}

		public void MusicBGM() {

			
			if (mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(musicList.get(0).getPath());

		}

		public void MusicShop() {
			
			MusicADD();
			if (mp3.isPlaying()) {
				mp3.stop();
			}

			mp3.play(musicList.get(1).getPath());
		}
		
		public void MusicShopBgm() {
			
			MusicADD();
			if (mp3.isPlaying()) {
				mp3.stop();
			}

			mp3.play(musicList.get(1).getPath());
			
		}
	}
}
