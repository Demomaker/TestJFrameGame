package net.demomaker.jframegametemplate.game.game;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import net.demomaker.jframegametemplate.engine.game.Game;
import net.demomaker.jframegametemplate.engine.graphics.GameWindow;
import net.demomaker.jframegametemplate.engine.graphics.GraphicsManager;
import net.demomaker.jframegametemplate.engine.scene.SceneManager;
import net.demomaker.jframegametemplate.engine.util.AdvancedImage;
import net.demomaker.jframegametemplate.engine.util.ImageObserver;
import net.demomaker.jframegametemplate.engine.util.ResourceFinder;
import net.demomaker.jframegametemplate.engine.util.Vector3;
import net.demomaker.jframegametemplate.game.graphics.JavaGraphicsTemplate;

import java.awt.*;
import java.awt.image.BufferStrategy;
import net.demomaker.jframegametemplate.game.scene.FirstSceneTemplate;

public class JFrameGameTemplate extends Game {
  private final String titlename = "DAG - Demomaker's Apple Game";
  private final JFrame frame = new JFrame();
  private static final int WIDTH = 900;
  private static final int HEIGHT = WIDTH / 16 * 9;

  public JFrameGameTemplate() {
    ResourceFinder.setRoot(this);
    frame.setResizable(true);
    frame.setTitle(titlename);
    frame.add(this);
    frame.setVisible(true);
    frame.pack();
    frame.setSize(WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    GameWindow.setName(titlename);
    GameWindow.setWidth(frame.getWidth());
    GameWindow.setHeight(frame.getHeight());
  }

  @Override
  public void initGame() {
    SceneManager.init();
    SceneManager.addScene(new FirstSceneTemplate());
    SceneManager.setActiveScene(SceneManager.getSceneByName("FirstSceneTemplate"));
  }

  @Override
  public void startGame() {
    ResourceFinder.setRoot(this);
    frame.setResizable(true);
    frame.setTitle(titlename);
    frame.add(this);
    frame.setVisible(true);
    frame.pack();
    frame.setSize(WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    GameWindow.setName(titlename);
    GameWindow.setWidth(frame.getWidth());
    GameWindow.setHeight(frame.getHeight());
    ImageObserver.setImageObserver(this);
    frame.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        super.componentResized(e);
        GameWindow.setWidth(frame.getWidth());
        GameWindow.setHeight(frame.getHeight());
      }
    });
    start();
  }

  @Override
  public void endGame() {
    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
  }

  @Override
  public void renderGame() {
    if(!SceneManager.getActiveScene().finishedLoading()) return;
    BufferStrategy bs = getBufferStrategy();
    if (bs == null) {
      createBufferStrategy(3);
      return;

    }
    JavaGraphicsTemplate javaGraphicsTemplate = new JavaGraphicsTemplate();
    Graphics g = bs.getDrawGraphics();
    javaGraphicsTemplate.setGraphics(g);
    GraphicsManager.init(javaGraphicsTemplate);
    AdvancedImage image = AdvancedImage.createImageFromWidthAndHeight(GameWindow.getWidth(), GameWindow.getHeight());
    GraphicsManager.drawImage(image, new Vector3<>(0f, 0f, 0f));
    SceneManager.getActiveScene().draw();
    GraphicsManager.cleanup();
    bs.show();
  }

  @Override
  public void updateGame(float deltaTime) {
    if(!SceneManager.getActiveScene().finishedLoading()) return;
    SceneManager.getActiveScene().update(deltaTime);
  }

  @Override
  public void goFullScreen() {
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    frame.setResizable(false);
    frame.setSize(WIDTH, HEIGHT);
    frame.setAlwaysOnTop(false);
    frame.setResizable(true);
  }

  @Override
  public void updateFPS() {
  }

  @Override
  public void updateUpdates() {
  }

  @Override
  public void onException(Exception exception) {
  }
}
