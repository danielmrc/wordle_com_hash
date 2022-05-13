package hash;

public class Hash {

    private Elemento[] palavras;

    /**
     * Este metodo inicializa a tabela hash vazia com o tamanho
     * recebido por parametro
     * @param tamanho
     */    
    public Hash(int tamanho){
        this.palavras = new Elemento[tamanho];
        for(int i = 0; i < tamanho; i++){
            palavras[i] = new Elemento();
        }
    }

    /**
     * Este metodo gera o código hash a ser mapeado
     * com base na soma do hashcode da primeira e ultima
     * letra da palavra
     * @param palavra
     * @return o código
     */
    public int codigo(String palavra){
        int cod;

        String ultimaLetra = palavra.substring(4);
        String primeiraLetra = palavra.substring(0, 1);

        cod = (ultimaLetra.hashCode()*3) + (primeiraLetra.hashCode()*2);

        return cod;
    }

    /**
     * Este metodo gera o mapeamento da posicao na tabela hash
     * baseado no retorno da funcao de codigo
     * @param palavra
     * @return a posicao do mapeamento na tabela hash
     */
    public int mapeamento(String palavra){
        return codigo(palavra) % palavras.length;
    }

    /**
     * Metodo realiza a insercao de uma palavra na tabela hash
     * baseado na posicao retornada pelo mapeamento
     * @param palavra
     */
    public void inserir(String palavra){
        if(palavra.length() == 5){
            int pos = mapeamento(palavra);
            for(int i = pos; i < palavras.length; i++){
                if(palavras[i].getValue() == null || !palavras[pos].getExiste()){
                    palavras[i].setValue(palavra);
                    palavras[i].setExiste(true);
                    break;
                }
            }
        }
    }

    /**
     * Metodo realiza a retirada de uma palavra da tabela hash 
     * baseada na posicao retornada pela funcao de mapeamento
     * @param palavra
     * @return a palavra recebida por parametro ou null caso 
     * não a encontre
     */
    public String retirar(String palavra){
        int pos = mapeamento(palavra);

        for(int i = pos; i < palavras.length; i++){
            if(palavras[i].getValue() == null || !palavras[pos].getExiste())
                break;              
            if(palavras[i].getValue().equals(palavra)){
                palavras[i].setExiste(false);
                return palavras[i].getValue();
            }
        }
        return null;
    }
    
    /**
     * Este metodo recebe uma posicao inteira como parametro e retorna
     * a palavra nessa posicao na tabela. Se a posicao nao contiver uma 
     * palavra, deve retornar uma palavra da posicao mais proxima 
     * @param posicao numero inteiro representando a posicao da tabela
     * @return uma palavra constante da tabela
     */
    public String sortearPalavra(int posicao){
        for(int i = posicao; i < palavras.length; i++){
            if(palavras[i].getValue() != null && palavras[posicao].getExiste())
                return palavras[i].getValue();          
        }
        return null;    
    }

    /**
     * Este metodo recebe uma string contendo uma palavra. Ele deve buscar
     * esta palavra na tabela, retornando TRUE se a palavra existe ou FALSE 
     * se ela nao existir 
     * @param palavra a palavra a ser procurada na tabela
     * @return TRUE/FALSE conforme a existencia da palavra na tabela
     */
    public boolean existePalavra(String palavra){
        int pos = mapeamento(palavra);

        for(int i = pos; i < palavras.length; i++){
            if(palavras[i].getValue() == null || !palavras[pos].getExiste())
                break;            
            if(palavras[i].getValue().equals(palavra)){
                return true;
            }
        }
        return false;
    }
}
