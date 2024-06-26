package employee.attendance.employeeTimeAndAttendance.entity;

import employee.attendance.employeeTimeAndAttendance.calendar.CalendarOfJune;
import employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

import static employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking.*;
import static employee.attendance.employeeTimeAndAttendance.entity.enums.ListCategory.Janitor;

@Getter
@Setter
@AllArgsConstructor
public class Work {
    public double hourOfWork;
    CalendarOfJune calendarOfJune;
    private final ConditionOfWorking conditionOfWorking;
    private List<Calendar> dayOfWorking;
    Employee employee;

    public Work() {
        this.conditionOfWorking = employee.getCategory().getWorkingConditions();
    }

    public double sumOfSalaryWithInMouthOfJune(Employee employee) {
        double salaryPerWeek = employee.getCategory().getSalaryPerWeek();
        double salaryBrut = employee.getSalaryAmount().getSalaryBrut();
        var categoryName = employee.getCategory().getNom();
        if (categoryName.equals(Janitor)) {
            salaryBrut = salaryPerWeek * 6;
            if (conditionOfWorking.equals(day)) return salaryBrut;
            else if (conditionOfWorking.equals(night)) return salaryBrut * 1.3;
            else if (conditionOfWorking.equals(sunday)) return salaryBrut * 1.4;
            else if (conditionOfWorking.equals(calendarOfJune.getIronDay())) return salaryBrut * 1.5;
        }
        return salaryBrut;
    }

    public double getSalaryPerHour(Employee employee) {
        var categoryName = employee.getCategory().getNom();
        double salaryPerHour = 0.0;
        if (categoryName.equals(Janitor)) {
            if (getConditionOfWorking().equals(day))
                return employee.getCategory().getSalaryPerWeek() / 70;
            else if (getConditionOfWorking().equals(night))
                return ((employee.getCategory().getSalaryPerWeek() / 70) * 13) / 14;
        }
        return salaryPerHour;
    }

    public double getSalaryPerDay(Employee employee) {
        var categoryName = employee.getCategory().getNom();
        double salaryPerDay = 0.0;
        if (categoryName.equals(Janitor)) {
            if (getConditionOfWorking().equals(day))
                return employee.getCategory().getSalaryPerWeek() / 7;
            else if (getConditionOfWorking().equals(night))
                return (employee.getCategory().getSalaryPerWeek() / 7) * 1.3;
        }
        return salaryPerDay;
    }

    public double salaryWithIronDay(Employee employee) {
        double salaryWithIronDay = 0.0;
        double salaryFor39days = (employee.getCategory().getSalaryPerWeek() / 7) * 39;
        double salaryFor3days = (employee.getCategory().getSalaryPerWeek() / 7) * 3;
        if (dayOfWorking.equals(getCalendarOfJune().getIronDay()))
            if (this.conditionOfWorking.equals(night)) {
                salaryFor39days = salaryFor39days * 1.3;
                salaryFor3days = salaryFor3days * 1.3;
                return salaryFor39days + salaryFor3days;
            }
        salaryWithIronDay = (salaryFor3days * 1.3) + salaryFor39days;
        return salaryWithIronDay;
    }
}
