/**
 * 
 */

window.addEventListener("load",function cart(){
	CartRefresh();

	var clearCartBut = document.getElementById("clearcart");
	
	
	clearCartBut.addEventListener("click", function clearAll(){
		
		$.ajax({
			type:"POST",
			cache:"false",
			url:"/mainsite/clearCart",
			timeout:100000,
			success:function(){
				var container = document.getElementsByClassName("cart_items_list")[0];
				
				while(container.childNodes[0]!=null)
					container.removeChild(container.childNodes[0]);
				
				CartRefresh();
			},
			error: function(e){
				console.log(e);
			},
			
		});
		
	});
		
	
})


function CartRefresh(){
	$.ajax({
		type:"GET",
		cache:"true",
		url:"/mainsite/fetchCart",
		dataType:"json",
		timeout:100000,
		success:function(cartList) {
			console.log(cartList);
			if(cartList[0]!=null){
                var cartContainer = document.getElementsByClassName("cart_items_list")[0];
                for(i=0;i<cartList.length;i++){
                    var cart = cartList[i];
                    var cartListItem = document.createElement("li");
                    cartListItem.setAttribute("class","cart_item item_list d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-lg-end justify-content-start");
				    cartListItem.setAttribute("id",cart.pid);
                    
                  var item =    '<div class="product d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start mr-auto">'+
                                '<div><div class="product_number">'+(i+1)+'</div></div>'+
                                '<div><div class="product_image"><img src='+"uploads/001.jpg" +' alt=""></div></div>'+
                                '<div class="product_name_container">'+
                                    '<div class="product_name"><a href='+"product.html"+'>'+cart.productname+'</a></div>'+
                                    '<div class="product_text">'+cart.availability+'</div>'+
                                '</div>'+
                                '</div>'+
//                                '<div class="product_color product_text"><span>Color: </span>'+'beige'+'</div>'+
//                                '<div class="product_size product_text"><span>Size: </span>'+'L'+'</div>'+
                                '<div class="product_price product_text"><span>'+'Price:' +'</span>'+cart.price+'</div>'+
                                '<div class="product_quantity_container">'+
                                    '<div class="product_quantity ml-lg-auto mr-lg-auto text-center">'+
                                        '<span class="product_text product_num">1</span>'+
                                        '<div class="qty_sub qty_button trans_200 text-center"><span>-</span></div>'+
                                        '<div class="qty_add qty_button trans_200 text-center"><span>+</span></div>'+
                                    '</div>'+
                                '</div>'+
                                '<div class="product_total product_text"><span>Total: </span>'+(cart.price*cart.quantity).toFixed(2)+'</div>'+
								   '<button type="button" class="removeitem btn btn-outline-danger">Remove</button>';

                    cartListItem.innerHTML = item;
                    cartContainer.appendChild(cartListItem);


                }

				
			}
        },
        error: function(e){
            console.log(e);
        },
        complete: function(){
        	
        	var removeBut = document.getElementsByClassName("removeitem");
        	
        	for(i=0;i<removeBut.length;i++){
        		removeBut[i].addEventListener("click", function removeItem(e){
        			console.log(e.target.parentNode.id);
        			$.ajax({
        				type:"POST",
        				url:"/mainsite/removeItem",
        				contentType:"application/json",
        				cache:"false",
        				data:JSON.stringify({pid:e.target.parentNode.id}),//Send pid of item to be removed
        				timeout:100000,
        				success:function (){
        					var container = document.getElementsByClassName("cart_items_list")[0];
        					
        					while(container.childNodes[0]!=null)
        						container.removeChild(container.childNodes[0]);
        					
        					
        					CartRefresh();
        				},
        				error: function(e){
        					console.log(e);
        				},
        				
        			});
        			
        		});
        		
        		
        	}

        },
	});
}
