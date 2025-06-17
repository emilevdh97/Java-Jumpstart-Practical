package TestingInJava;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//TODO: 1. Test Navigation

/**
 * TIP: To <b>generate</b> or navigate to a test <b>class press</b> <shortcut actionId="GotoTest"></shortcut>. <br>
 * To navigate to where the code is being used in the <b>specific test</b> select the method name and <b>press</b> <shortcut actionId="GotoDeclaration"></shortcut>.
 */
public class ReptileEnclosureService {

    public IDatabaseService databaseService;

    public ReptileEnclosureService(DatabaseService database) {
        this.databaseService = database;
    }


    //TODO: 2. Change Junit test to use hamcrest
    //TODO: 3. Get Temperature for enclosure 6 in the same test HINT Try @ParameterisedTest !

    /**
     * Get the temperature within the given time
     *
     * @param enclosureId - ID of the enclosure
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


    //TODO: 4. Register line 45..49 as global mocks
    //         Hint: @Mock - Remember to uncomment the extension ☝️

    //TODO: 5. Change the assert to make the test pass
    //         Hint: look at the slides. Can you find any Asserts that can handel exceptions? 😉
    //               Bonus can you solve it with Hamcrest?
    public Log swapEmployeeLog(String oldStaffId,
                               String newStaffId,
                               String EnclosureId,
                               LocalDateTime timeStamp) {
        var updatedValue = databaseService
                .updateTimeStamp(oldStaffId, newStaffId, EnclosureId, timeStamp);
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
     * Delete Logs past a specified date
     *
     * @param timeStampStart
     */
    public void deleteOldLogs(LocalDateTime timeStampStart) {
        databaseService.deleteOldLogs(timeStampStart);
    }

    //TODO: 7.
    public void staffCheckin(String employeeId,
                             String enclosureId,
                             LocalDateTime timeStamp) {

        //Get temperature of enclosure
        double leftLimit = 1D;
        double rightLimit = 10D;
        double temperature = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);

        Log newEntry = new Log(timeStamp, enclosureId, employeeId, temperature);

        databaseService.addDailyLog(newEntry);
    }


}
