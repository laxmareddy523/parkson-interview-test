<div class=" col-md-4 col-md-offset-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<B>PARKSON USER LOGIN</B>
		</div>
		<div class="panel-body">
			<div class="col-md-12">
				<form ng-submit="login()">
					<div class="form-group">
						<label for="username">Username</label> <input type="txt"
							class="form-control" ng-model="username" id="username">
					</div>
					<div class="form-group">
						<label for="pwd">Password</label> <input type="password"
							class="form-control" id="pwd" ng-model="password">
					</div>

					<input name="checkbox1" id="checkbox1" type="checkbox"> <label
						for="checkbox1"> Remember me </label> <br>

					<button type="submit" class="btn btn-default">Submit</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="btn btn-default" ui-sref="register">Register</button>

					<div class="alert alert-info margin-top-5" ng-show="message">{{message}}</div>
				</form>
			</div>
		</div>
	</div>
</div>