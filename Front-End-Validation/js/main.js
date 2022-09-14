



const phoneRGEX = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/;
const postalRGEX =/^\d{5}(?:[- ]?\d{4})?$/;
const emailRGEX = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const nameRGEX = /^[a-zA-Z ]{2,30}$/;
const userRGEX =/^[A-Za-z0-9]+$/;
const passwordRGEX=/^[a-zA-Z0-9!@#$%^&*]{6,16}$/;




function validatePhoneNumber(){
    var valid = true, error = "";
    var field = document.getElementById('phone-number');
    error = document.getElementById("p-error");

    var result = phoneRGEX.test(field);
  //  alert("phone:" +phoneResult);
    
    if(result == false){
        field.classList.add("err");
        //error.innerHTML = "Phone number is incorrect form";
        valid = false;
    }else{
        field.classList.remove("err");
        error.innerHTML = "";
    }
    return valid;
}
function validatePostalCode(){
    var valid = true, error ="";
    var field = document.getElementById("postal-code");
    error = document.getElementById("postal-error");

    var result = postalRGEX.test(field);
    if(result == false){
        field.classList.add("err");
      //  error.innerHTML = "Postal Code is in the incorrect form";
        valid = false;
    }else{
        field.classList.remove("err");
        error.innerHTML = "";
    }
    return valid;
}

function validateEmailAddress(){
    var valid = true, error="";
    var field = document.getElementById("email");
    error = document.getElementById("email-error");

    var result = emailRGEX.test(field);

    if(result == false){
        field.classList.add("err");
      //  error.innerHTML = "Email is in the incorrect form";
        valid = false;
    }
    else{
        field.classList.remove("err");
        error.innerHTML = "";    
    }
    return valid;
}

function validatePassword(){
    var valid = true, error="";
    var field = document.getElementById("password");
    error = document.getElementById("password-error");

    var result = passwordRGEX.test(field);

    if(result == false){
        field.classList.add("err");
      //  error.innerHTML = "Password is in the incorrect form";
        valid = false;
    }
    else{
        field.classList.remove("err");
        error.innerHTML = "";    
    }
    return valid;
}
function validateUsername(){
    var valid = true, error="";
    var field = document.getElementById("username");
    error = document.getElementById("username-error");

    var result = userRGEX.test(field);

    if(result == false){
        field.classList.add("err");
      //  error.innerHTML = "Username is in the incorrect form";
        valid = false;
    }
    else{
        field.classList.remove("err");
        error.innerHTML = "";    
    }
    return valid;
}

function validateFirstName(){
    var valid = true, error="";
    var field = document.getElementById("first-name").value;
    
   error = document.getElementById("firstName-error");
    var result = nameRGEX.test(field);
    
    if(result == false){
        field.classList.add("err");
        error.innerHTML = result +" "+field;
        valid = false;
        alert("Invalid input")
    }
    else{
        if(field.classList.contains("err")){
            field.classList.remove("err");
            error.innerHTML = "";  
        }
        else{
            field.classList.add("err");
            error.innerHTML = "correct";
            valid = true;
        }  
    }

    
    
    return valid;
}
function validateLastName(){
    var valid = true, error="";
    var field = document.getElementById('last-name');
    error = document.getElementById('lastName-error');

    var result = nameRGEX.test(field);

    if(result == false){
        field.classList.add("err");
       // error.innerHTML = "Name is in the incorrect form";
        valid = false;
    }
    else{
        field.classList.remove("err");
        error.innerHTML = "";    
    }
    return valid;
}