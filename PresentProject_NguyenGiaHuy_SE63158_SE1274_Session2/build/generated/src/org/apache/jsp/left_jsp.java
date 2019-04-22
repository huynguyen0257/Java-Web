package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_var_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_param_value_name_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_var_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_var_value.release();
    _jspx_tagPool_c_param_value_name_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"http://demos.creative-tim.com/material-dashboard-pro/assets/img/apple-icon.png\" />\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"http://demos.creative-tim.com/material-dashboard-pro/assets/img/favicon.png\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("        <title>Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template</title>\n");
      out.write("        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\" />\n");
      out.write("        <!-- Canonical SEO -->\n");
      out.write("        <link rel=\"canonical\" href=\"https://www.creative-tim.com/product/material-dashboard-pro\" />\n");
      out.write("        <!--  Social tags      -->\n");
      out.write("        <meta name=\"keywords\" content=\"material dashboard, bootstrap material admin, bootstrap material dashboard, material design admin, material design, creative tim, html dashboard, html css dashboard, web dashboard, freebie, free bootstrap dashboard, css3 dashboard, bootstrap admin, bootstrap dashboard, frontend, responsive bootstrap dashboard, premiu material design admin\">\n");
      out.write("        <meta name=\"description\" content=\"Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.\">\n");
      out.write("        <!-- Schema.org markup for Google+ -->\n");
      out.write("        <meta itemprop=\"name\" content=\"Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template\">\n");
      out.write("        <meta itemprop=\"description\" content=\"Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.\">\n");
      out.write("        <meta itemprop=\"image\" content=\"http://s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg\">\n");
      out.write("        <!-- Twitter Card data -->\n");
      out.write("        <meta name=\"twitter:card\" content=\"summary_large_image\">\n");
      out.write("        <meta name=\"twitter:site\" content=\"@creativetim\">\n");
      out.write("        <meta name=\"twitter:title\" content=\"Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template\">\n");
      out.write("        <meta name=\"twitter:description\" content=\"Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.\">\n");
      out.write("        <meta name=\"twitter:creator\" content=\"@creativetim\">\n");
      out.write("        <meta name=\"twitter:image\" content=\"http://s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg\">\n");
      out.write("        <!-- Open Graph data -->\n");
      out.write("        <meta property=\"fb:app_id\" content=\"655968634437471\">\n");
      out.write("        <meta property=\"og:title\" content=\"Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template\" />\n");
      out.write("        <meta property=\"og:type\" content=\"article\" />\n");
      out.write("        <meta property=\"og:url\" content=\"http://www.creative-tim.com/product/material-dashboard-pro\" />\n");
      out.write("        <meta property=\"og:image\" content=\"http://s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg\" />\n");
      out.write("        <meta property=\"og:description\" content=\"Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.\" />\n");
      out.write("        <meta property=\"og:site_name\" content=\"Creative Tim\" />\n");
      out.write("        <!-- Bootstrap core CSS     -->\n");
      out.write("        <link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("        <!--  Material Dashboard CSS    -->\n");
      out.write("        <link href=\"assets/css/material-dashboard.css\" rel=\"stylesheet\" />\n");
      out.write("        <!--  CSS for Demo Purpose, don't include it in your project     -->\n");
      out.write("        <link href=\"assets/css/demo.css\" rel=\"stylesheet\" />\n");
      out.write("        <!--     Fonts and icons     -->\n");
      out.write("        <link href=\"http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons\" />\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <div class=\"sidebar\" data-active-color=\"rose\" data-background-color=\"black\" data-image=\"assets/img/sidebar-1.jpg\">\n");
      out.write("                <!--\n");
      out.write("            Tip 1: You can change the color of active element of the sidebar using: data-active-color=\"purple | blue | green | orange | red | rose\"\n");
      out.write("            Tip 2: you can also add an image using data-image tag\n");
      out.write("            Tip 3: you can change the color of the sidebar with data-background-color=\"white | black\"\n");
      out.write("                -->\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"http://www.creative-tim.com\" class=\"simple-text\">\n");
      out.write("                        Creative Tim\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"logo logo-mini\">\n");
      out.write("                    <a href=\"http://www.creative-tim.com\" class=\"simple-text\">\n");
      out.write("                        Ct\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"sidebar-wrapper\">\n");
      out.write("                    <div class=\"user\">\n");
      out.write("                        <div class=\"photo\">\n");
      out.write("                            <img src=\"assets/img/faces/avatar.jpg\" />\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"info\">\n");
      out.write("                            <a data-toggle=\"collapse\" href=\"dashboard.html#collapseExample\" class=\"collapsed\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.fullname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                <b class=\"caret\"></b>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"collapse\" id=\"collapseExample\">\n");
      out.write("                                <ul class=\"nav\">\n");
      out.write("                                    <li>\n");
      out.write("                                        ");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Profile}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">My Profile</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    ");
      if (_jspx_meth_c_url_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Logout}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Logout</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <ul class=\"nav\">\n");
      out.write("                        <li class=\"active\">\n");
      out.write("                            <a href=\"manageEvent.jsp\">\n");
      out.write("                                <i class=\"material-icons\">Event</i>\n");
      out.write("                                <p>Event</p>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"manageUser.jsp\">\n");
      out.write("                                <i class=\"material-icons\">User</i>\n");
      out.write("                                <p>User</p>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"manageReward.jsp\">\n");
      out.write("                                <i class=\"material-icons\">Reward</i>\n");
      out.write("                                <p>Reward</p>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"calendar.html\">\n");
      out.write("                                <i class=\"material-icons\">date_range</i>\n");
      out.write("                                <p>Calendar</p>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("LeftMainController");
    _jspx_th_c_url_0.setVar("Profile");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_url_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                                            ");
        if (_jspx_meth_c_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                        ");
        int evalDoAfterBody = _jspx_th_c_url_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_0 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_0.setPageContext(_jspx_page_context);
    _jspx_th_c_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_0.setName("action");
    _jspx_th_c_param_0.setValue("Profile");
    int _jspx_eval_c_param_0 = _jspx_th_c_param_0.doStartTag();
    if (_jspx_th_c_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
    return false;
  }

  private boolean _jspx_meth_c_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent(null);
    _jspx_th_c_url_1.setValue("LeftMainController");
    _jspx_th_c_url_1.setVar("Logout");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_url_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_1.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                                        ");
        if (_jspx_meth_c_param_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_url_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_c_param_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_1 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_1.setPageContext(_jspx_page_context);
    _jspx_th_c_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_1);
    _jspx_th_c_param_1.setName("action");
    _jspx_th_c_param_1.setValue("Logout");
    int _jspx_eval_c_param_1 = _jspx_th_c_param_1.doStartTag();
    if (_jspx_th_c_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
    return false;
  }
}
