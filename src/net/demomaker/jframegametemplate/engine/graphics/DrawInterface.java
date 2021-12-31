package net.demomaker.jframegametemplate.engine.graphics;

import net.demomaker.jframegametemplate.engine.util.AdvancedImage;
import net.demomaker.jframegametemplate.engine.util.Vector3;

import java.awt.*;

public interface DrawInterface {
  void fillRectangle(Color color, int width, int height, Vector3<Float> position);
  void outlineRectangle(Color color, int width, int height, Vector3<Float> position);
  void drawImage(AdvancedImage advancedImage, Vector3<Float> position);
  void drawImage(AdvancedImage advancedImage, int width, int height, Vector3<Float> position);
  void drawString(Color color, String string, Vector3<Float> position);
  void cleanup();

}
