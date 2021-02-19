package com.semih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class SemyTetris {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("SemyTetris!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board(16, 32);
        frame.getContentPane().add(board);

        //Display the window.
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        Timer timer = new Timer(300, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                board.nextTurn();
                board.repaint();
            }

        });

        frame.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                System.out.println("key pressed " + e.getKeyCode());
                if(key == KeyEvent.VK_LEFT) {
                    board.rotateLeft();
                } else if (key == KeyEvent.VK_RIGHT) {
                    board.rotateRight();
                } else if (key == KeyEvent.VK_A) {
                    board.slide(-1);
                }  else if (key == KeyEvent.VK_D) {
                    board.slide(1);
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        timer.start();
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
