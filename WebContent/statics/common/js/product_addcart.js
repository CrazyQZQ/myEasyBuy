/**
 * 
 */
function addCard(productId,quantity){
	var quantity = $(".n_ipt").val();
	 $.ajax({
		url : "http://localhost:8080/easybuy/cart" ,
		method : "post",
		data:{"action":"clickAdd","productId":productId,"quantity":quantity},
		datatype:"html",
		success:function(result){
			$("#searchBar").html(result)
		}
	})
}