package nrj.platformer.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Jumper extends Sprite {
    public Vector2 v2Loc, v2Vel, v2Acc;
    Vector2 v2CurrentPos, v2Gravity;
    float fmaxHeight;
    boolean canJump, isAirborn, isGrounded;

    public Jumper(Texture tx, float _fX, float _fY) {
        super(tx);
        v2Loc = new Vector2(_fX, _fY);
        v2Vel = new Vector2(0, 0);
        v2Acc = new Vector2(0, 0);
        v2CurrentPos = new Vector2(v2Loc);
        v2Gravity = new Vector2(0,-1);
        isGrounded = false;
        canJump = false;
        isAirborn = false;
        v2CurrentPos.equals(v2Loc);
        fmaxHeight = v2CurrentPos.y + 100;
            //setPosition(v2Loc.x, v2Loc.y);
        setSize(50, 50);
        setFlip(true, false);
    }

    public void Update()//Grouping Function
    {
        move();
        jump();
        applyForce(v2Gravity);

    }

    void checkMove() {

    }

    void move() {
        v2Vel.add(v2Acc);
        v2Loc.add(v2Vel);
        setPosition(v2Loc.x, v2Loc.y);
        v2Vel.setZero();

        //Left Right Movement
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            //  System.out.println(v2Loc.x);
            v2Vel.x = -5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            // System.out.println(v2Loc.x);
            v2Vel.x = 5;
        }
    }

    void jump() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            v2CurrentPos.equals(v2Loc);
            fmaxHeight = v2CurrentPos.y + 100;
            isAirborn = true;
            isGrounded = false;

        }
        if (canJump) {

            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                if (v2Loc.y < fmaxHeight)
                    v2Acc.y = 10;


            }

            if (!Gdx.input.isKeyPressed(Input.Keys.W) && isAirborn){
                canJump = false;
            }

            if (v2Loc.y >= fmaxHeight) {
                canJump = false;
                isAirborn = true;

            }
        }
    }

    public void applyForce(Vector2 v) {
        Vector2 v2Copy = v.cpy();
        v2Acc.add(v2Copy);

    }
}
