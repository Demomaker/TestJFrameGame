package net.demomaker.jframegametemplate.engine.ui;

import net.demomaker.jframegametemplate.engine.graphics.GraphicsManager;
import net.demomaker.jframegametemplate.engine.util.AdvancedImage;
import net.demomaker.jframegametemplate.engine.util.ImageObserver;
import net.demomaker.jframegametemplate.engine.util.Vector3;

public class UIImage extends UIElement {
    private AdvancedImage image;
    public void setImage(AdvancedImage image) {
        this.image = image;
        this.setSize(new Vector3<>( (float) image.getWidth(ImageObserver.getImageObserver()), (float) image.getHeight(ImageObserver.getImageObserver()),0f));
    }
    public void draw() {
        GraphicsManager.drawImage(image, getPosition());
    }
}
