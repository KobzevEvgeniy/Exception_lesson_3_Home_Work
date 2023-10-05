import java.util.Scanner;



public class InputData {
    String text;

    public InputData(String text) {
        this.text = text;
    }

    public static String[] makeRecord()  {
        System.out.println(" Введите фамилию, имя, отчество, " +
                "\n дату рождения (в формате dd.mm.yyyy)," +
                "\n номер телефона (число без разделителей)" +
                "\n и пол(символ латиницей f или m), разделенные пробелом: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] data;

        data = input.split(" ");
        if (data.length > 6) {
                System.out.println("Ошибка! Введены лишние данные.");
            }
        return data;
        }



    }


