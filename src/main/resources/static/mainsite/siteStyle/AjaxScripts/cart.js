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
		cache:"false",
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
                                '<div><div class="product_image"><img src='+cart.src +' alt=""></div></div>'+
                                '<div class="product_name_container">'+
                                    '<div class="product_name"><a href='+"product.html"+'>'+cart.productname+'</a></div>'+
                                    '<div class="product_text">'+cart.availability+'</div>'+
                                '</div>'+
                                '</div>'+
                                '<div class="product_price product_text"><span>'+'Price:' +'</span>'+cart.price+'</div>'+
                                '<div class="product_quantity_container">'+
                                    '<div class="product_quantity ml-lg-auto mr-lg-auto text-center">'+
                                        '<span class="product_text product_num">'+ cart.quantity+'</span>'+
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
        	CartTotal();
        	initQty();
        	var removeBut = document.getElementsByClassName("removeitem");
        	var qtyBut = document.getElementsByClassName("qty_button");
        	var prodQty = document.getElementsByClassName("product_quantity");
        	console.log(prodQty[0].firstElementChild.innerHTML);
        	console.log(qtyBut);
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

				var val = prodQty[i].firstElementChild;
    			qtyBut[2*i].addEventListener("click", function changeQuantity(e){
    				console.log(e.target.parentNode.className);
    				console.log(document.getElementsByClassName(e.target.parentNode.className));
    				$.ajax({
    					type:"POST",
    					url:"/mainsite/quantityUpdate",
    					contentType:"application/json",
    					cache:"false",
    					data:JSON.stringify({pid:e.target.parentNode.parentNode.parentNode.id,
    						quantity:parseInt(val.innerHTML)}),
    					timeout:10000,
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
    			
    			
    			
    			qtyBut[2*i+1].addEventListener("click", function changeQuantity(e){
    				
    				$.ajax({
    					type:"POST",
    					url:"/mainsite/quantityUpdate",
    					contentType:"application/json",
    					cache:"false",
    					data:JSON.stringify({pid:e.target.parentNode.parentNode.parentNode.id,
    						quantity:parseInt(val.innerHTML)}),
    					timeout:10000,
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
        			
        		};
        		
        		
//        	}
        	
        	

        },
	});
}




function CartTotal(){	
						
	var cartlist = document.getElementsByClassName("product_total");
	var subtotal = 0 ;	
	for(i=0; i<cartlist.length; i++){
		subtotal = (subtotal + parseFloat(cartlist[i].innerText));
	};
	console.log(subtotal);	
	var shipOptions = document.getElementsByClassName("shipping_radio");
	var shipping = 0;
	for(i=0; i<shipOptions.length; i++){
		if(shipOptions[i].checked){
			shipping = parseFloat(shipOptions[i].value);
		}
	}

	console.log(shipping);
	
	var total = shipping + subtotal;
	console.log(total);
	
	document.getElementById("subtotal").innerHTML = subtotal.toFixed(2);
	document.getElementById("shipping").innerHTML = shipping.toFixed(2);
	document.getElementById("total").innerHTML = total.toFixed(2);
	
	
	
}	


function initQty()
{
	if($('.product_quantity').length)
	{
		var qtys = $('.product_quantity');

		qtys.each(function()
		{
			var qty = $(this);
			var sub = qty.find('.qty_sub');
			var add = qty.find('.qty_add');
			var num = qty.find('.product_num');
			var original;
			var newValue;

			sub.on('click', function()
			{
				original = parseFloat(qty.find('.product_num').text());
				if(original > 1)
					{
						newValue = original - 1;
					}
				num.text(newValue);
			});

			add.on('click', function()
			{
				original = parseFloat(qty.find('.product_num').text());
				newValue = original + 1;
				num.text(newValue);
			});
		});
	}
}
	


//function QuantityChange(k){
//	
//	
//	$.ajax({
//		type:"POST",
//		url:"/mainsite/quantityUpdate",
//		contentType:"application/json",
//		cache:"false",
//		data:JSON.stringify({pid:e.target.parentNode.parentNode.parentNode.id,
//			quantity:parseInt(prodQty[k].firstElementChild.innerHTML)+1}),
//		timeout:10000,
//		success:function(){
//			var container = document.getElementsByClassName("cart_items_list")[0];
//
//			while(container.childNodes[0]!=null)
//				container.removeChild(container.childNodes[0]);
//			
//			CartRefresh();
//		},
//		error: function(e){
//			console.log(e);
//		},
//		
//		
//	});
//	
//}