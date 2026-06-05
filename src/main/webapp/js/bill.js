/**
 * 
 */
let sno = 1;
let grandTotal = 0;
let cart=[];
function addItem() {

    let product = document.getElementById("search").value;
    let qty = parseInt(document.getElementById("qty").value);
    let price = parseInt(document.getElementById("price").value);

    if (!product || !qty || !price) {
        alert("Fill product details");
        return;
    }

    let total = qty * price;
    grandTotal += total;

    let row = `
        <tr>
            <td>${sno}</td>
            <td>${product}</td>
            <td>${qty}</td>
            <td>₹${price}</td>
            <td>₹${total}</td>
            <td>
                <button onclick="deleteRow(this, ${total},${sno})">
                    Delete
                </button>
            </td>
        </tr>
    `;

	let item = {
	    sno: sno,
	    product: product,
	    qty: qty,
	    price: price,
	    total: total
	};
	
	cart.push(item);
	
    document.getElementById("billBody").innerHTML += row;

    document.getElementById("grandTotal").innerHTML =
        "Total: ₹" + grandTotal;

    clearProductFields();
}

function clearProductFields() {

    document.getElementById("search").value = "";
    document.getElementById("qty").value = "";
    document.getElementById("price").value = "";
    document.getElementById("result").innerHTML = "";
	
}

function deleteRow(btn, total) {

    grandTotal -= total;

    document.getElementById("grandTotal").innerHTML = "₹" + grandTotal;        

    btn.closest("tr").remove();
	updateSerialNumber();
}

function updateSerialNumber() {

    let rows = document.querySelectorAll(
		"#billBody tr"
        );
    rows.forEach((row, index) => {
        row.cells[0]
        .innerHTML =
        index + 1;
    });
    sno =rows.length + 1;
    
}



function generateInvoice() {
	let customer=document.getElementById("custname").value.trim();
	let contact=document.getElementById("phone").value.trim();
	
	if(customer===""){
			 alert("Fill Customer Name");
			 return;
		}
		if(contact===""){
			alert("Fill Contact Number");
			return;
		}
		if(cart.length===0){
			 alert("Add at least 1 item");
			 return;
		}

    let form = document.getElementById("billingForm");

    form.action = "billing";
    form.target = "_blank";

    form.querySelectorAll(".dynamic-input")
        .forEach(e => e.remove());

    function addField(name, value) {

        let input = document.createElement("input");

        input.type = "hidden";
        input.name = name;
        input.value = value;
        input.className = "dynamic-input";

        form.appendChild(input);
    }

    addField("customer",customer);        

    addField("contact",contact);        

    addField("grandTotal", grandTotal);

    cart.forEach((item, index) => {

        ["sno", "product", "qty",
         "price", "total"]

        .forEach(field =>
            addField(
                field + "_" + index,
                item[field]
            )
        );
    });	
    form.submit();
	setTimeout(() => {
	    window.location.reload();
	}, 500);
	}

