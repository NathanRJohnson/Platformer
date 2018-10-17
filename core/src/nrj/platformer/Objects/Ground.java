package nrj.platformer.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;


public class Ground extends Sprite {
    Rectangle rctGround;
    public int nState;
    public Ground(Texture tx){
        super(tx);
        setSize(700,100);
        setPosition(0,-50);
        rctGround = new Rectangle(getBoundingRectangle());
         nState = 0;
    }

    public void floor(Jumper j)
    {

        if (j.getBoundingRectangle().overlaps(rctGround) && !Gdx.input.isKeyPressed((Input.Keys.W))){
                j.v2Loc.y = 45;
                j.canJump = true;
                j.isAirborn = false;
                if (j.v2Acc.y != 0) {
                    j.v2Acc.setZero();

                }
         //   }
            //System.out.println("can i get uhh");
        } else if (j.getBoundingRectangle().overlaps(rctGround) && Gdx.input.isKeyPressed((Input.Keys.W)) && j.isAirborn == true ) {
            j.v2Loc.y = 45;
            j.canJump = true;
            j.isAirborn = false;
            if (j.v2Acc.y != 0) {
                j.v2Acc.setZero();

            }
        } else {
            j.isAirborn = true;
        }

    }
}
