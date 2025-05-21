<!-- 9c. Develop a JDBC project using MySQL to append the fields empno, empname and basicsalary
into the table Emp of the database Employee by getting the fields through keyboard and Generate
the report as follows for the table Emp (Emp_NO , Emp_Name, Basicsalary ) using HTML and JSP
to get the field and display the results respectively -->
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Insert Employee</title></head>
<body>

<h2>Insert New Employee</h2>
<form method="post">
    Emp No: <input type="text" name="empno"><br>
    Emp Name: <input type="text" name="empname"><br>
    Basic Salary: <input type="text" name="basicsalary"><br>
    <input type="submit" name="action" value="Insert">
</form>

<%
String action = request.getParameter("action");

Connection conn = null;
PreparedStatement pst = null;
Statement st = null;
ResultSet rs = null;
int totalSalary = 0;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost/Employee", "root", "");

    if ("Insert".equals(action)) {
        String empno = request.getParameter("empno");
        String empname = request.getParameter("empname");
        String basicsalary = request.getParameter("basicsalary");

        if (empno != null && empname != null && basicsalary != null &&
            !empno.isEmpty() && !empname.isEmpty() && !basicsalary.isEmpty()) {

            String insertQuery = "INSERT INTO Emp (Emp_NO, Emp_Name, Basicsalary) VALUES (?, ?, ?)";
            pst = conn.prepareStatement(insertQuery);
            pst.setInt(1, Integer.parseInt(empno));
            pst.setString(2, empname);
            pst.setInt(3, Integer.parseInt(basicsalary));
            int rows = pst.executeUpdate();

            if (rows > 0) {
                out.println("<p style='color:green;'>Record inserted successfully!</p>");
            } else {
                out.println("<p style='color:red;'>Failed to insert record.</p>");
            }
        } else {
            out.println("<p style='color:red;'>Please fill in all fields.</p>");
        }
    }

    // Show salary report
    out.println("<h2>Employee Salary Report</h2>");
    st = conn.createStatement();
    rs = st.executeQuery("SELECT * FROM Emp");

    while (rs.next()) {
        int id = rs.getInt("Emp_NO");
        String name = rs.getString("Emp_Name");
        int salary = rs.getInt("Basicsalary");
        totalSalary += salary;
%>
    <hr>
    Emp_No: <%= id %><br>
    Emp_Name: <%= name %><br>
    Basic Salary: <%= salary %><br>
<%
    }
    out.println("<hr><b>Grand Salary Total: " + totalSalary + "</b><hr>");

} catch (Exception e) {
    out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
} finally {
    if (rs != null) rs.close();
    if (pst != null) pst.close();
    if (st != null) st.close();
    if (conn != null) conn.close();
}
%>

</body>
</html>
