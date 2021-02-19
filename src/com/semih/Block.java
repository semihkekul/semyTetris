package com.semih;

import java.awt.Color;
import java.awt.Graphics;

class Block {
    public Location position;
    public int colorIndex;

    public Block(int colorIndex, Location loc) {
        position = loc;
        this.colorIndex = colorIndex;
    }

    public void draw(Graphics g, int scale) {
        int px = position.x * scale + 1;
        int py = position.y * scale + 1;

        int size = scale - 2;

        g.fillRect(px, py, size, size);
    }

}
