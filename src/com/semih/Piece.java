package com.semih;

import java.util.ArrayList;
import java.util.Iterator;

public class Piece {
     public ArrayList<Block> blocks;
    // https://tetris.wiki/Tetromino#:~:text=The%20seven%20one%2Dsided%20tetrominoes,previously%20called%20tetraminoes%20around%201999.
    public enum Type {
        I, O, T, S, Z, J, L
    }
    public Type type;
     public Piece(Type t){
         type = t;
         blocks = new ArrayList<Block>();
         int left_start = 4;
         switch (t){
             case I:
                 blocks.add(new Block(t.ordinal(), new Location(4,1)));
                 blocks.add(new Block(t.ordinal(), new Location(4,2)));
                 blocks.add(new Block(t.ordinal(), new Location(4,3)));
                 blocks.add(new Block(t.ordinal(), new Location(4,4)));
                 break;
             case O:
                 blocks.add(new Block(t.ordinal(), new Location(5,0)));
                 blocks.add(new Block(t.ordinal(), new Location(5,1)));
                 blocks.add(new Block(t.ordinal(), new Location(6,0)));
                 blocks.add(new Block(t.ordinal(), new Location(6,1)));
                 break;
             case T:
                 blocks.add(new Block(t.ordinal(), new Location(4,0)));
                 blocks.add(new Block(t.ordinal(), new Location(3,1)));
                 blocks.add(new Block(t.ordinal(), new Location(4,1)));
                 blocks.add(new Block(t.ordinal(), new Location(5,1)));
                 break;
             case S:
                 blocks.add(new Block(t.ordinal(), new Location(4,0)));
                 blocks.add(new Block(t.ordinal(), new Location(5,0)));
                 blocks.add(new Block(t.ordinal(), new Location(3,1)));
                 blocks.add(new Block(t.ordinal(), new Location(4,1)));
                 break;
             case Z:
                 blocks.add(new Block(t.ordinal(), new Location(3,0)));
                 blocks.add(new Block(t.ordinal(), new Location(4,0)));
                 blocks.add(new Block(t.ordinal(), new Location(4,1)));
                 blocks.add(new Block(t.ordinal(), new Location(5,1)));
                 break;
             case J:
                 blocks.add(new Block(t.ordinal(), new Location(3,0)));
                 blocks.add(new Block(t.ordinal(), new Location(3,1)));
                 blocks.add(new Block(t.ordinal(), new Location(4,1)));
                 blocks.add(new Block(t.ordinal(), new Location(5,1)));
                 break;
             case L:
                 blocks.add(new Block(t.ordinal(), new Location(5,0)));
                 blocks.add(new Block(t.ordinal(), new Location(5,1)));
                 blocks.add(new Block(t.ordinal(), new Location(4,1)));
                 blocks.add(new Block(t.ordinal(), new Location(3,1)));
                 break;
         }
         translate(4,0);
     }

     public void rotateR(){
         switch (this.type){
             case I:
                 blocks.get(0).position.x +=3;
                 blocks.get(0).position.y -=3;
                 blocks.get(1).position.x +=2;
                 blocks.get(1).position.y -=2;
                 blocks.get(2).position.x +=1;
                 blocks.get(2).position.y -=1;
                 break;
             case O:

                 break;
             case T:

                 break;
             case S:

                 break;
             case Z:

                 break;
             case J:

                 break;
             case L:

                 break;
         }
     }

     public void translate(int vx, int vy){
         for (Block b: blocks) {
             b.position.x += vx;
             b.position.y += vy;
         }
     }
}
