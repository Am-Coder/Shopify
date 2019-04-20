

window.addEventListener("load",function carouselDisp(){
	
	////////////////Ajax for electronics
	$.ajax({
		type:"POST",
		url:"/mainsite/fetchCarousel/Electronics",
		dataType:"json",
		cache:false,
		success:function (data){
			console.log(data);
			if(data.length!=0){
				var electronicCarousel = document.getElementsByClassName("home_content_electronics")[0];				
				for(i=0; i<data.length; i++){
					var prod1 = data[0];
					var prod2 = data[1];
					var prod3 = data[2];
					var ele = document.createElement("div");
					ele.setAttribute("class","home_items");
					
											
					var carouselItem =		'<div class="row">'+
													'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
														'<div class="home_item_side"><a href="product.html">'+
															'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
																'<div>'+
																	'<div>from</div>'+
																	'<div>$'+prod1.price+'</span></div>'+
																'</div>'+
															'</div>'+
														
															'<img src='+prod1.directory+"product.jpg"+' alt=""></a>'+
														'</div>'+
													'</div>'+
													'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
														'<div class="home_item_side"><a href="product.html">'+
															'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
																'<div>'+
																	'<div>from</div>'+
																	'<div>$'+prod2.price+'</span></div>'+
																'</div>'+
															'</div>'+
														
															'<img src='+prod2.directory+"product.jpg"+' alt=""></a>'+
														'</div>'+
													'</div>'+
													'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
														'<div class="home_item_side"><a href="product.html">'+
															'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
																'<div>'+
																	'<div>from</div>'+
																	'<div>$'+prod3.price+'</span></div>'+
																'</div>'+
															'</div>'+
														
															'<img src='+prod3.directory+"product.jpg"+' alt=""></a>'+
														'</div>'+
													'</div>'+													
												'</div>';
											
					ele.innerHTML = carouselItem;
					electronicCarousel.appendChild(ele);
						
				}
			}
		},
		error:function(e){
			console.log(e);
		},
		complete:function(){
			console.log("Done");
		}
	});
	
	
	
	//////////////////Ajax for Clothing
	
		$.ajax({
		type:"POST",
		url:"/mainsite/fetchCarousel/Clothing",
		dataType:"json",
		cache:false,
		success:function (data){
			console.log(data);
			if(data.length!=0){
				var clothingCarousel = document.getElementsByClassName("home_content_clothing")[0];				
				for(i=0; i<data.length; i++){
					var prod1 = data[0];
					var prod2 = data[1];
					var prod3 = data[2];
					var ele = document.createElement("div");
					ele.setAttribute("class","home_items");
					
											
					var carouselItem =		'<div class="row">'+
													'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
														'<div class="home_item_side"><a href="product.html">'+
															'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
																'<div>'+
																	'<div>from</div>'+
																	'<div>$'+prod1.price+'</span></div>'+
																'</div>'+
															'</div>'+
														
															'<img src='+prod1.directory+"product.jpg"+' alt=""></a>'+
														'</div>'+
													'</div>'+
													'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
														'<div class="home_item_side"><a href="product.html">'+
															'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
																'<div>'+
																	'<div>from</div>'+
																	'<div>$'+prod2.price+'</span></div>'+
																'</div>'+
															'</div>'+
														
															'<img src='+prod2.directory+"product.jpg"+' alt=""></a>'+
														'</div>'+
													'</div>'+
													'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
														'<div class="home_item_side"><a href="product.html">'+
															'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
																'<div>'+
																	'<div>from</div>'+
																	'<div>$'+prod3.price+'</span></div>'+
																'</div>'+
															'</div>'+
														
															'<img src='+prod3.directory+"product.jpg"+' alt=""></a>'+
														'</div>'+
													'</div>'+													
												'</div>';
											
					ele.innerHTML = carouselItem;
					clothingCarousel.appendChild(ele);
						
				}
			}
		},
		error:function(e){
			console.log(e);
		},
		complete:function(){
			console.log("Done");
		}
	});
	
	
	
	
	///////////////Ajax for footwear
		$.ajax({
		type:"POST",
		url:"/mainsite/fetchCarousel/Footwear",
		dataType:"json",
		cache:false,
		success:function (data){
			console.log(data);
			if(data.length!=0){
				var footwearCarousel = document.getElementsByClassName("home_content_footwear")[0];				
					var prod1 = data[0];
					var prod2 = data[1];
					var prod3 = data[2];
					console.log(prod1,prod2,prod3);
					var ele = document.createElement("div");
					ele.setAttribute("class","home_items");
					
											
					var carouselItem =		'<div class="row">'+
													'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
														'<div class="home_item_side"><a href="product.html">'+
															'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
																'<div>'+
																	'<div>from</div>'+
																	'<div>$'+prod1.price+'</span></div>'+
																'</div>'+
															'</div>'+
														
															'<img src='+prod1.directory+"product.jpg"+' alt=""></a>'+
														'</div>'+
													'</div>'+
													'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
														'<div class="home_item_side"><a href="product.html">'+
															'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
																'<div>'+
																	'<div>from</div>'+
																	'<div>$'+prod2.price+'</span></div>'+
																'</div>'+
															'</div>'+
														
															'<img src='+prod2.directory+"product.jpg"+' alt=""></a>'+
														'</div>'+
													'</div>'+
													'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
														'<div class="home_item_side"><a href="product.html">'+
															'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
																'<div>'+
																	'<div>from</div>'+
																	'<div>$'+prod3.price+'</span></div>'+
																'</div>'+
															'</div>'+
														
															'<img src='+prod3.directory+"product.jpg"+' alt=""></a>'+
														'</div>'+
													'</div>'+													
												'</div>';
											
					ele.innerHTML = carouselItem;
					footwearCarousel.appendChild(ele);
						
			}
		},
		error:function(e){
			console.log(e);
		},
		complete:function(){
			console.log("Done");
		}
	})
	
	
	
	
	
})




//var carouselItem = '<div class="home_content">'+
//						'<div class="home_title">New Arrivals</div>'+
//						'<div class="home_subtitle">Summer Wear</div>'+
//						'<div class="home_items">'+
//							'<div class="row">'+
//								'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
//									'<div class="home_item_side"><a href="product.html">'+
//										'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
//											'<div>'+
//												'<div>from</div>'+
//												'<div>$3<span>.99</span></div>'+
//											'</div>'+
//										'</div>'+
//									
//										'<img src="siteStyle/images/home_1.jpg" alt=""></a>'+
//									'</div>'+
//								'</div>'+
//								'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
//									'<div class="home_item_side"><a href="product.html">'+
//										'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
//											'<div>'+
//												'<div>from</div>'+
//												'<div>$3<span>.99</span></div>'+
//											'</div>'+
//										'</div>'+
//									
//										'<img src="siteStyle/images/home_1.jpg" alt=""></a>'+
//									'</div>'+
//								'</div>'+
//								'<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">'+
//									'<div class="home_item_side"><a href="product.html">'+
//										'<div class="product_tag d-flex flex-column align-items-center justify-content-center">'+
//											'<div>'+
//												'<div>from</div>'+
//												'<div>$3<span>.99</span></div>'+
//											'</div>'+
//										'</div>'+
//									
//										'<img src="siteStyle/images/home_1.jpg" alt=""></a>'+
//									'</div>'+
//								'</div>'+													
//							'</div>'+
//						'</div>'+
//					'</div>';