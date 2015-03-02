package yoo.app.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;


public class ComponentUtils {
    
    private ComponentUtils(){}
    
    /** @return obtém uma instância da classe {@code ComponentUtils}. */
    public static ComponentUtils instance() {
        return ComponentUtilsHolder.INSTANCE;
    }
    
    /**
     * Define o <i>Look and Feel</i> da aplicação. É feita uma chamada ao método
     * {@code setLookAndFeel} tentando utilizar a classe responsável pela aparência
     * do sistema operacional.
     * 
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public void setSystemLookAndFeel()
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    
    /**
     * Adiciona um listener para tornar possível a movimentação de um {@code Component}
     * definido como {@code setUndecorated(false)}. Por padrão não é possível movimentar
     * uma janela <i>undecorated</i>, esse método torna isso possível.
     * @param component pode ser um {@code JFrame}, {@code JDialog}, etc.
     */
    public void setUndecoratedWindowHandler(Component component){
        Point externpoint = new Point();
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                super.mousePressed(evt);
                externpoint.x = evt.getX();
                externpoint.y = evt.getY();
            }  
        });
        component.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent evt) {
                super.mouseMoved(evt);
                Point innerpoint = component.getLocation();
                component.setLocation(
                    innerpoint.x + evt.getX() - externpoint.x,
                    innerpoint.y + evt.getY() - externpoint.y
                );
            }  
        });
    }
    
    /**
     * {@code defaultBorderColor} e {@code hoverBorderColor} definem as cores que serão 
     * usadas na borda de um componente quando houver o evento de <i>hover</i>.
     * {@code defaultBorderColor} define a cor do componente em seu estado normal.
     * {@code hoverBorderColor} define a cor do componente quando este tem o cursor
     * do mouse sobre ele.
     */
    private Color defaultBorderColor = null, hoverBorderColor = null;
    
    /**
     * {@code defaultForegroundColor} e {@code hoverForegroundColor} definem as cores
     * que serão usadas no texto de um componente quando houver o evento de <i>hover</i>.
     * {@code defaultForegroundColor} define a cor na fonte do componente em seu estado
     * normal. {@code hoverForegroundColor} define a cor na fonte do componente quando
     * este tem o cursor do mouse sobre ele.
     */
    private Color defaultForegroundColor = null, hoverForegroundColor = null;
    
    /**
     * Define as propriedades de <i>hover</i> para um {@code JButton}. Este método deve ser
     * chamado antes de utilizar {@code onHover} para 'setar' o comportamento do botão:
     * @param defaultBorderColor é a cor da borda do componente em seu estado normal.
     * @param hoverBorderColor é a cor da borda do componente quando há <i>hover</i>.
     * @param defaultForegroundColor é a cor na fonte do componente em seu estado normal.
     * @param hoverForegroundColor é a cor na fonte do componente quando este tem o cursor 
     * do mouse sobre ele.
     */
    public void setButtonOptions(Color defaultBorderColor, Color hoverBorderColor,
                                 Color defaultForegroundColor, Color hoverForegroundColor){
        this.defaultBorderColor = defaultBorderColor;
        this.hoverBorderColor = hoverBorderColor;
        this.defaultForegroundColor = defaultForegroundColor;
        this.hoverForegroundColor = hoverForegroundColor;
    }
    
    /**
     * Altera a borda do componente quando este tem o cursor do mouse sobre ele.
     * <b>NOTA:</b> Chamar {@code setButtonOptions} antes de utilizar esse método.
     * @param component é o botão onde a ação deve ocorrer.
     * @param hasHover se 'true', a cor da borda/fonte é alterada. Do contrário é
     * definido a cor padrão.
     */
    public void onHover(JButton component, boolean hasHover){
        LineBorder border = new LineBorder(defaultBorderColor, 1, false);
        if(component.isEnabled() && hasHover){
            component.setBorder(border);
            component.setForeground(hoverForegroundColor);
            return;
        } 
        component.setBorder(border);
        component.setForeground(defaultForegroundColor);
    }
    
    /**
     * Simula o 'efeito' de <i>placeholder</i> em um {@code JTextField}.
     * @param component o componente que será afetado.
     * @param hasFocus 'true' quando o elemento estiver com foco.
     */
    public void placeHolder(JTextField component, boolean hasFocus){
        String value = component.getText();
        if(hasFocus && value.equalsIgnoreCase(component.getName()))
            component.setText("");
        else if(value == null || value.isEmpty())
            component.setText(component.getName());
    }
    
    /**
     * Simula o 'efeito' de <i>placeholder</i> em um {@code JTextArea}.
     * @param component o componente que será afetado.
     * @param hasFocus 'true' quando o elemento estiver com foco.
     */
    public void placeHolder(JTextArea component, boolean hasFocus){
        String value = component.getText();
        if(hasFocus && value.equalsIgnoreCase(component.getName()))
            component.setText("");
        else if(value == null || value.isEmpty())
            component.setText(component.getName());
    }
    
    /**
     * Altera o nome de um {@code JTextField} para o valor que estiver no campo.
     * @param component o componente que será afetado.
     */
    public void setNameByContent(JTextField component){
        component.setName(component.getText());
    }

    /**
     * Altera o nome de uma {@code JTextArea} para o valor que estiver no campo.
     * @param component o componente que será afetado.
     */
    public void setNameByContent(JTextArea component){
        component.setName(component.getText());
    }
    
    private static class ComponentUtilsHolder {
        private static final ComponentUtils INSTANCE = new ComponentUtils();
    }
}
