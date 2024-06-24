package employee.attendance.employeeTimeAndAttendance.calendar;

import employee.attendance.employeeTimeAndAttendance.entity.Category;
import employee.attendance.employeeTimeAndAttendance.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking.day;
import static employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking.night;
import static employee.attendance.employeeTimeAndAttendance.entity.enums.ListCategory.Janitor;
import static employee.attendance.employeeTimeAndAttendance.entity.enums.ListCategory.normal;

@Getter
@Setter
public class CalendarOfJune {
    private final Calendar calendarJune = new GregorianCalendar(2024, Calendar.JUNE, 06);
    private final Calendar calendarOfMay = new GregorianCalendar(2024, Calendar.MAY, 01);
    private final Calendar calendarOfJuly = new GregorianCalendar(2024, Calendar.JUNE, 06);
    public List<Calendar> ironDay;
    int numberDayOfWorkingPerWeek = Calendar.DAY_OF_WEEK;
    Employee employee;

    public CalendarOfJune() {
        this.ironDay = new ArrayList<>();
        Calendar date17 = (Calendar) calendarJune.clone();
        Calendar date25 = (Calendar) calendarJune.clone();
        Calendar date26 = (Calendar) calendarJune.clone();
        date26.set(Calendar.DAY_OF_MONTH, 26);
        date25.set(Calendar.DAY_OF_MONTH, 25);
        date17.set(Calendar.DAY_OF_MONTH, 17);
        this.ironDay.add(date17);
        this.ironDay.add(date26);
        this.ironDay.add(date25);
    }

    public int displayWorkingDayPerWeek(Employee employee) {
        var categoryNameOfEmployee = employee.getCategory().getNom();
        int numberDay = this.numberDayOfWorkingPerWeek;
        if (categoryNameOfEmployee.equals(normal)) return numberDay - 2;
        else if (categoryNameOfEmployee.equals(Janitor)) return numberDay;
        return numberDay;
    }

    public double hourOfWorkForMouth(Employee employee) {
        var categoryOfEmployee = employee.getCategory().getNom();
        double hourForOneWeek = employee.getCategory().getHourNormalByDay() * 7;
        var workingCondition = employee.getCategory().getWorkingConditions();
        double hourInMonth = hourForOneWeek * 6;
        if (categoryOfEmployee.equals(Janitor)) {
            if (workingCondition.equals(night)) return hourInMonth;
            if (workingCondition.equals(day)) return hourInMonth;
        } else if (categoryOfEmployee.equals(normal)) return hourInMonth;
        return hourInMonth;
    }
}
