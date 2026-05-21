import java.util.ArrayList;

public abstract class PersonagemV2 {

    private int energia; 
    private int fome; 
    private int sono;
    private ArrayList<String> mochila; 
    private ArrayList<Musica> repertorio;

    public abstract void cacar();
    public abstract void comer();
    public abstract void dormir();
    public abstract void mochila();
    public abstract boolean estaMorto();
    public abstract void aprenderMusica();
}
