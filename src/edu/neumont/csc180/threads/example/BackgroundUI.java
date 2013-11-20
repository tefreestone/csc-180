package edu.neumont.csc180.threads.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BackgroundUI extends JFrame {
    class WorkToDo extends SwingWorker<Long, String> {
        private long result;

        @Override
        protected Long doInBackground() throws Exception {
            for (int j = 0; j < 100; j++) {
                for (int i = 0; i < 1e8; i++) {
                    result++;
                }
                if (this.isCancelled()) break;
                publish("Currently at: " + result);
            }
            cancelButton.setEnabled(false);
            return result;
        }

        @Override
        protected void process(List<String> chunks) {
            output.setText(chunks.get(0));
        }

        @Override
        protected void done() {
            output.setText("Result: " + this.result);
        }
    }

    private WorkToDo work;
    private JPanel content;
    private JButton workButton, cancelButton;
    private JTextField output;


    public BackgroundUI() {
        super("Work!");
        content = new JPanel(new BorderLayout());
        work = new WorkToDo();
        output = new JTextField(20);
        output.setEditable(false);
        workButton = new JButton("Go");
        workButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelButton.setEnabled(true);
                workButton.setEnabled(false);
                work.execute();
            }
        });
        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                work.cancel(true);
            }
        });

        content.add(workButton, BorderLayout.NORTH);
        content.add(output);
        content.add(cancelButton, BorderLayout.SOUTH);
        this.setContentPane(content);
        this.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ui = new BackgroundUI();
                ui.setVisible(true);
                ui.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
    }
}
