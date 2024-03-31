package parking.time.control.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;

@RedisHash
@Getter
public class ListDateValues {
	long carRegNumber;
	long parkingId;
	List <LocalDateTime> values = new ArrayList<>();
	
	public ListDateValues(long carRegNumber) {
		super();
		this.carRegNumber = carRegNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carRegNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListDateValues other = (ListDateValues) obj;
		return carRegNumber == other.carRegNumber;
	}
	

}
