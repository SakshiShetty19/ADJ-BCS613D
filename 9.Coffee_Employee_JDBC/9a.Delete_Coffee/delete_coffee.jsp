<!--9a. Read all the existing records from the table coffee which is from the database test and delete
an existing coffee product from the table with its id and display the rest of the records using
HTML and JSP to get the field and display the results respectively -->
<%@ page import="java.sql.*" %>
<html>
<head><title>Delete Coffee</title></head>
<body>

<h2>Delete Coffee Product</h2>
<form method="post">
    Enter Coffee ID to Delete: <input type="text" name="id"><br>
    <input type="submit" name="action" value="Delete">
</form>

<%
String action = request.getParameter("action");
String id = request.getParameter("id");

Connection conn = null;
PreparedStatement pst = null;
Statement st = null;
ResultSet rs = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

    if ("Delete".equals(action)) {
        String deleteSQL = "DELETE FROM coffee WHERE id = ?";
        pst = conn.prepareStatement(deleteSQL);
        pst.setInt(1, Integer.parseInt(id));
        int rows = pst.executeUpdate();

        if (rows > 0)
            out.println("<p style='color:green;'>Deleted coffee with ID: " + id + "</p>");
        else
            out.println("<p style='color:red;'>No record found for ID: " + id + "</p>");
    }

    out.println("<h3>Remaining Coffee Products</h3>");
    st = conn.createStatement();
    rs = st.executeQuery("SELECT * FROM coffee");

    while (rs.next()) {
        out.println("<hr>ID: " + rs.getInt("id") + "<br>");
        out.println("Name: " + rs.getString("coffee_name") + "<br>");
        out.println("Price: " + rs.getDouble("priced") + "<br>");
    }
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
} finally {
    if (rs != null) rs.close();
    if (pst != null) pst.close();
    if (st != null) st.close();
    if (conn != null) conn.close();
}
%>

</body>
</html>
