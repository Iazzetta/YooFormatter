package yoo.app.util;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import yoo.core.util.Validator;

public class EntryValidator {
    
    /**
     * Verifica se o valor digitado pelo usuário não é nulo ou vazio em um 
     * {@code JTextField}.
     * @param component o componente que deve ser verificado.
     * @return true se o valor não for vazio ou nulo.
     * @see Validator 'Validator' para maiores detalhes.
     */
    public static boolean hasValidEntry(JTextField component){
        return !Validator.isNullOrEmpty(component.getText());
    }
    
    /**
     * Verifica se o valor digitado pelo usuário não é nulo ou vazio em uma 
     * {@code JTextArea}.
     * @param component o componente que deve ser verificado.
     * @return true se o valor não for vazio ou nulo.
     * @see Validator 'Validator' para maiores detalhes.
     */
    public static boolean hasValidEntry(JTextArea component){
        return !Validator.isNullOrEmpty(component.getText());
    }
    
    /**
     * Verifica se o valor digitado pelo usuário em um {@code JTextField} não é 
     * nulo, vazio e se é uma URL valida. Exemplos de <i>matches</i>:
     * https://www.foo.com.br -> true
     * http://www.foo.com.br  -> true
     * http://www.foo.com     -> true
     * foo.com.br             -> false
     * @param component o componente que deve ser verificado.
     * @return true se o valor não for vazio ou nulo.
     * @see Validator 'Validator' para maiores detalhes.
     */
    public static boolean hasURLEntry(JTextField component){
        return Validator.isURL(component.getText());
    }
}