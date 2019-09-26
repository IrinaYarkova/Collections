package com.company;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String file = "src\\com\\company\\text";
        List collection = readFile(file);
        Map.Entry<String, Integer> maxEntry = null;

        //Сортировка
        java.util.Collections.sort(collection);

        Map<String, Integer> map = statistics(collection);

        System.out.println("Отсортированные по алфавиту слова:\n" + sortList(collection) + "\n");
        System.out.println("Статистика повторений слов:\n" + map + "\n");



        //нахождение слова с наибольшим повторением, не смогла сделать в отдельном методе, я его закоментила
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }

        System.out.println("Слово с наибольшим количеством повторений - " + maxEntry.getKey() + ", повторяется " + maxEntry.getValue() + " раза");
    }

    public static List readFile(String filePath) throws IOException {
        List list = new ArrayList();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()){
            String word = scanner.useDelimiter("\\s+").next();
            list.add(word);
        }
        return list;
    }

    public static HashMap statistics (List list){
        Map<String, Integer> statistic = new HashMap<>();
        for(int i=0; i<list.size(); i++) {
            Integer count = statistic.get(list.get(i));
            if(count == null) {
                count = 0;
            }
            statistic.put((String) list.get(i), ++count);
        }
        return (HashMap) statistic;
    }

    public static List sortList(List list){
        java.util.Collections.sort(list);
        return list;
    }

    /*public static void maxCountWord (HashMap map){
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
         System.out.println("Слово с наибольшим количеством повторений - " + maxEntry.getKey() + ", повторяется " + maxEntry.getValue() + " раза");
    }*/

}
