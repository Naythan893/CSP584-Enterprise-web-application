/Your API/import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Downtown")

public class Downtown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String name = null;
		String CategoryName = request.getParameter("name");
		HashMap<String, VR> hm = new HashMap<String, VR>();

		// hm.putAll(SaxParserDataStore.vrs);
		// 	name = "";
		if(CategoryName==null)
		{
			hm.putAll(SaxParserDataStore.vrs);
			name = "";
		}
		else
		{

		}

		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content' style='color:black;font-family: 'Trebuchet MS', Helvetica, sans-serif;'><div class='post'><h2 class='title'>Welcome to Bike2Go</h2>");

		//utility.printHtml("Maps.html");
		pw.print("<script>");
		pw.print("function myMap() {");
		pw.print("var uluru = {lat: 41.8403, lng: -87.6137};");
		pw.print("var map = new google.maps.Map(");
		pw.print("document.getElementById('googleMap'), {zoom: 6, center: uluru});");
		pw.print("var locations = [");
		pw.print("['Downtown', 41.8757, -87.6243],");
		pw.print("['Indiana', 39.7689, -86.1599],");
		pw.print("['Aurora', 41.7590, -88.3159],");
		pw.print("  ];");
		pw.print("var infowindow =  new google.maps.InfoWindow({});");
		pw.print("var marker, count;");
		pw.print("	for (count = 0; count < locations.length; count++) {");
		pw.print("marker = new google.maps.Marker({");
		pw.print("  position: new google.maps.LatLng(locations[count][1], locations[count][2]),");
		pw.print("  map: map,");
		pw.print("title: locations[count][0]");
		pw.print("});");
		pw.print("google.maps.event.addListener(marker, 'click', (function (marker, count) {");
		pw.print("return function () {");
		pw.print("infowindow.setContent(locations[count][0]);");
		pw.print("infowindow.open(map, marker);");
		pw.print("}");
		pw.print("})(marker, count));");
		pw.print("}");
		pw.print("}");





		pw.print("</script>");
		pw.print("<script async defer src='https://maps.googleapis.com/maps/api/js?key=/Your API/s&callback=myMap'></script>");
		pw.print("<div class='entry'>"
				+ "<div id='googleMap' style='width:100%;height:400px;'></div></div>"
				//+ "<tr><td><input type='submit' class='btnbuy' name='button' value='Trending' style = 'font-size:50px'></input>"
			//	+ "</td></tr></table>"
				 + "</div></div>");
		pw.print("</div></div>");
		utility.printHtml("Footer.html");

	}

}
