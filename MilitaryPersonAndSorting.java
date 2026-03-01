// Добавить свойство класса "зарплата".
// Реализовать сортировку по фамилиям и зарплатам.

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class MilitaryPersonAndSorting {
    private String lastName;           // фамилия
    private String company;            // рота
    private String rank;               // звание
    private LocalDate birthDate;       // дата рождения
    private LocalDate enlistmentDate;  // дата поступления на службу
    private String unit;               // часть
    private double salary;             // зарплата

    public MilitaryPersonAndSorting(String lastNameParam, String companyParam, String rankParam) {
        this.lastName = lastNameParam;
        this.company = companyParam;
        this.rank = rankParam;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEnlistmentDate() {
        return enlistmentDate;
    }

    public void setEnlistmentDate(LocalDate enlistmentDate) {
        this.enlistmentDate = enlistmentDate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("  Фамилия: ").append(lastName != null ? lastName : "не указана").append("\n");
        sb.append("  Рота: ").append(company != null ? company : "не указана").append("\n");
        sb.append("  Звание: ").append(rank != null ? rank : "не указано").append("\n");
        sb.append("  Дата рождения: ").append(birthDate != null ? birthDate.format(formatter) : "не указана").append("\n");
        sb.append("  Дата поступления на службу: ").append(enlistmentDate != null ? enlistmentDate.format(formatter) : "не указана").append("\n");
        sb.append("  Часть: ").append(unit != null ? unit : "не указана").append("\n");
        sb.append("  Зарплата: ").append(String.format("%.2f", salary)).append(" руб.");
        return sb.toString();
    }

    // настраиваем табличный вывод с фиксированной шириной для объектов
    public static void printTable(ArrayList<MilitaryPersonAndSorting> list) {
        if (list.isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String headerFormat = "│ %-3s │ %-15s │ %-12s │ %-18s │ %-12s │ %-15s │ %-10s │%n";
        String rowFormat   = "│ %-3d │ %-15s │ %-12s │ %-18s │ %-12s │ %-15s │ %-10.2f │%n";

        System.out.println("┌─────┼─────────────────┼──────────────┼────────────────────┼──────────────┼─────────────────┼────────────┐");
        System.out.printf(headerFormat, "№", "Фамилия", "Рота", "Звание", "Дата рожд.", "Дата поступл.", "Зарплата");
        System.out.println("├─────┼─────────────────┼──────────────┼────────────────────┼──────────────┼─────────────────┼────────────┤");

        for (int i = 0; i < list.size(); i++) {
            MilitaryPersonAndSorting p = list.get(i);

            String birthStr = p.getBirthDate() != null ? p.getBirthDate().format(formatter) : "не указана";
            String enlistStr = p.getEnlistmentDate() != null ? p.getEnlistmentDate().format(formatter) : "не указана";

            System.out.printf(rowFormat,
                    i + 1,
                    truncate(p.getLastName(), 15),
                    truncate(p.getCompany(), 12),
                    truncate(p.getRank(), 18),
                    truncate(birthStr, 12),
                    truncate(enlistStr, 15),
                    p.getSalary());
        }

        System.out.println("└─────┴─────────────────┴──────────────┴────────────────────┴──────────────┴─────────────────┴────────────┘");
    }

    private static String truncate(String str, int maxLength) {
        if (str == null) return "не указана";
        if (str.length() <= maxLength) return str;
        return str.substring(0, maxLength - 3) + "...";
    }

    public static void main(String[] args) {
        ArrayList<MilitaryPersonAndSorting> personnel = new ArrayList<>();

        String[] lastNames = {"Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов",
                "Попов", "Васильев", "Павлов", "Соколов", "Михайлов"};
        String[] companies = {"1-я рота", "2-я рота", "3-я рота", "штабная рота", "разведрота"};
        String[] ranks = {"рядовой", "ефрейтор", "младший сержант", "сержант",
                "старший сержант", "прапорщик", "лейтенант"};
        String[] units = {"Войсковая часть 12345", "Войсковая часть 54321",
                "Войсковая часть 67890", "Войсковая часть 09876",
                "Войсковая часть 13579"};

        Random random = new Random();

        System.out.println("=== СОЗДАНИЕ 10 ОБЪЕКТОВ ЧЕРЕЗ КОНСТРУКТОР ===\n");

        for (int i = 0; i < 10; i++) {
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String company = companies[random.nextInt(companies.length)];
            String rank = ranks[random.nextInt(ranks.length)];

            MilitaryPersonAndSorting person = new MilitaryPersonAndSorting(lastName, company, rank);
            personnel.add(person);

            System.out.println("Создан объект " + (i+1) + ": " +
                    lastName + ", " + company + ", " + rank +
                    " (остальные поля пока пустые)");
        }

        System.out.println("\n=== ДОПОЛНЕНИЕ ОБЪЕКТОВ ЧЕРЕЗ СЕТТЕРЫ ===\n");

        for (int i = 0; i < personnel.size(); i++) {
            MilitaryPersonAndSorting person = personnel.get(i);

            int birthYear = 1970 + random.nextInt(31);
            int birthMonth = 1 + random.nextInt(12);
            int birthDay = 1 + random.nextInt(28);
            LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);

            int enlistmentYear = birthYear + 18 + random.nextInt(23);
            int enlistmentMonth = 1 + random.nextInt(12);
            int enlistmentDay = 1 + random.nextInt(28);
            LocalDate enlistmentDate = LocalDate.of(enlistmentYear, enlistmentMonth, enlistmentDay);

            String unit = units[random.nextInt(units.length)];

            person.setBirthDate(birthDate);
            person.setEnlistmentDate(enlistmentDate);
            person.setUnit(unit);

            double salary = 20000 + random.nextDouble() * 130000;
            person.setSalary(salary);

            System.out.println("Дополнен объект " + (i+1) + ": установлены дата рождения, " +
                    "дата поступления, часть и зарплата");
        }

        System.out.println("\n=== ТЕКУЩИЙ СПИСОК ===\n");
        printTable(personnel);

        // настройка сортировки через ввод пользователем
        Scanner scanner = new Scanner(System.in);
        int criterion = 0;
        int order = 0;

        System.out.println("\nВыберите критерий сортировки:");
        System.out.println("1 - по фамилии");
        System.out.println("2 - по зарплате");

        while (true) {
            System.out.print("Введите номер (1 или 2): ");
            if (scanner.hasNextInt()) {
                criterion = scanner.nextInt();
                if (criterion == 1 || criterion == 2) {
                    break;
                } else {
                    System.out.println("Введите 1 или 2.");
                }
            } else {
                System.out.println("Введите 1 или 2.");
                scanner.next();
            }
        }

        System.out.println("\nВыберите метод сортировки:");
        System.out.println("1 - по возрастанию");
        System.out.println("2 - по убыванию");

        while (true) {
            System.out.print("Введите номер (1 или 2): ");
            if (scanner.hasNextInt()) {
                order = scanner.nextInt();
                if (order == 1 || order == 2) {
                    break;
                } else {
                    System.out.println("Введите 1 или 2.");
                }
            } else {
                System.out.println("Введите 1 или 2.");
                scanner.next();
            }
        }

        ArrayList<MilitaryPersonAndSorting> sortedList = new ArrayList<>(personnel);

        Comparator<MilitaryPersonAndSorting> comparator;
        if (criterion == 1) {
            comparator = Comparator.comparing(MilitaryPersonAndSorting::getLastName);
        } else {
            comparator = Comparator.comparingDouble(MilitaryPersonAndSorting::getSalary);
        }

        if (order == 2) {
            comparator = comparator.reversed();
        }

        sortedList.sort(comparator);

        System.out.println("\n=== ОТСОРТИРОВАННЫЙ СПИСОК ===\n");
        printTable(sortedList);
        scanner.close();
    }
}