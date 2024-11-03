<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<style>
			* {
				  box-sizing: border-box;
				  margin: 0;
				  padding: 0;
				}
				:root {
				  --padding: 60px;
				}
				.box {
				  position: relative;
				  margin: 50px auto;
				  width: 400px;
				  display: flex;
				  flex-direction: column;
				  justify-content: center;
				  padding: var(--padding);
				  background-color: #c4dfff;
				  border-radius: 7px;
				}
				
				.box input,
				.box button {
				  padding: 15px;
				  font-size: 1.2em;
				  border: none;
				}
				.box input {
				  margin-bottom: 25px;
				}
				.box button {
				  background-color: #ffe4c4;
				  color: #547fb2;
				  border-radius: 4px;
				}
		</style>
		<title></title>
    </head>

    <body>
    	<h1 class="d-flex justify-content-center">Admin SignIn</h1>
    	<hr>
        <div class="box">
        	<form id="form" method="post" action="${pageContext.request.contextPath}/off/adminLogin">
			  <input name="id" type="text" placeholder="Id">
			  <input name="pw" type="password" placeholder="Password">
			  <button id="btn" class="btn btn-secondary" type="button">Sign in</button>
		    </form>
		</div>
    </body>
       <script>
	       $('#btn').click(function(){
		   		console.log('btn clicked');
		   		// whether id or pw is empty or not
		   		if($('#id').val() === "" || $('#pw').val() === "") {
		   			$('#loginResult').text('Login failed, fill in form');
		   		} else {
		   			$('#form').submit();
		   		}
	   		});
    </script>
</html>