import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Dictionary {

    private ArrayList<String> dictionary = new ArrayList<>();

    public Dictionary() throws FileNotFoundException {
        try(BufferedReader br = new BufferedReader(new FileReader("Dictionary.txt"))) {
            String line;
            while ((line = br.readLine()) != null){
                dictionary.add(line);
            }
            }catch(IOException ioException) {
            System.out.println("Input, output error. ");
        }
    }

    public ArrayList<String> returnFamiliarWords(String s) {
        ArrayList<String> ret = new ArrayList<>();
        for (String word : dictionary){
            if(likenesValue(s,word)  > s.length()/2){
                ret.add(word);
            }
        }
        return ret;
    }

    private int likenesValue(String mainS, String secondS) {
        int likenes = 0;
        for (int i = 0; i < mainS.toCharArray().length; i++) {
            if (secondS.charAt(i) == (char) 0) {
                return likenes;
            } else {
                if (mainS.charAt(i) == secondS.charAt(i)) {
                    likenes++;
                }
            }
        }
        return likenes;
    }
}