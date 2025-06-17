package TestingInJava;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IDatabaseService {

    void addDailyLog(Log log);

    List<Log> getEnclosureDailyLog(String enclosureId);

    List<Log> getEmployeeDailyLog(String enclosureId);

    List<Log> getAfterTimeStamp(LocalDateTime timeStampStart);

    Optional<Log> updateTimeStamp(String oldEmployeeId,
                                  String newEmployeeId,
                                  String enclosureId,
                                  LocalDateTime timeStamp);

    Optional<List<Log>> deleteOldLogs(LocalDateTime timeStampStart);
}
