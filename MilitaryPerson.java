// Создать программу на языке Java для определения класса в некоторой предметной области. Описать свойства, конструктор, методы геттеры/сеттеры,
// перекрыть метод toString() для вывода полной информации об объекте в отформатированном виде:
// к - Конструктор
//  Военный состав
//  Command:
//  Свойства:
//      фамилия; к
//      рота; к
//      звание; к
//      дата рождения;
//      дата поступления на службу;
//      часть;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class MilitaryPerson {
    private String lastName;           // фамилия
    private String company;            // рота
    private String rank;               // звание
    private LocalDate birthDate;       // дата рождения
    private LocalDate enlistmentDate;  // дата поступления на службу
    private String unit;               // часть

    public MilitaryPerson(String lastNameParam, String companyParam, String rankParam) {
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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("  Фамилия: ").append(lastName != null ? lastName : "не указана").append("\n");
        sb.append("  Рота: ").append(company != null ? company : "не указана").append("\n");
        sb.append("  Звание: ").append(rank != null ? rank : "не указано").append("\n");
        sb.append("  Дата рождения: ").append(birthDate != null ? birthDate.format(formatter) : "не указана").append("\n");
        sb.append("  Дата поступления на службу: ").append(enlistmentDate != null ? enlistmentDate.format(formatter) : "не указана").append("\n");
        sb.append("  Часть: ").append(unit != null ? unit : "не указана");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<MilitaryPerson> personnel = new ArrayList<>();

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

            MilitaryPerson person = new MilitaryPerson(lastName, company, rank);

            personnel.add(person);

            System.out.println("Создан объект " + (i+1) + ": " +
                    lastName + ", " + company + ", " + rank +
                    " (остальные поля пока пустые)");
        }

        System.out.println("\n=== ДОПОЛНЕНИЕ ОБЪЕКТОВ ЧЕРЕЗ СЕТТЕРЫ ===\n");

        for (int i = 0; i < personnel.size(); i++) {
            MilitaryPerson person = personnel.get(i);

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

            System.out.println("Дополнен объект " + (i+1) + ": установлены дата рождения, " +
                    "дата поступления и часть");
        }

        System.out.println("\n=== ПОЛНАЯ ИНФОРМАЦИЯ ОБО ВСЕХ ВОЕННОСЛУЖАЩИХ ===\n");

        for (int i = 0; i < personnel.size(); i++) {
            System.out.println("----- Военнослужащий №" + (i+1) + " -----");
            System.out.println(personnel.get(i));
            System.out.println();
        }
    }
}