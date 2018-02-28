<!DOCTYPE html>
<html>
<head><#include "/common/head.html"/>
</head>
<body>
	<header> <#include "/common/header.html"/> </header>

	<div class="container">

		<form class="form-signin" method="post" action="login">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			
			<input
				type="text" class="form-control" required="" autofocus="" name="username">
				
			<label
				for="inputPassword" class="sr-only">Password</label>
			<input
				type="password" class="form-control"
				placeholder="Password" required="" name="password">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>
		
		<p>I do not have an account yet to <a href="/signup">register</a></p>

	</div>

	<#include "/common/script.html"/>


</body>
</html>