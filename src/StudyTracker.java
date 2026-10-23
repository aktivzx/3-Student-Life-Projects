import java.util.Scanner;
    public class StudyTracker {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int weeklyGoal = 600;

            // Все суммы в начале равны 0
            int programmingTotal = 0;
            int mathTotal = 0;
            int englishTotal = 0;
            int otherTotal = 0;
            int totalTime = 0;
            int sessions = 0;
            int choice = 0;

            while (choice != 4) {
                System.out.println();
                System.out.println("===== STUDY TRACKER =====\n\n1. Add study session\n2. View statistics\n3. Check weekly goal\n4. Exit\n\nChoose an option: ");
                choice = scan.nextInt();

                switch (choice) {//Первый выбор
                    case 1:
                        System.out.println();
                        System.out.println("Choose subject:");
                        System.out.println("1. Programming");
                        System.out.println("2. Mathematics");
                        System.out.println("3. English");
                        System.out.println("4. Other");
                        System.out.print("\nChoose an option: ");
                        int subject = scan.nextInt();

                        if (subject < 1 || subject > 4) {//Ощибка если значение выбора не существует
                            System.out.println("Invalid subject. Please choose from 1 to 4.");
                            break;
                        }

                        System.out.print("Study time in minutes: ");
                        int minutes = scan.nextInt();

                        if (minutes <= 0) {//Ошибка если время равно или меньше нуля
                            System.out.println("Invalid study time. Time must be greater than 0.");
                            break;
                        }
                        //Выбор предметов
                        if (subject == 1) {
                            programmingTotal += minutes;
                        } else if (subject == 2) {
                            mathTotal += minutes;
                        } else if (subject == 3) {
                            englishTotal += minutes;
                        } else {
                            otherTotal += minutes;
                        }
                        //Общее время
                        totalTime += minutes;
                        sessions += 1;

                        System.out.println("\nStudy session added!");
                        System.out.println("Current total study time: " + totalTime + " minutes");
                        break;

                    case 2://Показ статистики
                        System.out.println();
                        System.out.println("===== WEEKLY STATISTICS =====");
                        System.out.println();
                        System.out.println("Study sessions: " + sessions);
                        System.out.println("Total study time: " + totalTime + " minutes");
                        System.out.println();
                        System.out.println("Programming: " + programmingTotal + " minutes");
                        System.out.println("Mathematics: " + mathTotal + " minutes");
                        System.out.println("English: " + englishTotal + " minutes");
                        System.out.println("Other: " + otherTotal + " minutes");
                        break;

                    case 3://Недельная цель
                        System.out.println();
                        System.out.println("Weekly goal: " + weeklyGoal + " minutes");
                        System.out.println("You studied: " + totalTime + " minutes");

                        if (totalTime >= weeklyGoal) {
                            System.out.println("Weekly goal achieved!");
                        } else {
                            int remaining = weeklyGoal - totalTime;
                            System.out.println("Remaining: " + remaining + " minutes");
                        }
                        break;

                    case 4://Закрытие программы
                        System.out.println();
                        System.out.println("Study tracker closed. Keep up the good work!");
                        break;

                    default://Если ввести неправильный выбор
                        System.out.println("Invalid option. Please choose from 1 to 4.");
                        break;
                }
            }

            scan.close();
        }
    }
