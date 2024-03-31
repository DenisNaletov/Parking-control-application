package parking.time.control.dto;

import java.time.LocalDateTime;

public record DateValue(long carRegNumber, long parkingId, LocalDateTime dateValue) {

}
