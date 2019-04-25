<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spectrum Auction Admin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="http://d3js.org/d3.v2.min.js"></script>
  <style>
  body {
    font-family:  Helvetica, Arial, sans-serif;
    margin: 32px;
  }
  </style>
</head>
<body class="bodybackgroud">

<div class="container">
  <div class="page-header">
    <div class="row">
      <div class="col-md-6"  style="margin-top: -30px;">
        <h1> <small><a href="http://spectrumauction.tk/">SpectrumAuction - Admin</a></small></h1>
      </div>

      <div class="col-md-6">
        <form class="form-inline loginform">
          <div class="form-group">
            <label class="sr-only" for="exampleInputPassword3">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password">
          </div>
          <button type="button" class="btn btn-primary" id="login">Login</button>
        </form>
        <form class="form-inline logoutform">
          <button type="button" class="btn btn-primary" id="logout">Logout</button>
        </form>
      </div>
    </div>
    
  </div>
  <div class="row mainbody">
    	<div class="col-md-12">
	    	<div class="form-group">
	      	   <div class="alert alert-danger" role="alert">Content will be replaced in the existing file.</div>
	           <p><b>full_auction_data_2016.csv</b></p>
	           <textarea class="form-control" id="csv" rows="15" ></textarea>
	      </div>
	      <button type="button" class="btn btn-danger" id="save">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Save&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
	      <button type="button" class="btn btn-primary" id="reset">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reset&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
      </div>
    </div>
</div>
<div class="modal fade alertmodal" id="alertmodal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header alertheader">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="ModalLabel"><b>Message</h4>
      </div>
      <div class="modal-body">
           <p>Alert message to be shown...</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
      </div>
    </div>
  </div>
</div>

<script>
$(document).ready(function(){

	function init(){

		$.ajax({
            url : "load.php",
            type: "GET",
            success : function (data) {
            	if(data=="")
            	{
            		$('.alertmodal').find('p').html("File empty");
					$('.alertmodal').modal('show');
					return;
            	}
                $('#csv').val(data);
            },
            error: function(result) {
			    	$('.alertmodal').find('p').html("Server error.");
					$('.alertmodal').modal('show');
					return;
			    }
    	});
	}

	$('.logoutform').hide();
	$('.mainbody').hide();

	$('#login').click(function(){
		var pwd = $('#password').val();
		$('#password').val('');
		$.ajax({
	        url: 'chkpassword.php',
	        type: 'POST', // GET is default
	        data: {
	            password: pwd
	            // in PHP, use $_POST['yourData']
	        },
	        success: function(result) {
	        		
			    	if(result == "1")
			    	{
			    		$('.loginform').hide();
	        			$('.logoutform').show();
	        			$('.mainbody').show();
			    		init();
						return;
			    	}
			    	else
			    	{
			    		$('.alertmodal').find('p').html("Invalid Credentials");
						$('.alertmodal').modal('show');
						return;
			    	}
			    },
			error: function(result) {
			    	$('.alertmodal').find('p').html("Server error");
					$('.alertmodal').modal('show');
					return;
			    }
	    });
		$('#logout').click(function(){
			window.location.reload(true);
		});
		

	});
	$('#reset').click(function(){
			init();
			$('.alertmodal').find('p').html("File reset successfully");
			$('.alertmodal').modal('show');
	});
	$('#save').click(function(){
		var htmlData = $('#csv').val();
		
		$.ajax({
	        url: 'write.php',
	        type: 'POST', // GET is default
	        data: {
	            yourData: htmlData
	            // in PHP, use $_POST['yourData']
	        },
	        success: function(result) {
			    	$('.alertmodal').find('p').html("File saved successfully");
					$('.alertmodal').modal('show');
			    },
			error: function(result) {
			    	$('.alertmodal').find('p').html("Failed to save file");
					$('.alertmodal').modal('show');
			    }
	    });
	});
});
</script>
</body>
</html>

