package ithaca.edu.footballTeam.footballApp;

import java.io.*;


public class ReadingAndWritingIO {


    /**
     * Elvis Okumu
     * Comp311000 sp19
     * This IO file that contains all the methods to make reading to and writing from a file or the console easier
     */


        public static void readLineByLine(BufferedReader br) throws IOException {
            int count = 1;
            String line = br.readLine();
            while (line != null){
                line = br.readLine();

            }
        }

        public static   void readFromFile(String fileName) throws IOException{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            readLineByLine(br);
            br.close();
        }

        public static void readFromConsole(String fileName) throws IOException{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            readLineByLine(br);

        }

        public static void writeLineByLine(PrintStream ps, String input) throws Exception{
            ps.println(input);
        }

        public static void writeToFile(String fileName, String input) throws Exception{
            PrintStream ps = new PrintStream(new FileOutputStream(fileName));
            writeLineByLine(ps, input);
            ps.close();
        }

        public static void writeToConsole(String input) throws Exception{
            writeLineByLine(System.out, input);

        }


}
