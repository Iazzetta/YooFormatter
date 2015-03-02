package yoo.core.util;

import java.util.Date;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;

public class Save {
    
    /** Diretório onde será salvo o arquivo gerado pelo método {@code toFile}. */
    private final String path;

    /** Ver o método {@code instance}. */
    private Save(){
        String sys = System.getProperty("os.name").toLowerCase(),
               userHome = System.getProperty("user.home");
        path = sys.startsWith("win") ? userHome + "\\Desktop" : userHome;
    }
    
    /** 
     * Obtém uma instancia do objeto {@code Save}. No construtor da classe é feita
     * uma verificação para definir em qual diretório o arquivo gerado pelo método
     * {@code toFile} será criado. Se estiver em plataforma Windows o arquivo será
     * escrito e salvo na área de trabalho, caso contrário será salvo na <i>home</i>
     * do usuário.
     * @return uma instancia do objeto {@code Save} */
    public static Save instance() {
        return SaveHolder.INSTANCE;
    }

    /**
     * Gera um nome para o arquivo. O arquivo será nomeado seguindo o padrão:
     * [nome da aplicação][dia-mês-ano][hora minutos segundos] para evitar possíveis
     * problemas de duplicadas.
     * @return uma <i>string</i> formatada com modelo semelhante à 'Foo[01-03-2015][18 33 45]
     */
    private synchronized String createFileName(){
        return new SimpleDateFormat("[dd-MM-yyyy][hh mm ss]").format(new Date()) + ".txt";
    }
    
    /**
     * Persiste o texto em um arquivo. O nome do arquivo é gerado pelo método 
     * {@code createFileName}, sua extensão sempre será ".txt". Para evitar problemas
     * de <i>encoding</i> sempre será usado UTF-8.
     * 
     * @param content é a <i>string</i> que será escrita no arquivo.
     * @throws IOException se não for possível criar o arquivo e/ou se não for
     * possível escrevê-lo.
     * 
     * @see File 'File' - para maiores informações sobre a criação do arquivo.
     * @see FileUtils 'FileUtils' - para ver os detalhes de escrita no arquivo.
     */
    public void toFile(String content) throws IOException {
        FileUtils.write(new File(path, createFileName()), content, "UTF8");
    }
    
    /**
     * Insere o texto no clipboard. Esse método pode ser usado como <i>failback</i>
     * caso seja lançada uma {@code IOException} no método {@code toFile}, e.g
     * se não for possível persistir os dados em um arquivo de texto o usuário pelo
     * menos terá ele no <i>clipboard</i> para colar na {@code <textarea>} do fórum.
     * @param content é a <i>string</i> que será enviada para o clipboard
     * do usuário.
     */
    public void toClipboard(String content){
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
            new StringSelection(content),
            null
        );
    }
    
    private static class SaveHolder {
        private static final Save INSTANCE = new Save();
    }
}