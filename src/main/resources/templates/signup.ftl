<!DOCTYPE html>
<html>
<head><#include "/common/head.html"/>
</head>
<body>
	<header> <#include "/common/header.html"/> </header>

	<div class="container">

		<form class="form-signin" method="post" action="signup">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<h2 class="form-signin-heading">Please sign up</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			
			<input
				type="text" class="form-control" required="" autofocus="" placeholder="请使用ciecc所属邮箱"  name="username">
				
			<label
				for="inputPassword" class="sr-only">Password</label>
			<input
				type="password" class="form-control"
				placeholder="Password" required="" name="password">
				
			<label
				for="inputPassword" class="sr-only">nickname</label>
			<input
				type="text" class="form-control"
				placeholder="nickname" required="" name="nickname">

			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
		</form>
		
		<p>I already have an account, I want to direct  <a href="/login">sign in</a></p>

	</div>

	<#include "/common/script.html"/>


</body>
</html>