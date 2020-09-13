package lab1;

import common.FileManager;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    @Test
    public void fileTest() throws IOException {
        File inputFile = FileManager.getFileByPath("src/test/resources/lab1/input.txt");
        File outputFile = FileManager.create("src/test/resources/lab1/output.txt");
        try (
                FileReader fileReader = new FileReader(inputFile);
                FileWriter writer = new FileWriter(outputFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String stringLine;
            while ((stringLine = bufferedReader.readLine()) != null) {
                String[] arrayOfString = stringLine.split(" : ");
                String[] triangleValues = arrayOfString[0].split("\\s+");
                String expected = arrayOfString[1];
                String checkSymbol = expected.equals(Triangle.checkTriangle(triangleValues)) ? "✔" : "❌";
                writer.write(checkSymbol + "\n");
            }
        }
    }

    @Test
    public void testEquilateralTriangle() {
        String[] array = new String[3];
        array[0] = "2";
        array[1] = "2";
        array[2] = "2";
        assertEquals("Равносторонний", Triangle.checkTriangle(array));
    }

    @Test
    public void testIsoscelesTriangle() {
        String[] array = new String[3];
        array[0] = "3";
        array[1] = "2";
        array[2] = "2";
        assertEquals("Равнобедренный", Triangle.checkTriangle(array));
    }

    @Test
    public void testUsualTriangle() {
        String[] array = new String[3];
        array[0] = "4";
        array[1] = "3";
        array[2] = "2";
        assertEquals("Обычный", Triangle.checkTriangle(array));
    }

    @Test
    public void testExceptionTriangle() {
        String[] array = new String[3];
        array[0] = "";
        array[1] = "2";
        array[2] = "1";
        assertEquals("Ошибка", Triangle.checkTriangle(array));
    }
}
