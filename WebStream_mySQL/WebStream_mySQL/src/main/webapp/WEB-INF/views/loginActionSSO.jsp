<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*"%>
	<%@ page import="java.util.*"%>
	<%@ page import="java.text.*"%>

	<%@ page import="com.federal.checklist.loginsso.LeadGen"%>
	<%@ page import="com.federal.checklist.loginsso.Lgdao"%>


	<%
		LeadGen cb = new LeadGen();
		String uname = "";
		uname = "Anoop Krishna";
		try {
			//uname = request.getHeader("iv-user");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("uname is " + uname);
	%>

	<%


	//	cb = Lgdao.getLogin(uname);
		System.out.println("cb is " + cb);

		String rslt = cb.getBool();
		System.out.println("rslt is " + rslt);

		String eName = cb.getEname();
		System.out.println("eName is " + eName);

		String department = cb.getBranch();
		System.out.println("department is " + department);

		String designation = cb.getBcode();
		System.out.println("designation is " + designation);

		int sol = cb.getSolid();
		System.out.println("sol is " + sol);

		String solid = sol + "";
		String brName = cb.getBranch();
		System.out.println("brName is " + brName);



		int pfno = cb.getPf();
		System.out.println("pfno is " + pfno);

		String brCode = cb.getBcode();
		System.out.println("brCode is " + uname);

		/* session.setAttribute("username", uname); */
		//  session.setAttribute("solid", solid);
		//  session.setAttribute("code", brCode);
		//  session.setAttribute("userType", "User");
		//  session.setAttribute("brName", brName);
		//session.setAttribute("userid", pfno);
		//session.setAttribute("userid", "sreejithv");    //sreejithv

		//try{
		//if(rslt.equals("SUCCESS")){ Branch Code
		session.setAttribute("eName", eName);
		session.setAttribute("department", department);
		session.setAttribute("designation", designation);
		//String brCode=Lgdao.getRemote(uname);
		//request.setAttribute("theList", null);
		//response.sendRedirect("../index.jsp");
		request.getRequestDispatcher("checklist.jsp").include(request, response);
		//}
		//else{
		//response.sendRedirect("Login.jsp?error=Invalid Username and Password");

		// }
		//}catch(Exception e){
		//response.sendRedirect("Login.jsp?error=Webservice Not Working.. Contact System Admin");
		//}
	%>
</body>
</html>