/**
 * 
 */

window.addEventListener("load",function cart(){
	$.ajax({
		type:"GET",
		cache:"true",
		url:"/mainsite/fetchCart",
		dataType:"json",
		timeout:100000,
		success:function(cartList) {
			console.log(cartList);
//			if(cartList[0]!=null){
//                var cartContainer = document.getElementsByClassName("cart_items_list")[0];
//                for(i=0;i<cartList.length;i++){
//                    var cart = cartList[0];
//                    var cartListItem = document.createElement("li");
//                    cartListItem.setAttribute("class","cart_item item_list d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-lg-end justify-content-start");
//
//                    
//                  var item =    '<div class="product d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start mr-auto">'+
//                                '<div><div class="product_number">'+1+'</div></div>'+
//                                '<div><div class="product_image"><img src='+"siteStyle/images/cart_item_1.jpg"+ 'alt=""></div></div>'+
//                                '<div class="product_name_container">'+
//                                    '<div class="product_name"><a href='+"product.html"+'>'+Cool Flufy Clothing without Stripes+'</a></div>'+
//                                    '<div class="product_text">'+Second line additional info+'</div>'+
//                                '</div>'+
//                                '</div>'+
//                                '<div class="product_color product_text"><span>Color: </span>'+beige+'</div>'+
//                                '<div class="product_size product_text"><span>Size: </span>'+L+'</div>'+
//                                '<div class="product_price product_text"><span>'+'Price:' +'</span>'+$3.99+'</div>'+
//                                '<div class="product_quantity_container">'+
//                                    '<div class="product_quantity ml-lg-auto mr-lg-auto text-center">'+
//                                        '<span class="product_text product_num">1</span>'+
//                                        '<div class="qty_sub qty_button trans_200 text-center"><span>-</span></div>'+
//                                        '<div class="qty_add qty_button trans_200 text-center"><span>+</span></div>'+
//                                    '</div>'+
//                                '</div>'+
//                                '<div class="product_total product_text"><span>Total: </span>'+$3.99+'</div>';
//
//                    cartListItem.innerHTML = item;
//                    cartContainer.appendChild(cart_list);
//
//
//                }
//
//				
//			}
        },
        error: function(e){
            console.log(e);
        },
	})
	
})