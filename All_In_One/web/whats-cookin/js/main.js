var Main = {
	siteName: 'Whats Cooking',
	
	initialize: function () {
		console.log('In the initilize function...');
		
		setTimeout(function(){ 

			$('#main-area').html(
					
					'<h3>This is the Main area for site content.</h3>'
			);
			
		}, 3000);
		
		
		
	}
		
		
}