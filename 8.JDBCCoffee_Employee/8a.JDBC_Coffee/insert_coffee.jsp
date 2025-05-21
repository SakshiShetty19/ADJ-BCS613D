<!--8a. Q1. Read all the existing records from the table coffee which is from the database test and insert a
new coffee product into it [Create a table coffee with fields ( id,coffee_name,price)] using HTML and
JSP to get the fields and display the results respectively-->
  
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Insert Coffee</title></head>
<body>

<h2>Add New Coffee Product</h2>
<form method="post">
    Coffee ID: <input type="text" name="id"><br>
    Coffee Name: <input type="text" name="coffee_name"><br>
    Priced: <input type="text" name="priced"><br>
    <input type="submit" name="action" value="Insert">
</form>

<%
String action = request.getParameter("action");
String id = request.getParameter("id");
String coffeeName = request.getParameter("coffee_name");
String priced = request.getParameter("priced");

Connection conn = null;
PreparedStatement pst = null;
Statement st = null;
ResultSet rs = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

    if ("Insert".equals(action)) {
        String insertSQL = "INSERT INTO coffee (id, coffee_name, priced) VALUES (?, ?, ?)";
        pst = conn.prepareStatement(insertSQL);
        pst.setInt(1, Integer.parseInt(id));
        pst.setString(2, coffeeName);
        pst.setDouble(3, Double.parseDouble(priced));
        pst.executeUpdate();
        out.println("<p style='color:green;'>Coffee inserted successfully.</p>");
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
