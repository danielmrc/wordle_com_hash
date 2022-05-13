package hash;

public class Elemento {
    private String value;
    private boolean existe;

    public Elemento(){
        this.value = null;
        this.existe = false;
    }

    public String getValue(){
        return this.value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public boolean getExiste(){
        return this.existe;
    }

    public void setExiste(boolean existe){
        this.existe = existe;
    }
    
}
