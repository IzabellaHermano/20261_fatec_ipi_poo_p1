
import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception{
        var gerador = new Random();
        
        var personagem01 = new Personagem("Tica");

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

            System.out.println(personagem01);
            Thread.sleep(5000);
            System.out.println("*******************************");


        }while(!personagem01.estaMorto());
        
        System.out.println("Game Over!!!");
    }
}
