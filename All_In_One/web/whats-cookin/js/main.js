var Main = {
	siteName: 'Whats Cooking',
	
	initialize: function () {
		console.log('In the initilize function...');
		
		setTimeout(function(){ 	
            $('#main-area').html(					
                '<h3>This is the Main area for site content.</h3>'            
            );
		}, 1000 );                
		
    },
    onSignIn: function(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
    }
		
		
}