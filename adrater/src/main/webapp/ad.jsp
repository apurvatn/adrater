<!DOCTYPE html>
<%@page import="com.adrater.datacollection.vo.AdVO"%>
<html>
<head>
<meta charset="utf-8">
<title>Ad listings</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>
<body onload="listAds(0)">
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/adlist.js"></script>
	

	<div class="col-md-12">
		<h1>Ad details</h1>
			
		<div class="col-md-10">
			<%
				//get the ad details
				AdVO adVo = (AdVO)request.getAttribute("adVO");
			
			%>
		
			<div class="panel panel-info">
				<div class="panel-heading">
					<%out.print(adVo.getAdHeader()); %>
				</div>
				<div class="panel-body">
					<%out.print(adVo.getAdDetails()); %> <br>
					Category: <%out.print(adVo.getSubCategory().getCategory()); %> <br>
					Post Date: <%out.print(adVo.getPostDate()); %> <br>
					Location: <%out.print(adVo.getLocation()); %> <br>
				</div>
			</div>
		</div>
	
	</div>
</body>
</html>