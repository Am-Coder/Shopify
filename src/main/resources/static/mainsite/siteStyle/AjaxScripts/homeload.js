/**
 * 
 */



// window.addEventListener('load',function mainpage_load(){
//     var product_container = document.getElementsByClassName("row products_row")[0];

//     var bootstrap_container = document.createElement("div");
//     bootstrap_container.setAttribute("class","col-xl-4 col-md-6");

//     var product = document.createElement("div");
//     product.setAttribute("class","product");

//     var product_image = document.createElement("div");
//     product_image.setAttribute("class","product_image");
//     var image_container = document.createElement("img");
//     image_container.setAttribute("src",xyz);
//     product_image.appendChild(image_container);
//     main_container.appendChild(product_image);

//     var product_content = document.createElement("div");
//     product_content.setAttribute("class","product_content");
//     var bootstrap_prod_info = document.createElement("");
//     bootstrap_prod_info.setAttribute("class","product_info d-flex flex-row align-items-start justify-content-start");
    
//     var div_encloser1 = document.createElement("div");
//     var div_encloser2 = document.createElement("div");
//     var product_name = document.createElement("div");
//     product_name.setAttribute("class","product_name");
//     var name_details = doument.createElement("a");
//     name_details.setAttribute("href",url1);//url1
//     name_details.innerHTML = name_of_product; //Name
//     product_name.appendChild(name_details);
//     var product_category = document.createElement("div");
//     product_category.setAttribute("class","product_category");
//     var category_details = doument.createElement("a");
//     category_details.setAttribute("href",url2);//url2
//     category_details.innerHTML = category_of_product; //  Type
//     product_category.appendChild(category_details);
//     div_encloser2.appendChild(product_name);
//     div_encloser2.appendChild(product_category);
//     div_encloser1.appendChild(div_encloser2);
    
//     var bootstrap_rating = document.createElement("div");
//     bootstrap_rating.setAttribute("class","ml-auto text-right");
//     var star_rating = document.createElement("div");
//     star_rating.setAttribute("class","rating_r rating_r_4 home_item_rating")
//     star_rating.innerHTML = rating; //rating
//     var price_tag = document.createElement("div");
//     price_tag.setAttribute("class","product_price text-right");
//     price_tag.innerHTML = base + "<span>" + decimal + "</span>";
//     bootstrap_rating.append(star_rating,price_tag);

//     bootstrap_prod_info.appendChild(div_encloser1);
//     bootstrap_prod_info.appendChild(bootstrap_rating);

//     var product_buttons = document.createElement("div");
//     product_buttons.setAttribute("class","product_buttons");
//     var bootstrap_style = document.createElement("div");
//     bootstrap_style.setAttribute("class","text-right d-flex flex-row align-items-start justify-content-start");
//     var product_fav = document.createElement("div").setAttribute("class","product_button product_fav text-center d-flex flex-column align-items-center justify-content-center");
//     var div_encloser1 = document.createElement("div");
//     var div_encloser2 = document.createElement("div");
//     var heart_img = document.createElement("img");
//     heart_img.setAttribute("class","svg");
//     heart_img.setAttribute("src",url4)//url4
//     var div_encloser3 = document.createElement("div");
//     div_encloser3.innerHTML="+";
//     div_encloser2.append(heart_img,div_encloser3);
//     div_encloser1.appendChild(div_encloser2);
//     product_fav.appendChild(div_encloser1);

//     var product_cart = document.createElement("div")
//     product_cart.setAttribute("class","product_button product_cart text-center d-flex flex-column align-items-center justify-content-center");
//     var div_encloser1 = document.createElement("div");
//     var div_encloser2 = document.createElement("div");
//     var cart_img = document.createElement("img");
//     cart_img.setAttribute("class","svg");
//     cart_img.setAttribute("src",url3);//url3
//     var div_encloser3 = document.createElement("div");
//     div_encloser3.innerHTML="+";
//     div_encloser2.append(cart_img,div_encloser3);
//     div_encloser1.appendChild(div_encloser2);
//     product_cart.appendChild(div_encloser1);

//     bootstrap_style.append(product_fav,product_cart);
//     product_buttons.appendChild(bootstrap_style)
    
//     product_content.appendChild(bootstrap_prod_info);
//     product_content.appendChild(product_buttons);

//     product.appendChild(product_image);
//     product.appendChild(product_content);

//     bootstrap_container.appendChild(product);



//     product_container.appendChild(bootstrap_container);
// })

//////////////////////////////////////////////////////////////////////////M2

