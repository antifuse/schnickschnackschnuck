import java.util.Random;
import java.util.Scanner;

public class SchnickSchnackSchnuck {

    public static void main(String[] args) {
        Scanner cons = new Scanner(System.in);
        Random randomizer = new Random();
        Bewegung schere = new Bewegung("Schere");
        Bewegung stein = new Bewegung("Stein");
        Bewegung papier = new Bewegung("Papier");
        Bewegung nils = new Bewegung("Nils");

        schere.setAliases(new String[]{"schere", "sch","Sch","sc","Sc","scissors","Scissors"});
        stein.setAliases(new String[]{"stein","st","St","rock","Rock","r","R"});
        papier.setAliases(new String[]{"papier", "pap", "Pap", "P", "p","paper","Paper"});
        nils.setAliases(new String[]{"nils","ni","Ni","n","N","Nils312"});

        schere.getSchlaegt().add(papier);
        schere.getSchlaegt().add(nils);
        papier.getSchlaegt().add(stein);
        papier.getSchlaegt().add(nils);
        stein.getSchlaegt().add(schere);
        stein.getSchlaegt().add(nils);

        Spiel spiel = new Spiel(new Spieler("Spieler"), new Spieler("Computer"));
        Bewegung[] moves = new Bewegung[]{schere,stein,papier,nils};
        spiel.setMoves(moves);

        for (;;) {
            requestMove(spiel.getA(), spiel);
            Bewegung computermove = moves[randomizer.nextInt(4)];
            spiel.getB().spielen(computermove);
            System.out.println(spiel.getA().getName() + " spielt " + spiel.getA().getAktuelle().getName() + ", " + spiel.getB().getName() + " spielt " + spiel.getB().getAktuelle());
            Spieler winner = spiel.winner();
            if (winner != null) {
                winner.setPunkte(winner.getPunkte() + 1);
                System.out.println(winner.getName() + " gewinnt! Er hat nun " + winner.getPunkte() + " Punkt/e.");
                if (spiel.loser().getAktuelle().equals(nils)) System.out.println("Nils wurde soeben mit " + (spiel.winner().getAktuelle().equals(schere) ? "einer " : "einem ") + spiel.winner().getAktuelle().getName() + " geschlagen!");
            } else {
                System.out.println("Es ist eine Krawatte! Tja.");
            }
        }





    }

    private static void requestMove(Spieler spieler, Spiel spiel) {
        Scanner cons = new Scanner(System.in);
        String input;
        do {
            System.out.println(spieler.getName() + ", gib deine Bewegung ein. Möglich sind: " + spiel.getMoves().toString());
            input = cons.nextLine();
            if (input.equals("exit") || input.equals("Exit")) System.exit(0);
        } while (!spiel.isValidMove(input));

        try {
            spieler.spielen(input);
        } catch (InvalidMoveException e) {
            System.exit(-1);
        }
    }
}
