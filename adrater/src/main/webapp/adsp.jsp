<%@page import="com.adrater.datacollection.vo.AdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ad listings</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/adlist.js"></script>
	

	<div class="col-md-12">
		<h1>Ad listing</h1>
			
		<div class="col-md-10">
			<ul class="pager">
				<%
					//get the page count
					int pageCnt = (Integer)request.getAttribute("part");
					int prevPage  = 0; 
					int nxtPage = pageCnt + 1;
					if(pageCnt == 0){
						prevPage = 0;
					} else {
						prevPage = pageCnt - 1;
						
					}
	
				%>
				
				<li><a id="a_prev" href="ads?part=<%out.print(prevPage);%>"> << Previous</a></li>
				<li><a id="a_next" href="ads?part=<%out.print(nxtPage);%>">Next >> </a></li>
			</ul>
		</div>

		<div class="col-md-10">
			<div class="panel panel-info">
				<div class="panel-heading"></div>
				<div class="panel-body">
					<table class="table" id="tbl_ads">
						<tbody>
							<%
								List<AdVO> adList = (List<AdVO>)request.getAttribute("adlist");
								for(AdVO adVo : adList){
									
									%><tr><td><a id=<%out.print(adVo.getId());%> href="ads?id=<%out.print(adVo.getId());%>"><% out.print(adVo.getAdHeader()); %></td></tr><% 
									
								}
							
							%>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	
	</div>
	 <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>
</body>

</html>