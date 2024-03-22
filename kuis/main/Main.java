package main;

import logic.InternshipApplicationLogic;
import ui.InternshipApplicationUI;
import javax.swing.SwingUtilities;

public class Main {
    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InternshipApplicationUI();
            }
   });
}
}