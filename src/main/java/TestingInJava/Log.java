package TestingInJava;

import java.time.LocalDateTime;

public record Log(LocalDateTime timeStamp,
                  String enclosureId,
                  String StaffId,
                  double temperature) {
}

