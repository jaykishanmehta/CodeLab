package com.code.practice.timepass.adanimarathon.result;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * 
 * 
create table marathon_data (
	id int(11) not null auto_increment primary key,
	bibno int(11) not null default 0,
	race_cat varchar(50),
	name varchar(500),
	runTime varchar(20),
	location_det varchar(100),
	rank_overall varchar(100),
	rank_gender varchar(100),
	rank_location varchar(100),
	time_first varchar(20), 
	time_second varchar(20), 
	time_final varchar(20)
);
 * 
 * 
 * @author jaykishanm
 *
 */
public class grabber {

	public static void main(String[] args) {

		//int bibNo = 11694;
		int[] bibNo = {11694, 11695};
		String response = null;
		try {
			
			for (int i = 10100; i < 10300; i++) {
				//int bib = bibNo[i];
				int bib = i;
				response = retrieveDataforBIB(bib);				
				parseResponse("<html><body>" + response + "</body></html>", bib);
			}
			
			/*response = "<script type=\"text/javascript\">  $(document).ready(function(){  	$('.carousel').carousel(); });</script>				<div class='container padding-right no-padding-table-result1 padding-right' >				<div class='row'>				  <div class='container'>					  <div class='col-md-4 text-center banner-mobile-padding1' style='padding-top: 2%;'>					  	<img src='/uploads/results_banner/F84538A31BB6D64025F4.jpg' id='banner' class='result-banner-border img-responsive responsive-img'>				  	  </div>					<div class='col-md-8 result-background first-table padding-right full-width-table'>					  <div class='box-shadow-result margin_left'>						<h3 class='txt-color text-center h3_race_name'>Adani Ahmedabad Marathon 2018</h3>						<h5 class='text-center race_name_margin individual-race-date'>November 25, 2018</h5>						<div class='border-btmmmm half-tbl2'>						</div>						<h3 class='txt-color text-center h3_race_name padding-left'>Race Category - 10 Km</h3>					</div></div>				</div>			</div>				 <div class='col-md-4 text-center full-width-table'>				<div class='result-background box-shadow-result text-center padding-right short-name relative-position' style='margin-top:10px;margin-bottom:10%; respos'>      						  	<span class='txt-color name-font'>JM</span><br>				           <h3 class='txt-color img-padding'>Jaykishan Mehta</h3>						<span style='border-bottom:2px solid #d1d2d4; margin-bottom:2%;font-size:18px;'>BIB</span>				           <h3 class='txt-color bibtxt'>11694</h3>				           </div>						<div class='col-md-12 text-center full-width-table full-width-table2'>	<tr>												<button onclick='sharedata(45999)' name='share' id='share' class='vieww pm-rounded-btn btun-marg share-btn border-btmm text-center share-btn-bottom dld-hr nomar icone-padding' style='margin-bottom: 22px!important;font-size: 12px!important;'><i class='fa fa-share-alt'></i>Share Your Result</button>												<div class='row social-icon-row box-shadow-result' style='margin-left:0!important;margin-right:0!important;display:none;' id='hide-default'>							<div class='col-md-12'>								<div class='col-md-3 col-xs-3 col-md-offsett'>								<a href='' id='fbLink' target='_blank'><img id='fblogo' src='img/facebook_new.png' width='55px' class='' title='Share on Facebook' height='55px' style='display: none; margin: 0em 0em;'></a>								</div>								<div class='col-md-3 col-xs-3'>								<a href='' id='twitterLink' target='_blank'><img id='twitterlogo' src='img/twitter_new.png' width='55px' class='' title='Share on Twitter' height='55px' style='display: none; margin: 0em 0em;'></a>								</div>								<div class='col-md-3 col-xs-3'>								<a href='' id='mysharelink' target='_blank'><img id='sharelink' src='img/share_new.png' width='55px' class='' title='Share Link' height='55px' style='display: none;'></a>								</div>								<div class='col-md-3 col-xs-3 hide-desk'>								<a href='' id='whatsappLink' target='_blank'><img id='whatsapp' src='img/whatsapp_new.png' width='55px' class='' title='Share on Whatsapp' height='55px' style='display: none; margin: 0em 0em;'></a>								</div>															</div>						</div></div>				</div>				<div class='col-md-8 result-background first-table padding-right full-width-table'>							                <div class='col-md-6 table1 full-width-table'>                    <table class='table box-shadow-result table-responsive'>                    <tbody>                    	<tr>	                    	<th class='text-center rank-font icone-padding' colspan='2'><img src='/img/results/alarm-clock.png' alt='' style='padding-right: 2%;padding-bottom: 1%;'></i>Timing</th>	                    </tr>                                          <tr>                        <th class='text-center'>Finished Time</th>                        <th class='text-center'>Chip Pace (min/km)</th>                      </tr>                      <tr>                          <td class='text-center neww-table he'>01:19:19</td>	                      <td class='text-center neww-table'>00:07:56</td>                      </tr>                    </tbody>                  </table>                </div>								<div class='col-md-6 padding-right full-width-table'>                     <table class='table box-shadow-result table-responsive'>                      <tbody>                      <tr>                      <th class='text-center rank-font icone-padding' colspan='4'><img src='/img/results/trophy-r.png' alt='' style='padding-right: 2%;padding-bottom: 1%;'>Rank</th>                      </tr>				<th class='text-center'>Overall</th><th class='text-center'>Gender</th><th class='text-center'>Ahmedabad Local Runners</th><tr><td class='text-center neww-table'>716<h6>of 1791</h6></td><td class='text-center neww-table'>622<h6>of 1378</h6></td><td class='text-center neww-table'>610<h6>of 1586</h6></td>						</tr>							</tbody>		                      </table>		                    </div>							<div class='col-md-12 col-xs-12 result-background padding-right full-width-table race_category-top-margin team-r'>		                    <div class='table-responsive box-shadow-result'>			                    <h3 class=\"txt-color h3_race_name text-center\">                    <img src=\"/img/resultlogo2.png\" class=\"icone-padding\" width=\"55\" height=\"55\" style=\"margin-right:6px;\">Race Details</h3>                    <table class=\"table\">                    <tbody>                      <tr>                        <th>Interval</th>                        <th>Chip Time</th>                        <th>Chip Pace<br>(min/km)</th>						<th>Speed</th>                      </tr>                      <tr>			</tr>					<tr>					</tr><tr></tr><tr></tr><tr>																			<td class=\"table-td\">											Split @ 2.1 Km									</td>																			 																			<td class=\"table-td\">											00:14:42									</td>																			 																			<td class=\"table-td\">											00:07:00									</td>																			 																			<td class=\"table-td\">											8.6 km/h									</td>																			 </tr><tr></tr><tr>																			<td class=\"table-td\">											Split @ 6.1 Km									</td>																			 																			<td class=\"table-td\">											00:45:44									</td>																			 																			<td class=\"table-td\">											00:07:30									</td>																			 																			<td class=\"table-td\">											8 km/h									</td>																			 </tr><tr>																<td class=\"table-td\">								Full Course						</td>																 																<td class=\"table-td\">								01:19:19						</td>																 																<td class=\"table-td\">								00:07:56						</td>																 																<td class=\"table-td\">								7.6 km/h						</td>																 							</tr>						<tr class=\"text-center\">							<td colspan=\"5\" class=\"table-td\">Full Course - Gun Time - 01:19:23</td>						</tr>					</tbody>                  </table>              </div>            </div></div></div>		</div></ul>						</div>					</div>				</div>				<br>			<div class='container full-width-table2'>	    <p class=\"bold-text note\"></p>	    	    <p class='notice-p'><span style=\"font-weight: bold;\">Note: </span>These are provisional results only. Where bib tag data of any runner is not reflected on any of the timing points at start/finish or on the course, or where the runner starts race before scheduled start time or beyond the permissible time limit, timings of such runners will not appear. You may raise a query ticket on the website or write to us on info@sportstimingsolutions.in for any clarification or discrepancies</p>			</p>	  </div>		<script type=\"text/javascript\">    $().fancybox({      selector : '[data-fancybox=\"images\"]',      loop     : true    });    $('[data-fancybox=\"images\"]').fancybox({      protect    : false,    });        $( '[data-fancybox=\"images\"]' ).fancybox({        caption : function( instance, item ) {            var caption = $(this).data('caption') || '';            if ( item.type === 'image' ) {                caption = (caption.length ? caption + '<br />' : '') + '<form action=\"download.php\" method=\"post\"><input type=\"hidden\" name=\"img\" value=\"'+ item.src + '\"><button class=\"pm-rounded-btn-downloadPhoto\" target=\"_blank\">Download Photo</button>' ;            }            return caption;        }    });           </script>";
			parseResponse("<html><body>" + response + "</body></html>", 11694);*/
			
			//System.out.println(response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String raceCat_10Km = "Race Category - 10 Km";
	private static String raceCat_10Km_defence = "Race Category - 10 Km - Defence";
	private static void parseResponse(String HTMLresponse, int bib) {
		try {
			//System.out.println("Input HTML String to JSoup :" + HTMLresponse);
			
			Document html = Jsoup.parse(HTMLresponse);
			
			//Info
	        String name = html.body().getElementsByClass("img-padding").text();
	        String raceCat = html.select("h3.padding-left").text().trim();
	        
	        if(raceCat_10Km.equals(raceCat) || raceCat_10Km_defence.equals(raceCat)) {
	        	String runTime = null;
		        //Overall, Gender, Ahmedabad Local Runners
		        List<String> rank = new ArrayList<>();
		        String locationDet = null;
		        //2.1km, 6.1km, Full Course
		        List<String> timing = new ArrayList<>();
		        
		        Elements resultDiv = html.select("div.result-background");
		        resultDiv.remove(0);
		        resultDiv.remove(0);
		        resultDiv.remove(1);
		        
		        Elements targetDiv = resultDiv.select("div.full-width-table");
	        	int counter = 0;
	        	for (Element element2 : targetDiv) {
	        		if(counter == 1) {
	        			runTime = element2.select("tr:last-child td:first-child").text();
	        		} else if(counter == 2) {
	        			for (Element element : element2.select("tr:last-child td")) {
							rank.add(element.text());
						}
	        			locationDet = element2.select("tr th:last-child").text();
	        			
	        		} else if(counter == 3) {
	        			for (Element element : element2.select("tr td:nth-child(2)")) {
	        				timing.add(element.text());
						}
	        		}
	        		counter++;
	        	}
		        
		        System.out.println("name: " + name);
		        System.out.println("runTime: " + runTime);
		        System.out.println("locationDet: " + locationDet);
		        System.out.println("rank: " + rank);
		        System.out.println("timing: " + timing);
		        
		        insertdata(bib, raceCat, name, runTime, locationDet, rank, timing);
	        } else {
	        	System.out.println("raceCat: " + raceCat);
	        	System.out.println("Resposne: " + HTMLresponse);
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	
	// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://10.210.22.83/wealth";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
	   
	private static void insertdata(int bib, String race_cat, String name, String runTime, String locationDet, List<String> rank, List<String> timing) throws SQLException {
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		   
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			if(raceCat_10Km.equals(race_cat) || raceCat_10Km_defence.equals(race_cat)) {
				String sql = "INSERT INTO marathon_data (bibno, race_cat, name, runTime, location_det, rank_overall, rank_gender, rank_location, time_first, time_second, time_final) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				int counter = 1;
				stmt.setInt(counter++, bib);
				stmt.setString(counter++, name);
				stmt.setString(counter++, race_cat);
				stmt.setString(counter++, runTime);
				stmt.setString(counter++, locationDet);
				if(rank.size() == 2) {
					stmt.setString(counter++, rank.get(0));
					stmt.setString(counter++, rank.get(1));
					stmt.setString(counter++, "");					
				} else {
					stmt.setString(counter++, rank.get(0));
					stmt.setString(counter++, rank.get(1));
					stmt.setString(counter++, rank.get(2));
				}
				stmt.setString(counter++, timing.get(0));
				stmt.setString(counter++, timing.get(1));
				stmt.setString(counter++, timing.get(2));
				
				stmt.executeUpdate();
				
				System.out.println("Inserted " + bib);
			} else {
				System.out.println("Skipped " + bib);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null)
				conn.close();
		}
		
	}

	private static String retrieveDataforBIB(int bibNo) throws IOException {
		
		String strUrl = "https://www.sportstimingsolutions.in/resultstable1.php";
		/*Map<String, String> reqMap = new HashMap<>();
		reqMap.put("bibno", "11964");
		reqMap.put("eventname", "Adani+Ahmedabad+Marathon+2018");
		reqMap.put("eventId", "45999");*/
		
		
		HttpsURLConnection connection = null;
		StringBuilder response = new StringBuilder();
		
		InputStream is = null;
		DataOutputStream wr = null;
		try {
			final URL url = new URL(null, strUrl, new sun.net.www.protocol.https.Handler());
			
			connection = (HttpsURLConnection)url.openConnection();
	        //connection.setSSLSocketFactory(sslContext.getSocketFactory());
	        connection.setDoOutput(true);
	        connection.setConnectTimeout(15 * 1000);
	        connection.setRequestMethod("POST");
	       
            /*connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Basic " + encode(vendorConfig.get("TPS_USERNAME") + ":" + vendorConfig.get("TPS_PASSWORD")));*/
	        String requestObj = "eventId=45999&bibno=" + bibNo + "&eventname=Adani+Ahmedabad+Marathon+2018";
            response.append(requestObj.toString());
			
            wr = new DataOutputStream(connection.getOutputStream());
	        wr.writeBytes(response.toString());
	        wr.close();
	        int statusCode = connection.getResponseCode();
	        //System.out.println("statusCode: " + statusCode);
	        if (statusCode == HttpsURLConnection.HTTP_OK) {
	        	is = connection.getInputStream();
		        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		        response.setLength(0);
		        String line;
		        while((line = rd.readLine()) != null)
		        {
		            response.append(line);
		        }
		        rd.close();
		        //System.out.println(response);
	        }

            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null)
				connection.disconnect();
			if(is != null)
				is.close();
			if(wr != null)
				wr.close();
		}
		
		return response.toString();
	}

}
