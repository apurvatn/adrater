/**
 * Function to list all ads
 */

var count = 0;

$(document).ready(function() {
	alert("Please wait while we load latest posts");
	listAds(0);

	$("#a_prev").click(function() {
		if (count == 0) {
			// do nothing
			alert("first page");
		} else {
			count--;
			listAds(count);
		}
	});

	$("#a_next").click(function() {
		count++;
		listAds(count);

	});

	$("#submit").click(function() {
		adDetails(id);
	});

});

function listAds(count) {

	$.ajax({
				url : "adrater/ads?part=" + count,
				type : "GET",
				contentType : "application/json",

				// function to be called when success
				success : function(data, textStatus, jqXHR) {

					if (data != 0) {

						// delete all rows in the table
						// $("#tbl_ads tbody>tr").remove();

						$
								.each(
										data,
										function(index, element) {

											$("#tbl_ads > tbody:last")
													.append(
															'<tr><td align= "left"><a href="javascript:adDetails('
																	+ element.id
																	+ ')" >'
																	+ element.postDate
																	+ '</a></td><td align= "left"><a href="adDetails.html">'
																	+ element.adHeader
																	+ '</a></td><td align= "left"><a href="adrater/ads/ad?'
																	+ element.id
																	+ '" >'
																	+ element.location
																	+ '</a></td><td align= "left"><a href="adrater/ads/ad?id='
																	+ element.id
																	+ '" >'
																	+ element.subCategory.category
																	+ '</a></td></tr>');
										});

					} else {

						alert("no data available" + " " + textStatus);
					}

				},

				// function to be called in case of error
				error : function(textStatus, jqXHR, errorThrown) {

					alert(textStatus + " " + jqXHR);

				}

			});

}

function adDetails(id) {
	alert("in function adDetails");
	//window.open('adDetails.html');
	$.ajax({
				url : "adrater/ads/ad?id=" + id,
				type : "GET",
				contentType : "application/json",

				// function to be called when success
				success : function(data, textStatus, jqXHR) {

					if (data != 0) {

						//delete all rows in the table
						$(".container").remove();

						$
								.each(
										data,
										function(index, element) {

											$("adDetails#tbl_ads > tbody:last")
													.append(
															'<tr><td align= "left"><a href="javascript:adDetails('
																	+ element.id
																	+ ')" >'
																	+ element.postDate
																	+ '</a></td></tr>');
										});

					} else {

						alert("no data available" + " " + textStatus);
					}

				},

				// function to be called in case of error
				error : function(textStatus, jqXHR, errorThrown) {

					alert(textStatus + " " + jqXHR);

				}

			});

}