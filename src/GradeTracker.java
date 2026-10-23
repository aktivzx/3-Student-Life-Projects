import java.util.Locale;
import java.util.Scanner;
public class GradeTracker {
    private static char getGrade(double average) {//Мой метод для оценок
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        //Все значнеия равны 0
        double assignmentPoints = 0;
        int assignmentCount = 0;
        double examPoints = 0;
        int examCount = 0;
        double assignmentAverage = 0;
        double examAverage = 0;
        double overallAverage;

        for (; ; ) {
            System.out.println();
            System.out.println("===== SEMESTER GRADE TRACKER =====");//Меню
            System.out.println();
            System.out.println("1. Add assignment result");
            System.out.println("2. Add exam result");
            System.out.println("3. View current grade");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {//Результаты задания
                    System.out.print("Enter assignment score: ");
                    double score = scanner.nextDouble();
                    System.out.println();
                    if (score > 100 || score <= 0) {//Условие для ошибки
                        System.out.println("Invalid score. Enter a value from 0 to 100.");
                    } else {
                        assignmentPoints += score;
                        assignmentCount++;
                        System.out.println("Assignment score added.");
                    }
                    break;
                }
                case 2: {//Результаты экзамена
                    System.out.print("Enter exam score: ");
                    double score = scanner.nextDouble();
                    System.out.println();
                    if (score > 100 || score <= 0) {
                        System.out.println("Invalid score. Enter a value from 0 to 100.");
                    } else {
                        examPoints += score;
                        examCount++;
                        System.out.println("Exam score added.");
                    }
                    break;
                }
                case 3://Просмотр оценки
                    System.out.println();
                    if (assignmentCount == 0 && examCount == 0) {
                        System.out.println("No results available yet.");
                        break;
                    } else {
                        if (assignmentCount > 0) {
                            assignmentAverage = assignmentPoints / assignmentCount;
                        }
                        if (examCount > 0) {
                            examAverage = examPoints / examCount;
                        }
                        if (assignmentCount > 0 && examCount > 0) {
                            overallAverage = assignmentAverage * 0.50 + examAverage * 0.50;
                        } else if (assignmentCount > 0) {
                            overallAverage = assignmentAverage;
                            System.out.println("No exam results yet, so the overall average equals the assignment average.");
                        } else {
                            overallAverage = examAverage;
                            System.out.println("No assignment results yet, so the overall average equals the exam average.");
                        }


                        System.out.println("===== CURRENT RESULTS =====");
                        System.out.println("\nAssignments completed: " + assignmentCount);
                        if (assignmentCount > 0) {
                            System.out.println("Assignment average: " + String.format(Locale.US, "%.1f", assignmentAverage));
                        } else {
                            System.out.println("Assignment average: N/A (no results yet)");//Условие если еще нету резльтатов задания
                        }
                        System.out.println();
                        System.out.println("Exams completed: " + examCount);
                        if (examCount > 0) {
                            System.out.println("Exam average: " + String.format(Locale.US, "%.1f", examAverage));
                        } else {
                            System.out.println("Exam average: N/A (no results yet)");//Если нету результатов экзамена
                        }
                        System.out.println();
                        System.out.println("Overall average: " + String.format(Locale.US, "%.1f", overallAverage));
                        System.out.println("Grade: " + getGrade(overallAverage));//Оценка
                        System.out.println("Status: " + (overallAverage >= 60 ? "Passing" : "Not passing"));//Прошел ли
                    }
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println();//При вводе неправильного выбора
                    System.out.println("Invalid option. Choose 1, 2, 3 or 4.");
            }
        }
    }
}