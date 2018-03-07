package im.ligas.ejb.sample.portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import im.ligas.ejb.sample.dto.DataDto;
import im.ligas.ejb.sample.portlet.constants.EjbTestPortletKeys;
import im.ligas.ejb.sample.remote.TestBean;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import javax.naming.InitialContext;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author ligasm
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=EJB Test Portlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + EjbTestPortletKeys.EjbTest,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class EjbTestPortlet extends MVCPortlet {

    private static Log LOG = LogFactoryUtil.getLog(EjbTestPortlet.class);

    private TestBean testBean;


    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        DataDto data = testBean.getData();
        renderRequest.setAttribute("message", String.format("%s timestamp: %s", data.getMessage(), data.getTimestamp()));
        renderRequest.setAttribute("remoteMessage", testBean.getMessage());
        super.doView(renderRequest, renderResponse);
    }

    @Activate
    public void activate() {
        try {
            InitialContext ctx = new InitialContext();
            testBean = (TestBean) ctx.lookup("java:global/ejb-sample/ejb-sample-impl/TestBeanImpl!im.ligas.ejb.sample.remote.TestBean");
            LOG.info(testBean);
        } catch (Exception e) {
            LOG.error(e.getLocalizedMessage());
        }
    }


}
