$.ajax({

      type: "get",
      url:  "http://localhost:9000/EC/webapi/Test/success",
      //data: JSON.stringify(myFunction()),
      //datatype : JSON,
      success: function(product){
       console.log("hereA")
        console.log(product);
       console.log("hereB")
        
       
          
      },
      error: function(data){
   	   
         	console.log("Failure");
         }
});

function shopNow(){
	console.log("yes shopNow");
	}