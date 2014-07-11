/**
 * Function to list all ads 
 */

var count = 0;

$(document).ready(function(){
	$("#a_prev").click(function (){
		if(count == 0){
			//do nothing 
			alert("first page");
		} else {
			count--;
			listAds(count);
		}
	});
	
	$("#a_next").click(function (){
		count++;
		listAds(count);
		
	});
	
	
});


function listAds(count){
	
	$.ajax({
		
		url: "adrater/ads?part="+count,
		type: "GET",
		contentType:"application/json",
		
		//function to be called when success
		success: function(data, textStatus, jqXHR){
			
			if(data!=0){

				
				//delete all rows in the table
				$("#tbl_ads tbody>tr").remove();
				
				$.each(data, function(index, element) {
					
		            $("#tbl_ads > tbody:last").append('<tr><td>' + element.adHeader + '</td></tr>' );
		        });
				
				
			} else {
				
				alert("no data available"+ " "+ textStatus);
			}
			
		},
		
		//function to be called in case of error
		error: function(textStatus, jqXHR, errorThrown){
		
			alert(textStatus+" "+jqXHR);
			
		}
		
		
	});
	
	
}