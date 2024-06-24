package employee.attendance.employeeTimeAndAttendance.calendar;

import employee.attendance.employeeTimeAndAttendance.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static employee.attendance.employeeTimeAndAttendance.entity.enums.ListCategory.Janitor;
import static employee.attendance.employeeTimeAndAttendance.entity.enums.ListCategory.normal;

@Getter
@Setter
public class CalendarOfJune {
    private final Calendar calendarJune = new GregorianCalendar(2024, Calendar.JUNE, 1);
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
}
