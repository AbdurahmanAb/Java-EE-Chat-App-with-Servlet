/**
 * 
 *//**
 * 
 *//**
 * 
 */


function addText()
{
let username = document.getElementById("u").value;
 let msg = document.getElementById('h').value;
    olist = document.getElementById('list');
  //  document.getElementById("name").innerHTML = username;
    //document.getElementById("msg").innerHTML = msg;
  // op = document.createElement('p');
  //  op.innerHTML = username + "- <g>" + msg + "</g>";
    ocontent = document.getElementById('content');
  //  ocontent.appendChild(op);             //Add new line on click
  //  olist.scrollTop = olist.scrollHeight; //Adjust Height
    document.getElementById('h').value = '';
    var xmlhttp;
   
        xmlhttp = new XMLHttpRequest();
 

    xmlhttp.open("POST", "chatstore?uname=" + username + "&msg=" + msg, true);

    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
           
        }
    };
    xmlhttp.send();
}
 setInterval(reloaddata,2000);
function reloaddata()
{
    var xmlhttp;
  
        xmlhttp = new XMLHttpRequest();
  
    xmlhttp.open("POST", "reload", true);

    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {

            document.querySelector(".flex").innerHTML = xmlhttp.responseText;
            olist = document.getElementById('list'); //everything in id list
            olist.scrollTop = olist.scrollHeight;


        }


    };
    xmlhttp.send()


console.log("post requested");

}