package nrj.platformer.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;


public class Platform extends Ground {
    Rectangle rectPlatform;
    public Platform(Texture tx, float fX, float fY, float fW, float fH){
        super(tx);
        setSize(fW, fH);
        setPosition(fX, fY);
        rectPlatform = new Rectangle(getBoundingRectangle());
    }
   public void hold(Jumper j){
        if (j.getBoundingRectangle().overlaps(rectPlatform) && !Gdx.input.isKeyPressed((Input.Keys.W))){
            System.out.println("overlapping");
            j.fmaxHeight = j.v2Loc.y + 100;
            j.isAirborn = false;
            j.canJump = true;
            j.isGrounded = true;
            j.v2Loc.y =(rectPlatform.getY() + j.getHeight()/2);
            if (j.v2Acc.y != 0)
            j.v2Acc.setZero();

        } else if (j.getBoundingRectangle().overlaps(rectPlatform) && Gdx.input.isKeyPressed((Input.Keys.W)) && j.isAirborn) {
            j.fmaxHeight = j.v2Loc.y + 100;
            j.isAirborn = false;
            j.canJump = true;
            j.isGrounded = true;
            j.v2Loc.y =(rectPlatform.getY() + j.getHeight()/2);
            if (j.v2Acc.y != 0)
                j.v2Acc.setZero();

        } else if (!j.isGrounded){
            j.isAirborn = true;
        }

    }

}
