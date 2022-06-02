package music;

public class MusicDAO {

private String path;
	
	public MusicDAO() {
		
	}
	
	public MusicDAO(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
