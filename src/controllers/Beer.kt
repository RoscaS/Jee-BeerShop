package controllers

import models.Beer
import tools.BeerDAO
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "beer", value = ["/beer/*"])
open class Beer : HttpServlet() {

  private val name: String = "Beer"
  private val rootView: String = "/WEB-INF/${name.toLowerCase()}-"

  override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
    if (req.pathInfo == null) {
      list(req, res)
    } else {
      detail(req, res)
    }
  }

  fun list(req: HttpServletRequest, res: HttpServletResponse) {
    val view = buildViewName("list")
    req.setAttribute("title", "$name list")
    req.setAttribute("items", BeerDAO.get())
    servletContext.getRequestDispatcher(view).forward(req, res)

  }

  fun detail(req: HttpServletRequest, res: HttpServletResponse) {
    val view = buildViewName("detail")

    val id = try {
      req.pathInfo.replace("/", "").toInt()
    } catch (e: Exception) {
      res.sendError(404)
      return
    }

    val item: Beer? = BeerDAO.get().find { it.id == id }
    if (item == null) res.sendError(404)

    req.setAttribute("item", item)
    servletContext.getRequestDispatcher(view).forward(req, res)
  }

  private fun buildViewName(type: String): String = "$rootView$type.jsp"

}