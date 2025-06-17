package TestingInJava;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//TODO: uncomment when needed
//@ExtendWith(MockitoExtension.class)
class ReptileEnclosureServiceTest {

    //TODO: 2. Change Junit test to use hamcrest
    //TODO: 3. Get Temperature for enclosure 6 in the same test HINT Try @ParameterisedTest !

    @Test
    @DisplayName("Get Time Stamp for enclosure 0")
    void GetTimeStamp() {

        //GIVEN - Concrete Implementation
        DatabaseService databaseService = new DatabaseService();
        ReptileEnclosureService enclosureService = new ReptileEnclosureService(databaseService);

        //WHEN
        // EG: 2007-12-03T10:15:30
        var result = enclosureService.temperatureChecker("0",
                LocalDateTime.parse("2025-06-02T08:00:00"),
                LocalDateTime.parse("2025-06-02T19:00:00"));

        //THEN
        assertEquals(27.54, result.getFirst());
    }


    //TODO: 4. Register line 45..49 as global mocks
    //         Hint: @Mock - Remember to uncomment the extension ☝️

    //TODO: 5. Change the assert to make the test pass
    //         Hint: look at the slides. Can you find any Asserts that can handel exceptions? 😉
    //               Bonus can you solve it with Hamcrest?
    @Test
    @DisplayName("Update invalid staff, Throws error")
    void SwapEmployeeLog() {

        //GIVEN - with MOCK
        DatabaseService mockDatabaseService = mock(DatabaseService.class);
        ReptileEnclosureService enclosureService = new ReptileEnclosureService(mockDatabaseService);

        //WHEN - Stub
        when(mockDatabaseService.updateTimeStamp("7",
                "5", "0", LocalDateTime.of(2025, 6, 9, 9, 30)))
                .thenReturn(Optional.empty());

        var result = enclosureService.swapEmployeeLog("6",
                "5", "0", LocalDateTime.of(2025, 6, 9, 9, 30));


        verify(mockDatabaseService, times(1)).updateTimeStamp("7",
                "5", "0", LocalDateTime.of(2025, 6, 9, 9, 30));
        //THEN
        assertNull(result);
    }


    //TODO: 7. Use SPY
    //         Hint: Look at Mock
    @Test
    @DisplayName("Staff 1 is able to check in")
    void staffCheckin() {

        //GIVEN with SPY
        DatabaseService databaseService = new DatabaseService();
        //Create Spy here
        ReptileEnclosureService enclosureService = new ReptileEnclosureService(spyDatabaseService);

        enclosureService.staffCheckin("11",
                "0",
                LocalDateTime.parse("2025-06-17T08:00:00"));


        verify(spyDatabaseService)
                .addDailyLog(any(Log.class)); //Note: the generic any()

        assertTrue(spyDatabaseService.dailyLog.getLast().StaffId().equals("11"));

    }


}