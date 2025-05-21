<!-- 9b. Read all the existing records from the table coffee which is from the database test and query
coffee name starting with ‘D’ in the table using HTML and JSP to get the field and display the
results respectively-->
<%@ page import="java.sql.*" %>
<html>
<head><title>Query Coffee Starting With D</title></head>
<body>

<h2>Coffee Products Starting With 'D'</h2>

<%
Connection conn = null;
Statement st = null;
ResultSet rs = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

    String query = "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";
    st = conn.createStatement();
    rs = st.executeQuery(query);

    boolean found = false;
    while (rs.next()) {
        found = true;
%>
        <hr>
        ID: <%= rs.getInt("id") %><br>
        Name: <%= rs.getString("coffee_name") %><br>
        Price: <%= rs.getDouble("priced") %><br>
<%
    }

    if (!found) {
        out.println("<p>No coffee products starting with 'D' found.</p>");
    }

} catch (Exception e) {
    out.println("Error: " + e.getMessage());
} finally {
    if (rs != null) rs.close();
    if (st != null) st.close();
    if (conn != null) conn.close();
}
%>

</body>
</html>
