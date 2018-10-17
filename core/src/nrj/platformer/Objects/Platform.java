package nrj.platformer.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;


public class Platform extends Sprite {
    Rectangle rectPlatform;
    public Platform(Texture tx, float fX, float fY, float fW, float fH){
        super(tx);
        setSize(fW, fH);
        setPosition(fX, fY);
        rectPlatform = new Rectangle(getBoundingRectangle());
    }

}
