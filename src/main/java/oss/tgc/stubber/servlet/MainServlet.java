package oss.tgc.stubber.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import oss.tgc.stubber.dao.StubDao;
import oss.tgc.stubber.model.Constants;
import oss.tgc.stubber.model.StubInstance;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by rajeevguru on 01/07/15.
 */
public class MainServlet extends HttpServlet {


@Autowired
    StubDao stubDao;



     @Override public void service(HttpServletRequest request, HttpServletResponse response) {



         try {



             List<StubInstance> stubs = stubDao.search(request.getMethod(), request.getPathInfo());

             if (stubs != null && stubs.size() > 0) {
                 response.getWriter().print(stubs.get(0).getResponse());
                 String responeHeaders = stubs.get(0).getResponseHeaders();
                 if (responeHeaders!=null && responeHeaders.trim().length()>0){

                     String[] responeHeadersList = responeHeaders.split(Constants.SEPERATOR);
                     for (int i =0 ; i< responeHeadersList.length; i++){
                         String[] header = responeHeadersList[i].split(":");
                         response.setHeader(header[0],header[1]);
                     }

                 }



             }
             else
             {
                 response.sendError(404);
             }


         } catch (IOException e) {
             e.printStackTrace();
         }

     }


    public void init(ServletConfig config) {
        try {
            super.init(config);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }
}
