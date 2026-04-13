
import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception{
        var gerador = new Random();
        
        var personagem01 = new Personagem("Tica");

        ArrayList<Musica> musicas= new ArrayList<>();

         //lista de musicas
        musicas.add(new Musica("Bad romance"));
        musicas.add(new Musica("Hello"));
        musicas.add(new Musica("God is a woman"));
        musicas.add(new Musica("Confident"));
        musicas.add(new Musica("StarBoy"));
        musicas.add(new Musica("Cool for the summer"));
        musicas.add(new Musica("Abracadabra"));
        musicas.add(new Musica("Bring me to life"));
        musicas.add(new Musica("i whish you roses"));
        musicas.add(new Musica("Exagerado"));
        musicas.add(new Musica("Back in black"));

        do{ 
            var oQueFazer = gerador.nextInt(1,4);

                switch (oQueFazer) {
                case 1:
                    personagem01.cacar();
                    break;
                case 2:
                    personagem01.comer();
                    break;
                case 3:
                    personagem01.dormir();        
                    break;
                }

            personagem01.aprenderMusica(musicas);
            System.out.println(personagem01);
            Thread.sleep(5000);
            System.out.println("*******************************");


        }while(!personagem01.estaMorto());
        
        System.out.println("Game Over!!!");
    }
}
