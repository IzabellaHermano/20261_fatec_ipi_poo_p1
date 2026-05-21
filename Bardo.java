import java.util.ArrayList;
import java.util.Random;

public class Bardo  extends PersonagemV2{
    
    public Bardo (String nome,int energia, int fome, int sono) {
        
        System.out.println("Construindo segundo personagem... ");
        this.nome = nome;
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
        mochila = new ArrayList<>(); 
        repertorio = new ArrayList<>(); 

    } 

    void addMusicaAutoral(Musica musica) {
        repertorio.add(musica);
    }

    @Override
    public void realizarAcaoAleatorio() {
        var gerador = new Random();
        var oQueFazer = gerador.nextInt(1, 11);
                switch (oQueFazer) {
                    case 1, 2:
                        cacar();
                        aprenderMusica(musicas);
                        break;
                    case 3, 4:
                        comer();
                        aprenderMusica(musicas);
                        break;
                    case 5, 6, 7, 8, 9, 10:
                        dormir();
                        aprenderMusica(musicas);
                        break;

                }
    }
    
}
