import com.sun.deploy.util.JVMParameters;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.TreeSet;

public class WordSorter {

    TreeSet<String> wordsSet = new TreeSet<>();

    public void start(String pathIn, String pathOut) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                wordsSet.addAll(Arrays.asList(line.toLowerCase().split(",|\\s|\\?|!|\\.")));
                wordsSet.remove("");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            ;
        } catch (IOException e) {
            System.out.println(e);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))) {
            String line = "";
            for (String word : wordsSet) {
                bw.append(word + "\n");
                bw.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Success!");
    }
}
