package yoo.app.views;

import java.awt.Component;
import javax.swing.JOptionPane;

public class FlowDialog {
    
    private FlowDialog() {}
    
    /**
     * Exibe uma janela {@code JOptionPane} simples. - contendo somente o título
     * e o conteúdo do <i>dialog</i>.
     * @param parent o componente pai.
     * @param title o título da janela.
     * @param message a mensagem.
     */
    public static void dialog(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * Exibe uma janela {@code JOptionPane} com ícone de <i>WARNING</i>.
     * @param parent o componente pai.
     * @param title o título da janela.
     * @param message a mensagem.
     */
    public static void alert(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Exibe uma janela {@code JOptionPane} com ícone de <i>ERROR</i>.
     * @param parent o componente pai.
     * @param title o título da janela.
     * @param message a mensagem.
     */
    public static void error(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Exibe uma janela {@code JOptionPane} com ícone de <i>INFO</i>.
     * @param parent o componente pai.
     * @param title o título da janela.
     * @param message a mensagem.
     */
    public static void information(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Exibe uma janela de confirmação {@code showConfirmDialog} com o ícone de
     * <i>INFO</i>. - A janela terá dois botões para decisão: 'OK' e 'Cancelar'.
     * @param parent o componente pai.
     * @param title o título da janela.
     * @param message a mensagem.
     * @return true se o usuário clicar em 'OK' e false se clicar em 'Cancelar'.
     */
    public static boolean confirm(Component parent, String title, String message){
        return JOptionPane.showConfirmDialog(
            parent, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE
        ) == JOptionPane.OK_OPTION;
    }
}