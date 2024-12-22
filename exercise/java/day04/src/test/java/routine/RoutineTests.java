package routine;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RoutineTests {
    @Test
    void startRoutineWithMockito() {
        var mockEmailService = mock(EmailService.class);
        var mockSchedueService = mock(ScheduleService.class);
        var schedule = new Schedule();
        when(mockSchedueService.todaySchedule()).thenReturn(schedule);
        var mockReindeerFeeder = mock(ReindeerFeeder.class);
        var routine = new Routine(mockEmailService, mockSchedueService, mockReindeerFeeder);

        routine.start();

        verify(mockSchedueService).organizeMyDay(schedule);
        verify(mockReindeerFeeder).feedReindeers();
        verify(mockEmailService).readNewEmails();
        verify(mockSchedueService).continueDay();
    }

    @Test
    void startRoutineWithManualTestDoubles() {
        // Write a test using your own test double(s)
    }
}
