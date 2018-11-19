<?php
class Question{
 
    // database connection and table name
   public $conn;
   public  $table_name = "Questions";
 
    // object properties
    public $id;
    public $question;
    public $answerA;
    public $answerB;
    public $answerC;
    public $answerD;
    public $correctAnswer;
    public $points;

 
    // constructor with $db as database connection
    function __construct($db){
        $this->conn = $db;
    }


    // read products
    function read(){
 
    // select all query
    $query = "SELECT * from " . $this->table_name;
 
    // prepare query statement
    $stmt = $this->conn->prepare($query);
 
    // execute query
    $stmt->execute();
 
    return $stmt;
}




}
