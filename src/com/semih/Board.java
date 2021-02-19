package com.semih;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.JComponent;

class Board extends JComponent {
    private static final int SCALE = 16; // number of pixels per square
    private int cols;
    private int rows;

    private Piece activePiece;
    private ArrayList<Block> wall_blocks;
    public static Color[] colors = {Color.cyan, Color.yellow, new Color(102,0,153),
            Color.green, Color.red, Color.blue, Color.orange};
    public Board(int cols, int rows) {
        super();
        this.cols = cols;
        this.rows = rows;
        wall_blocks = new ArrayList<Block>();
        setPreferredSize(new Dimension(cols * SCALE, rows * SCALE));
        createNewActivePeace();
    }

    public void paintComponent(Graphics g) {
        // clear the screen with black
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(new Color(51,51,51));
        for(Block block: wall_blocks){
            block.draw(g, SCALE);
        }

        for(Block block: activePiece.blocks){
            g.setColor(colors[activePiece.type.ordinal()]);
            block.draw(g, SCALE);
        }
    }

    // Move the active piece down one step. Check for collisions.
    //  Check for complete rows that can be destroyed.
    public void nextTurn() {
        if(collision()){
            convertActivePieceToBlocks();
            createNewActivePeace();
            return;
        }
        activePiece.translate(0,1);
    }

    public void slide(int dx) {
        activePiece.translate(dx,0);
        repaint();
    }

    public void rotateRight() {
        activePiece.rotateR();

        repaint();
    }

    public void rotateLeft() {
        // TO DO: rotate the active piece to the left:
        repaint();
    }

    private boolean collision(){
        for(Block b: activePiece.blocks){
            if(b.position.y >= rows - 1){
                return true;
            }
            for(Block w_b : wall_blocks){
                System.out.println(w_b.position.toString() + " vs " + b.position.toString());
                if(w_b.position.x == b.position.x && w_b.position.y == b.position.y+1 ) {
                    return true;
                }
            }
        }
        return false;
    }

    private void convertActivePieceToBlocks(){
        for(Block b: activePiece.blocks){
              wall_blocks.add(b);
            }
        activePiece.blocks.clear();
    }

    private void createNewActivePeace(){
        Random rand = new Random(); //instance of random class
        int random_type = rand.nextInt(7);
        //activePiece = new Piece(Piece.Type.values()[random_type]);
        activePiece = new Piece(Piece.Type.I);
    }
}