window.addEventListener('load',function mainpage_load(){


	//Ajax for fetching clothes
	$.ajax({
		type : "GET",
		cache: false,
		// contentType : "application/json",//type of data being send to server
		url : "/mainsite/fetch/Clothing",
		// data : JSON.stringify({email: $("#email").val()}),
		
		dataType : "json",//result expected from server
						//with json return type we can return java objects
						//With text we can return String from java conroller
		timeout : 100000,
		success : function(product) {
			
			console.log(product);
			if(product != null){
					var product_container = document.getElementsByClassName("row products_row")[0];
		
					var bootstrap_container = document.createElement("div");
					bootstrap_container.setAttribute("class","col-xl-4 col-md-6");
					
					
					var product ='<div class="product">'+
						'<div class="product_image"><img src='+ "siteStyle/images/product_6.jpg" +' alt=""></div>' +
						'<div class="product_content">' +
							'<div class="product_info d-flex flex-row align-items-start justify-content-start">' +
								'<div>' + 
									'<div>' +
										'<div class="product_name"><a href='+product.productname+'>'+product.productname+'</a></div>'+
										'<div class="product_category">In <a href='+product.type+'>'+product.type+'</a></div>'+
									'</div>' +
								'</div>'+
								'<div class="ml-auto text-right">' +
									'<div class="rating_r rating_r_4 home_item_rating">'+'<i></i><i></i><i></i><i></i><i></i>'+product.rating+'</div>'+
									'<div class="product_price text-right">'+'$'+parseInt(product.price)+'<span>'+(((parseFloat(product.price)%1).toFixed(2)).toString()).replace("0","")+'</span></div>'+
								'</div>'+
							'</div>'+
							'<div class="product_buttons">'+
								'<div class="text-right d-flex flex-row align-items-start justify-content-start">'+
									'<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">'+
										'<div><div><img src="siteStyle/images/heart_2.svg" class="svg" alt=""><div>+</div></div></div>'+
									'</div>'+
									'<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">'+
										'<div><div><img src="siteStyle/images/cart.svg" class="svg" alt=""><div>+</div></div></div>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</div>'+
				'</div>' ;
				bootstrap_container.innerHTML=product;
				product_container.appendChild(bootstrap_container);
			}

		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		complete : function(e) {
			console.log("DONE");
		}
	});
	
	
	//Ajax for fetching electronics
	$.ajax({
		type : "GET",
		cache: false,
		// contentType : "application/json",//type of data being send to server
		url : "/mainsite/fetch/Electronics",
		// data : JSON.stringify({email: $("#email").val()}),
		
		dataType : "json",//result expected from server
						//with json return type we can return java objects
						//With text we can return String from java conroller
		timeout : 100000,
		success : function(product) {
			
			console.log(product);
			if(product != null){
					var product_container = document.getElementsByClassName("row products_row")[0];
		
					var bootstrap_container = document.createElement("div");
					bootstrap_container.setAttribute("class","col-xl-4 col-md-6");
					
					
					var product ='<div class="product">'+
						'<div class="product_image"><img src='+ "siteStyle/images/product_6.jpg" +' alt=""></div>' +
						'<div class="product_content">' +
							'<div class="product_info d-flex flex-row align-items-start justify-content-start">' +
								'<div>' + 
									'<div>' +
										'<div class="product_name"><a href='+product.productname+'>'+product.productname+'</a></div>'+
										'<div class="product_category">In <a href='+product.type+'>'+product.type+'</a></div>'+
									'</div>' +
								'</div>'+
								'<div class="ml-auto text-right">' +
									'<div class="rating_r rating_r_4 home_item_rating">'+'<i></i><i></i><i></i><i></i><i></i>'+product.rating+'</div>'+
									'<div class="product_price text-right">'+'$'+parseInt(product.price)+'<span>'+(((parseFloat(product.price)%1).toFixed(2)).toString()).replace("0","")+'</span></div>'+
								'</div>'+
							'</div>'+
							'<div class="product_buttons">'+
								'<div class="text-right d-flex flex-row align-items-start justify-content-start">'+
									'<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">'+
										'<div><div><img src="siteStyle/images/heart_2.svg" class="svg" alt=""><div>+</div></div></div>'+
									'</div>'+
									'<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">'+
										'<div><div><img src="siteStyle/images/cart.svg" class="svg" alt=""><div>+</div></div></div>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</div>'+
				'</div>' ;
				bootstrap_container.innerHTML=product;
				product_container.appendChild(bootstrap_container);
			}

		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		complete : function(e) {
			console.log("DONE");
		}
	});
	
	
	//Ajax for fetching footwear
	$.ajax({
		type : "GET",
		cache: false,
		// contentType : "application/json",//type of data being send to server
		url : "/mainsite/fetch/Footwear",
		// data : JSON.stringify({email: $("#email").val()}),
		
		dataType : "json",//result expected from server
						//with json return type we can return java objects
						//With text we can return String from java conroller
		timeout : 100000,
		success : function(product) {
			
			console.log(product);
			if(product != null){
					var product_container = document.getElementsByClassName("row products_row")[0];
		
					var bootstrap_container = document.createElement("div");
					bootstrap_container.setAttribute("class","col-xl-4 col-md-6");
					
					
					var product ='<div class="product">'+
						'<div class="product_image"><img src='+ "siteStyle/images/product_6.jpg" +' alt=""></div>' +
						'<div class="product_content">' +
							'<div class="product_info d-flex flex-row align-items-start justify-content-start">' +
								'<div>' + 
									'<div>' +
										'<div class="product_name"><a href='+product.productname+'>'+product.productname+'</a></div>'+
										'<div class="product_category">In <a href='+product.type+'>'+product.type+'</a></div>'+
									'</div>' +
								'</div>'+
								'<div class="ml-auto text-right">' +
									'<div class="rating_r rating_r_4 home_item_rating">'+'<i></i><i></i><i></i><i></i><i></i>'+product.rating+'</div>'+
									'<div class="product_price text-right">'+'$'+parseInt(product.price)+'<span>'+(((parseFloat(product.price)%1).toFixed(2)).toString()).replace("0","")+'</span></div>'+
								'</div>'+
							'</div>'+
							'<div class="product_buttons">'+
								'<div class="text-right d-flex flex-row align-items-start justify-content-start">'+
									'<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">'+
										'<div><div><img src="siteStyle/images/heart_2.svg" class="svg" alt=""><div>+</div></div></div>'+
									'</div>'+
									'<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">'+
										'<div><div><img src="siteStyle/images/cart.svg" class="svg" alt=""><div>+</div></div></div>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</div>'+
				'</div>' ;
				bootstrap_container.innerHTML=product;
				product_container.appendChild(bootstrap_container);
			}

		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		complete : function(e) {
			console.log("DONE");
		}
	});
  
})