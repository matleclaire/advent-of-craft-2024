package routine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class RoutineTests {
    @Test
    void startRoutineWithMockito() {
        var mockEmailService = mock(EmailService.class);
        var mockSchedulerService = mock(ScheduleService.class);
        var schedule = new Schedule();
        when(mockSchedulerService.todaySchedule()).thenReturn(schedule);
        var mockReindeerFeeder = mock(ReindeerFeeder.class);
        var routine = new Routine(mockEmailService, mockSchedulerService, mockReindeerFeeder);

        routine.start();

        verify(mockSchedulerService).organizeMyDay(schedule);
        verify(mockReindeerFeeder).feedReindeers();
        verify(mockEmailService).readNewEmails();
        verify(mockSchedulerService).continueDay();
    }

    @Test
    void startRoutineWithManualTestDoubles() {
        var mockEmailService = new TestEmailService();
        var schedule = new Schedule();
        var mockSchedulerService= new TestScheduleService(schedule);
        var mockReindeerFeeder = new TestReindeerFeeder();
        var routine = new Routine(mockEmailService, mockSchedulerService, mockReindeerFeeder);

        routine.start();

        assertThat(mockSchedulerService.organizeMyDayCalls).isEqualTo(1);
        assertThat(mockSchedulerService.continueDayCalls).isEqualTo(1);
        assertThat(mockReindeerFeeder.feedReindeersCalls).isEqualTo(1);
        assertThat(mockEmailService.readNewEmailsCalls).isEqualTo(1);
    }

    private static class TestEmailService implements EmailService {

        private int readNewEmailsCalls;

        public TestEmailService() {
        }

        @Override
        public void readNewEmails() {
            this.readNewEmailsCalls++;
            System.out.println("Reading new emails");
        }

    }

    private static class TestScheduleService implements ScheduleService {
        private Schedule scheduleToReturn;
        private int continueDayCalls;
        private int organizeMyDayCalls;

        public TestScheduleService() {
        }

        public TestScheduleService(Schedule scheduleToReturn) {
            this.scheduleToReturn = scheduleToReturn;
        }

        @Override
        public Schedule todaySchedule() {
            return this.scheduleToReturn;
        }

        @Override
        public void organizeMyDay(Schedule schedule) {
            if (schedule.equals(this.scheduleToReturn)) {
                this.organizeMyDayCalls++;
            }
            System.out.println("Organizing my day");
        }

        @Override
        public void continueDay() {
            this.continueDayCalls++;
            System.out.println("Continuing my day");
        }
    }

    private class TestReindeerFeeder implements ReindeerFeeder {

        private int feedReindeersCalls;

        public TestReindeerFeeder() {
        }

        @Override
        public void feedReindeers() {
            this.feedReindeersCalls++;
            System.out.println("Feeding reindeers");
        }
    }
}
