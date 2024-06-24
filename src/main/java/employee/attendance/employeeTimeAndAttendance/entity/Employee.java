package employee.attendance.employeeTimeAndAttendance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class Employee {
    public String name;
    public String registrationNumber;
    public LocalDate dateOfBirth;
    public LocalDate HiringDate;
    public LocalDate ContractEndDate;
    public Category category;
}
