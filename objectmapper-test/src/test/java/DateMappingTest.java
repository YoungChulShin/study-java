import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.Instant;
import java.time.LocalDateTime;
import model.Sample;
import model.SampleWithInstantTime;
import model.SampleWithoutLocalDateTime;
import org.junit.jupiter.api.Test;

public class DateMappingTest {

  @Test
  void default_localDateTime_매핑_테스트() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    //{"id":1,"name":"sample","time":[2022,9,17,9,25,7,493779000]}

    Sample sample = new Sample(
        1L,
        "sample",
        LocalDateTime.now()
    );

    String result = objectMapper.writeValueAsString(sample);

    System.out.println(result);
  }

  @Test
  void default_매핑_테스트() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    SampleWithoutLocalDateTime sample = new SampleWithoutLocalDateTime(
        1L,
        "sample"
    );

    String result = objectMapper.writeValueAsString(sample);

    System.out.println(result);
  }

  @Test
  void default_instant_매핑_테스트() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    SampleWithInstantTime sample = new SampleWithInstantTime(
        1L,
        "sample",
        Instant.now()
    );

    String result = objectMapper.writeValueAsString(sample);

    System.out.println(result);
  }
}
