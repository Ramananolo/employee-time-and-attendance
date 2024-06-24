package employee.attendance.employeeTimeAndAttendance;

import employee.attendance.employeeTimeAndAttendance.calendar.CalendarOfJune;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

}
