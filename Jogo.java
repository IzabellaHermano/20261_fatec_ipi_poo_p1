
import java.util.ArrayList;
import java.util.Random;

public class Jogo {

    public static void main(String[] args) throws Exception {
        var gerador = new Random();

        var personagem01 = new Personagem("Tica");
        var personagem02 = new Personagem("Tico Trovador", 3, 8, 8);
        personagem02.addMusicaAutoral(new Musica("Thriller do Trovador"));

        ArrayList<Musica> musicas = new ArrayList<>();

        //lista de musicas
        musicas.add(new Musica("Bad romance"));
        musicas.add(new Musica("Hello"));
        musicas.add(new Musica("God is a woman"));
        musicas.add(new Musica("Confident"));
        musicas.add(new Musica("StarBoy"));
        musicas.add(new Musica("Cool for the summer"));
        musicas.add(new Musica("Abracadabra"));
        musicas.add(new Musica("Bring me to life"));
        musicas.add(new Musica("I whish you roses"));
        musicas.add(new Musica("Exagerado"));
        musicas.add(new Musica("Back in black"));

        do {
            if (!personagem01.estaMorto()) {
                var oQueFazer = gerador.nextInt(1, 4);

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
            }
            System.out.println(personagem01);
            System.out.println("*******************************");

            if (!personagem02.estaMorto()) {
                var oQueFazer = gerador.nextInt(1, 11);
                switch (oQueFazer) {
                    case 1, 2:
                        personagem02.cacar();
                        personagem02.aprenderMusica(musicas);
                        break;
                    case 3, 4:
                        personagem02.comer();
                        personagem02.aprenderMusica(musicas);
                        break;
                    case 5, 6, 7, 8, 9, 10:
                        personagem02.dormir();
                        personagem02.aprenderMusica(musicas);
                        break;

                }
            }
            System.out.println(personagem02);
            Thread.sleep(5000);
            System.out.println("*******************************");

        } while (!personagem01.estaMorto() || !personagem02.estaMorto());

        System.out.println("Game Over!!!");
    }
}
