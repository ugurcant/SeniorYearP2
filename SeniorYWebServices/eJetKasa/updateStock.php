<?php 
 if($_SERVER['REQUEST_METHOD']=='POST'){

 $barcode = $_POST['barcode'];
 $amount = $_POST['amount'];
 
 require_once('dbConnect.php');
 
 $sql = "UPDATE product SET amount = '$amount' WHERE barcode = $barcode;";
 
 if(mysqli_query($con,$sql)){
 echo 'Stock Updated Successfully';
 }else{
 echo 'Could Not Update Stock Try Again';
 }
  
 mysqli_close($con);
 }