package arquivo;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class Arquivo {

    public List<String> carregaDoArquivo(String pathArquivo){
        List<String> listaPalavras = new ArrayList<String>();
        File file = new File(pathArquivo);
        
        try(Scanner scan = new Scanner(file)){
            while(scan.hasNextLine()){
                listaPalavras.add(scan.nextLine());
            }
        }catch(FileNotFoundException e1){
            System.out.println("Arquivo não encontrado!!");
        }catch(Exception e2){
            e2.printStackTrace();
        }

        return listaPalavras;
    } 
    
}
