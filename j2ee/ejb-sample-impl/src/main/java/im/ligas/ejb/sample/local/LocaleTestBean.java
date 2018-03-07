/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package im.ligas.ejb.sample.local;

import im.ligas.ejb.sample.dto.DataDto;
import org.jboss.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.time.LocalDateTime;

@Stateless
@LocalBean
public class LocaleTestBean {
    private static Logger log = Logger.getLogger(LocaleTestBean.class.getName());
    private static final String HELLO_FROM_THE_EJB = "Hello from the EJB";

    {
        log.info("LocaleTestBean initialised");
    }

    public String getMessage() {
        log.info("getMessage invoked");

        LocalDateTime localDateTime = LocalDateTime.now();
        return String.format(HELLO_FROM_THE_EJB + ". Generated at: %s", localDateTime);
    }

    public DataDto getData() {
        log.info("getData invoked");
        DataDto data = new DataDto();
        data.setTimestamp(LocalDateTime.now());
        data.setMessage(HELLO_FROM_THE_EJB);
        return data;
    }
}
