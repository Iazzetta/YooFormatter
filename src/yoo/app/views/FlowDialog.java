package yoo.app.views;

import java.awt.Component;
import javax.swing.JOptionPane;

public class FlowDialog {
    
    private FlowDialog() {}
    
    public static void dialog(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void alert(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public static void error(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void information(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean confirm(Component parent, String title, String message){
        return JOptionPane.showConfirmDialog(
            parent, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE
        ) == JOptionPane.OK_OPTION;
    }
}