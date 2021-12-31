package net.demomaker.jframegametemplate.engine.scene;

public interface Scene {
    boolean finishedLoading();
    void onWindowResize();
    void init();
    void update(float deltaTime);
    void draw();
    void cleanup();
    void onResume();
}
