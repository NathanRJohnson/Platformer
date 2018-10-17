package nrj.platformer.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Background extends Sprite {

    public Background(Texture tx) {
        super(tx);
        int nWidth = 700, nHeight = 500;
        setSize(nWidth, nHeight);
        setPosition(0,0);

    }
}
