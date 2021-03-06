<%@page import="com.adrater.datacollection.vo.AdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Dimensional Rating</title>
<!-- Bootstrap Core CSS -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>

<!-- Custom CSS -->
<link href="../bootstrap/css/business-casual.css" rel="stylesheet">

<!-- Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<p align="right">
		<a href=""><small>Sign Out</small></a>
	</p>
	<div class="brand">Dimensional Rating</div>
	<div class="address-bar">San Francisco Bay Area</div>

	<!-- Navigation -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<header>
					<a href="">Sign Out</a>
				</header>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
				<a class="navbar-brand" href="home.html">Dimensional Rating</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling
            -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="home.html">Home</a></li>
					<li><a href="profile.html">Profile</a></li>
					<li><a href="myReviews.html">My Reviews</a></li>
					<!-- <li><a href="contact.html">Contact</a></li>
					<li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
	</nav>

	<div class="container">

		<div class="row">



			<div class="box">
				<div class="col-lg-12 text-center">
					<div>
						<form name="" action="">
							<input type="text"></input>
							<button type="submit">Search</button>
							<a href="advancedSearch.html">Advanced Search Options</a>
						</form>

						<tr>
							<td></td>
						</tr>
					</div>
					<hr>
					
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
			
					<table class="table" id="tbl_ads">
						<tbody>

							<%
								List<AdVO> adList = (List<AdVO>)request.getAttribute("adlist");
								for(AdVO adVo : adList){
									
									%><tr>
									
									<td><a id=<%out.print(adVo.getId());%> href="ads?id=<%out.print(adVo.getId());%>"><% out.print(adVo.getPostDate()); %></td>	
									<td><a id=<%out.print(adVo.getId());%> href="ads?id=<%out.print(adVo.getId());%>"><% out.print(adVo.getAdHeader()); %></td>
									<td><a id=<%out.print(adVo.getId());%> href="ads?id=<%out.print(adVo.getId());%>"><% out.print(adVo.getLocation()); %></td>
									</tr><% 
									
								}
							
							%>

							<!-- java code removed -->

						</tbody>
					</table>
		</div>

					<div class="col-md-10">
						<ul class="pager">
							<li><a id="a_prev" href="#"> << Previous</a></li>
							<li><a id="a_next" href="#">Next >> </a></li>
						</ul>
					</div>

					<div class="col-md-10">
						<!-- <div class="panel panel-info">
								<div class="panel-heading"></div>
								<div class="panel-body"> -->
						<table class="table" id="tbl_ads" border=0>
							<tbody>

								<tr>
									<th align="left">Post Date
									<th>
									<th align="left">Post</th>
									<th align="left">Location</th>
									<th align="left">Category</th>
								</tr>
								<tr>
									<td>Data 1</td>
									<td>Data 2</td>


								</tr>

							</tbody>
						</table>

						<!-- </div> -->
					</div>
					<!-- </div> -->

					<!--    <div id="carousel-example-generic" class="carousel slide">
                        Indicators
                        <ol class="carousel-indicators hidden-xs">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                        Wrapper for slides
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="img-responsive img-full" src="bootstrap/img/slide-1.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="bootstrap/img/slide-2.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="bootstrap/img/slide-3.jpg" alt="">
                            </div>
                        </div>

                        Controls
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="icon-prev"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="icon-next"></span>
                        </a>
                    </div> -->
					<!-- <h2 class="brand-before">
						<small>Welcome to</small>
					</h2>
					<h1 class="brand-name">Dimensional Rating</h1>
					<hr class="tagline-divider">
					<h2>
						<small>By <strong>Team </strong>
						</small>
					</h2> -->
				</div>
			</div>
		</div>

		<!--         <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center"><strong>Our Inspiration</strong>
                    </h2>
                    <hr>
                    <img class="img-responsive img-border img-left" src="bootstrap/img/intro-pic.jpg" alt="">
                    <hr class="visible-xs">
                    <p>Internet has made the world smaller with information easily available and accessible. Craigslist is one such</p> 
                    <p>website where you can find classified advertisements with sections  </p>
                      <p> varying from jobs, housing, sale items, services, community to discussion forums.  </p>
                       <p>From last minute tickets to your favorite show to items on sale for cheaper price,  </p>
                       <p>Craigslist is the most popular website for Ads thus attracting a large number of internet users.  </p>
                       <p>The number of Ads listed for your criteria is huge which are further categorized into many categories. </p>
                       <p> But deciding on an Ad becomes difficult as Craigslist does not provide any differentiation using tags,  </p>
                        <p>reviews or ratings on any of these posts. Craigslist does not provide a good user experience in terms  </p>
                        <p>of searching for an ad either. Instead if you are searching for a specific post, you are likely to </p>
                         <p>end up with a big list of unrelated and sometimes duplicate ads. </p>
                </div>
            </div>
        </div> -->

		<!-- <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Beautiful boxes
                        <strong>to showcase your content</strong>
                    </h2>
                    <hr>
                    <p>Use as many boxes as you like, and put anything you want in them! They are great for just about anything, the sky's the limit!</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                </div>
            </div>
        </div> -->

	</div>



	<div class="col-md-10" onload="listAds(0)"></div>
	<!-- /.container -->

	<!--     <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; CMPE295B Summer 2014</p>
                </div>
            </div>
        </div>
    </footer> -->

	<!-- jQuery Version 1.11.0 -->
	<!--  <script src="bootstrap/js/jquery-1.11.0.js"></script> -->


	<!-- Bootstrap Core JavaScript -->
	<script src="../bootstrap/js/bootstrap.min.js"></script>
	<script src="../js/adlist.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>
	<script>
		$(document).ready(function() {
			$("#box").load("home.html");
		});
	</script>
</body>

</html>


