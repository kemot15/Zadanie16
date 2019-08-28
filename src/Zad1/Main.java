package Zad1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String path = "stats.csv";
        try {
            List<Player> players = getPlayers();
            players.sort(new ResultComparator());
            savePlayers(players, path);
            System.out.println("Dane posortowano i zapisano do pliku " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (IndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Dane zawodnika sa niepoprawne");
        }
    }

    private static List<Player> getPlayers (){
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList();
        String line = "";
        while (!line.toUpperCase().contains("STOP")){
            System.out.println("Podaj wyniki kolejnego gracza (lub stop):");
            line = scanner.nextLine();
            if(!line.toUpperCase().contains("STOP")){
                String[] split = line.split(" ");
                players.add(new Player(split[0], split[1], Integer.valueOf(split[2])));
            }
        }
        scanner.close();
        return players;
    }

    private static void showPlayers (List<Player> players){
        for (Player player : players){
            System.out.println("Zawodnik: " + player.getFirstName() + " " + player.getLastName() + " ma punktow: " + player.getPoints());
        }
    }

    private static void savePlayers (List<Player> players, String path) throws IOException {
        FileWriter fr = new FileWriter(new File(path));
        BufferedWriter br = new BufferedWriter(fr);
        for (Player player : players){
            br.write(player.getFirstName() + " " + player.getLastName() + ";" + player.getPoints() + "\n");
        }
        br.close();
        System.out.println();
    }
}
