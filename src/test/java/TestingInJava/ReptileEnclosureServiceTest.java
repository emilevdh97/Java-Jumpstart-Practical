package TestingInJava;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

//TODO: ✅ Uncomment when needed
@ExtendWith(MockitoExtension.class)
class ReptileEnclosureServiceTest {

    @Mock
    DatabaseService mockDatabaseService;
    @InjectMocks
    ReptileEnclosureService enclosureService;

    //TODO: ✅ 2. Change Junit test to use hamcrest
    @Test
    @DisplayName("Get temperature for first enclosure")
    void getTemperature() {

        //GIVEN - Concrete Implementation
        DatabaseService databaseService = new DatabaseService();
        ReptileEnclosureService enclosureService = new ReptileEnclosureService(databaseService);

        //WHEN
        // EG: 2007-12-03T10:15:30
        var result = enclosureService.temperatureChecker("0",
                LocalDateTime.parse("2025-06-02T08:00:00"),
                LocalDateTime.parse("2025-06-02T19:00:00"));

        //THEN
        assertThat(result.getFirst(), is(27.54));

    }

    //TODO: ✅ 3. Test ALL Temperatures for enclosure 3 in the same test
    //         HINT Try @ParameterisedTest ! Temperatures are 29.56, 23.56, 26.56
    @ParameterizedTest
    @ValueSource(doubles = {29.56, 23.56, 26.56})
    @DisplayName("Get Temperatures for enclosure 3")
    void getTemperatures(double temperature) {

        //GIVEN - Concrete Implementation
        DatabaseService databaseService = new DatabaseService();
        ReptileEnclosureService enclosureService = new ReptileEnclosureService(databaseService);

        //WHEN
        // EG: 2007-12-03T10:15:30
        var result = enclosureService.temperatureChecker("3",
                LocalDateTime.parse("2025-06-02T08:00:00"),
                LocalDateTime.parse("2025-06-09T19:00:00"));

        //THEN
        //Hint: change "Matcher" value
        assertThat(result, hasItem(temperature));
    }

    //TODO: ✅ 4. Register mockDatabaseService as a global mocks
    //         Hint: @Mock - Remember to uncomment the extension ☝️
    //               Bonus - Use @InjectMock()

    //TODO: ✅ 5. Change the assert to make the test pass
    //         Hint: Look at the test result
    //               Bonus - can you solve it with Hamcrest?
    @Test
    @DisplayName("Update invalid staff, Throws error")
    void swapStaffLog() {

        //GIVEN - with MOCK
     /*
        DatabaseService mockDatabaseService = mock(DatabaseService.class);
        ReptileEnclosureService enclosureService = new ReptileEnclosureService(mockDatabaseService);
     */

        //WHEN - STUB
        when(mockDatabaseService
                .updateTimeStamp("7",
                        "5",
                        "0",
                        LocalDateTime.of(2025, 6, 9, 9, 30))
        ).thenReturn(Optional.empty());

        //Assert that an exception has been thrown!
        var result = assertThrows(RuntimeException.class, () ->
                enclosureService
                        .swapStaffLog("7",
                                "5",
                                "0",
                                LocalDateTime.of(2025, 6, 9, 9, 30)
                        ));


        verify(mockDatabaseService, times(1))
                .updateTimeStamp("7",
                        "5",
                        "0",
                        LocalDateTime.of(2025, 6, 9, 9, 30));
        //THEN
        assertThat(result.getMessage(), is("Time stamp does not exist"));
    }


    //TODO: ✅ 7. Create a SPY for databaseService called "spyDatabaseService" (Can be in line)
    //         Hint: Look at Mock
    @Test
    @DisplayName("Staff member with ID 11 is able to check in")
    void staffCheckin() {

        //GIVEN with SPY
        DatabaseService databaseService = new DatabaseService();
        //Create Spy here then uncomment code
        DatabaseService spyDatabaseService = spy(databaseService);

        // == UNCOMMENT ==
        ReptileEnclosureService enclosureService = new ReptileEnclosureService(spyDatabaseService);

        enclosureService.staffCheckin("11",
                "0",
                LocalDateTime.parse("2025-06-17T08:00:00"));


        verify(spyDatabaseService)
                .addDailyLog(any(Log.class)); //Note: the generic any()

        assertThat(spyDatabaseService.dailyLog.getLast().StaffId(), is("11"));

        // == END_UNCOMMENT ==

    }


}