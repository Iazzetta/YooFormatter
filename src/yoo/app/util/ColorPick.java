package yoo.app.util;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JColorChooser;

public class ColorPick {
    
    /** Cor selecionada pelo usuário. */
    private Color selected;
    
    /** Cor Padrão. */
    private final Color DEFAULT_COLOR = Color.BLACK;
    
    private ColorPick(){}
    
    /** @return uma instancia da classe {@code ColorPick} */
    public static ColorPick instance() {
        return ColorPickHolder.INSTANCE;
    }
    
    /**
     * Exibe a caixa de cores. O método chama {@code showDialog} do objeto
     * {@code JColorChooser} no qual será exibida uma caixa de cores para o usuário
     * selecionar a cor do texto (títulos e conteúdo) gerado no <i>output</i>.
     * Por padrão a cor inicial sempre será {@code Color.BLACK} quando a janela
     * for exibida.
     * 
     * <strong>Nota:</strong> O retorno do método {@code showDialog} será <b>null</b>
     * caso o usuário não escolha nenhuma cor, e.g: clicar no 'x' para fechar a janela
     * ou no botão 'cancelar'. Nesse caso, como tratamento, o valor da seleção será a
     * cor padrão mesmo que nenhuma cor seja selecionada.
     * 
     * @param parent o componente pai que irá 'segurar' essa caixa de seleção.
     * @param windowTitle o título que deve ser exibido no topo da caixa de seleção.
     */
    public void selectColor(Component parent, String windowTitle){
        Color temp = JColorChooser.showDialog(parent, windowTitle, DEFAULT_COLOR);
        selected = temp != null ? temp : DEFAULT_COLOR;
    }
    
    /**
     * @return a cor selecionada pelo usuário ou a padrão (no caso de não
     * ter sido selecionada nenhuma).
     */
    public Color getSelectedColor(){
        if(selected == null)
            selected = DEFAULT_COLOR;
        return selected;
    }
    
    /**
     * @return a cor selecionada pelo usuário em hexadecimal, e.g #FFFFFF. Caso
     * nenhuma cor tenha sido selecionada o retorno será o padrão #000000.
     */
    public String getSelectedHexColor(){
        return colorToHex(getSelectedColor());
    }
    
    /**
     * Destrói a seleção feita pelo usuário. Método usado quando a seleção
     * anterior deve ser descartada.
     */
    public void destroySelection(){
        selected = null;
    }
    
    /**
     * Método usado para obter o código hexadecimal de uma cor.
     * @param color a cor escolhida.
     * @return uma <i>string</i> com o código hexadecimal, e.g #FFFFFF.
     */
    private String colorToHex(Color color){
        return String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
    }
    
    private static class ColorPickHolder {
        private static final ColorPick INSTANCE = new ColorPick();
    }
}