import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Exponent {

        public static void main(String[] args) {
            String inputFilename = "input.txt";
            String outputFileName = "output.txt";
            int[] ab = readFromFile(inputFilename);
            String answer =  exp(ab);
            writeToFile(outputFileName, answer);
            System.out.println("Выполнено!");
        }

        static String exp(int[] ab)    // Метод возвращает результат возведения "a" в степень "b"
        {
            int a = ab[0];
            if(ab[1] == 0 && ab[0] == 0)
            {
                return "Не определено!";
            }
            else if (ab[0] != 0 && ab[1] == 0)
            {
                return "1";
            }
            else if (ab[0] > 0 && ab[1] > 0)
            {
                for (int i = 1; i < ab[1]; i++) {
                    a *= ab[0];
                }
            }
            else if (ab[0] != 0 && ab[1] < 0)
            {
                return Double.toString(Math.pow(ab[0], ab[1]));
            }
            return Integer.toString(a);
        }

        static int[] readFromFile(String filename)          // Метод считывает из файла строки и записывает значение
        {                                                   // a в 0 ячейку массива, b в 1 ячейку и возвращает массив
            int[] ab = new int[2];
            try (FileReader fr = new FileReader(filename))
            {
                int count = 0;
                String[] str = new String[2];
                Scanner sc = new Scanner(fr);

                while (sc.hasNextLine())
                {
                    str[count] = sc.nextLine();
                    count++;
                }
                for (int i = 0; i < 2; i++)
                {
                    boolean hasDigit = false;
                    for (int j = 0; j < str[i].length(); j++)           // Проверка на то, что указаны оба числа (a и b)
                    {
                        if(Character.isDigit(str[i].charAt(j)))
                        {
                            hasDigit = true;
                        }
                    }
                    if(hasDigit == false)                               // Если нет хотя бы одного числа, ответ будет
                    {                                                   // "не определено" как для a и b = 0
                        ab[0] = 0;
                        ab[1] = 0;
                        return ab;
                    }
                    if(str[i].contains("a"))
                    {
                        ab[0] = Integer.parseInt(str[i].replaceAll("[^\\d0-9]", ""));
                    }
                    if(str[i].contains("b"))
                    {
                        ab[1] = Integer.parseInt(str[i].replaceAll("[^\\d0-9]", ""));;
                    }
                }

            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
            return ab;
        }

        static void writeToFile(String filename, String answer)         // Метод записывает ответ в файл
        {
            try (FileWriter fw = new FileWriter(filename))
            {
                fw.write(answer);
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }

}
