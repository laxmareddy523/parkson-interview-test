<style>
.user {
	font-weight: bold;
}

.logout {
	cursor: pointer;
	margin-left: 5px;
}
</style>

<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" ui-sref="home">PARKSON INTERVIEW TEST</a>
		</div>

		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li ng-show="user.username"><a ui-sref="users"><b>USER'S
							LIST</b></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">

				<li ng-show="user.username"><a> <span class="user">Hi,
							{{user.name}}</span> <span ng-click="logout()" href="" class="logout">LOGOUT</span>
				</a></li>
				<li ng-show="!user.username"><a ui-sref="register"><B>REGISTER</B></a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>