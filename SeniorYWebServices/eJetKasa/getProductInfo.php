<?php 

$barcode = $_GET['barcode'];
 
require_once('dbConnect.php');
 
$sql = "SELECT * FROM product WHERE barcode=$barcode";
 
$r = mysqli_query($con,$sql);
 
$result = array();
 
$row = mysqli_fetch_array($r);
 
 array_push($result,array(
 "barcode"=>$row['barcode'],
 "product_name"=>$row['product_name'],
 "product_info" => $row['product_info'],
 "price" => $row['price']
 ));
 
 echo json_encode(array('result'=>$result));
 
 mysqli_close($con);