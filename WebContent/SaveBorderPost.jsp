<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="borderPost" class="ee.itcollege.piirivalve.model.BorderPost" scope="session" />
<jsp:setProperty name="borderPost" property="*" />
<c:redirect url="ViewBorderPost.jsp" />