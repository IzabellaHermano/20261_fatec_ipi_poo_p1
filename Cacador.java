import java.util.ArrayList;
import java.util.Random;

public class Cacador extends PersonagemV2{

    public Cacador (String nome) {
       
        System.out.println("Construindo primeiro personagem... ");
        
        this.nome = nome;
        energia = 10;
        fome = 0;
        sono = 0;
        mochila = new ArrayList<>();
        repertorio = new ArrayList<>();

    }

    @Override
    public void realizarAcaoAleatorio() {
        var gerador = new Random();
        var oQueFazer = gerador.nextInt(1, 5);

        switch (oQueFazer) {
            case 1:
                cacar();
                break;
            case 2:
                comer();
                break;
            case 3:
                dormir();
                break;
            }   
    }

}
