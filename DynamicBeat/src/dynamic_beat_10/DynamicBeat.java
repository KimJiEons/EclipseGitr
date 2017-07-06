package dynamic_beat_10;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dynamic_beat_7.Main;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/background.jpg")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/background.jpg")).getImage();

	
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLine = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();	
	private Image noteRoute = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
	private Image noteRouteline = new ImageIcon(Main.class.getResource("../images/noteRouteline.png")).getImage();	
	private Image noteBasic = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();	
	

	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar.png")));

	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBsicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));

	private ImageIcon leftButtonBsicImage = new ImageIcon(Main.class.getResource("../images/leftbasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftentered.png"));
	
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightbasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightentered.png"));
	
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easytButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	

	
	

	private ImageIcon exit1 = new ImageIcon(Main.class.getResource("../images/exit1.png"));
	private ImageIcon exit = new ImageIcon(Main.class.getResource("../images/exit.png"));

	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/exit.png")));
	private JButton startButton = new JButton(startButtonBsicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBsicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	
	
	
	
	
	private int mouseX, mouseY;
	
	
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();

	private Music introMusic = new Music("bgm.mp3", true);
	private Music selectedMusic;
	private Image titleImage;
	private Image selectImage;
	private int nowSelected  = 0;
	

	
	

	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_HEIGHT, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		introMusic.start();
		
		
		trackList.add(new Track("introtitle0.png", "introduce0.png", "mainintroduce0.png", "music1.mp3"));
		trackList.add(new Track("introtitle1.png", "introduce1.png", "mainintroduce1.png", "music2.mp3"));
		trackList.add(new Track("introtitle2.png", "introduce1.png", "mainintroduce2.png", "music3.mp3"));

		exitButton.setBounds(600, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setFocusPainted(false);

		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				exitButton.setIcon(exit);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("backm1.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exit1);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {

				Music buttonEnteredMusic = new Music("backm2.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException E) {
					// TODO: handle exception
					E.getMessage();
				}

				System.exit(0);
			}

		});

		add(exitButton);

		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);

		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//	Music buttonEnteredMusic = new Music("backm1.mp3", false);
			//	buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBsicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {

			
				// 게임시작 이벤트
				introMusic.close();
				enterMain();
			
				
			}

		});

		add(startButton);

		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);

		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//	Music buttonEnteredMusic = new Music("backm1.mp3", false);
			//	buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {

				Music buttonEnteredMusic = new Music("backm2.mp3", false);
				buttonEnteredMusic.start();

				// 게임시작 이벤트

				try {
					Thread.sleep(1000);
				} catch (InterruptedException E) {
					// TODO: handle exception
					E.getMessage();
				}

				System.exit(0);
			}

		});

		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140,310,60,60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);

		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//	Music buttonEnteredMusic = new Music("backm1.mp3", false);
			//	buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBsicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {

		//		Music buttonEnteredMusic = new Music("backm2.mp3", false);
		//		buttonEnteredMusic.start();
       
				// 게임시작 이벤트

			//왼쪽버튼 이벤트
				selectLeft();
				
			}

		});

		add(leftButton);
		
		
		rightButton.setVisible(false);
		rightButton.setBounds(360,310,60,60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);

		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//	Music buttonEnteredMusic = new Music("backm1.mp3", false);
			//	buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {

		//		Music buttonEnteredMusic = new Music("backm2.mp3", false);
		//		buttonEnteredMusic.start();
       
				// 게임시작 이벤트

			//왼쪽버튼 이벤트
				selectRight();
				
				
			}

		});

		add(rightButton);
		
		
		easyButton.setVisible(false);
		easyButton.setBounds(80,580,250,67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);

		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				easyButton.setIcon(easytButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//	Music buttonEnteredMusic = new Music("backm1.mp3", false);
			//	buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {

		//		Music buttonEnteredMusic = new Music("backm2.mp3", false);
		//		buttonEnteredMusic.start();
       
				// 게임시작 이벤트

			//왼쪽버튼 이벤트
				selectRight();
				
				//난이도 쉬움 이벤트
				
				gameStart(nowSelected, "easy");
			}

		});

		add(easyButton);
		
		
		hardButton.setVisible(false);
		hardButton.setBounds(380 ,580,250,67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);

		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//	Music buttonEnteredMusic = new Music("backm1.mp3", false);
			//	buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {

		//		Music buttonEnteredMusic = new Music("backm2.mp3", false);
		//		buttonEnteredMusic.start();
       
				// 게임시작 이벤트

			//왼쪽버튼 이벤트
				selectRight();
				
				//난이도 어려움
				
				gameStart(nowSelected, "hard");
				
			}

		});

		add(hardButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20,50,60,60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);

		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//	Music buttonEnteredMusic = new Music("backm1.mp3", false);
			//	buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {

		//		Music buttonEnteredMusic = new Music("backm2.mp3", false);
		//		buttonEnteredMusic.start();
       
				// 게임시작 이벤트

			//왼쪽버튼 이벤트
			//	selectRight();
				
			//메인화면돌아가기
				backMain();
				
			}

		});

		add(backButton);

		menubar.setBounds(0, 0, 1280, 30);
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});

		menubar.addMouseMotionListener(new MouseAdapter() {

			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}

		});

		add(menubar);

		
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen)
		{
			g.drawImage(selectImage, 40, 50, null);
			g.drawImage(titleImage,50,50, null);
		}
		if(isGameScreen)
		{
			g.drawImage(gameInfoImage, 0, 660, null);
			g.drawImage(judgementLine, 0, 600, null);
			
			g.drawImage(noteBasic, 228, 120, null);
			
			g.drawImage(noteRoute, 20, 10, null);
			g.drawImage(noteRouteline, 120, 10, null);
			g.drawImage(noteRoute, 125, 10, null);
			g.drawImage(noteRouteline, 225, 10, null);
			g.drawImage(noteRoute, 230, 10, null);
			g.drawImage(noteRouteline, 330, 10, null);
			g.drawImage(noteRoute, 335, 10, null);
			
			g.drawImage(noteRouteline, 435, 10, null);
			g.drawImage(noteRoute, 440, 10, null);
			
			g.drawImage(noteRouteline, 540, 10, null);
			g.drawImage(noteRoute, 545, 10, null);
			
			g.drawImage(noteRouteline, 645, 10, null);
			g.drawImage(noteRoute, 650, 10, null);
			
		}
		
		
		paintComponents(g);
		this.repaint();
	}
	
	
	public void selectTrck(int nowSelected)
	{
		if(selectedMusic != null)
		  selectedMusic.close();
		
		titleImage = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getTitleImage())).getImage();
		selectImage = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getTitleImage())).getImage();

		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
		selectedMusic.start();
	}
	
	public void selectLeft()
	{
		if(nowSelected == 0)
			nowSelected = trackList.size()-1;
		else
			nowSelected--;
		selectTrck(nowSelected);
	}
	public void selectRight()
	{
		if(nowSelected == trackList.size()-1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrck(nowSelected);
	}
	
	
	public void gameStart(int nowSelected,String difficulty)
	{
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		
		background = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		
	}
	
	public void backMain()
	{
		isMainScreen= true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();;		
		backButton.setVisible(true);
		selectTrck(nowSelected);
		isGameScreen = false;
	}
	
	public void enterMain()
	{
		selectTrck(0);
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectTrck(0);
		
		

	}

}



































