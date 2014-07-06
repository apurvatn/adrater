<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%-- <%@ page import="com.mongodb.*" %>
<%@ page import="com.mongodb.DBCollection"  %>
<%@ page import="com.mongodb.DBCursor"  %>
<%@ page import="com.mongodb.MongoURI" %>
<%@ page import="com.mongodb.BasicDBObject" %>
<%@ page import="java.util.*,java.text.SimpleDateFormat" %> --%>

<%
/* try{	
	
	String username = "cmpe295b";
	char[] password = {'c','m','p','e','2','9','5','b'};
	
	//connect to the Mongolab
	String textUri = "mongodb://cmpe295b:cmpe295b@ds033018.mongolab.com:33018/craigslist";
	MongoURI uri  = new MongoURI(textUri); 
	Mongo m = new Mongo(uri);
    // connect to your database
    DB db = m.getDB( "craigslist" );
	System.out.println("Connected to database successfully");
	//authentication
	boolean auth = db.authenticate(username,password);            			 
	System.out.println("Authentication: "+auth);
	
	//
	DBCollection coll = db.getCollection("advertisements");
	System.out.println("Collection selected successfully");
 
	//Retrieve documents
	DBCursor cursor = coll.find();
	int i=1;
	while (cursor.hasNext()) { 
	    System.out.println("Inserted Document: "+i + "\n"); 
	    System.out.println(cursor.next()); 
	    System.out.println("\n");
	    i++;
	}
    //Update the registration collection
    //db.createCollection("registration", new BasicDBObject("capped", true).append("size", 1048576));
    System.out.println("Collection inserted successfully");
    
    //Delete a document
    
    //Update a document
    
    db.createCollection("registration1234", new BasicDBObject("capped", true).append("size", 1048576));
    String firstname= request.getParameter("fname");
    
    String lastname = request.getParameter("lname");
    String emailaddress = request.getParameter("email");
   String address = request.getParameter("address");
    String phone = request.getParameter("phone");
    String pword = request.getParameter("password");;

    System.out.println("Collection inserted successfully");
    System.out.println("lastname" +lastname);
    
            
	 }
catch(Exception e){
     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
} */
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Sign in &middot; Twitter Bootstrap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="../assets/ico/favicon.png">
  </head>

  <body>

    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Please sign up</h2>
        
     <input type="text" class="input-block-level" placeholder="First Name">
       <input type="text" class="input-block-level" name= "lname" placeholder="Last Name"> 
        <input type="text" class="input-block-level" placeholder="Email address">
        <input type="text" class="input-block-level" placeholder="Address">
        <input type="text" class="input-block-level" placeholder="Phone">
        <input type="password" class="input-block-level" placeholder="Password">
        <button class="btn btn-large btn-primary" type="submit" onClick="document.forms[0].action = 'login.jsp'; return true;">Sign Up</button>
      </form>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/js/bootstrap-transition.js"></script>
    <script src="../assets/js/bootstrap-alert.js"></script>
    <script src="../assets/js/bootstrap-modal.js"></script>
    <script src="../assets/js/bootstrap-dropdown.js"></script>
    <script src="../assets/js/bootstrap-scrollspy.js"></script>
    <script src="../assets/js/bootstrap-tab.js"></script>
    <script src="../assets/js/bootstrap-tooltip.js"></script>
    <script src="../assets/js/bootstrap-popover.js"></script>
    <script src="../assets/js/bootstrap-button.js"></script>
    <script src="../assets/js/bootstrap-collapse.js"></script>
    <script src="../assets/js/bootstrap-carousel.js"></script>
    <script src="../assets/js/bootstrap-typeahead.js"></script>

  </body>
</html>
