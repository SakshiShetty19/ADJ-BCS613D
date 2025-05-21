<!--9d. Develop a JDBC project using MySQL to delete the records in the table Emp of the database
Employee by getting the name starting with ‘S’ through keyboard and Generate the report as
follows using HTML and JSP to get the field and display the results respectively -->


<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Employees Starting with 'S'</title>
</head>
<body>

<h2>Delete Employees by Name Starting Letter</h2>

<%
    String startChar = request.getParameter("startChar");

    if (startChar == null) {
%>
    <form method="get">
        <label>Enter starting letter (e.g., 'S'):</label>
        <input type="text" name="startChar" maxlength="1" required />
        <input type="submit" value="Delete Employees" />
    </form>
<%
    } else {
        Connection conn = null;
        PreparedStatement deleteStmt = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

            String deleteQuery = "DELETE FROM Emp WHERE Emp_Name LIKE ?";
            deleteStmt = conn.prepareStatement(deleteQuery);
            deleteStmt.setString(1, startChar + "%");
            int deleted = deleteStmt.executeUpdate();
%>
            <p style="color:green;">✅ Deleted <%= deleted %> employee(s) whose names start with '<%= startChar %>'.</p>
<%
            // Display remaining employees
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Emp");

            int total = 0;
%>
    <h2>Remaining Employees Report</h2>
    <hr/>
<%
            while (rs.next()) {
                int id = rs.getInt("Emp_NO");
                String name = rs.getString("Emp_Name");
                int basic = rs.getInt("Basicsalary");
                total += basic;
%>
    <strong>Emp_No:</strong> <%= id %><br/>
    <strong>Emp_Name:</strong> <%= name %><br/>
    <strong>Basic:</strong> <%= basic %><br/>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
<%
            }
%>
    <strong>Grand Salary: </strong><%= total %><br/>
<%
        } catch (Exception e) {
%>
    <p style="color:red;">❌ Error: <%= e.getMessage() %></p>
<%
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (deleteStmt != null) deleteStmt.close();
            if (conn != null) conn.close();
        }
    }
%>

</body>
</html>
