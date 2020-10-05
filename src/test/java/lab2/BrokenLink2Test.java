package lab2;

import common.FileManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class BrokenLink2Test {
    String startLink = "http://91.210.252.240/broken-links";
    Map<Integer, List<String>> codes = null;
    List<String> links = new ArrayList<>();
    Integer countOfValidLinks = 0;
    Integer countOfInvalidLinks = 0;

    public void writeToFile() throws IOException {
        File validFile = FileManager.create("src/test/resources/lab2/valid_links2.txt");
        File invalidFile = FileManager.create("src/test/resources/lab2/invalid_links2.txt");
        try (
                FileWriter validWriter = new FileWriter(validFile);
                FileWriter invalidWriter = new FileWriter(invalidFile);
        ) {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = dateFormat.format(date);
            for (Map.Entry<Integer, List<String>> code : codes.entrySet()) {
                System.out.println(code);
                if (code.getKey() >= 200 && code.getKey() < 300) {
                    for (String link : code.getValue()) {
                        validWriter.write("code: " + code.getKey() + " -- " + link + "\n");
                        countOfValidLinks++;
                    }
                } else {
                    for (String link : code.getValue()) {
                        invalidWriter.write("code: " + code.getKey() + " -- " + link + "\n");
                        countOfInvalidLinks++;
                    }
                }
            }

            validWriter.write("count of links: " + countOfValidLinks + "\n");
            validWriter.write(strDate);

            invalidWriter.write("count of links: " + countOfInvalidLinks + "\n");
            invalidWriter.write(strDate);
        }
    }


    public void insertNewLinks(List<String> newLinks) {
        links = new ArrayList<String>() {
            {
                addAll(newLinks);
                addAll(links);
            }
        }.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    @Test
    public void test() throws IOException {
        links.add(startLink);
        int countOfLinksStart = 0;
        int countOfLinksEnd = links.size();
        while (countOfLinksStart != countOfLinksEnd) {
            countOfLinksStart = links.size();

            for (String link : links) {
                if (BrokenLink2.getResponseCode(link) == 200 && link.contains(startLink)) {
                    insertNewLinks(BrokenLink2.readLink(startLink, link));
                }
            }

            countOfLinksEnd = links.size();
        }

        codes = links
                .stream()
                .distinct()
                .collect(Collectors.groupingBy(BrokenLink::getResponseCode));

        writeToFile();
    }
}
