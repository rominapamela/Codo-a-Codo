function myFunction()  
{  
    var cantidad = document.getElementById("cantidad");
    var nombre = document.getElementById("nombre");
    alert("nombre: "+nombre.toString());
    var categoria = document.getElementById("categoria");
    var total;

    if (parseInt(cantidad.value, 10)<=0 || isNaN(parseInt(cantidad.value, 10)))
    {
        alert("cantidad invalida");
    }
    else
    {
        if (categoria.value == 'estudiante')
        {
            // 80% de descuento: paga el 20%
            total = parseInt(cantidad.value, 10)*200*0.20;
        }
        else
        {
            if (categoria.value  == 'trainee')
            {
                // 50% de descuento: paga el 50%
                total = parseInt(cantidad.value, 10)*200*0.50;
            }
            else
            {
                // 15% de descuento: paga el 85%
                total = parseInt(cantidad.value, 10)*200*0.85;
            }
        }
        var node= document.getElementById('total');
        node.style.display = "inline";  
        var node2= document.getElementById('mensaje');         
        node2.innerHTML = "Total a pagar: $" + total;
    }
}  

function borrar()  
{  
    document.getElementById("formventa").reset();
    var node= document.getElementById('total');
    node.style.display = "none";  
}  

