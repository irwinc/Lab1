package edu.wit.comp2071.irwinc.adt1;

import java.io.*;

/**
 * Created by irwinc on 5/25/16.
 */
public class Main extends LinkedBag1
{
    public static void main(String[] args)
    {
        LinkedBag1 <String> bag = new LinkedBag1<>();
        String fileName = "/Users/irwinc/IdeaProjects/Lab1/src/edu/wit/comp2071/irwinc/adt1/test";

        //Will read file one line at a time
        String line;

        try
        {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null)
            {
                String[] word = line.split(" ");
                //System.out.println(line);
                for (int i = 0; i < word.length; i ++)
                {
                    System.out.println(word[i]);
                    //Insert code to check against dictionary
                    //put dictionary in the fucking bag
                }

            }


            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        }
        catch(IOException ex)
        {
            System.out.println(
                    "Error reading file '" + fileName + "'");

        }

    }
}
