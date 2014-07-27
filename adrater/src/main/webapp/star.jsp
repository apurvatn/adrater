<!DOCTYPE html>
<%@page import="com.adrater.datacollection.vo.AdVO"%>
<html>
<head>
<link href="../bootstrap/css/star-rating.css" media="all" rel="stylesheet"
	type="text/css" />
<link href="../bootstrap/css/star-rating.min.css" media="all"
	rel="stylesheet" type="text/css" />


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Dimensional Rating</title>

<!-- Bootstrap Core CSS -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="bootstrap/css/star.css" rel="stylesheet"> NOT NEEDED...CONFLICTING-->

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
<!--  from ad.jsp-->
    <meta charset="UTF-8"/>
    <title>Krajee JQuery Plugins - &copy; Kartik</title>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <link href="../bootstrap/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="../js/star-rating.js" type="text/javascript"></script>
<body><p align="right">
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
						

					</li> -->
					<!--   <li>
                        <a href="signin.html">Sign In</a>
                    </li> -->
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
					<!-- 	<div>

						<form name="" action="">
							<input type="text"></input>
							<button type="submit">Search</button>
							<a href="advancedSearch.html">Advanced Search Options</a>
						</form>

					</div>
					<hr> -->
					

					<div class="col-lg-12 text-center" id="col-lg-12 text-center">
					
					<%
				//get the ad details
				AdVO adVo = (AdVO)request.getAttribute("adVO");
			
			%>
						<table border=0 width=100%>
							<tr>
								<td rowspan=3 width=30%><img src="../bootstrap/img/apurva.jpg"></td>
								
								<td align="topleft">Title:<%out.print(adVo.getAdHeader()); %><br>
								Post:<%out.print(adVo.getAdDetails()); %> <br>
								Category: <%out.print(adVo.getSubCategory().getCategory()); %> <br>
					Post Date: <%out.print(adVo.getPostDate()); %> <br>
					Location: <%out.print(adVo.getLocation()); %> <br>
								</td>
							</tr>
							<!-- <tr>
								<td>San Francisco</td>
							</tr>
							<tr>
								<td>Posted Date:</td>
							</tr> -->
						</table>

					</div>

					<hr>
					<div class="col-md-10" onload="adDetails()">
						<strong class="choice">Post Ratings</strong>
						<table border=0 width=100%>
							<tr>
								<td width=31%>Licensed</td>
								<td><div class="container">
										<form>
											<input id="input-21e" value="0" type="number" class="rating"
												min=0 max=5 step=0.5 data-size="xs"> <br>
											<div class="clearfix"></div>
											<!--    <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
   
   </div> -->
										</form>
									</div> <br>


									</div></td>
							</tr>
							<tr>
								<td width=30%>Punctual</td>
								<div class="container">
									<form>
										<input id="input-21e" value="0" type="number" class="rating"
											min=0 max=5 step=0.5 data-size="xs"> <br>
										<div class="clearfix"></div>
										<!--    <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
   
   </div> -->
									</form>
								</div>
								<br>


								</div>

								</td>
							</tr>
							<tr>
								<td width=30%>Available</td>
								<td>
									<div class="container">
										<form>
											<input id="input-21e" value="0" type="number" class="rating"
												min=0 max=5 step=0.5 data-size="xs"> <br>
											<div class="clearfix"></div>
											<!--    <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
   
   </div> -->
										</form>
									</div> <br>


									</div>

								</td>
							</tr>
							<tr>
								<td width=30%>Problem Solved</td>
								<td>
									<div class="container">
										<form>
											<input id="input-21e" value="0" type="number" class="rating"
												min=0 max=5 step=0.5 data-size="xs"> <br>
											<div class="clearfix"></div>
											<!--    <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
   
   </div> -->
										</form>
									</div> <br>


									</div>

								</td>
							</tr>
						</table>
					</div>

					<div>
					<tr>
						<td class="col-md-10" colspan=2>
							<button type="submit" id="login" class="btn btn-default"
								onclick="showDiv()">Rate this Post</button>
						</td>
					</tr>
					</table>
				</div>





			</div>
			<hr>
<!-- End of page before rate -->
			<div id="welcomeDiv" class="row-md-10" style="display: none;">

				<table border=0 width=100%>
					<tr>
						<td width=31%>Licensed</td>
						<td>
							<div class="container">
								<form>
									<input id="input-21e" value="0" type="number" class="rating"
										min=0 max=5 step=0.5 data-size="xs"> <br>
									<div class="clearfix"></div>
									<!--    <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
   
   </div> -->
								</form>
							</div> <br>


							</div>
						</td>
					</tr>
					<tr>
						<td width=30%>Punctual</td>
						<td>
							<div class="container">
								<form>
									<input id="input-21e" value="0" type="number" class="rating"
										min=0 max=5 step=0.5 data-size="xs"> <br>
									<div class="clearfix"></div>
									<!--    <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
   
   </div> -->
								</form>
							</div> <br>


							</div>
						</td>
					</tr>
					<tr>
						<td width=30%>Available</td>
						<td>
							<div class="container">
								<form>
									<input id="input-21e" value="0" type="number" class="rating"
										min=0 max=5 step=0.5 data-size="xs"> <br>
									<div class="clearfix"></div>
									<!--    <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
   
   </div> -->
								</form>
							</div> <br>


							</div>
						</td>
					</tr>
					<tr>
						<td width=30%>Problem Solved</td>
						<td>
							<div class="container">
								<form>
									<input id="input-21e" value="0" type="number" class="rating"
										min=0 max=5 step=0.5 data-size="xs"> <br>
									<div class="clearfix"></div>
									<!--    <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
   
   </div> -->
								</form>
							</div> <br>


							</div>
						</td>
					</tr>
					<tr>
						<td = colspan=2>
							<button type="submit" id="login" class="btn btn-default"
								onclick="LogInfun()">Rate</button>
						</td>
					</tr>
				</table>




			</div>
			<!--end of rate div  -->	
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

	<div class="col-md-10" onload=""></div>
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
	<script src="../js/star.js"></script>
	<script src="../js/showdiv.js"></script>
	<script src="../js/star-rating.js" type="text/javascript"></script>
	<script src="../js/star-rating.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.js"></script>


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

	<script>
		$(document).ready(function() {
			$(".rating-kv").rating();
		});
	</script>



















<!-- <div class="container">
<form>
    <input id="input-21e" value="0" type="number" class="rating" min=0 max=5 step=0.5 data-size="xs" >
    <br>
    <div class="clearfix"></div>
    <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
    </div>
</form>
<br>
<script>
    jQuery(document).ready(function () {
        $(".rating-kv").rating();
    });
</script>

</div>  -->  
</body>
</html>