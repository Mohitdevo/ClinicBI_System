
let stock=0;
let prodname="";

async function searchProduct() {
	let response = await fetch("api/inventory");
	let key = document.getElementById("search").value.toLowerCase();	
	let products = await response.json();
	
	let html = "";
	
	products.forEach(p => {
		if (p.productName.toLowerCase().includes(key))
			{
                html += `<div onclick="selectProduct('${p.productName}', ${p.price},${p.quantity})">
				            ${p.productName}
							</div>`;					
			   }
			   });              
				document.getElementById("result").innerHTML =html;
			}
		
function selectProduct(productName,price,quantity){
	              document.getElementById("search").value=productName;
				  document.getElementById("price").value=price;
				  stock=quantity;
				  document.getElementById("result").innerHTML ="";
}

function checkStock(){
	let qty=document.getElementById("qty").value;
	
	if(qty>stock){
		alert("Not sufficient stock");
	}
}
