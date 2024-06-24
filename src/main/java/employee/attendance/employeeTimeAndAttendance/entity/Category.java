package employee.attendance.employeeTimeAndAttendance.entity;

import employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking;
import employee.attendance.employeeTimeAndAttendance.entity.enums.ListCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category {
    private final ListCategory nom;
    private int hourNormalByDay;
    private double salaryPerWeek;
    private double indemnity;
    private ConditionOfWorking workingConditions;
}
