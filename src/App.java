import arquivo.Arquivo;
import hash.Hash;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    private static Arquivo arquivo = new Arquivo();
    private static Hash hash;
    private static List<String> palavrasArquivo = new ArrayList<String>();

    private static Scanner scan = new Scanner(System.in);

    /**
     * Metodo main, utilizei apenas para testes de funcionamento
     * (inclusive pesso perdao pela falta de organizacao nele, falta de tempo é a causa)
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Aguarde... o arquivo de palavras está sendo carregado para a tabela hash!");
        init();
        System.out.println("Pronto!!");

        System.out.println("Informe a palavra que deseja buscar: ");
        String entrada = scan.nextLine();
        String palavra = buscaPalavra(entrada);
        if(palavra == null)
            System.out.println("Palavra inexistente!!");
            else
                System.out.println("Palavra buscada: " + palavra);

        System.out.println("Informe uma posicao a ser buscada: ");
        int posicao = Integer.parseInt(scan.nextLine());
        System.out.println("Palavra sorteada: " + hash.sortearPalavra(posicao));
        
        System.out.println("Informe palavra que deseja verificar existencia: ");
        String palavraExiste = scan.nextLine();
        if(hash.existePalavra(palavraExiste))
            System.out.println("Existe!");
            else
                System.out.println("Não Existe!!");;
    }

    /**
     * Metodo para o carregamento do arquivo de palavras em memória
     * e a inicializacao da tabela hash
     */
    public static void init(){
        palavrasArquivo = arquivo.carregaDoArquivo("palavras.txt");

        hash = new Hash(palavrasArquivo.size()/ 3);

        palavrasArquivo.forEach(palavra -> {
            hash.inserir(palavra);
        });
    }
    /**
     * Metodo para chamada da funcao de retirada no hash
     * @param palavra
     * @return palavra retornada pelo metodo de retirada do hash
     */
    public static String buscaPalavra(String palavra){
        return hash.retirar(palavra);
    }

}
