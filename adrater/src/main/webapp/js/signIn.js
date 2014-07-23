function LogInfun(){
alert(formToJSON());
	$.ajax({
			type: "POST",
			url:"adrater/auth",
			contentType: "application/json",
			dataType: 'json',
			data : formToJSON(),
				//success: function () { //success(data); }
			success: function(data, textStatus, jqXHR){
				if(data != 0){
					alert("you are logged in");
					 //$.cookie('cust_id',data,{expires:1,path:'/'});
					window.location.href = "ads.html";
				} else {
					alert("Please sign up");
				}
					
				},
			error: function(textStatus, jqXHR,errorThrown){
				alert(textStatus+" "+jqXHR);
			}

		});
}

function formToJSON() {
    return JSON.stringify({
    "email": $('#userName').val(),
    "pwd": $('#passwd').val(),
    });
}