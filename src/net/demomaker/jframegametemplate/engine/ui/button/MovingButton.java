package net.demomaker.jframegametemplate.engine.ui.button;

import net.demomaker.jframegametemplate.engine.util.AdvancedImage;
import net.demomaker.jframegametemplate.engine.util.ImageObserver;
import net.demomaker.jframegametemplate.engine.util.Vector3;

public class MovingButton extends Button {

    public void setImage(AdvancedImage image) {
        imageToShow = image;
        this.setSize(new Vector3<>( (float) image.getWidth(ImageObserver.getImageObserver()), (float) image.getHeight(ImageObserver.getImageObserver()),0f));
    }

    @Override
    protected void click() {
        super.click();
        //Do nothing
    }

    @Override
    protected void normal() {
        super.normal();
        //Do nothing
    }

    @Override
    protected void release() {
        super.release();
        //Do nothing
    }

    @Override
    protected void press() {
        super.press();
        //Do nothing
    }
}
