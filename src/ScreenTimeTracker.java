import  java.util.Scanner;
public class ScreenTimeTracker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Все значения равны 0
        int socialT = 0;
        int gameT = 0;
        int studyT = 0;
        int streamT = 0;
        int totalT = 0;
        int sessionT = 0;
        int entertainmentTime = socialT + gameT + streamT;
        for (; ; ) {
            System.out.println("\n===== SCREEN-TIME TRACKER =====");
            System.out.println("\n1. Add social media time\n2. Add gaming time\n3. Add studying time\n" + "4. Add video or streaming time\n" + "5. View statistics\n" + "6. Exit");
            System.out.println("\n\nChoose an option: ");
            int opt = scan.nextInt();
            if (opt <= 0 || opt > 6)//Условие для ошибки
                System.out.println("Invalid option!");
            else if (opt == 1) {
                System.out.println("Enter social media minutes:");
                int socialM = scan.nextInt();
                if (socialM <= 0) {//Если ввести время меньше или равно 0
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                } else {
                    totalT += socialM;
                    socialT += socialM;
                    sessionT += 1;
                    System.out.println("\nTime added successfully!");

                }
            } else if (opt == 2) {
                System.out.println("Enter gaming time minutes:");
                int gameM = scan.nextInt();
                if (gameM <= 0) {
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                } else {
                    totalT += gameM;
                    gameT += gameM;
                    sessionT += 1;
                    System.out.println("\nTime added successfully!");

                }
            } else if (opt == 3) {
                System.out.println("Enter studying time minutes:");
                int studyM = scan.nextInt();
                if (studyM <= 0) {
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                } else {
                    totalT += studyM;
                    studyT += studyM;
                    sessionT += 1;
                    System.out.println("\nTime added successfully!");

                }
            } else if (opt == 4) {
                System.out.println("Enter video or streaming time minutes:");
                int streamM = scan.nextInt();
                if (streamM <= 0) {
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                } else {
                    totalT += streamM;
                    studyT += streamM;
                    sessionT += 1;
                    System.out.println("\nTime added successfully!");
                }
            }
            else if (opt==5){//Результаты
                System.out.println("===== TODAY'S SCREEN TIME =====");
                System.out.println("\nSocial media:"+ socialT +"minutes");
                System.out.println("Gaming time:"+ gameT +"minutes");
                System.out.println("Studying time:"+ studyT +"minutes");
                System.out.println("Streaming time:"+ streamT +"minutes");
                System.out.println("\nTotal screen time: "+totalT +"minutes");
                System.out.println("Recorded sessions: "+ sessionT);
                if(entertainmentTime>studyT) {//Условие если развлечений больше чем учебы
                    System.out.println("\n\nEntertainment screen time is greater than study time");
                }
                else if (entertainmentTime<studyT)//Наоборот
                    System.out.println("\n\nStudy screen time is greater than entertainment screen time. Good balance!");
                else if(entertainmentTime==studyT)//Равны
                    System.out.println("\n\nStudy and entertainment screen time are equal.");
                System.out.println("\nDaily Screen-Time Message");//Сообщение для пользователя
                if(totalT>240)
                    System.out.println("High screen time");
                else if (totalT>=120 & totalT<=240)
                    System.out.println("Moderate screen time");
                else if(totalT<120)
                    System.out.println("Low screen time");
            }
            else if(opt==6){
                scan.close();
                System.out.println("Screen-time tracker closed.");
                System.exit(0);
            }

        }
    }
}