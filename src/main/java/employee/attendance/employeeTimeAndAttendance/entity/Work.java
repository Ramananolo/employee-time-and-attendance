package employee.attendance.employeeTimeAndAttendance.entity;

import employee.attendance.employeeTimeAndAttendance.calendar.CalendarOfJune;
import employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

import static employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking.*;
import static employee.attendance.employeeTimeAndAttendance.entity.enums.ListCategory.Janitor;

@Getter
@Setter
@AllArgsConstructor
public class Work {
    public double hourOfWork;
    CalendarOfJune calendarOfJune;
    private final ConditionOfWorking conditionOfWorking;

    Employee employee;

    public Work() {
        this.conditionOfWorking = employee.getCategory().getWorkingConditions();
    }
    public double sumOfSalaryWithInMouthOfJune(Employee employee) {
        double salaryPerWeek = employee.getCategory().getSalaryPerWeek();
        double salaryBrut = employee.getSalaryAmount().getSalaryBrut();
        double hourPerWeek = employee.getCategory().getHourNormalByDay()*7;
        var categoryName = employee.getCategory().getNom();
        if (categoryName.equals(Janitor)) {
            double hourForOneMoth = hourPerWeek * 6;
            salaryBrut = salaryPerWeek * 6;
            if (conditionOfWorking.equals(day)) return salaryBrut;
            else if (conditionOfWorking.equals(night)) salaryBrut = salaryBrut*1.3;
            else if (conditionOfWorking.equals(sunday)) salaryBrut = salaryBrut*1.4;
            else if (conditionOfWorking.equals(calendarOfJune.getIronDay())) salaryBrut = salaryBrut*1.5;
        }
        return salaryBrut;
    }
}
