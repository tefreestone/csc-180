package edu.neumont.csc180.ThreadLab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// How to do framerate -- http://www.dreamincode.net/forums/blog/867/entry-2094-frame-rate-in-java/

public class Animator extends JFrame {
    JButton start, stop;
    JPanel ballPanel;
    Ball ball;
    boolean animate;

    public Animator() {
        super("Animation");
        start = new JButton("Start");
        stop = new JButton("Stop");
        Box buttons = new Box(BoxLayout.X_AXIS);
        buttons.add(start);
        buttons.add(stop);
        getContentPane().add(buttons, BorderLayout.NORTH);
        ballPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ball.paint(g);
            }
        };
        ball = new Ball(ballPanel);
        getContentPane().add(ballPanel);

        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                animate = true;
                while (animate) {
                    ball.move();
                    repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame f = new Animator();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(300, 300, 300, 200);
        f.setVisible(true);
    }

}
