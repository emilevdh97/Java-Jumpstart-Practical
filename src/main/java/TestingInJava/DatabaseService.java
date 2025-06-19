package TestingInJava;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DatabaseService implements IDatabaseService {

    //✌️ Database ✌️
    public ArrayList<Log> dailyLog = new ArrayList<>(Arrays.asList(
            // The 2nd of JUNE
            new Log(LocalDateTime.of(2025, 6, 2, 8, 0), "2", "3", 32.00),
            new Log(LocalDateTime.of(2025, 6, 2, 8, 0), "6", "4", 22.00),
            new Log(LocalDateTime.of(2025, 6, 2, 8, 30), "0", "4", 27.54),
            new Log(LocalDateTime.of(2025, 6, 2, 8, 30), "6", "4", 21.01),
            new Log(LocalDateTime.of(2025, 6, 2, 9, 0), "0", "5", 31.32),

            // The 3rd of JUNE
            new Log(LocalDateTime.of(2025, 6, 3, 8, 30), "6", "4", 24.00),
            new Log(LocalDateTime.of(2025, 6, 3, 9, 30), "6", "4", 24.00),
            new Log(LocalDateTime.of(2025, 6, 3, 10, 30), "6", "4", 24.00),

            // The 9th of JUNE
            new Log(LocalDateTime.of(2025, 6, 9, 9, 30), "3", "6", 29.56),
            new Log(LocalDateTime.of(2025, 6, 9, 9, 30), "3", "6", 23.56),
            new Log(LocalDateTime.of(2025, 6, 9, 9, 30), "3", "6", 26.56)
    ));

    @Override
    public void addDailyLog(Log log) {
        dailyLog.addLast(log);
    }

    @Override
    public List<Log> getEnclosureDailyLog(String enclosureId) {
        return dailyLog.stream()
                .filter(log -> log.enclosureId().equals(enclosureId))
                .toList();
    }

    @Override
    public List<Log> getEmployeeDailyLog(String employeeId) {
        return dailyLog.stream()
                .filter(id -> id.enclosureId().equals(employeeId))
                .toList();
    }

    @Override
    public List<Log> getAfterTimeStamp(LocalDateTime timeStampStart) {
        return dailyLog.stream()
                .filter(log -> log.timeStamp().isBefore(timeStampStart))
                .toList();
    }

    //https://www.baeldung.com/java-streams-find-first-match-index
    @Override
    public Optional<Log> updateTimeStamp(String oldEmployeeId,
                                         String newEmployeeId,
                                         String enclosureId,
                                         LocalDateTime timeStamp) {

        var location = dailyLog.stream().takeWhile(log -> log.timeStamp().isEqual(timeStamp) &&
                        log.enclosureId().equals(enclosureId) &&
                        log.StaffId().equals(oldEmployeeId))
                .count();

        var oldLog = dailyLog.get(Math.toIntExact(location));

        if (oldLog.timeStamp().isEqual(timeStamp) &&
                oldLog.StaffId().equals(enclosureId) &&
                oldLog.StaffId().equals(oldEmployeeId)) {

            dailyLog.set(Math.toIntExact(location),
                    new Log(timeStamp, enclosureId, newEmployeeId, oldLog.temperature()));

            return Optional.of(oldLog);
        } else {
            return Optional.empty();
        }
    }

    /**
     * @see <a href=”https://www.baeldung.com/java-use-remove-item-stream">Operating on and Removing an Item from Stream | Baeldung</a>
     */
    @Override
    public Optional<List<Log>> deleteOldLogs(LocalDateTime timeStampStart) {


        var removableItems = dailyLog.stream()
                .filter(log -> log.timeStamp().isBefore(timeStampStart))
                .toList();

        if (removableItems.isEmpty()) {
            return Optional.empty();
        } else {

            dailyLog.removeAll(removableItems);
            return Optional.of(removableItems);
        }
    }


}
