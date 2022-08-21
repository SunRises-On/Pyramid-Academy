package com.example.HangmanFunctional.Score;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ScoreFile {
    private static final String filePath= "src/main/resources/Leaderboard.txt" ;

    private Scanner scanner;

    protected int getRank (int userScore, String userName) throws NumberFormatException{

            //Key = Rank,  Value = Player which has score and name
            Map<Integer, List<GameSave>> save = new TreeMap<>();
            int userRank = 0;
            save = readFile(save);

            if(save.isEmpty()){

                userRank = 1;
                GameSave gameSave = new GameSave(userScore, userName);

                List<GameSave> newList = new ArrayList<>();
                newList.add(gameSave);

                save.put( userRank, newList );
            }


              
            //search gameSave for our score
            //if found get

        return -1;
    }

    private  Map<Integer, List<GameSave>> readFile ( Map<Integer, List<GameSave>> save  ) throws NumberFormatException{
        try{

            File text = new File(filePath);
            Scanner scanner = new Scanner(text);

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();

                if(line.isEmpty()){
                    break;
                }
                //Line is ordered by String, rank name score
                String[] array = line.split(" "); /*split by space */

                int currRank = Integer.parseInt(array[0]);
                String currName = array[1];
                int currScore = Integer.parseInt(array[2]);

                GameSave gameSave = new GameSave(currScore, currName);

                if( !save.containsKey(currRank)){
                    List<GameSave> newList = new ArrayList<>();
                    newList.add(gameSave);
                    save.put( currRank, newList );
                }else{
                    save.get(currRank).add(gameSave);
                }

            }
            scanner.close();
        }catch( FileNotFoundException e){
            System.out.println("Leaderboard.txt not found");
        }
        return save;
    }
}
