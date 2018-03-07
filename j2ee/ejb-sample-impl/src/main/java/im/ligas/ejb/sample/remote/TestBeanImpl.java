/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package im.ligas.ejb.sample.remote;

import im.ligas.ejb.sample.dto.DataDto;
import im.ligas.ejb.sample.local.LocaleTestBean;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * @author martin
 */
@Stateless
@Remote
public class TestBeanImpl implements TestBean, Serializable {

    @EJB
    private LocaleTestBean localeTestBean;

    @Override
    public DataDto getData() {
        return localeTestBean.getData();
    }

    @Override
    public String getMessage() {
        return localeTestBean.getMessage();
    }
}
