<?php
	$firstname = $_POST['firstname'];
	$lastname = $_POST['lastname'];
        $email = $_POST['email'];
        $phone = $_POST['phone'];
        $Food = $_POST['Food']
        $Cloth = $_POST['Cloth'];
        $Grocery = $_POST['Grocery'];
        $Medicine = $_POST['Medicine'];
        $Utensils = $_POST['Utensils'];
        $Money = $_POST['Money'];

	// Database connection
	$conn = new mysqli('localhost','root','','test');
	if($conn->connect_error){
		echo "$conn->connect_error";
		die("Connection Failed : ". $conn->connect_error);
	} else {
		$stmt = $conn->prepare("insert into registration(firstname,lastname,email,phone,Food,Cloth,Grocery,Medicine,Utensils,Money) values(?, ?, ?, ?, ?, ?, ?, ?)");
		$stmt->bind_param("sssissssss", $firstName, $lastName, $gender, $email, $phone, $Food, $Cloth, $Grocery, $Medicine, $Utensils, $Money);
		$execval = $stmt->execute();
		echo $execval;
		echo "Registration successfully Our NGO will callback you soon...";
		$stmt->close();
		$conn->close();
	}
?>