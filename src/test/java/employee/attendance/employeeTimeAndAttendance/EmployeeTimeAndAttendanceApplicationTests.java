package employee.attendance.employeeTimeAndAttendance;

import employee.attendance.employeeTimeAndAttendance.calendar.CalendarOfJune;
import employee.attendance.employeeTimeAndAttendance.entity.Category;
import employee.attendance.employeeTimeAndAttendance.entity.Employee;
import employee.attendance.employeeTimeAndAttendance.entity.Salary;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking.day;
import static employee.attendance.employeeTimeAndAttendance.entity.enums.ConditionOfWorking.night;
import static employee.attendance.employeeTimeAndAttendance.entity.enums.ListCategory.Janitor;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmployeeTimeAndAttendanceApplicationTests {

	@Test
	void display_iron_day() {
		CalendarOfJune calendarOfJune = new CalendarOfJune();
		Calendar calendarJune = calendarOfJune.getCalendarJune();
		List<Calendar> ironDay = new ArrayList<>();
		Calendar date17 =(Calendar) calendarJune.clone();
		Calendar date25 =(Calendar) calendarJune.clone();
		Calendar date26 =(Calendar) calendarJune.clone();
		date26.set(Calendar.DAY_OF_MONTH,26);
		date25.set(Calendar.DAY_OF_MONTH,25);
		date17.set(Calendar.DAY_OF_MONTH,17);
		ironDay.add(date17);
		ironDay.add(date26);
		ironDay.add(date25);
		assertEquals(ironDay,calendarOfJune.ironDay);
	}

	@Test
	void day_of_working_for_employee(){
		var categoryJanitor = new Category(Janitor,56,110000,0,null);
		var salaryOfJanitor = new Salary(110000*4);
		var employee1 = new Employee("RAKOTO","MN00401", LocalDate.of(1999,01,04), LocalDate.of(2022,04,01),null,categoryJanitor);
		var calendarOfJune = new CalendarOfJune();
		var calendarJune = calendarOfJune.getCalendarJune();
		int workingDayPerWeek = calendarOfJune.displayWorkingDayPerWeek(employee1);
		assertEquals(7,workingDayPerWeek);
	}

	@Test
	void hours_worked_by_rakoto_for_the_month_of_June(){
		var categoryRakoto = new Category(Janitor,10,100000,0,day);
		var employeeRakoto = new  Employee("RAKOTO","MN00401", LocalDate.of(1999,01,04), LocalDate.of(2022,04,01),null,categoryRakoto);
		var calendarOfJune = new CalendarOfJune();
		double hourWorkedByRakoto = calendarOfJune.hourOfWorkForMouth(employeeRakoto);

		assertEquals(420,hourWorkedByRakoto);
	}
}
