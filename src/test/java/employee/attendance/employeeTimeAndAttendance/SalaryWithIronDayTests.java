package employee.attendance.employeeTimeAndAttendance;

import employee.attendance.employeeTimeAndAttendance.calendar.CalendarOfJune;
import employee.attendance.employeeTimeAndAttendance.entity.Category;
import employee.attendance.employeeTimeAndAttendance.entity.Employee;
import employee.attendance.employeeTimeAndAttendance.entity.Salary;
import employee.attendance.employeeTimeAndAttendance.entity.Work;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking.day;
import static employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking.night;
import static employee.attendance.employeeTimeAndAttendance.entity.enums.ListCategory.Janitor;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SalaryPerHourAndPerDayTests {
    @Test
    void salary_per_day_of_rabe() {
        var categoryRabe = new Category(Janitor, 14, 100000, 0, night);
        var salaryOfJanitorRabe = new Salary(100000 * 6);
        var employeeRabe = new Employee("RABE", "MN00402", LocalDate.of(1999, 01, 04), LocalDate.of(2022, 04, 01), null, categoryRabe, salaryOfJanitorRabe);
        var calendarOfJune = new CalendarOfJune();
        var work = new Work(0, calendarOfJune, night,null, employeeRabe);
        var salaryPerDay = work.getSalaryPerDay(employeeRabe);
        assertEquals(18571.428571428572, salaryPerDay);
    }

    @Test
    void salary_per_hour_of_rabe() {
        var categoryRabe = new Category(Janitor, 14, 100000, 0, night);
        var salaryOfJanitorRabe = new Salary(100000 * 6);
        var employeeRabe = new Employee("RABE", "MN00402", LocalDate.of(1999, 01, 04), LocalDate.of(2022, 04, 01), null, categoryRabe, salaryOfJanitorRabe);
        var calendarOfJune = new CalendarOfJune();
        var work = new Work(0, calendarOfJune, night,null, employeeRabe);
        var salaryPerHour = work.getSalaryPerHour(employeeRabe);
        assertEquals(1326.530612244898, salaryPerHour);
    }

    @Test
    void salary_per_day_of_rakoto() {
        var categoryRakoto = new Category(Janitor, 10, 100000, 0, day);
        var salaryOfJanitorRakoto = new Salary(100000 * 6);
        var employeeRakoto = new Employee("RAKOTO", "MN00401", LocalDate.of(1999, 01, 04), LocalDate.of(2022, 04, 01), null, categoryRakoto, salaryOfJanitorRakoto);
        var calendarOfJune = new CalendarOfJune();
        var work = new Work(0, calendarOfJune, day,null, employeeRakoto);
        var salaryPerDay = work.getSalaryPerDay(employeeRakoto);
        assertEquals(14285.714285714287, salaryPerDay);
    }
    @Test
    void salary_per_hour_of_rakoto(){
        var categoryRakoto = new Category(Janitor, 10, 100000, 0, day);
        var salaryOfJanitorRakoto = new Salary(100000 * 6);
        var employeeRakoto = new Employee("RAKOTO", "MN00401", LocalDate.of(1999, 01, 04), LocalDate.of(2022, 04, 01), null, categoryRakoto, salaryOfJanitorRakoto);
        var calendarOfJune = new CalendarOfJune();
        var work = new Work(0, calendarOfJune, day,null, employeeRakoto);
        var salaryPerHour = work.getSalaryPerHour(employeeRakoto);
        assertEquals(1428.5714285714287,salaryPerHour);
    }
}
