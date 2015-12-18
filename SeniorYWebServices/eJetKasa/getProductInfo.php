<?php 

require_once('dbConnect.php');

$barcode = $_REQUEST["barcode"];

$sql = "SELECT product_name, product_info, product_price FROM product_t WHERE product_barcode=$barcode";
 
$r = mysqli_query($con,$sql);
 
$result = array();
 
$row = mysqli_fetch_array($r);
 
 array_push($result,array(
 "product_name"=>$row['product_name'],
 "product_info" => $row['product_info'],
 "product_price" => $row['product_price']
 ));
 
 echo json_encode(array('result'=>$result));
 
 mysqli_close($con);