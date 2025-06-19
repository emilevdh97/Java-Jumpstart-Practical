package TestingInJava;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//TODO: ✅ 1. Test Navigation

/**
 * TIP: To <b>generate</b> or navigate to a test <b>class press</b> <shortcut actionId="GotoTest"></shortcut>. <br>
 * To navigate to where the code is being used in the <b>specific test</b> select the method name and <b>press</b> <shortcut actionId="GotoDeclaration"></shortcut>.
 */
public class ReptileEnclosureService {

    public IDatabaseService databaseService;

    public ReptileEnclosureService(DatabaseService database) {
        this.databaseService = database;
    }


    //TODO: ✅ 2. Change Junit test to use hamcrest
    //TODO: ✅ 3. Test ALL Temperatures for enclosure 3 in the same test
    //         HINT Try @ParameterisedTest ! Temperatures are 29.56, 23.56, 26.56

    /**
     * Get the temperature within the given time
     *
     * @param enclosureId ID of the enclosure
     * @param timeStampStart start of the interval
     * @param timeStampEnd end of the interval
     * @return temperatureLog - Logs of the temperature
     */
    public List<Double> temperatureChecker(String enclosureId,
                                           LocalDateTime timeStampStart,
                                           LocalDateTime timeStampEnd) {
        return databaseService.getEnclosureDailyLog(enclosureId).stream()
                .filter(log ->
                        log.timeStamp().isAfter(timeStampStart) && log.timeStamp().isBefore(timeStampEnd)
                )
                .map(Log::temperature)
                .collect(Collectors.toList());
    }


    //TODO: ✅ 4. Register mockDatabaseService as a global mocks
    //         Hint: @Mock - Remember to uncomment the extension ☝️
    //               Bonus - Use @InjectMock()

    //TODO: ✅ 5. Change the assert to make the test pass
    //         Hint: Look at the test result
    //               Bonus - can you solve it with Hamcrest?

    /**
     * In the event that a staff member unexpectedly changes shifts after checking in </br>
     * Shifts can be updated with this method
     *
     * @param oldStaffId staff member whose shift must be swapped
     * @param newStaffId new staff member taking over shift
     * @param enclosureId id of the enclosure to be covered in the shift
     * @param timeStamp timestamp of the shift to be updated
     * @return old log that has been updated
     */
    public Log swapStaffLog(String oldStaffId,
                               String newStaffId,
                               String enclosureId,
                               LocalDateTime timeStamp) {
        var updatedValue = databaseService
                .updateTimeStamp(oldStaffId, newStaffId, enclosureId, timeStamp);
        if (updatedValue.isPresent()) {
            return updatedValue.get();
        } else {
            throw new RuntimeException("Time stamp does not exist");
        }
    }


    //TODO: 6. Run All test Successfully
    //         why is only one test passing?
    //         Hint: Look at the test lifecycle 🔁

    /**
     * Delete Logs before a specified date </br>
     * e.g. <code> 2025-06-02T08:00:00</code> will delete all logs before the 2nd of July at 8 am
     *
     * @param timeStampStart - time stamp of when to delete from
     */
    public void deleteOldLogs(LocalDateTime timeStampStart) {
        databaseService.deleteOldLogs(timeStampStart);
    }



    //TODO: 7. Create a SPY for databaseService called "spyDatabaseService" (Can be in line)
    //         Hint: Look at Mock

    /**
     * Checks in the staff member to the enclosure
     *  <li>logs the time of checkin and temperature of reptile enclosure </li>
     *
     * @param staffId id of the staff member checking in
     * @param enclosureId id of the enclosure the staff member enters
     * @param timeStamp time of checkin
     */
    public void staffCheckin(String staffId,
                             String enclosureId,
                             LocalDateTime timeStamp) {

        //Get temperature of enclosure
        double leftLimit = 1D;
        double rightLimit = 10D;
        double temperature = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);

        Log newEntry = new Log(timeStamp, enclosureId, staffId, temperature);

        databaseService.addDailyLog(newEntry);
    }


}
