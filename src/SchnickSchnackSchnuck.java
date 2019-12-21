import java.util.Scanner;

public class SchnickSchnackSchnuck {

    private static Spiel spiel;
    private static Scanner cons = new Scanner(System.in);

    public static void main(String[] args) {
        Bewegung schere = new Bewegung("Schere");
        Bewegung stein = new Bewegung("Stein");
        Bewegung papier = new Bewegung("Papier");

        schere.setAliases(new String[]{"schere", "sch","Sch","sc","Sc"});
        stein.setAliases(new String[]{"stein","st","St"});
        papier.setAliases(new String[]{"papier", "pap", "Pap", "P", "p"});

        schere.getSchlaegt().add(papier);
        papier.getSchlaegt().add(stein);
        stein.getSchlaegt().add(schere);

        spiel = new Spiel(new Spieler("A"), new Spieler("B"));
        spiel.setMoves(new Bewegung[]{schere,stein,papier});

        String input = "";


        requestMove(spiel.getA());
        requestMove(spiel.getB());
        Spieler winner = spiel.eval();
        if (winner != null) {
            winner.setPunkte(winner.getPunkte() + 1);
            System.out.println(winner.getName() + " gewinnt! Er hat nun " + winner.getPunkte() + " Punkt/e.");
        } else {
            System.out.println("Es ist eine Krawatte! Tja.");
        }



    }

    private static void requestMove(Spieler spieler) {
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
