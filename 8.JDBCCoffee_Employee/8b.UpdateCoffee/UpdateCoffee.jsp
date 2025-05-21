<!--8b. Read all the existing records from the table coffee which is from the database test and update an
existing coffee product in the table with its id. [Create a table coffee with fields
( id,coffee_name,price)] using HTML and JSP to get the fields and display the results respectively -->
<%@ page import="java.sql.*" %>
<html>
<head><title>Update Coffee</title></head>
<body>

<h2>Update Coffee Product</h2>
<form method="post">
    Coffee ID to Update: <input type="text" name="id"><br>
    New Coffee Name: <input type="text" name="coffee_name"><br>
    New Priced: <input type="text" name="priced"><br>
    <input type="submit" name="action" value="Update">
</form>

<%
String action = request.getParameter("action");
String id = request.getParameter("id");
String name = request.getParameter("coffee_name");
String priced = request.getParameter("priced");

Connection conn = null;
PreparedStatement pst = null;
Statement st = null;
ResultSet rs = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

    if ("Update".equals(action)) {
        String updateSQL = "UPDATE coffee SET coffee_name = ?, priced = ? WHERE id = ?";
        pst = conn.prepareStatement(updateSQL);
        pst.setString(1, name);
        pst.setDouble(2, Double.parseDouble(priced));
        pst.setInt(3, Integer.parseInt(id));
        int updated = pst.executeUpdate();

        if (updated > 0)
            out.println("<p style='color:green;'>Updated successfully.</p>");
        else
            out.println("<p style='color:red;'>No coffee found with ID: " + id + "</p>");
    }

    out.println("<h3>All Coffee Products</h3>");
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
