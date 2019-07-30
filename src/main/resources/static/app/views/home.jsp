<div class="row">
	<div class="col-sm-4 ">
		<div class="panel panel-default">
			<div class="panel-heading">ADD COMPANY DETAILS</div>
			<div class="panel-body">
				<div class="col-md-12">
					<form ng-submit="submit()" name="userForm" novalidate>

						<div class="form-group"
							ng-class="{ 'has-error': userForm.name.$invalid && userForm.name.$dirty }">
							<label for="name">Company Code*</label> <input type="text"
								required class="form-control" ng-model="appUser.name" id="name"
								name="name">
						</div>

						<div class="form-group"
							ng-class="{ 'has-error': userForm.username.$invalid && userForm.username.$dirty }">
							<label for="username">Company Name*</label> <input type="text"
								required class="form-control" ng-model="appUser.username"
								id="username" name="username">
						</div>

						<div class="form-group"
							ng-class="{ 'has-error': userForm.username.$invalid && userForm.username.$dirty }">
							<label for="username">Company Reg.No</label> <input type="text"
								required class="form-control" ng-model="appUser.username"
								id="username" name="username">
						</div>

						<div class="form-group"
							ng-class="{ 'has-error': userForm.username.$invalid && userForm.username.$dirty }">
							<label for="username">Company Active Date</label> <input
								type="date" required class="form-control"
								ng-model="appUser.username" id="username" name="username">
						</div>

						<div class="form-group"
							ng-class="{ 'has-error': userForm.username.$invalid && userForm.username.$dirty }">
							<label for="username">Company HRIS*</label> <input type="text"
								required class="form-control" ng-model="appUser.username"
								id="username" name="username">
						</div>

						<div class="form-group"
							ng-class="{ 'has-error': userForm.username.$invalid && userForm.username.$dirty }">
							<label for="username">Company Abbr.Name*</label> <input
								type="text" required class="form-control"
								ng-model="appUser.username" id="username" name="username">
						</div>

						<div class="form-group"
							ng-class="{ 'has-error': userForm.username.$invalid && userForm.username.$dirty }">
							<label for="username">Company Logo</label> <input type="file"
								required class="form-control" ng-model="appUser.username"
								id="username" name="username">
						</div>

						<div class="form-group"
							ng-class="{ 'has-error': userForm.username.$invalid && userForm.username.$dirty }">
							<label for="role">Company Status</label> <select required
								multiple="multiple" class="form-control"
								ng-model="appUser.roles" id="role" name="role">
								<option value="ACTIVE">Active</option>
								<option value="DEACTIVE">DEACTIVE</option>
							</select>
						</div>

						<button type="submit" class="btn btn-default"
							ng-disabled="userForm.$invalid">create</button>

					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-8">
		<div class="panel panel-default">
			<div class="panel-heading">
				COMPANY DETAILS

				<button type="button" class="btn btn-default btn-sm"
					ng-click="initAddUser()">
					<span class="glyphicon glyphicon-plus"></span> ADD COMPANY
				</button>
			</div>
			<div class="panel-body">

				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Company Code</th>
							<th>Company Name</th>
							<th>Last Modified On</th>
							<th>Last Modified By</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="user in users">
							<td>{{$index+1}}</td>
							<td>{{user.name}}</td>
							<td>{{user.username}}</td>
							<td><span ng-repeat="role in user.roles">{{role}}<span
									ng-if="$index < (user.roles.length-1)">,</span>
							</span></td>
							<td><button type="button" class="btn btn-default btn-sm"
									ng-click="initEdit(user)">
									<span class="glyphicon glyphicon-edit"></span>
								</button></td>
							<td>
								<button type="button" class="btn btn-default btn-sm"
									ng-click="deleteUser(user)">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
