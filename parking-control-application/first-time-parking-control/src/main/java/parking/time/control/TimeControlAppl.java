package parking.time.control;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;

import parking.time.control.dto.DateValue;
import parking.time.control.service.IDateController;

@SpringBootApplication
public class TimeControlAppl {
	

	@Autowired
	IDateController service;

	@Autowired
	StreamBridge bridge;

	@Value("${app.time.producer.binding.name:timeProducer-out-0}")
	String bindingName;

	public static void main(String[] args) {

		SpringApplication.run(TimeControlAppl.class, args);
	}

	@Bean
	Consumer<DateValue> dateController() {
		return (dateValue) -> {
			Boolean res = service.dateController(dateValue);
			if (res) {
				//DateValue data = new DateValue(dateValue.carRegNumber(), dateValue.parkingId(), dateValue.dateValue());
				bridge.send("timeProducer-out-0", dateValue);
			}

		};

	}

}
