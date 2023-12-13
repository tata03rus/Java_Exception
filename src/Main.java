import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество ДатаРождения(через\".\") пол(f/m) телефон");
        System.out.println("Образец: Иванов,Иван,Иванович 21.05.1999 f 123456");
        String personalData = in.nextLine();
        BoxPersonalData boxPersonalData1 = new BoxPersonalData(personalData);

        if (boxPersonalData1.lenDataIsOk() == 0) {
            PersonBuilder person1 = new PersonBuilder();
            try  {
                for (String data : boxPersonalData1.getPersonalData()) {
                    if (data.contains(".")) {
                        person1.setDateOfBirtday(data);
                    } else if (data.contains(",")) {
                        String[] nameLnFn = data.split(",");
                        person1.setName(nameLnFn[1]);
                        person1.setLastname(nameLnFn[0]);
                        person1.setFatherName(nameLnFn[2]);
                    } else if (data.trim().equals("f") || data.trim().equals("m")) {
                        person1.setGender(data.trim());
                    }
                    else if (!(data.contains("f") && data.contains("m"))){
                        Long phone = Long.parseLong(data.trim());
                        person1.setNumber(phone);
                    }
                }
                Person p1 = person1.build();
                try (FileWriter writer = new FileWriter(p1.getLastname() + ".txt" ,true)){
                    writer.append(String.format("ФИО: %s %s %s; Дата рождения: %s; Пол: %s;  Номер телефона: %d \n",
                            p1.getName(), p1.getLastname(),
                            p1.getFatherName(), p1.getDateOfBirtday(),
                            p1.getGender().equals("f")? "ж" : "м", p1.getNumber()));
                    System.out.println("successfully");}
                catch (IOException ee){
                    System.out.println(ee.getClass().getSimpleName());
                    System.out.println(ee.getStackTrace());
                }
            }
            catch (NumberFormatException e){
                System.out.println("Номер телефона введён в некорректном формате");
            }

            catch (Exception e){
                System.out.println("Произошла ошибка");
                System.out.println();
            }


        }

    }
}