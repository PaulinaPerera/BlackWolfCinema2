const btnLogin = document.querySelector('.btnLogin');
btnLogin.addEventListener('click',iniciarSesion);

async function iniciarSesion(){
    let userData={};
    userData.email= document.querySelector('#exampleInputEmail').value;
    userData.password= document.querySelector('#exampleInputPassword').value;
    
    const request = await fetch('api/login',{
        method: 'POST',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    });

    const response= await request.text();
   if(response=='Ok'){
        window.location.href= 'http://localhost:8080/index.html'
   }
   else{
      alert("Try again")
   }
}