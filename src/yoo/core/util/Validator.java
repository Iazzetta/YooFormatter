package yoo.core.util;

public class Validator {
    
    /**
     * Verifica se a <i>string</i> é uma URL válida. Método usado para validação
     * dos {@code JTextField} onde o usuário pode inserir qualquer cadeia de caracteres
     * para uma URL de uma imagem, scan, download, etc. Esta validação é necessária para
     * evitar construir um <i>output</i> (o tópico) correto e evitar que as tags de âncora
     * não recebam valores que não apotem para um <i>link</i>.
     * @param str é a <i>string</i> a ser validada.
     * @return true se o valor for uma URL.
     */
    public static boolean isURL(String str){
        return str.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
    }
    
    /**
     * Verifica se a <i>string</i> não é nula ou vazia. Método usado para validação
     * geral do conteúdo inserido pelo usuário em componentes {@code JTextField} e/ou
     * {@code JTextArea} na <i>view</i>. Esta validação é necessária para evitar que o
     * usuário deixe de inserir informações em componentes obrigatórios.
     * @param str é a <i>string</i> a ser verificada.
     * @return true se valor não <code>null</code> ou vazia.
     */
    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    } 
}