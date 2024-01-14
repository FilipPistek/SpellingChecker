import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Dictionary {

    private ArrayList<String> dictionary = new ArrayList<>();
    private boolean areSame = false;

    // Drains data from text file Dictionary.txt
    public Dictionary() throws FileNotFoundException {
        try(BufferedReader br = new BufferedReader(new FileReader("Dictionary.txt"))) {
            String line;
            while ((line = br.readLine()) != null){
                dictionary.add(line);
            }
            }catch(IOException exception) {
            System.out.println("Input, output error. ");
        }
    }
    // This method returns words with same characters.
    public ArrayList<String> returnFamiliarWords(String s) {
        ArrayList<String> ret = new ArrayList<>();
        if(areSame){
            areSame = false;
        }
        for (String word : dictionary){
            if(likenessValue(s,word)  > s.length()/2){
                ret.add(word);
            }
        }
        return ret;
    }

    // This method determines the value of similarity.
    private int likenessValue(String mainS, String secondS) {
        int likeness = 0;
        if(Objects.equals(mainS,secondS)){
            areSame = true;
            return mainS.length();

        }
        if(secondS.length() > mainS.length()){
            String temp = secondS;
            secondS = mainS;
            mainS = temp; //swap
        }

        try {
            for (int i = 0; i < mainS.toCharArray().length; i++) {
                if (secondS.charAt(i) == 0) {
                    return likeness;
                } else {
                    if (mainS.charAt(i) == secondS.charAt(i)) {
                        likeness++;
                    }
                }
            }
        }catch (Exception e){
            areSame = true;
    }
        return likeness;
    }
}