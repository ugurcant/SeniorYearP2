<?php 

$barcode = $_GET['barcode'];
 
require_once('dbConnect.php');
 
$sql = "SELECT amount FROM product WHERE barcode=$barcode";
 
$r = mysqli_query($con,$sql);
 
$result = array();
 
$row = mysqli_fetch_array($r);
 
 array_push($result,array(
 "amount"=>$row['amount'],
 ));
 
 echo json_encode(array('result'=>$result));
 
 mysqli_close($con);