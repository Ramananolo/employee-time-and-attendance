package employee.attendance.employeeTimeAndAttendance.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Salary {
    public double salaryBrut;
    public double salaryNet;

    public Salary(double salaryBrut) {
        this.salaryBrut = salaryBrut;
        this.salaryNet = (salaryBrut*80)/100;
    }
}
