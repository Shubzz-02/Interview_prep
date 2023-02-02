package com.company.etc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingPad extends JPanel {

    private ArrayList<ArrayList<PointAndColor>> lines = new ArrayList<ArrayList<PointAndColor>>();
    private Color color = Color.black;

    public DrawingPad() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ArrayList<PointAndColor> line = new ArrayList<PointAndColor>();
                line.add(new PointAndColor(e.getPoint(), color));
                lines.add(line);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ArrayList<PointAndColor> line = lines.get(lines.size() - 1);
                line.add(new PointAndColor(e.getPoint(), color));
                repaint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                ArrayList<PointAndColor> line = lines.get(lines.size() - 1);
                line.add(new PointAndColor(e.getPoint(), color));
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ArrayList<PointAndColor> line : lines) {
            for (int i = 0; i < line.size() - 1; i++) {
                PointAndColor p1 = line.get(i);
                PointAndColor p2 = line.get(i + 1);
                g.setColor(p1.color);
                g.drawLine(p1.point.x, p1.point.y, p2.point.x, p2.point.y);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    private static class PointAndColor {

        public final Point point;
        public final Color color;

        public PointAndColor(Point point, Color color) {
            this.point = point;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPad drawingPad = new DrawingPad();
        frame.add(drawingPad);

        JButton colorButton = new JButton("Change color");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPad.color = JColorChooser.showDialog(frame, "Choose color",
                        drawingPad.color);
            }
        });
        frame.add(colorButton, "South");

        frame.pack();
        frame.setVisible(true);
    }
}

