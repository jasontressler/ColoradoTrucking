<?php

require("dbinfo.php");

// Start XML file, create parent node

$dom = new DOMDocument("1.0");
$node = $dom->createElement("markers");
$parnode = $dom->appendChild($node);

// Opens a connection to a mssql server

$connection=mssql_connect ($server, $username, $password);
if (!$connection) {  die('Not connected : ' . mssql_error());}

// Set the active mssql database

$db_selected = mssql_select_db($database, $connection);
if (!$db_selected) {
  die ('Can\'t use db : ' . mssql_error());
}

// Select all the rows in the markers table

$query = "SELECT * FROM Inservice";
$result = mssql_query($query);
if (!$result) {
  die('Invalid query: ' . mssql_error());
}

header("Content-type: text/xml");

// Iterate through the rows, adding XML nodes for each

while ($row = @mssql_fetch_assoc($result)){
  // Add to XML document node
  $node = $dom->createElement("marker");
  $newnode = $parnode->appendChild($node);
  $newnode->setAttribute("id",$row['dot_number']);
  $newnode->setAttribute("name",$row['legal_name']);
  $newnode->setAttribute("address", $row['phy_street']);
  $newnode->setAttribute("lat", $row['gpsLatitude']);
  $newnode->setAttribute("lng", $row['gpsLongitude']);
  //$newnode->setAttribute("type", $row['type']);
}

echo $dom->saveXML();

?>