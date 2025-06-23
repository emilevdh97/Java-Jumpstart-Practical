package TestingInJava;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO: 6. Run All test Successfully
//         why is only one test passing?
//         Hint: Look at the test lifecycle 🔁

/**
 * Run all tests with the <b>gutter Icon</b> <icon src="AllIcons.RunConfigurations.TestState.Run_run"/> </li>
 * Run <b>individual</b> test with <icon src="AllIcons.RunConfigurations.TestState.Run"/>
 */
@Disabled
class ReptileEnclosureServiceDeleteTest {

    //We only want to create one instance
    static DatabaseService databaseService = new DatabaseService();
    static ReptileEnclosureService enclosureService = new ReptileEnclosureService(databaseService);

    @Test
    @DisplayName("Delete logs before the 9th at 8h00, expected 0 logs left")
    void deleteOldLogs() {
        assertEquals(11, databaseService.dailyLog.size());

        // EG: 2007-12-03T10:15:30
        enclosureService.deleteOldLogs(LocalDateTime.parse("2025-06-10T08:00:00"));

        assertEquals(0, databaseService.dailyLog.size());
    }

    @Test
    @DisplayName("Delete all logs before the 9nd at 8h00, expected 3 logs left")
    void deleteOldLogs2() {
        // EG: 2007-12-03T10:15:30
        enclosureService.deleteOldLogs(LocalDateTime.parse("2025-06-09T08:00:00"));

        assertEquals(3, databaseService.dailyLog.size());
    }
}