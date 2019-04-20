<?php
// get_sorted_content.php
    //echo $_SERVER["DOCUMENT_ROOT"];

    $file = $_SERVER["DOCUMENT_ROOT"].'/data/full_auction_data_2016.csv';
	
	echo file_get_contents($file);

?>