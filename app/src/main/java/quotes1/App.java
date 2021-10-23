/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes1;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.*;

public class App {


    public static void main(String[] args) throws IOException {
//        Gson gson=new Gson();
//        Reader reader = Files.newBufferedReader(Paths.get("app/src/main/resources/data.json"));
//        BufferedReader readFromArray =new BufferedReader(reader);
//
//        Quotes[] convertArray = gson.fromJson(readFromArray, Quotes[].class);
//        int radnomQuote = (int)(Math.random()*(convertArray.length-1));
//        System.out.println("Name of Author: "+convertArray[radnomQuote].getAuthor());
//        System.out.println("The Quote : " + convertArray[radnomQuote].getText());
//        System.out.println("Quote number : " + radnomQuote);

        String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        sendGetRequest(url);
    }
//    public static String randomLine() throws FileNotFoundException {
////        Random rand = new Random();
//        String reseltq = "";
//        int number = (int) (Math.random() * 10);
//        Random random = new Random();
//
//        try {
//            File files = new File("app/src/main/resources/Apidata.txt");
//            int c = 0;
//            Scanner scanner = new Scanner(files);
//            while (scanner.hasNextLine()) {
//                String l = scanner.nextLine();
//                c++;
//                if (c == number) {
//                    reseltq = l;
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("error, please insert the valid files");
//        }
//        return reseltq;
//
//    }
    static void sendGetRequest(String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = setUpConnectionObject(url);
            if(connection.getResponseCode() == 200){
                BufferedReader in = getBufferedReaderFromConnection(connection);
                printBufferedReaderContect(in);
                in.close();
            }
        } catch (MalformedURLException e) {
            try {
                System.out.println(getRandomQuotes("app/src/main/resources/data.json")) ;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            try {
//                System.out.println(randomLine());
                System.out.println(getRandomQuotes("app/src/main/resources/data.json")) ;
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

//            System.out.println("Sorry, there was a problem opening the connection from the URL object, the error was:");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    static HttpURLConnection setUpConnectionObject(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        return connection;
    }

    static BufferedReader getBufferedReaderFromConnection(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);   // needs an input stream
        BufferedReader in = new BufferedReader(inputStreamReader);    // I need to provide the reader with a stream reader
        //  BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        ArrayList<Object> numList = new ArrayList<>();
//        File file = new File("app/src/main/resources/data.json");
//        FileWriter fr = new FileWriter(file, true);
//        BufferedWriter br = new BufferedWriter(fr);
//       int num= numList.size();
//
//       for (Object L:numList) {
//           br.write(numList.toString());
//       }
//        br.close();
//        fr.close();
        return in;
    }
    public static Quotes getRandomQuotes (String path) throws IOException{
        int min = 0 , max = 137;
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        List<Quotes> quote =  gson.fromJson(reader , new TypeToken<List<Quotes>>() {}.getType());
        reader.close();
        return quote.get((int) (Math.random()*(max-min+1)+min));
    }
    static void printBufferedReaderContect(BufferedReader in) throws IOException {
        Gson gson=new Gson();
//        ApiQuote convertArray = gson.fromJson(in,ApiQuote.class);
//        System.out.println("Name of Author: "+convertArray.getQuoteAuthor());
//        System.out.println("The Quote : " + convertArray.getQuoteText());
//        File file = new File("app/src/main/resources/Apidata.txt");
//        FileWriter fr = new FileWriter(file, true);
//        BufferedWriter br = new BufferedWriter(fr);
//        br.write(convertArray.toString()+"\n");
//
//        br.close();
//        fr.close();
//         Gson gson=new Gson();
//        Reader reader = Files.newBufferedReader(Paths.get("app/src/main/resources/data.json"));
//        BufferedReader readFromArray =new BufferedReader(reader);
////
//        Quotes[] convertArray = gson.fromJson(readFromArray, Quotes[].class);
//        int radnomQuote = (int)(Math.random()*(convertArray.length-1));
//        System.out.println("Name of Author: "+convertArray[radnomQuote].getAuthor());
////        System.out.println("The Quote : " + convertArray[radnomQuote].getText());
//        System.out.println("Quote number : " + radnomQuote);
        BufferedReader reader = new BufferedReader(new FileReader("app/src/main/resources/data.json"));
        List<Quotes> quotes =  gson.fromJson(reader , new TypeToken<List<Quotes>>(){}.getType());
        BufferedWriter bw = new BufferedWriter(new FileWriter("app/src/main/resources/data.json" , false));
        ApiQuote convertArray1 = gson.fromJson(in,ApiQuote.class);
        System.out.println("Name of Author: "+convertArray1.getQuoteAuthor());
        System.out.println("The Quote : " + convertArray1.getQuoteText());
        Quotes quote = new Quotes(convertArray1.getQuoteAuthor(),convertArray1.getQuoteText());
//        System.out.println(quote);
        quotes.add(quote);
        gson = gson.newBuilder().setPrettyPrinting().create();
        String newQuotes = gson.toJson(quotes);
        String apiQuote = gson.toJson(quote);
//        System.out.println(apiQuote);
//        System.out.println("From API ");
        bw.write(newQuotes);
        bw.close();
        in.close();
//        System.out.println(getRandomQuotes("app/src/main/resources/data.json")) ;    }
}}