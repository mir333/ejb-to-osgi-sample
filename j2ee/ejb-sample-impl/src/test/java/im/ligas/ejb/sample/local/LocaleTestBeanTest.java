package im.ligas.ejb.sample.local;

import im.ligas.ejb.sample.dto.DataDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class LocaleTestBeanTest {

    private LocaleTestBean testBean = new LocaleTestBean();

    @Test
    void testGetMessage() {
        String result = testBean.getMessage();

        Assertions.assertThat(result)
                .isNotBlank()
                .startsWith("Hello from the EJB");
    }

    @Test
    void testGetData() {
        DataDto result = testBean.getData();

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getMessage())
                .isNotNull()
                .isSameAs("Hello from the EJB");

        Assertions.assertThat(result.getTimestamp())
                .isNotNull()
                .isEqualToIgnoringMinutes(LocalDateTime.now());

    }
}
