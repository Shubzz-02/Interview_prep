package com.company.etc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InfyCupCricketSelection {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfPlayers = scan.nextInt();

        List<Player> playersList = new ArrayList<>();
        for (int i = 1; i <= noOfPlayers; i++) {
            Player player = new Player(scan.next(), scan.nextDouble(), scan.next());
            playersList.add(player);
        }

        Map<Integer, Player> finalSetOfPlayers = new HashMap<>();
        finalSetOfPlayers = Player.selectionProcess(playersList, noOfPlayers);
        System.out.println(finalSetOfPlayers);
        scan.close();

    }

}

class Player implements Comparable<Player> {
    private String playerName;
    private Double avarage;
    private String playerDOB;

    public Player(String playerName, Double avarage, String playerDOB) {
        super();
        this.playerName = playerName;
        this.avarage = avarage;
        this.playerDOB = playerDOB;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Double getAvarage() {
        return avarage;
    }

    public void setAvarage(Double avarage) {
        this.avarage = avarage;
    }

    public String getPlayerDOB() {
        return playerDOB;
    }

    public void setPlayerDOB(String playerDOB) {
        this.playerDOB = playerDOB;
    }


    @Override
    public String toString() {
        return this.playerName + "";
    }


    public static Map<Integer, Player> selectionProcess(List<Player> playerList, int noOfPlayers) {
        //Write your logic as per the instructions
        Set<Player> playerSet = new TreeSet<>(playerList);
        Map<Integer, Player> map = new HashMap<>();
        int i = 1;
        for (Player p : playerSet)
            map.put(i++, p);
        return map;

    }

    @Override
    public int compareTo(Player o) {
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(o.getPlayerDOB());
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(this.getPlayerDOB());
            if (o.getAvarage().compareTo(this.getAvarage()) == 0)
                if (date1.compareTo(date2) == 0)
                    return (-1)*o.getPlayerName().compareTo(this.getPlayerName());
                else
                    return (-1)*date1.compareTo(date2);
            else
                return o.getAvarage().compareTo(this.getAvarage());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
