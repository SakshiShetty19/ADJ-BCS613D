<!--9d. Develop a JDBC project using MySQL to delete the records in the table Emp of the database
Employee by getting the name starting with ‘S’ through keyboard and Generate the report as
follows using HTML and JSP to get the field and display the results respectively -->


<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Employee</title>
</head>
<body>

<%
    String empIdStr = request.getParameter("empId");
    if (empIdStr == null) {
%>
    <form method="get" action="update.jsp">
        <label for="empId">Enter Employee ID to delete:</label>
        <input type="number" name="empId" required />
        <input type="submit" value="Delete" />
    </form>
<%
    } else {
        int empId = Integer.parseInt(empIdStr);
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "";

        Connection conn = null;
        PreparedStatement delStmt = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            String deleteQuery = "DELETE FROM Emp WHERE Emp_NO = ?";
            delStmt = conn.prepareStatement(deleteQuery);
            delStmt.setInt(1, empId);
            int deleted = delStmt.executeUpdate();

            if (deleted > 0) {
%>
                <p>✅ Employee with ID <b><%= empId %></b> deleted successfully.</p>
<%
            } else {
%>
                <p>⚠ No employee found with ID <b><%= empId %></b>.</p>
<%
            }

            String selectQuery = "SELECT * FROM Emp";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectQuery);
%>

    <h2>Salary Report</h2>
    <hr/>
<%
            while (rs.next()) {
%>
        <div style="margin-bottom:10px;">
            <strong>Emp_No:</strong> <%= rs.getInt("Emp_NO") %><br/>
            <strong>Emp_Name:</strong> <%= rs.getString("Emp_Name") %><br/>
            <strong>Basic:</strong> <%= rs.getInt("Basicsalary") %><br/>
            <hr/>
        </div>
<%
            }

        } catch (Exception e) {
%>
            <p style="color:red;">❌ Error: <%= e.getMessage() %></p>
<%
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (delStmt != null) delStmt.close();
            if (conn != null) conn.close();
        }
    }
%>

</body>
</html>

----
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<html>
<body>

<!-- Form to insert employee details -->
<h2>Enter Employee Details</h2>
<form method="post">
  Emp No: <input type="text" name="empno"/><br/>
  Emp Name: <input type="text" name="empname"/><br/>
  Basic Salary: <input type="text" name="salary"/><br/>
  <input type="submit" value="Insert Employee"/>
</form>

<%
    // Insert employee record when form is submitted
    if(request.getParameter("empno") != null) {
        int empno = Integer.parseInt(request.getParameter("empno"));
        String empname = request.getParameter("empname");
        int salary = Integer.parseInt(request.getParameter("salary"));
        
        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            // SQL insert query
            PreparedStatement ps = con.prepareStatement("INSERT INTO Emp (Emp_NO, Emp_Name, Basicsalary) VALUES (?, ?, ?)");
            ps.setInt(1, empno);
            ps.setString(2, empname);
            ps.setInt(3, salary);
            
            // Execute insert query
            int i = ps.executeUpdate();
            if(i > 0) {
                out.println("<h3>Employee inserted successfully.</h3>");
            }
            
            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
%>

<hr>

<!-- Button to generate the salary report -->
<h2>Salary Report for Employees with Name Starting with 'S'</h2>
<form method="get">
    <input type="submit" value="Generate Report"/>
</form>

<%
    // Generate the salary report when the "Generate Report" button is clicked
    if(request.getMethod().equalsIgnoreCase("get")) {
        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            // Query to fetch employees whose name starts with 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Emp WHERE Emp_Name LIKE 'S%'");

            int grandSalary = 0;
            
            out.println("<hr>");
            while(rs.next()) {
                int empno = rs.getInt("Emp_NO");
                String empname = rs.getString("Emp_Name");
                int salary = rs.getInt("Basicsalary");
                
                // Display employee details
                out.println("Emp_No: " + empno + "<br>");
                out.println("Emp_Name: " + empname + "<br>");
                out.println("Basic Salary: " + salary + "<br>");
                out.println("<hr>");
                
                // Calculate grand salary
                grandSalary += salary;
            }
            
            out.println("<h3>Grand Salary: " + grandSalary + "</h3>");
            
            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
%>

</body>
</html>
