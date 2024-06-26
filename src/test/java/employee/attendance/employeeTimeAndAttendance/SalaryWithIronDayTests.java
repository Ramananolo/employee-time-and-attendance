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
class SalaryWithIronDayTests {
    @Test
    void salary_of_rakoto_with_iron_day(){
        var categoryRakoto = new Category(Janitor, 10, 100000, 0, day);
        var salaryOfJanitorRakoto = new Salary(100000 * 6);
        var employeeRakoto = new Employee("RAKOTO", "MN00401", LocalDate.of(1999, 01, 04), LocalDate.of(2022, 04, 01), null, categoryRakoto, salaryOfJanitorRakoto);
        var calendarOfJune = new CalendarOfJune();
        var work = new Work(0, calendarOfJune, day, calendarOfJune.getIronDay(), employeeRakoto);
        double salary = work.salaryWithIronDay(employeeRakoto);
        assertEquals(612857.1428571428,salary,"salary with Iron day");
    }
    @Test
    void salary_of_rabe_with_iron_day(){
        var categoryRabe = new Category(Janitor, 14, 100000, 0, night);
        var salaryOfJanitorRabe = new Salary(100000 * 6);
        var employeeRabe = new Employee("RABE", "MN00402", LocalDate.of(1999, 01, 04), LocalDate.of(2022, 04, 01), null, categoryRabe, salaryOfJanitorRabe);
        var calendarOfJune = new CalendarOfJune();
        var work = new Work(0, calendarOfJune, night,calendarOfJune.getIronDay(), employeeRabe);
        var salary = work.salaryWithIronDay(employeeRabe);
        assertEquals(780000.0,salary);
    }
}
