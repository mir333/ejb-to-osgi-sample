package im.ligas.ejb.sample.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DataDto implements Serializable {
    private LocalDateTime timestamp;
    private String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
