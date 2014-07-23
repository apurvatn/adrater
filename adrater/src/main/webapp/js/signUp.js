function signUpfun(){
	
alert('user  '+formToJSON());	

jQuery.ajax({
    type: "POST",
    url: "adrater/signup",
    data: formToJSON(),
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function (data, status, jqXHR) {
    	if(data) {
    		alert("user created successfully"+formToJSON());
    	} else {
    		alert("Failed to create the user");
    	}
    },

//    error: function (jqXHR, status) {            
//    	alert(jqXHR+" "+status);
//    }

});
}

function formToJSON() {
    return JSON.stringify({
    "firstName": $('#firstName').val(),
    "lastName": $('#lastName').val(),
    "email": $('#email').val(),
    "address":$('#address').val(),
    "phone":$('#phone').val(),
    "pwd": $('#passwd').val(),
    });
}