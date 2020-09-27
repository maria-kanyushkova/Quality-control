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

public class BrokenLinkTest {
    Map<Integer, List<String>> codes = null;
    Integer countOfValidLinks = 0;
    Integer countOfInvalidLinks = 0;

    public void writeToFile() throws IOException {
        File validFile = FileManager.create("src/test/resources/lab2/valid_links.txt");
        File invalidFile = FileManager.create("src/test/resources/lab2/invalid_links.txt");
        try (
                FileWriter validWriter = new FileWriter(validFile);
                FileWriter invalidWriter = new FileWriter(invalidFile);
        ) {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = dateFormat.format(date);
            for (Map.Entry<Integer, List<String>> code : codes.entrySet()) {
                System.out.println(code);
                if (code.getKey() == 200) {
                    for (String link : code.getValue()) {
                        validWriter.write("code: 200 -- " + link + "\n");
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

    public void insertNewLinks(Map<Integer, List<String>> newLinks) {
        for (Map.Entry<Integer, List<String>> links : newLinks.entrySet()) {
            Integer code = links.getKey();
            List<String> codeLinks = links.getValue();
            if (codes.containsKey(code)) {
                codeLinks = new ArrayList<String>() {
                    {
                        addAll(codes.get(code));
                        addAll(links.getValue());
                    }
                }.stream()
                        .distinct()
                        .collect(Collectors.toList());
            }
            codes.put(code, codeLinks);
        }
    }

    @Test
    public void fileTest() throws IOException {
        codes = BrokenLink.getLinkAndCodes("http://91.210.252.240/broken-links");
        insertNewLinks(BrokenLink.getLinkAndCodes("http://91.210.252.240/broken-links/about.html"));
        insertNewLinks(BrokenLink.getLinkAndCodes("http://91.210.252.240/broken-links/work.html"));
        insertNewLinks(BrokenLink.getLinkAndCodes("http://91.210.252.240/broken-links/pricing.html"));
        insertNewLinks(BrokenLink.getLinkAndCodes("http://91.210.252.240/broken-links/blog.html"));
        insertNewLinks(BrokenLink.getLinkAndCodes("http://91.210.252.240/broken-links/contact.html"));
        writeToFile();
    }
}
