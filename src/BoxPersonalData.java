import java.util.Scanner;

public class BoxPersonalData {

    String[] personalData;

    public String[] getPersonalData() {
        return personalData;
    }

    public BoxPersonalData(String personalData) {
        this.personalData = personalData.split(" ");
    }
    public int lenDataIsOk(){
        if (personalData.length != 4) {
            System.out.println("Вы ввели меньше строк, чем нужно");
            return -1;
        }
        return 0;}
}