package employee.attendance.employeeTimeAndAttendance.entity;

import employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking;
import employee.attendance.employeeTimeAndAttendance.entity.enums.ListCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Category {
    private final ListCategory nom;
    private int hourNormalByWeek;
    private double salaryPerWeek;
    private double indemnity;
    private ConditionOfWorking workingConditions;
}
