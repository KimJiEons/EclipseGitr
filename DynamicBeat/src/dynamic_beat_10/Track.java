package dynamic_beat_10;

public class Track {
	
	private String titleImage;//����κ��̹���
	private String startImage;//���Ӽ�
	private String gameImage;
	private String startMusic;
	
	
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	
	
	public Track(String titleImage, String startImage, String gameImage, String startMusic) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
	}
	
	
	
	
	
	
	
	
	

}
