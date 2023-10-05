import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args) throws Exception {

        String[] data;
        try {
            data = InputData.makeRecord();
            String surname = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            if (phoneNumber.length()==10){
                phoneNumber=data[4];
            } else {
                System.out.println("Ошибка! Не достаточно цифр в номере, введите в формате 9555551111");
                return;
            }
            String gender;
            if (data[5]!="f"| data[5]!="m"){
                gender=data[5];
            }
            else {
                System.out.println("Ошибка! Не верно ввели пол, введите латиницей f или m ");
                return;

            }
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date corectDate;
            {
                try {
                    corectDate = (Date) formatter.parse(birthDate);
                } catch (ParseException e) {
                    System.out.println("Ошибка! Не удалось преобразовать дату, введите дату в формате dd.MM.yyyy ");
                    return;
                }
            }
            String output = surname + " " + firstName + " " + middleName + " " + corectDate + " " + phoneNumber + " " + gender;
            FileWriter fileWriter = new FileWriter(surname + ".txt");
            fileWriter.write(output);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка! Не удалось создать файл.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка! Введены неполные данные.");
            return;
        }
        System.out.println("Данные успешно сохранены в файле " + data[0] + ".txt");
    }
}