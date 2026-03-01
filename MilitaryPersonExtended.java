// Реализовать предметную область
// Учет военного дела. Создать родительский класс "Военный состав" (фамилия, рота, звание, дата рождения, дата поступления на службу, часть) и дочерние классы:
// - "Органы военного управления" (название округа, должность, выслуга лет, сумма надбавки);
// - "Военная служба по контракту" (период договора, дата договора, номер протокола, сумма зарплаты);
// - "Награжденные" (название награды, премия, сумма надбавки).
// Реализовать класс для хранения списка военных с методом добавления нового военного и методом печати списка военных.

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class MilitaryPersonExtended {
    private String lastName;           // фамилия
    private String company;            // рота
    private String rank;               // звание
    private LocalDate birthDate;       // дата рождения
    private LocalDate enlistmentDate;  // дата поступления на службу
    private String unit;               // часть

    public MilitaryPersonExtended(String lastName, String company, String rank) {
        this.lastName = lastName;
        this.company = company;
        this.rank = rank;
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
}

// дочерний класс - органы военного управления
class MilitaryCommand extends MilitaryPersonExtended {
    private String district;          // название округа
    private String position;          // должность
    private int yearsOfService;       // выслуга лет
    private double allowanceAmount;   // сумма надбавки

    public MilitaryCommand(String lastName, String company, String rank,
                           String district, String position, int yearsOfService, double allowanceAmount) {
        super(lastName, company, rank);
        this.district = district;
        this.position = position;
        this.yearsOfService = yearsOfService;
        this.allowanceAmount = allowanceAmount;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public double getAllowanceAmount() {
        return allowanceAmount;
    }

    public void setAllowanceAmount(double allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "  Название округа: " + district + "\n" +
                "  Должность: " + position + "\n" +
                "  Выслуга лет: " + yearsOfService + "\n" +
                "  Сумма надбавки: " + allowanceAmount;
    }
}

// дочерний класс: военная служба по контракту
class ContractService extends MilitaryPersonExtended {
    private String contractPeriod;    // период договора (например, "2023-2025")
    private LocalDate contractDate;   // дата договора
    private String protocolNumber;    // номер протокола
    private double salaryAmount;      // сумма зарплаты

    public ContractService(String lastName, String company, String rank,
                           String contractPeriod, LocalDate contractDate, String protocolNumber, double salaryAmount) {
        super(lastName, company, rank);
        this.contractPeriod = contractPeriod;
        this.contractDate = contractDate;
        this.protocolNumber = protocolNumber;
        this.salaryAmount = salaryAmount;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return super.toString() + "\n" +
                "  Период договора: " + contractPeriod + "\n" +
                "  Дата договора: " + (contractDate != null ? contractDate.format(formatter) : "не указана") + "\n" +
                "  Номер протокола: " + protocolNumber + "\n" +
                "  Сумма зарплаты: " + salaryAmount;
    }
}

// дочерний класс: награжденные
class Awarded extends MilitaryPersonExtended {
    private String awardName;         // название награды
    private double bonusAmount;       // премия
    private double allowanceAmount;   // сумма надбавки

    public Awarded(String lastName, String company, String rank,
                   String awardName, double bonusAmount, double allowanceAmount) {
        super(lastName, company, rank);
        this.awardName = awardName;
        this.bonusAmount = bonusAmount;
        this.allowanceAmount = allowanceAmount;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public double getAllowanceAmount() {
        return allowanceAmount;
    }

    public void setAllowanceAmount(double allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "  Название награды: " + awardName + "\n" +
                "  Премия: " + bonusAmount + "\n" +
                "  Сумма надбавки: " + allowanceAmount;
    }
}

// класс для хранения списка военных
class MilitaryRegistry {
    private List<MilitaryPersonExtended> personnelList;

    public MilitaryRegistry() {
        personnelList = new ArrayList<>();
    }

    public void addMilitaryPerson(MilitaryPersonExtended person) {
        personnelList.add(person);
    }

    public void printAll() {
        if (personnelList.isEmpty()) {
            System.out.println("Список военных пуст.");
            return;
        }
        for (int i = 0; i < personnelList.size(); i++) {
            System.out.println("========== Военнослужащий №" + (i + 1) + " ==========");
            System.out.println(personnelList.get(i));
            System.out.println();
        }
    }
}