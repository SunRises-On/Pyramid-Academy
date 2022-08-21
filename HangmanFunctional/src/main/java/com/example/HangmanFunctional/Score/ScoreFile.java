package com.example.HangmanFunctional.Score;

import com.example.HangmanFunctional.Hangman.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
                save = setNewRank( userScore, userName, save, userRank);
            }
            //put save into new hashmap of score and rank
            // Create simple TreeMap of <rank, score> 
            Iterator<Integer> keyIterator = save.keySet().iterator();

            Map<Integer, Integer> smallSave =
                    save.values().stream().flatMap(
                            c->c.stream().map(d-> d.getScore()))
                            .collect(Collectors.toMap(k->keyIterator.next(),
                                    Function.identity(),
                                    (l,r) -> l , TreeMap::new));



            //if not empty add too it
         /*   List<GameSave> newSave = save.values().stream()/* List<GameSave>> */
                //    .flatMap( c -> c.stream()
              //              .filter( GameSave -> GameSave.getScore() == userScore)
            //        ).collect(Collectors.toList());
            //get higher rank,  userScore > oldScore,
          //  int higherRank = save.values().stream()
        //            .flatMap( c -> c.stream()


      //              ); */
            //
            //Get lower rank


        return -1;
    }

    private Map<Integer, List<GameSave>> setNewRank (int score, String name, Map< Integer,List<GameSave> > save , int rank){

        GameSave gameSave = new GameSave(score, name);
        List<GameSave> list = new ArrayList<>();
        list.add(gameSave);
        save.put(rank, list);

        return save;
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
