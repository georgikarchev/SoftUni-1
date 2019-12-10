package Google;
public class Company {
    private String companyName;
    private String department;
    private double salary;

    public Company(String companyName, String department, double salary) {
        setCompanyName(companyName);
        this.department = department;
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDepartment() {

        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setCompanyName(String companyName) {
        if (companyName == null) {
            this.companyName = "hahha";
            return;
        }
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return companyName;
    }
}
