import tools.MySqlConnection
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.servlet.annotation.WebListener
import javax.servlet.http.HttpSessionAttributeListener
import javax.servlet.http.HttpSessionEvent
import javax.servlet.http.HttpSessionListener
import javax.servlet.http.HttpSessionBindingEvent

@WebListener
class ContextListener : ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    override fun contextInitialized(sce: ServletContextEvent?) {
        println("\u001B[32mCONTEXT INITIALIZED\u001B[0m")
        /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
    }

    override fun contextDestroyed(sce: ServletContextEvent?) {
        MySqlConnection.closeConnection()
        println("\u001B[32mCONTEXT DESTROYED\u001B[0m")

        /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    override fun sessionCreated(se: HttpSessionEvent?) {
        /* Session is created. */
    }

    override fun sessionDestroyed(se: HttpSessionEvent?) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    override fun attributeAdded(sbe: HttpSessionBindingEvent?) {
        /* This method is called when an attribute
         is added to a session.
      */
    }

    override fun attributeRemoved(sbe: HttpSessionBindingEvent?) {
        /* This method is called when an attribute
         is removed from a session.
      */
    }

    override fun attributeReplaced(sbe: HttpSessionBindingEvent?) {
        /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
