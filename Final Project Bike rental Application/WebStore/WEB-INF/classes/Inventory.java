import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

@WebServlet("/Inventory")
public class Inventory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        displayInventory(request, response, pw);
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter pw = response.getWriter();
//        Utilities utility = new Utilities(request, pw);
//
//
//        HashMap<String, Product> hm = new HashMap<String, Product>();
//        String TOMCAT_HOME = System.getProperty("catalina.home");
//
//        //get the user details from file
//        try {
//            hm = MySqlDataStoreUtilities.selectInventory();
//        } catch (Exception e) {
//
//        }
//    }

    protected void displayInventory(HttpServletRequest request,
                                    HttpServletResponse response, PrintWriter pw)
            throws ServletException, IOException {

        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("LeftNavigationBar.html");

        HashMap<String, Product> productMap = new HashMap<String, Product>();

        //Table of Inventory
        pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<h3 class='title'>");
        pw.print("Table of Bike Inventory");
        pw.print("</h3>");
        pw.print("<div class='entry'>");

        pw.print("<table class='gridtable'>");
        pw.print("<tr>");
        pw.print("<td>Bike/Accessory Name</td>");
        pw.print("<td>Price per day</td>");
        pw.print("<td>Inventory</td>");
        pw.print("</tr>");


        try {
            productMap = MySqlDataStoreUtilities.selectInventory();
        } catch (Exception ignored) {
            pw.print("WRONG!!!");
        }

        for (Product product : productMap.values()) {

            pw.print("<tr>");
            pw.print("<td>" + product.getName() + "</td>" +
                    "<td>" + product.getPrice() + "</td>" +
                    "<td>" + product.getInventory() + "</td>");
            pw.print("</tr>");

        }
        pw.print("</table></div></div>");


        //Bar Chart of Inventory

        //////////<script>
        pw.println("<script type='text/javascript' src=\"https://www.gstatic.com/charts/loader.js\"></script>");
        pw.println("<script type='text/javascript'>");

        // Load the Visualization API and the corechart package.
        pw.println("google.charts.load('current', {'packages':['corechart']});");

        // Set a callback to run when the Google Visualization API is loaded.
        pw.println("google.charts.setOnLoadCallback(drawChart);");

        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.
        pw.println("function drawChart() {");

        // Create the data table.
        pw.println("var data = new google.visualization.DataTable();");
        pw.println("data.addColumn('string', 'Product Name');");
        pw.println("data.addColumn('number', 'Inventory');");
        pw.println(" data.addRows([");
        for (Product product : productMap.values()) {

            pw.println(" ['" + product.getName() + "', " + product.getInventory() + "],");
             /*pw.println(" ['Mushrooms', 3],");
              pw.println("['Onions', 1],");n
            pw.println("  ['Olives', 1],");
            pw.println("  ['Zucchini', 1],");
            pw.println("  ['Pepperoni', 2]  ");*/
        }
        pw.println("]);");
        // Set chart options
        pw.println(" var options = {'title':'Inventory',");
        pw.println("        'width':600,");
        pw.println("       'height':800,lineWidth: 5,vAxis: {title: 'Inventory Name'},hAxis: {title: 'Quantity',maxValue:20}};");

        // Instantiate and draw our chart, passing in some options.
        pw.println(" var chart = new google.visualization.BarChart(document.getElementById('chart_div'));");
        pw.println("  chart.draw(data, options);     }");
        pw.println(" </script>");

        /////////</script>


        pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<h3 class='title'>");
        pw.print("Bar Chart of Inventory");
        pw.print("</h3>");
        pw.print("<div class='entry'>");
        pw.println("<div id='chart_div'></div>");

        pw.print("</div></div>");


        //Table of all products currently on sale
        pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<h3 class='title'>");
        pw.print("Table of all Bikes/Accessories currently available for renting");
        pw.print("</h3>");
        pw.print("<div class='entry'>");

        pw.print("<table class='gridtable'>");
        pw.print("<tr>");
        pw.print("<td>Product Name</td>");
        pw.print("</tr>");

        try {
            productMap = MySqlDataStoreUtilities.selectOnSale();
        } catch (Exception ignored) {
         pw.print("<tr><td>WRONG!!</td></tr>");
        }

        for (Product product : productMap.values()) {
           // pw.print("Hi");
            pw.print("<tr>");
            pw.print("<td> " + product.getName() + "</td>");
            pw.print("</tr>");

        }

        pw.print("</table></div></div>");


        //Table of all products currently that have manufacturer rebates
        pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<h3 class='title'>");
        pw.print("Table of all Bikes/Accessories currently that have manufacturer rebates");
        pw.print("</h3>");
        pw.print("<div class='entry'>");

        pw.print("<table class='gridtable'>");
        pw.print("<tr>");
        pw.print("<td>Product Name</td>");
        pw.print("<td>Rebate</td>");
        pw.print("</tr>");
        try {
            productMap = MySqlDataStoreUtilities.selectRebate();
        } catch (Exception ignored) {

        }

        for (Product product : productMap.values()) {

            pw.print("<tr>");
            pw.print("<td>" + product.getName() + "</td>");
            pw.print("<td>" + product.getDiscount() + "</td>");
            pw.print("</tr>");

        }
        pw.print("</table></div></div>");
    }
}
